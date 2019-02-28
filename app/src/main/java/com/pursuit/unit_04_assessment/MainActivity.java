package com.pursuit.unit_04_assessment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;


import com.pursuit.unit_04_assessment.fragments.DetailFragment;
import com.squareup.picasso.Picasso;

import com.pursuit.unit_04_assessment.controller.MyEchinodermAdapter;
import com.pursuit.unit_04_assessment.model.Echinoderm;
import com.pursuit.unit_04_assessment.model.EchinodermsList;
import com.pursuit.unit_04_assessment.network.EchinodermService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    final Retrofit retrofit = createRetrofit();

    private List<Echinoderm> echinodermsList = new ArrayList<>();

    private ImageView animal;
    private RecyclerView recyclerView;
    private String myEchinodermAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animal = findViewById(R.id.recycler_tile_image_view);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(new MyEchinodermAdapter(echinodermsList));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        }

    public void onResponse(Call<Echinoderm> call, Response<Echinoderm> response){
        Echinoderm responseAnimal = response.body();

        Picasso.get()
                .load(responseAnimal.getAnimal())
                .into((ImageView) echinodermsList);
    }
    public void onFailure(Call<EchinodermsList> call, Throwable t){

    }
    private Retrofit createRetrofit(){
        return new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

}
