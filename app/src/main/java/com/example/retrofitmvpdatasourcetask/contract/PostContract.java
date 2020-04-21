package com.example.retrofitmvpdatasourcetask.contract;

import com.example.retrofitmvpdatasourcetask.model.Post;

import java.util.List;

public interface PostContract {

    interface View {
        void showPosts(List<Post> posts);
        void showProgress();
        void hideProgress();
        void showError(Throwable t);

    }

    interface Presenter {

        void getPosts();

        void detachView();

    }
}
