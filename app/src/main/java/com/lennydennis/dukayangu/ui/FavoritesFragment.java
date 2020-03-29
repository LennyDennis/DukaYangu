package com.lennydennis.dukayangu.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.lennydennis.dukayangu.Constants;
import com.lennydennis.dukayangu.R;
import com.lennydennis.dukayangu.adapters.FavoritesViewholder;
import com.lennydennis.dukayangu.adapters.FirebaseFavoritesListAdapter;
import com.lennydennis.dukayangu.model.Product;
import com.lennydennis.dukayangu.util.OnStartDragListener;
import com.lennydennis.dukayangu.util.SimpleItemTouchHelperCallback;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritesFragment extends Fragment implements OnStartDragListener {

    private static final String TAG = "CartFragment";

    @BindView(R.id.favoritesRecyclerView) RecyclerView favoritesRecyclerView;

    private DatabaseReference favoritesReference;
    private FirebaseFavoritesListAdapter favoritesListAdapter;
    private ItemTouchHelper itemTouchHelper;

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

        setUpFirebaseAdapter();

        return view;
    }

    private void setUpFirebaseAdapter() {

        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        String userId = firebaseUser.getUid();

        Query query = FirebaseDatabase.getInstance()
                .getReference().child(Constants.FIREBASE_CHILD_FAVORITE)
                .child(userId)
                .orderByChild(Constants.FIREBASE_QUERY_INDEX);

        FirebaseRecyclerOptions<Product> options =
                new FirebaseRecyclerOptions.Builder<Product>()
                        .setQuery(query, Product.class).build();

        favoritesListAdapter = new FirebaseFavoritesListAdapter(options, query, this, getContext()) {
            @Override
            protected void onBindViewHolder(@NonNull FavoritesViewholder favoritesViewholder, int i, @NonNull Product product) {
                favoritesViewholder.bindProduct(product);
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
        favoritesListAdapter.startListening();
        favoritesRecyclerView.setAdapter(favoritesListAdapter);
        favoritesRecyclerView.setHasFixedSize(true);
        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(favoritesListAdapter);
        itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(favoritesRecyclerView);
    }

    @Override
    public void onStart() {
        super.onStart();
        favoritesListAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        if (favoritesListAdapter != null) {
            favoritesListAdapter.stopListening();
        }
    }

    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        itemTouchHelper.startDrag(viewHolder);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        favoritesListAdapter.stopListening();
    }

}
