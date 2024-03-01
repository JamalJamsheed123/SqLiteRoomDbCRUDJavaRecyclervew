package com.example.androidsampleapp.Features;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.example.androidsampleapp.Adapter.PurchaseAdapter;
import com.example.androidsampleapp.EntityClass.PurchaseModel;
import com.example.androidsampleapp.R;
import com.example.androidsampleapp.SampleAppDB.SqLiteDB;

import java.util.ArrayList;
import java.util.List;

public class GetDataActivity extends AppCompatActivity {

    RecyclerView recyclerview;

    private List<PurchaseModel> list;
    private PurchaseAdapter purchaseAdapter;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_data);
        recyclerview = findViewById(R.id.recyclerview);
        searchView = findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });
    }

    private void filterList(String text) {
        List<PurchaseModel> filteredList = new ArrayList<>();
        for (PurchaseModel item: list){
            if (item.getCustomerName().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }
        if (filteredList.isEmpty()){
            Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show();
        }
        else {
            recyclerview.setAdapter(new PurchaseAdapter(getApplicationContext(), filteredList, new PurchaseAdapter.DeleteItemClicklistner() {
                @Override
                public void onItemDelete(int position, int id) {
                    SqLiteDB.getDatabase(getApplicationContext()).getDao().deleteData(id);
                    getData();
                }
            }));
            }
    }

    @Override
    protected void onResume() {
        super.onResume();
        getData();

    }

    private void getData() {
        list = new ArrayList<>();
        list = SqLiteDB.getDatabase(getApplicationContext()).getDao().getAllData();
        recyclerview.setAdapter(new PurchaseAdapter(getApplicationContext(), list, new PurchaseAdapter.DeleteItemClicklistner() {
            @Override
            public void onItemDelete(int position, int id) {
                SqLiteDB.getDatabase(getApplicationContext()).getDao().deleteData(id);
                getData();
            }
        }));
    }
}