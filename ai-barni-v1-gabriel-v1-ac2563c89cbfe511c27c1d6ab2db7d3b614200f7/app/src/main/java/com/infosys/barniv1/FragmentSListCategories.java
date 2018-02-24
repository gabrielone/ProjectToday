package com.infosys.barniv1;

import android.content.Context;
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
import com.infosys.barniv1.barni_service.Category;
import com.infosys.barniv1.barni_service.CustomAdapterCategory;

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

public class FragmentSListCategories extends Fragment {


    ListView categoryListView;

    int[] categoryIds;
    String[] categoryNames;
    String[] categoryImages;
    String[] categoryDescriptions;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


        final View view = inflater.inflate(R.layout.fragment_slist_categories, container, false);

        this.getActivity().setTitle("Categories of Products");


        // build retrofit obj
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BarniService.BASE_BARNI_SERVICE_URI)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        // build api
        BarniService api = retrofit.create(BarniService.class);

        // call our api
        Call<List<Category>> call = api.getCategories();
        call.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {

                // create list from body
                List<Category> categoryResponse = response.body();
                // convert list to ArrayLisy
                List<Category> categorysArrayList = new ArrayList<Category>();

                for (Category pt : categoryResponse) {

                    Category category = new Category();

                    Log.d("INLISTA == ",pt.getCategoryName());

                    category.setCategoryImagePath(pt.getCategoryImagePath());
                    category.setCategoryName(pt.getCategoryName());
                    category.setCategoryDescription(pt.getCategoryDescription());

                    categorysArrayList.add(category);

                }

                categoryListView = (ListView) view.findViewById(R.id.idCategoriesListView);
                CustomAdapterCategory customAdapter = new CustomAdapterCategory(view.getContext(), R.layout.slist_category_list_item, categorysArrayList);
                categoryListView.setAdapter(customAdapter);

            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
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

}
