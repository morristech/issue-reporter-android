package com.cookpad.android.issuereporter.sample.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.cookpad.android.issuereporter.sample.R;

public class DetailActivity extends Activity {
    private static final String EXTRA_POSITION = "extra_position";

    public static void launch(Context context, int position) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(EXTRA_POSITION, position);
        context.startActivity(intent);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setupViews();
    }

    private void setupViews() {
        int position = getIntent().getIntExtra(EXTRA_POSITION, -1);

        TextView titleTextView = (TextView) findViewById(R.id.title_text);
        titleTextView.setText("Hello! I'm Android " + position);
    }
}
