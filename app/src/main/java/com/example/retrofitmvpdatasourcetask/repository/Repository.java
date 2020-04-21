package com.example.retrofitmvpdatasourcetask.repository;

import com.example.retrofitmvpdatasourcetask.model.Post;

import java.util.List;

import io.reactivex.Observable;

public interface Repository {

    Observable<List<Post>> getPosts();
}
