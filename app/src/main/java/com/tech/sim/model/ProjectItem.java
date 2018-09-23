package com.tech.sim.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProjectItem {

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    @SerializedName("id")
    private Integer id;
    @SerializedName("title")
    private String title;
    @SerializedName("desc")
    private String desc;
    @SerializedName("type")
    private String type;
    @SerializedName("created_date")
    private String created_date;
}