package com.lennydennis.dukayangu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder> {

    private Context context;
    private List<Product> favoriteProducts;

    public FavoriteAdapter(Context context, List<Product> favoriteProducts) {
        this.context = context;
        this.favoriteProducts = favoriteProducts;
    }

    @NonNull
    @Override
    public FavoriteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorite_items,parent,false);
        FavoriteViewHolder favoriteViewHolder = new FavoriteViewHolder(view);
        return favoriteViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteViewHolder holder, int position) {
        Glide.with(context)
                .asBitmap()
                .load(favoriteProducts.get(position).getImage())
                .into(holder.favoriteItemImage);
        holder.favoriteItemName.setText(favoriteProducts.get(position).getName());
        String salesPrice = Double.toString(favoriteProducts.get(position).getSalePrice());
        holder.favoriteItemPrice.setText("KSH "+ salesPrice);
        String rating = Double.toString(favoriteProducts.get(position).getCustomerReviewAverage());
        holder.favoriteItemRating.setText("Ratings: "+rating);

    }

    @Override
    public int getItemCount() {
        return favoriteProducts.size();
    }

    public class FavoriteViewHolder extends RecyclerView.ViewHolder{

        ImageView favoriteItemImage;
        TextView favoriteItemName;
        TextView favoriteItemRating;
        TextView favoriteItemPrice;

        public FavoriteViewHolder(@NonNull View itemView) {
            super(itemView);

            favoriteItemImage = itemView.findViewById(R.id.favorite_image);
            favoriteItemName = itemView.findViewById(R.id.favorite_name);
            favoriteItemPrice = itemView.findViewById(R.id.favorite_price);
            favoriteItemRating = itemView.findViewById(R.id.favorite_rating);
        }
    }
}
