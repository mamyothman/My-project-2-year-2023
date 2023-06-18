package com.example.todo.services;

import com.example.todo.model.UserInformation;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserService {
    @POST("api/User/saveUser")
    Call<Void> submitUserInformation(@Body UserInformation userInformation);

    @GET("/users/")
    Call<UserInformation> getUserInformation();

}