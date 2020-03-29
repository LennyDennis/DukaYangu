package com.lennydennis.dukayangu.adapters;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.lennydennis.dukayangu.R;
import com.lennydennis.dukayangu.model.Product;

public class FavoritesViewholder extends RecyclerView.ViewHolder {

    public ImageView favoriteItemImage;
    View view;
    Context context;

    public FavoritesViewholder(@NonNull View itemView) {
        super(itemView);
        view = itemView;
        context = itemView.getContext();
    }

    public void bindProduct(Product product) {
        favoriteItemImage = itemView.findViewById(R.id.favorite_image);
        TextView favoriteItemName = itemView.findViewById(R.id.favorite_name);
        TextView favoriteItemPrice = itemView.findViewById(R.id.favorite_price);
        TextView favoriteItemRating = itemView.findViewById(R.id.favorite_rating);

        Glide.with(context).asBitmap().load(product.getImage()).into(favoriteItemImage);

        favoriteItemName.setText(product.getName());
        String salesPrice = Double.toString(product.getSalePrice());
        favoriteItemPrice.setText("KSH " + salesPrice);
        String rating = Double.toString(product.getCustomerReviewAverage());
        favoriteItemRating.setText("Ratings: " + rating + "/5");
    }

}
