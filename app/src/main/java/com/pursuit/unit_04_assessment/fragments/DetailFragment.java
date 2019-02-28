package com.pursuit.unit_04_assessment.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.pursuit.unit_04_assessment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {
    private OnFragmentInteractionListener listener;
    private View rootView;
    private TextView textView;
    private ImageView imageView;
    private Button button;


    public DetailFragment() { }

    public static DetailFragment newInstance() {
        DetailFragment fragment = new DetailFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        textView = rootView.findViewById(R.id.detail_fragment_name_text);
        imageView = rootView.findViewById(R.id.detail_fragment_image_view);
        button = rootView.findViewById(R.id.detail_fragment_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String websiteTextString = textView.getText().toString();
                onButtonPressed(websiteTextString);
            }
        });
        return rootView;
    }

    public void onButtonPressed(String website){
        if (listener != null){
            listener.onFragmentInteraction(website);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener){
            listener = (OnFragmentInteractionListener)context;
        } else{
            throw new RuntimeException(context.toString()
            + "must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public interface OnFragmentInteractionListener {
     void onFragmentInteraction(String website);
    }
}
