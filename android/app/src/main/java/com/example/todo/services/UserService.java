package com.example.todo.services;

import com.example.todo.model.UserInformation;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface UserService {
    @POST("/users/")
    Call<Void> submitUserInformation(@Body UserInformation userInformation);
}
