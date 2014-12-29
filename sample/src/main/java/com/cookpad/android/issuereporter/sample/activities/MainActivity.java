package com.cookpad.android.issuereporter.sample.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.RecyclerView;

import com.cookpad.android.issuereporter.sample.R;
import com.cookpad.android.issuereporter.sample.adapters.ListAdapter;

public class MainActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
    }

    private void setupViews() {
        RecyclerView listView = (RecyclerView) findViewById(R.id.list_view);
        ListAdapter listAdapter = new ListAdapter(listView);
        listView.setAdapter(listAdapter);
    }
}
