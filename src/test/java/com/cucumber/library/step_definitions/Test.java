package com.cucumber.library.step_definitions;

import com.cucumber.library.pojos.User;



public class Test {
    public static void main(String[] args) {
        User user=new User();
        user.setFullName();
        System.out.println("user.getFullName() = " + user.getFullName());
        user.setEmail();
        System.out.println("user.getEmail() = " + user.getEmail());
        user.setAddress();
        System.out.println("user.getAddress() = " + user.getAddress());
        user.setPassword();
        System.out.println("user.getPassword() = " + user.getPassword());
    }
}
