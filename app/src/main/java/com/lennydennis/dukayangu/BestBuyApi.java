package com.lennydennis.dukayangu;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BestBuyApi {

    @GET("products?show=sku,name,type,salePrice,image&format=json")
    Call<BestBuyProductSearchResponse> getProducts();
}
