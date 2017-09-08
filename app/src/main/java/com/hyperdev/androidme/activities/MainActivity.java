package com.hyperdev.androidme.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hyperdev.androidme.R;
import com.hyperdev.androidme.data.AndroidImageAssets;
import com.hyperdev.androidme.fragments.BodyPartFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            BodyPartFragment head = new BodyPartFragment();
            head.setList(AndroidImageAssets.getHeads());
            int headPosition = getIntent().getIntExtra("head", 0);
            head.setPosition(headPosition);

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.head, head)
                    .commit();

            BodyPartFragment body = new BodyPartFragment();
            body.setList(AndroidImageAssets.getBodies());
            int bodyPosition = getIntent().getIntExtra("body", 0);
            body.setPosition(bodyPosition);

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.body, body)
                    .commit();

            BodyPartFragment legs = new BodyPartFragment();
            legs.setList(AndroidImageAssets.getLegs());
            int legPosition = getIntent().getIntExtra("legs", 0);
            legs.setPosition(legPosition);

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.legs, legs)
                    .commit();
        }
    }
}