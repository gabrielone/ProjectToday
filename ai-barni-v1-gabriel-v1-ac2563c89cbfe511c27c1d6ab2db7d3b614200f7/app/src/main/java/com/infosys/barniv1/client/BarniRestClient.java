package com.infosys.barniv1.client;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infosys.barniv1.client.interceptors.AuthenticationInterceptor;
import com.infosys.barniv1.client.adapters.MyGsonAdapterFactory;
import com.infosys.barniv1.client.request.ClientRequest;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.infosys.barniv1.client.BarniService.URL_BASE;

/**
 * Rest client.
 */

public class BarniRestClient {

    private OkHttpClient okHttpClient;
    private Retrofit retrofit;

    private String token = null;

    public BarniRestClient(String token) {
        this.token = token;
        initOkHttpClient();
        initRetrofitClient();
    }

    public BarniRestClient() {

    }

    public void setToken(String token) {
        this.token = token;
        initOkHttpClient();
        initRetrofitClient();
    }

    private void initRetrofitClient() {
        Retrofit.Builder builder = getRetrofitClient();
        retrofit = builder.build();
    }

    private void initOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(10, TimeUnit.SECONDS);
        builder.retryOnConnectionFailure(false);

        builder.addInterceptor(new AuthenticationInterceptor(token));
        okHttpClient = builder.build();
    }

    public <S> S createService(Class<S> serviceClass) {
        if (token == null) {
            throw new RuntimeException("token for authentication cannot be null");
        }
        return retrofit.create(serviceClass);
    }

    private Retrofit.Builder getRetrofitClient() {

        return new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .client(okHttpClient)

                // okHttpBuilder.callFactory()
                .addConverterFactory(GsonConverterFactory.create());

    }
}
