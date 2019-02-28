package com.pursuit.unit_04_assessment.controller;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.pursuit.unit_04_assessment.R;
import com.pursuit.unit_04_assessment.SecondActivity;
import com.pursuit.unit_04_assessment.model.Echinoderm;

import org.w3c.dom.Text;

public class EchinodermViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
private ImageView imageView;
private TextView textView;
private Echinoderm echinoderm;

    public EchinodermViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.recycler_tile_image_view);
        textView = itemView.findViewById(R.id.recycler_tile_text_view);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }

    public void bind(final Echinoderm echinoderm) {
        textView.setText(echinoderm.getAnimal());
       // imageView.setImageURI();
       // textView.

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SecondActivity.class);
                        intent.putExtra("animal", echinoderm.getAnimal());
            }
        });
    }
}
