package com.example.androidsampleapp.Features;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidsampleapp.EntityClass.PurchaseModel;
import com.example.androidsampleapp.MainActivity;
import com.example.androidsampleapp.R;
import com.example.androidsampleapp.SampleAppDB.SqLiteDB;

public class AddRecordActivity extends AppCompatActivity {
    EditText customerName, productName, quantity, purchaseDate, contactNumber, outletLocation;
    Button save, getData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);
        customerName = findViewById(R.id.customerName);
        productName = findViewById(R.id.productName);
        quantity = findViewById(R.id.Quantity);
        purchaseDate = findViewById(R.id.purchaseDate);
        contactNumber = findViewById(R.id.contactNumber);
        outletLocation = findViewById(R.id.outletLocation);
        save = findViewById(R.id.btn_save);
        getData = findViewById(R.id.btn_getData);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validation_SaveData();
            }
        });

        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), GetDataActivity.class));
            }
        });

        OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if (shouldInterceptBackPress()) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                } else {
                    setEnabled(false);
                    onBackPressed();
                }
            }

            private boolean shouldInterceptBackPress() {
                return true;
            }
        };
        getOnBackPressedDispatcher().addCallback(this, onBackPressedCallback);
    }

    private void validation_SaveData(){
        if (customerName.getText().toString().isEmpty()) {
            customerName.setError("Enter Customer Name.!");
            requestFocus(customerName);
        }
        else if (productName.getText().toString().isEmpty()) {
            productName.setError("Enter Product Name.!");
            requestFocus(productName);
        }
        else if (quantity.getText().toString().isEmpty()) {
            quantity.setError("Enter Quantity.!");
            requestFocus(quantity);
        }
        else if (purchaseDate.getText().toString().isEmpty()) {
            purchaseDate.setError("Enter Purchase Date.!");
            requestFocus(purchaseDate);
        }
        else if (contactNumber.getText().toString().isEmpty()) {
            contactNumber.setError("Enter Contact Number.!");
            requestFocus(contactNumber);
        }
        else if (outletLocation.getText().toString().isEmpty()) {
            outletLocation.setError("Enter Outlet Location.!");
            requestFocus(outletLocation);
        }
        else {
            saveData();

        }
    }
    private void requestFocus(View view) {
        if (view.requestFocus()) {
            this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }
    private void saveData() {

        String customerName_txt = customerName.getText().toString().trim();
        String productName_txt = productName.getText().toString().trim();
        String quantity_txt = quantity.getText().toString().trim();
        String purchaseDate_txt = purchaseDate.getText().toString().trim();
        String contactNumber_txt = contactNumber.getText().toString().trim();
        String outletLocation_txt = outletLocation.getText().toString().trim();



        PurchaseModel model = new PurchaseModel();
        model.setCustomerName(customerName_txt);
        model.setProductName(productName_txt);
        model.setQuantity(quantity_txt);
        model.setPurchaseDate(purchaseDate_txt);
        model.setContactNumber(contactNumber_txt);
        model.setOutletLocation(outletLocation_txt);
        SqLiteDB.getDatabase(getApplicationContext()).getDao().insertAllData(model);

        customerName.setText("");
        productName.setText("");
        quantity.setText("");
        purchaseDate.setText("");
        contactNumber.setText("");
        outletLocation.setText("");
        Toast.makeText(this, "Data Successfully Saved", Toast.LENGTH_SHORT).show();


    }
}