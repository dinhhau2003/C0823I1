package com.example.product.model;

public class Manufactor {
    private int manufactor_id;
    private String name_manufactor;

    public Manufactor() {
    }

    public Manufactor(int manufactor_id, String name_manufactor) {
        this.manufactor_id = manufactor_id;
        this.name_manufactor = name_manufactor;
    }

    public int getManufactor_id() {
        return manufactor_id;
    }

    public void setManufactor_id(int manufactor_id) {
        this.manufactor_id = manufactor_id;
    }

    public String getName_manufactor() {
        return name_manufactor;
    }

    public void setName_manufactor(String name_manufactor) {
        this.name_manufactor = name_manufactor;
    }
}
