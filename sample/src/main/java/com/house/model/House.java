package com.house.model;

public class House {
    private String id;

    public House(String id, String name) {
        this.id = id;
        this.name = name;
    }


    private String name;

    private Door door;

    public House() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public Door getDoor() {
        return door;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
