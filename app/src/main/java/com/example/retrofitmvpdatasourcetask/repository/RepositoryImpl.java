package com.example.retrofitmvpdatasourcetask.repository;

import com.example.retrofitmvpdatasourcetask.model.Post;
import com.example.retrofitmvpdatasourcetask.network.Client;
import com.example.retrofitmvpdatasourcetask.network.RetrofitObject;

import java.util.List;

import io.reactivex.Observable;

public class RepositoryImpl implements Repository {

    private Client client;

    public RepositoryImpl() {
        client = RetrofitObject.getClient();
    }

    @Override
    public Observable<List<Post>> getPosts() {
        return client.getPosts();
    }
}
