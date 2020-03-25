package com.lennydennis.dukayangu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Product> productList;
    private Context context;

    public RecyclerViewAdapter( Context context,List<Product> productList) {
        this.productList = productList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context)
                .asBitmap()
                .load(productList.get(position).getImage())
                .into(holder.imageView);
        holder.textName.setText(productList.get(position).getName());
        String salesPrice = Double.toString(productList.get(position).getSalePrice());
        holder.textPrice.setText("Ksh " + salesPrice);
    }

    @Override
    public int getItemCount()
    {
        return productList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textName;
        TextView textPrice;
        RelativeLayout parentLayout;

        public    ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textName = itemView.findViewById(R.id.textName);
            textPrice = itemView.findViewById(R.id.textPrice);
            parentLayout = itemView.findViewById(R.id.parentLayout);
        }
    }

//    public void searchList(List<Product> newList) {
//        productList = new ArrayList<>();
//        productList.addAll(newList);
//        notifyDataSetChanged();
//    }

}
