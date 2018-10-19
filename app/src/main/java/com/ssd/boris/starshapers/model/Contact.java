package com.ssd.boris.starshapers.model;

public class Contact {
    private String name;
    private String phone;
    private String email;
    private String package_type;
    private String message;

    public Contact(){

    }

    public Contact(String name,String phone, String email, String package_type, String message){
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.package_type = package_type;
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getPackage_type() {
        return package_type;
    }

    public String getMessage() {
        return message;
    }

}
