package com.infosys.barniv1.client.responses;

import android.os.AsyncTask;


import com.infosys.barniv1.client.BarniService;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by andrei on 24.02.18.
 */

public class AsyncResponse extends AsyncTask<Void, Void, Boolean> {

    private final String lang;
    private final String query;
    private final String timezone;
    private final String sessionId;
    private Callback<AsyncResponse> call = null;

    public AsyncResponse(String lang, String query, String timezone, String sessionId, Callback<AsyncResponse> call) {
        this.lang = lang;
        this.query = query;
        this.timezone = timezone;
        this.sessionId = sessionId;
        this.call = call;
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", "Bearer " + "d5fd544cdb5743fca633710dba5ffebe")
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BarniService.URL_BASE)
                .build();

        BarniService apiInterface = retrofit.create(BarniService.class);


        // prepare call in Retrofit 2.0
        try {
            JSONObject paramObject = new JSONObject();
            paramObject.put("lang", "de");
            paramObject.put("sessionId", "12345");
            paramObject.put("timezone", "America/New_York");
            paramObject.put("query", "I have to buy olive corn potato cabbage and lamb");

            //Call<AsyncResponse> userCall = apiInterface.loadResponse(paramObject.toString());
            //userCall.enqueue(call);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    protected void onPostExecute(final Boolean success) {

    }

    @Override
    protected void onCancelled() {

    }
}
