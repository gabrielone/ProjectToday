package com.infosys.barniv1.barni_service;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.infosys.barniv1.FragmentSListProducts;
import com.infosys.barniv1.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by adrian on 2/7/2018.
 */

public class CustomAdapterCategory extends ArrayAdapter<Category> {

    private Context context;
    private List<Category> categorys;
    private String imageUrl = "https://i3.silhcdn.com/3/i/shapes/lg/4/7/d230474.jpg";
    ImageView categoryImageView;

    TextView tvProductName;
    TextView tvProductDescription;
    TextView tvProductPrice;

    public CustomAdapterCategory(@NonNull Context context, int textViewResourceId, @NonNull List<Category> objects) {
        super(context, textViewResourceId, objects);

        this.categorys = objects;
        this.context = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.slist_category_list_item, parent, false);

        tvProductName = rowView.findViewById(R.id.categoryListItemProductName);
        tvProductDescription = rowView.findViewById(R.id.categoryListItemProductDescription);

        categoryImageView = rowView.findViewById(R.id.categoryListItemImage);
        // TODO: find tiny images
        imageUrl = categorys.get(position).getCategoryImagePath().toString();
        loadImageFromUrl(imageUrl);

        tvProductName.setText(categorys.get(position).getCategoryName());
        tvProductDescription.setText(categorys.get(position).getCategoryDescription());
//        categoryImageView.setImageURI(Uri.parse(imageUrl)); // replaced by the into part from loadImageFromUrl


        rowView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.d("SARI LA=","pagina de produse din acesta categorie");

//                // open new fragment
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                FragmentManager fragmentManager = activity.getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                FragmentSListProducts fragmentSListProducts = new FragmentSListProducts();

                // get the Category and pass it to the Products
                Bundle bundle = new Bundle();
                bundle.putString("categoryName", categorys.get(position).getCategoryName());
                fragmentSListProducts.setArguments(bundle);//send bundle to target fragment

                fragmentTransaction.replace(R.id.theFrameLayout, fragmentSListProducts);
                fragmentTransaction.commit();

                Toast.makeText(context, "Am selectat categoria = "+categorys.get(position).getCategoryName(), Toast.LENGTH_SHORT).show();
            }
        });

        return rowView;
    }

    private void loadImageFromUrl(String url) {
        Picasso.with(getContext()).load(url).placeholder(R.mipmap.ic_launcher) //optional
                .error(R.mipmap.ic_launcher)
                .into(categoryImageView, new com.squareup.picasso.Callback(){

                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {

                    }
                });
    }


}
