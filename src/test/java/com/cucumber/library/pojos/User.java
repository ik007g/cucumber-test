package com.cucumber.library.pojos;

import com.github.javafaker.Country;
import com.github.javafaker.Faker;

public class User {

    private String fullName;
    private String email;
    private String address;
    private String password;
    private String id;


    public User(){
    }
    public User(String fullName, String email, String address, String password) {
        this.fullName = fullName;
        this.email = email;
        this.address = address;
        this.password=password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName() {
        Faker faker=new Faker();
        String fullName=faker.name().fullName();
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail() {
        Faker faker=new Faker();
        String email = getFullName().toLowerCase().replace(" ", "") + "@" + faker.company().name().replace(" ", "").toLowerCase().replace(",","");
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress() {
       Faker faker=new Faker();
        String address = faker.address().fullAddress();
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword() {
        Faker faker=new Faker();
        String password="abc"+faker.number().digits(4);
        this.password = password;
    }
    public String getId(){
        return id;
    }
}
