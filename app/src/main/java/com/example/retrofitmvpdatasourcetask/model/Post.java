package com.example.retrofitmvpdatasourcetask.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private Title title;
    @SerializedName("excerpt")
    @Expose
    private Excerpt excerpt;

    public Integer getId() {
        return id;
    }



    public Title getTitle() {
        return title;
    }



    public Excerpt getExcerpt() {
        return excerpt;
    }





}
