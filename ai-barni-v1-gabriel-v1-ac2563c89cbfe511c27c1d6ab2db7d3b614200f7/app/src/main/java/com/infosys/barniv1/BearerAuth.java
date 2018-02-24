package com.infosys.barniv1;

import android.text.TextUtils;

import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gabriel.gheorghe on 2/23/2018.
 */

public class BearerAuth {
//    public static final String API_BASE_URL = "https://api.dialogflow.com/v1/query?v=20150910/";
//
//    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
//
//    private static Retrofit.Builder builder =
//            new Retrofit.Builder()
//                    .baseUrl(API_BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create());
//
//    public static <S> S createService(Class<S> serviceClass) {
//        return createService(serviceClass, null);
//    }
//
//    public static <S> S createService(
//            Class<S> serviceClass, String clientId, String clientSecret) {
//        if (!TextUtils.isEmpty(clientId)
//                && !TextUtils.isEmpty(clientSecret)) {
//            String authToken = Credentials.basic(clientId, clientSecret);
//            return createService(serviceClass, authToken);
//        }
//
//        return createService(serviceClass, null, null);
//    }
//
//    public static <S> S createService(
//            Class<S> serviceClass, final String authToken) {
//        if (!TextUtils.isEmpty(authToken)) {
//            AuthenticationInterceptor interceptor =
//                    new AuthenticationInterceptor(authToken);
//
//            if (!httpClient.interceptors().contains(interceptor)) {
//                httpClient.addInterceptor(interceptor);
//
//                builder.client(httpClient.build());
//                retrofit = builder.build();
//            }
//        }
//
//        return retrofit.create(serviceClass);
//    }
}
