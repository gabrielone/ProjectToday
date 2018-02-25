package com.infosys.barniv1.client.interceptors;

import android.text.TextUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Authorization interceptor used for authorization.
 */

public class AuthenticationInterceptor implements Interceptor {

    public static final String AUTHORIZATION_KEY = "Authorization";

    private String token;

    public AuthenticationInterceptor(String token) {
        this.token = token;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();

        Request.Builder requestBuilder = original.newBuilder();
        if (original.header(AUTHORIZATION_KEY) == null && !TextUtils.isEmpty(token)) {
            requestBuilder.addHeader(AUTHORIZATION_KEY, getToken(token));
        }

        Request request = requestBuilder.build();
        return chain.proceed(request);
    }

    private String getToken(String token) {
        return "Bearer " + token;
    }
}