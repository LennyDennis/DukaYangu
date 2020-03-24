package com.lennydennis.dukayangu.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lennydennis.dukayangu.BestBuyApi;
import com.lennydennis.dukayangu.BestBuyProductSearchResponse;
import com.lennydennis.dukayangu.BestBuyRetrofitInstance;
import com.lennydennis.dukayangu.FavoriteAdapter;
import com.lennydennis.dukayangu.Product;
import com.lennydennis.dukayangu.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritesFragment extends Fragment {

    private static final String TAG = "CartFragment";
    @BindView(R.id.favoritesRecyclerView) RecyclerView favoritesRecyclerView;
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

        BestBuyApi client  = BestBuyRetrofitInstance.getProducts();

        Call<BestBuyProductSearchResponse> call = client.getProducts();

        call.enqueue(new Callback<BestBuyProductSearchResponse>() {
            @Override
            public void onResponse(Call<BestBuyProductSearchResponse> call, Response<BestBuyProductSearchResponse> response) {

                if(response.isSuccessful()) {
                    favoriteItems = response.body().getProducts();
                    FavoriteAdapter favoriteAdapter = new FavoriteAdapter(getContext(),favoriteItems);
                    favoritesRecyclerView.setAdapter(favoriteAdapter);
                    layoutManager = new LinearLayoutManager(getContext());
                    favoritesRecyclerView.setLayoutManager(layoutManager);
//                    showProducts();
                }else{
                    Log.d(TAG, "unsuccessful");
                }
            }

            @Override
            public void onFailure(Call<BestBuyProductSearchResponse> call, Throwable t) {
                Log.d(TAG, "failed");
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}
