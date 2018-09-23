package com.tech.sim.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GenericResponse {

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @SerializedName("status")
    private String status;




    public GenericResponse(String status) {
        this.status= status;
     }

}