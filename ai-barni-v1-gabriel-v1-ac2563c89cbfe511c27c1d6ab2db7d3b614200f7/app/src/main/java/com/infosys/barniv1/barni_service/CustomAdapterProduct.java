package com.infosys.barniv1.barni_service;

import android.content.Context;
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

import com.infosys.barniv1.Fragment_Product;
import com.infosys.barniv1.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by adrian on 2/7/2018.
 */

public class CustomAdapterProduct extends ArrayAdapter<Product> {

    private Context context;
    private List<Product> products;
    private String imageUrl = "https://i3.silhcdn.com/3/i/shapes/lg/4/7/d230474.jpg";
    ImageView productImageView;

    TextView tvProductName;
    TextView tvProductDescription;
    TextView tvProductPrice;

    public CustomAdapterProduct(@NonNull Context context, int textViewResourceId, @NonNull List<Product> objects) {
        super(context, textViewResourceId, objects);

        this.products = objects;
        this.context = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.slist_product_list_item, parent, false);

        tvProductName = rowView.findViewById(R.id.productListItemProductName);
        tvProductDescription = rowView.findViewById(R.id.productListItemProductDescription);

        productImageView = rowView.findViewById(R.id.productListItemImage);
        // TODO: find tiny images
        imageUrl = products.get(position).getProductImagePath().toString();
        loadImageFromUrl(imageUrl);

        tvProductName.setText(products.get(position).getProductName());
        tvProductDescription.setText(products.get(position).getProductDescription());
//        productImageView.setImageURI(Uri.parse(imageUrl)); // replaced by the into part from loadImageFromUrl


        rowView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Log.d("CAProduct-Click","you've clicked on a product");
                // open new fragment
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                FragmentManager fragmentManager = activity.getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                Fragment_Product fragmentProduct = new Fragment_Product();

                // TODO: pass data from ProductsList to Product page if you want

                fragmentTransaction.replace(R.id.theFrameLayout, fragmentProduct);
                fragmentTransaction.commit();

                Toast.makeText(context, products.get(position).getProductName(), Toast.LENGTH_SHORT).show();
            }
        });

        return rowView;
    }

    private void loadImageFromUrl(String url) {
        Picasso.with(getContext()).load(url).placeholder(R.mipmap.ic_launcher) //optional
                .error(R.mipmap.ic_launcher)
                .into(productImageView, new com.squareup.picasso.Callback(){

                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {

                    }
                });
    }


}
