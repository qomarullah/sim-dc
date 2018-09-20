package com.tech.ditraktir.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Project {

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ProjectItem> getData() {
        return data;
    }

    public void setData(List<ProjectItem> data) {
        this.data = data;
    }

    @SerializedName("version")
    private Integer version;
    @SerializedName("total")
    private Integer total;
    @SerializedName("status")
    private String status;
    @SerializedName("data")
    private List<ProjectItem> data;




    public Project(Integer version,String status, List<ProjectItem> data) {
        this.version = version;
        this.status= status;
        this.data=data;
    }

}