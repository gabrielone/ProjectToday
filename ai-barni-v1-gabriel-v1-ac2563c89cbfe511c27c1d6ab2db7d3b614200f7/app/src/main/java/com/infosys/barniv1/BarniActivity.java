package com.infosys.barniv1;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.TextView;

import com.infosys.barniv1.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public class BarniActivity extends AppCompatActivity implements Callback<Rez> {

    private ImageButton buton = null;
    private TextView text = null;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barni);
        final Rez r = new Rez("","","","",this);
        text = (TextView) findViewById(R.id.textView2);
        buton = (ImageButton) findViewById(R.id.idBtnGen);
        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                r.doInBackground();
            }
        });






    }


    @Override
    public void onResponse(Call<Rez> call, retrofit2.Response<Rez> response) {

    }

    @Override
    public void onFailure(Call<Rez> call, Throwable t) {
    }
}

interface ApiInterface {

    public static String URL_BASE = "https://api.dialogflow.com/v1/query?v=20150910/";

    @Headers("Content-Type: application/json")

    Call<Rez> getRez(@Body String body);

}

class Rez extends AsyncTask<Void, Void, Boolean> {

    private final String lang;
    private final String query;
    private final String timezone;
    private final String sessionId;
    private Callback<Rez> call = null;
    public Rez(String lang, String query,String timezone,String sessionId,Callback<Rez> call) {
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
                Request newRequest  = chain.request().newBuilder()
                        .addHeader("Authorization", "Bearer " + "d5fd544cdb5743fca633710dba5ffebe")
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ApiInterface.URL_BASE)
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);


        // prepare call in Retrofit 2.0
        try {
            JSONObject paramObject = new JSONObject();
            paramObject.put("lang", "de");
            paramObject.put("sessionId", "12345");
            paramObject.put("timezone", "America/New_York");
            paramObject.put("query", "I have to buy olive corn potato cabbage and lamb");

            Call<Rez> userCall = apiInterface.getRez(paramObject.toString());
            userCall.enqueue(call);
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

