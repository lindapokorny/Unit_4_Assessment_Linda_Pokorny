package com.pursuit.unit_04_assessment;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.pursuit.unit_04_assessment.fragments.DetailFragment;

public class SecondActivity extends AppCompatActivity implements DetailFragment.OnFragmentInteractionListener {
    private TextView animalTextView;
    private ImageView animalImageView;
    private Button submitButton;
    private final String ANIMAL = "animal";
    private final String IMAGE = "image";
    private final String URL = "wiki";
    private String nameText;
    private String animalImage;
    private String wikiUrl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

    }

    @Override
    public void onFragmentInteraction(String website) {

        animalTextView =findViewById(R.id.detail_fragment_name_text);
        Intent intent = getIntent();
        nameText = intent.getStringExtra(ANIMAL);
        animalImage = intent.getStringExtra(IMAGE);
        wikiUrl = intent.getStringExtra(URL);

        DetailFragment detailFragment = DetailFragment.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.second_activity_container, detailFragment).commit();


    }
}
