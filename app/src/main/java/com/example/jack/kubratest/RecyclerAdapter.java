package com.example.jack.kubratest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    //String names[];
    //String addresses[];
    List<Person> personList;
    Context context;

    public RecyclerAdapter(Context context, List<Person> persons) {
        //this.names = names;
        //this.addresses = addresses;
        this.personList = persons;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_design_user,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        holder.textViewName.setText("Name: " + personList.get(position).getName());
        holder.textViewAddress.setText("Address: " +
                personList.get(position).getAddress().getStreet() + ", " +
                personList.get(position).getAddress().getSuite() + ", " +
                personList.get(position).getAddress().getCity());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // this runs when the user clicks on an item in the RecyclerView
                //Toast.makeText(context,"Clicked on " + personList.get(position).getName(),Toast.LENGTH_SHORT).show();
                Intent postsIntent = new Intent(context, PostsActivity.class);
                Bundle b = new Bundle();
                //TODO: make this bundle pass int id or a parcelable object of Person
                b.putString("name", personList.get(position).getName());
                postsIntent.putExtras(b);
                context.startActivity(postsIntent);
            }
        });
    }

    @Override
    public int getItemCount() { return personList.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        TextView textViewAddress;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.tvName);
            textViewAddress = itemView.findViewById(R.id.tvAddress);
        }
    }
}
