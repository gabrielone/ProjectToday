package com.infosys.barniv1;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by adrian on 2/4/2018.
 */

public class Fragment_Barni extends Fragment {

    private TextView txvResult;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View viewBarni = inflater.inflate(R.layout.fragment_barni, container, false);

        // check if the idBarniSearchFor is empty.
        // if yes go to the Barni Voice Activity
        // else keep the current page and current results
        TextView txvBarniCheckFor = (TextView) viewBarni.findViewById(R.id.idBarniCheckFor);
        String valueTxvBarniCheckFor = txvBarniCheckFor.getText().toString();


        Log.d("MY_LOG",valueTxvBarniCheckFor.toString());

        if (valueTxvBarniCheckFor.equalsIgnoreCase("looking for...") || valueTxvBarniCheckFor == null) {
            Intent intent = new Intent(getContext(), BarniActivity.class);
            startActivity(intent);

            this.getActivity().setTitle("Talk To Barni");
        }

        this.getActivity().setTitle("Barni Results");

        txvResult = (TextView) viewBarni.findViewById(R.id.txvResult);

        return viewBarni;
    }

    public void getSpeechInput(View view){

        Toast.makeText(getContext(),"Open Barni Speech",Toast.LENGTH_SHORT).show();
//
//        Intent intent = new Intent(getContext(), BarniActivity.class);
//        startActivity(intent);
//
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 10:
                if (/*resultCode == RESULT_OK &&*/ data != null) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    txvResult.setText(result.get(0));
                }
                break;
        }
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}
