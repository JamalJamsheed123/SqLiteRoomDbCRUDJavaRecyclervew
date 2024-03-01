package com.example.androidsampleapp.Features;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.androidsampleapp.APIAdapter.UserAdapter;
import com.example.androidsampleapp.APIModel.UserModel;
import com.example.androidsampleapp.R;
import com.example.androidsampleapp.Services.APIClient;
import com.example.androidsampleapp.Services.UserService;

import java.io.Serializable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AddRecordAPIActivity extends AppCompatActivity {

    //photos--endpoint
   public static String api = "https://jsonplaceholder.typicode.com";
   List<UserModel> allUserList;
   private ListView userListView;
   private Button getButton, postButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record_apiactivity);
        getButton = (Button) findViewById(R.id.getDataButton);
        postButton = (Button) findViewById(R.id.postDataButton);
        getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddRecordAPIActivity.this, GetDataApiActivity.class);
                startActivity(intent);
            }
        });
        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddRecordAPIActivity.this, PostDataActivity.class);
                startActivity(intent);
            }
        });


    }
}