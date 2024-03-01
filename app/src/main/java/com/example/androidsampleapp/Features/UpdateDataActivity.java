package com.example.androidsampleapp.Features;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidsampleapp.R;
import com.example.androidsampleapp.SampleAppDB.SqLiteDB;

public class UpdateDataActivity extends AppCompatActivity {

    EditText customername, productname, quantity, purchasedate, contactnumber, outletlocation;
    Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);
        customername = findViewById(R.id.customerName);
        productname = findViewById(R.id.productName);
        quantity = findViewById(R.id.Quantity);
        purchasedate = findViewById(R.id.purchaseDate);
        contactnumber = findViewById(R.id.contactNumber);
        outletlocation = findViewById(R.id.outletLocation);
        update = findViewById(R.id.btn_update);


        //GET DATA
        customername.setText(getIntent().getExtras().getString("customerName"));
        productname.setText(getIntent().getExtras().getString("productName"));
        quantity.setText(getIntent().getExtras().getString("quantity"));
        purchasedate.setText(getIntent().getExtras().getString("purchaseDate"));
        contactnumber.setText(getIntent().getExtras().getString("contactNumber"));
        outletlocation.setText(getIntent().getExtras().getString("outletLocation"));
        final String id = getIntent().getExtras().getString("id");

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String customername_txt = customername.getText().toString().trim();
                String productname_txt = productname.getText().toString().trim();
                String quantity_txt = quantity.getText().toString().trim();
                String purchasedate_txt = purchasedate.getText().toString().trim();
                String contactnumber_txt = contactnumber.getText().toString().trim();
                String outletlocation_txt = outletlocation.getText().toString().trim();
                if (customername_txt.equals("") || productname_txt.equals("") || quantity_txt.equals("") || purchasedate_txt.equals("") || contactnumber_txt.equals("") || outletlocation_txt.equals("")) {
                    Toast.makeText(UpdateDataActivity.this, "All Field is required ....", Toast.LENGTH_SHORT).show();
                } else {
                    SqLiteDB.getDatabase(getApplicationContext()).getDao().updateData(customername_txt, productname_txt, quantity_txt, purchasedate_txt, contactnumber_txt, outletlocation_txt, Integer.parseInt(id));
                    finish();
                    Toast.makeText(UpdateDataActivity.this, "Data Update Successfully", Toast.LENGTH_SHORT).show();

                }


            }
        });
    }
}