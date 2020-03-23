package com.lennydennis.dukayangu.ui;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.viewpager.widget.ViewPager;

import com.lennydennis.dukayangu.BestBuyApi;
import com.lennydennis.dukayangu.BestBuyProductSearchResponse;
import com.lennydennis.dukayangu.BestBuyRetrofitInstance;
import com.lennydennis.dukayangu.Product;
import com.lennydennis.dukayangu.R;
import com.lennydennis.dukayangu.RecyclerViewAdapter;
import com.lennydennis.dukayangu.ViewPagerAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private static final String TAG = "HomeFragment";
    @BindView(R.id.view_pager) ViewPager viewPager;

    List<Product> mostViewedProducts;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this,view);

        BestBuyApi client  = BestBuyRetrofitInstance.getProducts();

        Call<BestBuyProductSearchResponse> call = client.getProducts();

        call.enqueue(new Callback<BestBuyProductSearchResponse>() {
            @Override
            public void onResponse(Call<BestBuyProductSearchResponse> call, Response<BestBuyProductSearchResponse> response) {

                if(response.isSuccessful()) {
                    mostViewedProducts = response.body().getProducts();
                    ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(mostViewedProducts, getContext());
                    viewPager.setAdapter(viewPagerAdapter);
                }else{
                    showUnsuccessfulMessage();
                }
            }

            @Override
            public void onFailure(Call<BestBuyProductSearchResponse> call, Throwable t) {
                showFailureMessage();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

    private void showFailureMessage() {
        Log.d(TAG,"Failure");
    }

    private void showUnsuccessfulMessage() {
        Log.d(TAG,"Something went wrong. Please check your Internet connection and try again later");
    }
}
