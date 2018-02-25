package com.infosys.barniv1.barni_service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Barni service.
 */

public interface BarniService {

    String BASE_BARNI_SERVICE_URI = "http://83.103.212.192:9095/barni-services/api/v1/";

    @GET("category")
    Call<List<Category>> getCategories();

    @GET("traditional")
    Call<List<Product>> getProducts();
}
