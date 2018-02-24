package com.infosys.barniv1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.infosys.barniv1.barni_service.BarniService;
import com.infosys.barniv1.barni_service.CustomAdapterProduct;
import com.infosys.barniv1.barni_service.Product;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by adrian on 2/4/2018.
 */

public class FragmentSListProducts extends Fragment {


    ListView productListView;

    int[] productIds;
    String[] productNames;
    String[] productImages;
    String[] productDescriptions;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


        final View view = inflater.inflate(R.layout.fragment_slist_products, container, false);

        // put the data that you wanted to be received from previous fragment
        Bundle bundle = getArguments();
        String categoryName = bundle.getString("categoryName");

        // set the title
        this.getActivity().setTitle("Products per "+categoryName);


        // build retrofit obj
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BarniService.BASE_BARNI_SERVICE_URI)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        // build api
        BarniService api = retrofit.create(BarniService.class);

        // call our api
        Call<List<Product>> call = api.getProducts();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {

                // create list from body
                List<Product> productResponse = response.body();
                // convert list to ArrayLisy
                List<Product> productsArrayList = new ArrayList<Product>();

                for (Product pt : productResponse) {

                    Product product = new Product();

                    Log.d("FragmentSListProducts=",pt.getProductName());

                    product.setProductImagePath(pt.getProductImagePath());
                    product.setProductName(pt.getProductName());
                    product.setProductDescription(pt.getProductDescription());

                    productsArrayList.add(product);

                }

                productListView = (ListView) view.findViewById(R.id.idProductsListView);
                CustomAdapterProduct customAdapter = new CustomAdapterProduct(view.getContext(), R.layout.slist_product_list_item, productsArrayList);
                productListView.setAdapter(customAdapter);

            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Log.e("ERROR", "An error has occured!");
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
////        return super.onCreateView(inflater, container, savedInstanceState);
////        return inflater.inflate(R.layout.slist_product_list_fragment, container, false);
//
//        View rootView = inflater.inflate(R.layout.slist_product_list_fragment, container, false);
//
//        Bundle bundle = getArguments();
//        String categoryName = bundle.getString("categoryName");
//
//        TextView idCategoryNameTextView = rootView.findViewById(R.id.idTextViewProductsCategoryName);
//        idCategoryNameTextView.setText(categoryName);
//
//        return rootView;
//    }
}
