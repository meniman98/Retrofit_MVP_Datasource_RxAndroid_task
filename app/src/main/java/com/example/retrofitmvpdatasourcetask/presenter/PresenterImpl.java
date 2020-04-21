package com.example.retrofitmvpdatasourcetask.presenter;

import com.example.retrofitmvpdatasourcetask.contract.PostContract;
import com.example.retrofitmvpdatasourcetask.model.Post;
import com.example.retrofitmvpdatasourcetask.repository.Repository;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class PresenterImpl implements PostContract.Presenter {
    private PostContract.View view;
    private Repository repository;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public PresenterImpl(PostContract.View view, Repository repository) {
        this.view = view;

        this.repository = repository;
    }


    @Override
    public void getPosts() {

        view.showProgress();
        compositeDisposable.add(
                repository.getPosts()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(this::handleSuccess, this::handleError)


        );



    }


    private void handleError(Throwable throwable) {
        view.showError(throwable);
    }

    private void handleSuccess(List<Post> posts) {
        view.hideProgress();
        view.showPosts(posts);
    }

    @Override
    public void detachView() {
        view = null;
        compositeDisposable.clear();

    }
}
