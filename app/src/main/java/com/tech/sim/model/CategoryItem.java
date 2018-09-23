package com.tech.sim.model;

import com.google.gson.annotations.SerializedName;

public class CategoryItem {

    @SerializedName("id")
    private Integer id;
    @SerializedName("title")
    private String title;
    @SerializedName("code")
    private String code;
    @SerializedName("desc")
    private String desc;
    @SerializedName("type")
    private String type;
    @SerializedName("icon")
    private String icon;
    @SerializedName("created_date")
    private String created_date;
    @SerializedName("count")
    private Integer count;
    @SerializedName("status")
    private Integer status;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}