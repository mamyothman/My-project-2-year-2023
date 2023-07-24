package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.todo.model.UserInformation;
import com.example.todo.services.UserService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private ListView listViewUsers;
    private List<UserInformation> userList;


    private EditText firstNameEditText;
    private EditText secondNameEditText;
    private EditText lastNameEditText;
    private EditText phoneEditText;
    private EditText addressEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the EditText fields
        firstNameEditText = findViewById(R.id.firstNameEditText);
        secondNameEditText = findViewById(R.id.secondNameEditText);
        lastNameEditText = findViewById(R.id.lastNameEditText);
        phoneEditText = findViewById(R.id.phoneEditText);
        addressEditText = findViewById(R.id.addressEditText);
        Button submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the entered values

                String firstName = firstNameEditText.getText().toString();
                String secondName = secondNameEditText.getText().toString();
                String lastName = lastNameEditText.getText().toString();
                String phone = phoneEditText.getText().toString();
                String address = addressEditText.getText().toString();


                // Create a Retrofit instance
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://192.168.43.152:8081/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                // Create the service interface
                UserService userService = retrofit.create(UserService.class);

                // Create a UserInformation object
                UserInformation userInformation = new UserInformation(firstName, secondName, lastName, phone, address);

                // Make the POST request
                Call<Void> call = userService.submitUserInformation(userInformation);
                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (response.isSuccessful()) {
                            // Handle success
                            Toast.makeText(MainActivity.this, "Data submitted successfully", Toast.LENGTH_SHORT).show();
                        } else {
                            // Handle error
                            Toast.makeText(MainActivity.this, "Error submitting data", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        // Handle failure
                        Toast.makeText(MainActivity.this, "Failed to submit data: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }

        });


    }
    // Initialize Retrofit
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.100.152:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    // Create the UserService instance
    UserService userService = retrofit.create(UserService.class);

    // Make the API request to get user information



}