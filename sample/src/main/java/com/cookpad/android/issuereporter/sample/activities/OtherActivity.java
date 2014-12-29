package com.cookpad.android.issuereporter.sample.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.cookpad.android.issuereporter.sample.R;

public class OtherActivity extends Activity {
    public static void launch(Context context) {
        Intent intent = new Intent(context, OtherActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
    }
}
