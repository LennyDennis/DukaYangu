package com.lennydennis.dukayangu.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.lennydennis.dukayangu.R;
import com.lennydennis.dukayangu.adapters.FavoritesViewholder;
import com.lennydennis.dukayangu.model.Product;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritesFragment extends Fragment {

    private static final String TAG = "CartFragment";

    @BindView(R.id.favoritesRecyclerView) RecyclerView favoritesRecyclerView;

    private DatabaseReference favoritesReference;
    private FirebaseRecyclerOptions<Product> options;
    private FirebaseRecyclerAdapter<Product, FavoritesViewholder> favoritesAdapter;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private String userId;

    LinearLayoutManager layoutManager;
    List<Product> favoriteItems;

    public FavoritesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_favorites, container, false);
        ButterKnife.bind(this,view);
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        userId = firebaseUser.getUid();

        favoritesReference = FirebaseDatabase.getInstance().getReference().child("Favorites").child(userId);
        options = new FirebaseRecyclerOptions.Builder<Product>()
                .setQuery(favoritesReference, Product.class).build();

        favoritesAdapter = new FirebaseRecyclerAdapter<Product, FavoritesViewholder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull FavoritesViewholder favoritesViewholder, int i, @NonNull Product product) {

                Glide.with(getContext())
                        .asBitmap()
                        .load(product.getImage())
                        .into(favoritesViewholder.favoriteItemImage);
                favoritesViewholder.favoriteItemName.setText(product.getName());
                String salesPrice = Double.toString(product.getSalePrice());
                favoritesViewholder.favoriteItemPrice.setText("KSH " + salesPrice);
                String rating = Double.toString(product.getCustomerReviewAverage());
                favoritesViewholder.favoriteItemRating.setText("Ratings: " + rating);
            }

            @NonNull
            @Override
            public FavoritesViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorite_items, parent, false);
                return new FavoritesViewholder(view);
            }
        };

        layoutManager = new LinearLayoutManager(getContext());
        favoritesRecyclerView.setLayoutManager(layoutManager);
        favoritesAdapter.startListening();
        favoritesRecyclerView.setAdapter(favoritesAdapter);
        return view;
    }

}
