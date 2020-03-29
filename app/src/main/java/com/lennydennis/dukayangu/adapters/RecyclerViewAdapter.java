package com.lennydennis.dukayangu.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.lennydennis.dukayangu.R;
import com.lennydennis.dukayangu.model.Product;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";
    private List<Product> productList;
    private Context context;

    private DatabaseReference favoriteDatabaseReference;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;
    private String userId;

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

        holder.favoriteView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.favoriteView.setImageResource(R.drawable.ic_favorite_black_24dp);
                Log.d(TAG, "onClick: clicked on: " + productList.get(position).getName());

                addFavoriteProductToFirebase();
            }

            private void addFavoriteProductToFirebase() {
                String favoriteName = productList.get(position).getName();
                String favoriteImage = productList.get(position).getImage();
                double favoriteRating = productList.get(position).getCustomerReviewAverage();
                double favoritePrice = productList.get(position).getSalePrice();

                favoriteDatabaseReference = FirebaseDatabase.getInstance().getReference();
                firebaseAuth = FirebaseAuth.getInstance();
                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                userId = firebaseUser.getUid();
                Product favoriteProduct = new Product(favoriteName, favoritePrice, favoriteImage, favoriteRating);
                favoriteDatabaseReference.child("Favorites").child(userId).push().setValue(favoriteProduct);

            }

        });
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
        ImageView favoriteView;
//        RelativeLayout parentLayout;

        public    ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textName = itemView.findViewById(R.id.textName);
            textPrice = itemView.findViewById(R.id.textPrice);
            favoriteView = itemView.findViewById(R.id.select_favorite_item);
//            parentLayout = itemView.findViewById(R.id.parentLayout);
        }
    }

//    public void searchList(List<Product> newList) {
//        productList = new ArrayList<>();
//        productList.addAll(newList);
//        notifyDataSetChanged();
//    }

}
