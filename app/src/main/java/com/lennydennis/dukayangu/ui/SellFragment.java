package com.lennydennis.dukayangu.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lennydennis.dukayangu.BestBuyApi;
import com.lennydennis.dukayangu.BestBuyProductSearchResponse;
import com.lennydennis.dukayangu.BestBuyRetrofitInstance;
import com.lennydennis.dukayangu.Product;
import com.lennydennis.dukayangu.R;
import com.lennydennis.dukayangu.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SellFragment extends Fragment {
    private static final String TAG = "SellFragment";
    @BindView(R.id.recyclerView) RecyclerView recyclerView;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    RecyclerView.LayoutManager layoutManager;

    List<Product> productList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sell, container, false);
        ButterKnife.bind(this,view);

        BestBuyApi client  = BestBuyRetrofitInstance.getProducts();

        Call<BestBuyProductSearchResponse> call = client.getProducts();

        call.enqueue(new Callback<BestBuyProductSearchResponse>() {
            @Override
            public void onResponse(Call<BestBuyProductSearchResponse> call, Response<BestBuyProductSearchResponse> response) {

                if(response.isSuccessful()) {
                    productList = response.body().getProducts();
                    RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(),productList);
                    recyclerView.setAdapter(recyclerViewAdapter  );
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

}
