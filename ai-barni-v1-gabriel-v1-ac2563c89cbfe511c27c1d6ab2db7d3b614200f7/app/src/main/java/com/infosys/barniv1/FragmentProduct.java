package com.infosys.barniv1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


///**
// * A simple {@link Fragment} subclass.
// * Activities that contain this fragment must implement the
// * {@link FragmentProduct.OnFragmentInteractionListener} interface
// * to handle interaction events.
// * Use the {@link FragmentProduct#newInstance} factory method to
// * create an instance of this fragment.

public class FragmentProduct extends Fragment {


    ListView productListView;

    int[] productIds;
    String[] productNames;
    String[] productImages;
    String[] productDescriptions;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_product, container, false);

//        // open new fragment - add to cart
//        // TODO: this is stupid...put add to cart on the list.... this is only details view
//        AppCompatActivity activity = (AppCompatActivity) view.getContext();
//        FragmentManager fragmentManager = activity.getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//        Fragment_Cart fragmentCart = new Fragment_Cart();
//
//        fragmentTransaction.replace(R.id.theFrameLayout, fragmentCart);
//        fragmentTransaction.commit();

        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


}
