package com.tech.sim.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Category {


    public Integer getApi_status() {
        return api_status;
    }

    public void setApi_status(Integer api_status) {
        this.api_status = api_status;
    }

    public String getApi_message() {
        return api_message;
    }

    public void setApi_message(String api_message) {
        this.api_message = api_message;
    }

    public List<CategoryItem> getData() {
        return data;
    }

    public void setData(List<CategoryItem> data) {
        this.data = data;
    }

    @SerializedName("api_status")
    private Integer api_status;
    @SerializedName("api_message")
    private String api_message;
    @SerializedName("data")
    private List<CategoryItem> data;





}