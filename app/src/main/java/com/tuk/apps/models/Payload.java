package com.tuk.apps.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Payload {
    @SerializedName("_id")
    @Expose
    private Id id;
    @SerializedName("make")
    @Expose
    private String make;

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }
}
