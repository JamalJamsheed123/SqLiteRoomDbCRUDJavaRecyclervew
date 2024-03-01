package com.example.androidsampleapp.Features;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.androidsampleapp.APIAdapter.UserAdapter;
import com.example.androidsampleapp.APIModel.UserModel;
import com.example.androidsampleapp.Adapter.PurchaseAdapter;
import com.example.androidsampleapp.EntityClass.PurchaseModel;
import com.example.androidsampleapp.R;
import com.example.androidsampleapp.SampleAppDB.SqLiteDB;
import com.example.androidsampleapp.Services.APIClient;
import com.example.androidsampleapp.Services.UserService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetDataApiActivity extends AppCompatActivity {

    public static String api = "https://jsonplaceholder.typicode.com/";
    List<UserModel> allUserList;
    private ListView userListView;
    private SearchView searchView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_data_api);
        userListView = (ListView) findViewById(R.id.userLV);
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


        UserService userService = APIClient.getClient().create(UserService.class);
        Call call = userService.findAll();
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, @NonNull Response response) {
                allUserList = (List< UserModel >) response.body();
                userListView.setAdapter(new UserAdapter(allUserList, getApplicationContext()));

                /*userListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        UserModel userModel = (UserModel) adapterView.getItemAtPosition(i);
                        Intent intent = new Intent(GetDataApiActivity.this, PostRecordActivity.class);
                        //intent.putExtra("userModel", (Serializable) userModel);
                        startActivity(intent);
                    }
                });*/

            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void filterList(String text) {
        List< UserModel > filteredList = new ArrayList<>();
        for (UserModel item: allUserList){
            if (item.getUserId().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
            else if (item.getId().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
            else if (item.getTitle().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
            else if (item.getBody().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }
        if (filteredList.isEmpty()){
            Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show();
        }
        else {
            userListView.setAdapter(new UserAdapter(filteredList, getApplicationContext()));

        }
        }
    }