package com.cookpad.android.issuereporter.sample.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import com.cookpad.android.issuereporter.sample.R;

public class MainActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
    }

    private void setupViews() {
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOtherActivity();
            }
        });
    }

    private void openOtherActivity() {
        OtherActivity.launch(this);
    }
}
