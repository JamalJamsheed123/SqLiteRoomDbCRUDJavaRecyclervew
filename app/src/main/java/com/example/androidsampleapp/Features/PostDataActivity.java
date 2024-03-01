package com.example.androidsampleapp.Features;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.androidsampleapp.APIAdapter.UserAdapter;
import com.example.androidsampleapp.APIModel.UserModel;
import com.example.androidsampleapp.R;
import com.example.androidsampleapp.Services.APIClient;
import com.example.androidsampleapp.Services.UserService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Tag;

public class PostDataActivity extends AppCompatActivity {
    public static String api = "https://jsonplaceholder.typicode.com/";
    List<UserModel> allUserList;
    private ListView userListView;
    List<UserModel> userModels;
    UserAdapter userAdapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_data);
        userListView = (ListView) findViewById(R.id.userLV1);

        // Create a new post

        UserService userService = APIClient.getClient().create(UserService.class);
        UserModel newPost = new UserModel("12","101","HONDA", "MY CAR");

        UserModel newPost1 = new UserModel("13","102","CIVIC", "THIS IS YOUR CAR");

        userService.createPost(newPost).enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                if (response.isSuccessful()) {

                    Log.e(TAG,"onResponse:  " + response.code());
                    Log.e(TAG,"onResponse:  " + response.body().getUserId());
                    Log.e(TAG,"onResponse:  " + response.body().getId());
                    Log.e(TAG,"onResponse:  " + response.body().getTitle());
                    Log.e(TAG,"onResponse:  " + response.body().getBody());
                    //UserModel createdPost = response.body();
                   //userListView.setAdapter(new UserAdapter((List<UserModel>) createdPost, getApplicationContext()));
                    // Update RecyclerView Adapter with new post
                } else {
                    // Handle unsuccessful response
                }
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                // Handle network failure
            }
        });
        userService.createPost(newPost1).enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                if (response.isSuccessful()) {

                    Log.e(TAG,"onResponse:  " + response.code());
                    Log.e(TAG,"onResponse:  " + response.body().getUserId());
                    Log.e(TAG,"onResponse:  " + response.body().getId());
                    Log.e(TAG,"onResponse:  " + response.body().getTitle());
                    Log.e(TAG,"onResponse:  " + response.body().getBody());
                    //UserModel createdPost = response.body();
                    //userListView.setAdapter(new UserAdapter((List<UserModel>) createdPost, getApplicationContext()));
                    // Update RecyclerView Adapter with new post
                } else {
                    // Handle unsuccessful response
                }
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                // Handle network failure
            }
        });
    }
}