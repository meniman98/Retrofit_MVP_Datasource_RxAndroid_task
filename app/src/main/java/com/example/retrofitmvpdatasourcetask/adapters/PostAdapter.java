package com.example.retrofitmvpdatasourcetask.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitmvpdatasourcetask.R;
import com.example.retrofitmvpdatasourcetask.model.Post;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostsViewHolder> {


    private List<Post> postsList;

    public PostAdapter() {
        this.postsList = new ArrayList<>();
    }

    public void setData(List<Post> posts) {
        postsList.clear();
        postsList.addAll(posts);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public PostsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        return new PostsViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.PostsViewHolder holder, int position) {
        Post post = postsList.get(position);

        holder.title.setText(post.getTitle().getRendered());
        holder.excerpt.setText(post.getExcerpt().getRendered());

    }



    @Override
    public int getItemCount() {
        return postsList.size();
    }



    public class PostsViewHolder extends RecyclerView.ViewHolder {

        private TextView title, excerpt;


        public PostsViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tvTitle);
            excerpt = itemView.findViewById(R.id.tvExcerpt);
        }
    }
}
