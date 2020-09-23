package com.example.musketeerbubblesort;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DisplaySortedInformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_sorted_information);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.DATA_INPUT_MESSAGE);

        TextView textView = findViewById(R.id.displaySortedInformationTextView);
        textView.setText(message);

    }
    public void QuitApp(View view) {
        DisplaySortedInformationActivity.this.finish();
        System.exit(0);
    }
}