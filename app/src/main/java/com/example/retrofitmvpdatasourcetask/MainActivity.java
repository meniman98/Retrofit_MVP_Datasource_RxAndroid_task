package com.example.retrofitmvpdatasourcetask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.retrofitmvpdatasourcetask.adapters.PostAdapter;
import com.example.retrofitmvpdatasourcetask.contract.PostContract;
import com.example.retrofitmvpdatasourcetask.model.Post;
import com.example.retrofitmvpdatasourcetask.presenter.PresenterImpl;
import com.example.retrofitmvpdatasourcetask.repository.RepositoryImpl;

import java.util.List;

public class MainActivity extends AppCompatActivity implements PostContract.View {
    private PostContract.Presenter presenter;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private PostAdapter postAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rvMain);
        progressBar = findViewById(R.id.pgMain);

        presenter = new PresenterImpl(this, new RepositoryImpl());

        presenter.getPosts();


        presenter = new PresenterImpl(this, new RepositoryImpl());

        setupRecyclerView();

    }

    private void setupRecyclerView() {
         postAdapter = new PostAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(postAdapter);
    }

    @Override
    public void showPosts(List<Post> posts) {
        postAdapter.setData(posts);


    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);

    }

    @Override
    public void showError(Throwable t) {
        Toast.makeText(this, Constants.ERROR_MESSAGE + t, Toast.LENGTH_SHORT).show();

    }
}
