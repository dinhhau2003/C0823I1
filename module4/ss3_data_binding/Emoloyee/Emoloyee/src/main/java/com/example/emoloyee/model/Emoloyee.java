package com.example.emoloyee.model;

public class Emoloyee {
    private String id;
    private String name;
    private String contactNumber;

    public Emoloyee() {
    }

    public Emoloyee(String id, String name, String contactNumber) {
        this.id = id;
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
