package com.infosys.barniv1.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.infosys.barniv1.R;
import com.infosys.barniv1.application.BarniApplication;
import com.infosys.barniv1.client.request.ClientRequest;
import com.infosys.barniv1.client.responses.QueryResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class BarniActivity extends AppCompatActivity {

    private ImageButton buton = null;
    private EditText editText;
    private static final String TAG = BarniActivity.class.getCanonicalName();
    private TextView text = null;
    //change it - pune l in alta part - gen config file -> res/raw/config.xml ceva de genul
    private String token = "d5fd544cdb5743fca633710dba5ffebe";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barni);

        text = (TextView) findViewById(R.id.textView2);
        buton = (ImageButton) findViewById(R.id.idBtnGen);
        editText = (EditText) findViewById(R.id.txvResult);

        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                executeCall();
            }
        });
    }

    private void executeCall() {

        List<String> contexts = new ArrayList<>();
        contexts.add("shop");
        ClientRequest request = new ClientRequest.RequestBuilder()
                .language("de")
                .sessionId("12345")
                .timezone("America/New_York")
                .contexts(contexts)
                .query(editText.getText().toString())
                .build();

        Call<QueryResponse> call = BarniApplication.getInstance().getManager().loadResponse(token, request);
        call
                .enqueue(new Callback<QueryResponse>() {
                    @Override
                    public void onResponse(Call<QueryResponse> call, retrofit2.Response<QueryResponse> response) {
                        Log.d(TAG, "response from server:" + response.body().getResult().getParameters().getListItem().get(0));
                    }

                    @Override
                    public void onFailure(Call<QueryResponse> call, Throwable t) {
                        Log.e(TAG, "exception in call:" + t.getLocalizedMessage());
                    }
                });
    }

}

