package com.hyperdev.androidme.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hyperdev.androidme.R;

import java.util.ArrayList;
import java.util.List;



public class BodyPartFragment extends Fragment {

    private static final String list = "list";
    private static final String position = "position";
    private List<Integer> parts;
    private int partPosition;

    public BodyPartFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {

        if(savedInstanceState != null){
            parts = savedInstanceState.getIntegerArrayList(list);
            partPosition = savedInstanceState.getInt(position);
        }

        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);

        final ImageView imageView = (ImageView)rootView.findViewById(R.id.bodypartfragment);
        if(parts != null){
            imageView.setImageResource(parts.get(partPosition));
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(partPosition < parts.size()-1){
                        partPosition++;
                    }else {
                        partPosition = 0;
                    }
                    imageView.setImageResource(parts.get(partPosition));
                }
            });
        }
        return rootView;
    }

    public void setList(List<Integer> list) {
        this.parts = list;
    }

    public void setPosition(int partPosition) {
        this.partPosition = partPosition;
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntegerArrayList(list, (ArrayList<Integer>)parts);
        outState.putInt(position,partPosition);
    }
}