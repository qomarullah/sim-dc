package com.tech.ditraktir.model;

import com.google.gson.annotations.SerializedName;

public class ProjectItem {

    @SerializedName("id")
    private Integer id;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @SerializedName("total")
    private Integer total;

    @SerializedName("title")
    private String title;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @SerializedName("category")
    private String category;
    @SerializedName("url")
    private String url;
    @SerializedName("thumbnailUrl")
    private String thumbnailUrl;

    public ProjectItem(Integer id, String title, String category,String url, String thumbnailUrl) {
        this.id = id;
        this.title = title;
        this.category=category;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
    }


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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}