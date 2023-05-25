package com.example.todo.model;



public class UserInformation {

    private String first_name;
    private String second_name;
    private String lastname;
    private String phone;
    private String address;

    public UserInformation(String firstName, String secondName, String lastName, String phone, String address) {
        this.first_name = firstName;
        this.second_name = secondName;
        this.lastname = lastName;
        this.phone = phone;
        this.address = address;
    }


    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Include getters and setters as needed
}

