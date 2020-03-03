package com.lennydennis.dukayangu;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<String> itemName = new ArrayList<>();
    private  ArrayList<String> itemImage = new ArrayList<>();
    private ArrayList<String> itemPrice = new ArrayList<>();
    private Context context;

    public RecyclerViewAdapter( Context context,ArrayList<String> itemName, ArrayList<String> itemImage, ArrayList<String> itemPrice) {
        this.itemName = itemName;
        this.itemImage = itemImage;
        this.itemPrice = itemPrice;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_item,parent,false);
        ViewHolder ViewHolder = new ViewHolder(view);
        return ViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context)
                .asBitmap()
                .load(this.itemImage.get(position))
                .into(holder.imageView);
        holder.textName.setText(this.itemName.get(position));
        holder.textPrice.setText(this.itemPrice.get(position));
    }

    @Override
    public int getItemCount()
    {
        return this.itemName.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textName;
        TextView textPrice;
        LinearLayout parentLayout;

        public    ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textName = itemView.findViewById(R.id.textName);
            textPrice = itemView.findViewById(R.id.textPrice);
            parentLayout = itemView.findViewById(R.id.parentLayout);
        }
    }

}
