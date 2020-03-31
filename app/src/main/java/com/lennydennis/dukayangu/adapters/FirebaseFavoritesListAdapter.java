package com.lennydennis.dukayangu.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.lennydennis.dukayangu.R;
import com.lennydennis.dukayangu.model.Product;
import com.lennydennis.dukayangu.util.ItemTouchHelperAdapter;
import com.lennydennis.dukayangu.util.OnStartDragListener;

import java.util.ArrayList;
import java.util.Collections;

public class FirebaseFavoritesListAdapter extends FirebaseRecyclerAdapter<Product, FavoritesViewholder> implements ItemTouchHelperAdapter {

    private DatabaseReference databaseReference;
    private OnStartDragListener onStartDragListener;
    private Context context;
    private Query query;
    private ChildEventListener childEventListener;
    private ArrayList<Product> products = new ArrayList<>();

    public FirebaseFavoritesListAdapter(@NonNull FirebaseRecyclerOptions<Product> options, Query query, OnStartDragListener onStartDragListener, Context context) {
        super(options);
        this.query = query.getRef();
        this.onStartDragListener = onStartDragListener;
        this.context = context;

        childEventListener = query.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                products.add(dataSnapshot.getValue(Product.class));
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onBindViewHolder(@NonNull FavoritesViewholder favoritesViewholder, int i, @NonNull Product product) {
        favoritesViewholder.bindProduct(product);
        favoritesViewholder.favoriteItemImage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
                    onStartDragListener.onStartDrag(favoritesViewholder);
                }
                return false;
            }
        });
    }

    @NonNull
    @Override
    public FavoritesViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorite_items, parent, false);
        return new FavoritesViewholder(view);
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(products, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        setIndexInFirebase();
        return false;
    }

    @Override
    public void stopListening() {
        super.stopListening();
        query.removeEventListener(childEventListener);
    }

    @Override
    public void onItemDismiss(int position) {
        products.remove(position);
        getRef(position).removeValue();
    }

    private void setIndexInFirebase() {
        for (Product product : products) {
            int index = products.indexOf(product);
            DatabaseReference ref = getRef(index);
            product.setIndex(Integer.toString(index));
            ref.setValue(product);
        }
    }

}

