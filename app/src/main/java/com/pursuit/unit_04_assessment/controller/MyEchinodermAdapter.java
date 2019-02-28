package com.pursuit.unit_04_assessment.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pursuit.unit_04_assessment.R;
import com.pursuit.unit_04_assessment.model.Echinoderm;
import com.pursuit.unit_04_assessment.model.EchinodermsList;

import java.util.List;

public class MyEchinodermAdapter extends RecyclerView.Adapter<EchinodermViewHolder> {
    private List<Echinoderm> echinodermsList;

    public MyEchinodermAdapter(List<Echinoderm> echinodermList){
        this.echinodermsList = echinodermList;
    }

    @NonNull
    @Override
    public EchinodermViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view_tile, viewGroup, false);
        return new EchinodermViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EchinodermViewHolder echinodermViewHolder, int position) {
    echinodermViewHolder.bind(echinodermsList.get(position));
    }

    @Override
    public int getItemCount() {
        return echinodermsList.size();
    }
}
