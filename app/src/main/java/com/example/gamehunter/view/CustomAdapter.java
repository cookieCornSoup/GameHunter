package com.example.gamehunter.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gamehunter.R;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private ArrayList<User> arrayList;
    private Context context;

    public CustomAdapter(ArrayList<User> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.CustomViewHolder holder, int position) {
        Glide.with(holder.itemView)
                .load(arrayList.get(position).getProfile())
                .into(holder.GH_profile);
        holder.GH_id.setText(arrayList.get(position).getId());
        holder.GH_pw.setText(arrayList.get(position).getPw());
        holder.GH_userName.setText(arrayList.get(position).getUserName());
    }

    @Override
    public int getItemCount() {
        //삼항 연산자
        return (arrayList != null ? arrayList.size() : 0);
    }
    public class CustomViewHolder extends RecyclerView.ViewHolder {
        ImageView GH_profile;
        TextView GH_id;
        TextView GH_pw;
        TextView GH_userName;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.GH_profile = itemView.findViewById(R.id.GH_profile);
            this.GH_id = itemView.findViewById(R.id.GH_id);
            this.GH_pw = itemView.findViewById(R.id.GH_pw);
            this.GH_userName = itemView.findViewById(R.id.GH_userName);
        }
    }
}

