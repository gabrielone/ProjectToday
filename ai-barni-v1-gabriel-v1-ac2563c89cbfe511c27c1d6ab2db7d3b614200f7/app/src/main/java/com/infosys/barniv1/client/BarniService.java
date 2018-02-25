package com.infosys.barniv1.client;

import com.infosys.barniv1.client.request.ClientRequest;
import com.infosys.barniv1.client.responses.QueryResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Barni service interface.
 */

public interface BarniService {

    String URL_BASE = "https://api.dialogflow.com/v1/";

    String query = "query?v=20150910/";
    @Headers("Content-Type: application/json")
    @POST("query?v=20150910/")
    Call<QueryResponse> loadResponse(@Body ClientRequest body);

}