package com.lennydennis.dukayangu.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lennydennis.dukayangu.R;
import com.lennydennis.dukayangu.adapters.RecyclerViewAdapter;
import com.lennydennis.dukayangu.model.Product;
import com.lennydennis.dukayangu.network.BestBuyApi;
import com.lennydennis.dukayangu.network.BestBuyProductSearchResponse;
import com.lennydennis.dukayangu.network.BestBuyRetrofitInstance;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsFragment extends Fragment implements SearchView.OnQueryTextListener {
    private static final String TAG = "SellFragment";
    @BindView(R.id.recyclerView) RecyclerView recyclerView;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    RecyclerView.LayoutManager layoutManager;

    List<Product> productList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_products, container, false);
        ButterKnife.bind(this,view);

        BestBuyApi client  = BestBuyRetrofitInstance.getProducts();

        Call<BestBuyProductSearchResponse> call = client.getProducts();

        call.enqueue(new Callback<BestBuyProductSearchResponse>() {
            @Override
            public void onResponse(Call<BestBuyProductSearchResponse> call, Response<BestBuyProductSearchResponse> response) {

                if(response.isSuccessful()) {
                    productList = response.body().getProducts();
                    RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(),productList);
                    recyclerView.setAdapter(recyclerViewAdapter);
                    layoutManager = new GridLayoutManager(getContext(),2);
                    recyclerView.setLayoutManager(layoutManager);
                    showProducts();
                }else{
                    showUnsuccessfulMessage();
                }
            }

            @Override
            public void onFailure(Call<BestBuyProductSearchResponse> call, Throwable t) {
                showFailureMessage();
            }
        });

        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_search, menu);

        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(this);
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void showProducts() {
        recyclerView.setVisibility(View.VISIBLE);
    }

    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }


}
