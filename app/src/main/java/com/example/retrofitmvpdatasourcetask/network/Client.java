package com.example.retrofitmvpdatasourcetask.network;

import com.example.retrofitmvpdatasourcetask.Constants;
import com.example.retrofitmvpdatasourcetask.model.Post;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Client {

    @GET(Constants.POST_ENDPOINT)
    Observable<List<Post>> getPosts();
}
