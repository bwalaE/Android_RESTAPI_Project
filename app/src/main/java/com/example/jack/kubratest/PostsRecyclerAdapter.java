package com.example.jack.kubratest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostsRecyclerAdapter extends RecyclerView.Adapter<PostsRecyclerAdapter.ViewHolder> {

    List<Post> postList;
    Context context;

    public PostsRecyclerAdapter(Context context, List<Post> postList) {
        this.postList = postList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_design_post,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textviewTitle.setText(postList.get(position).getTitle());
        holder.textviewBody.setText(postList.get(position).getBody());
        // don't need to make an onClick() right now (or ever?)
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textviewTitle;
        TextView textviewBody;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textviewTitle = itemView.findViewById(R.id.tvTitle);
            textviewBody = itemView.findViewById(R.id.tvBody);
        }
    }
}
