package com.example.androidsampleapp.Services;

import com.example.androidsampleapp.APIModel.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface UserService {

    @GET("posts")
    Call<List<UserModel>> findAll();

    @POST("posts")
    Call<UserModel> createPost(@Body UserModel userModel);

}
