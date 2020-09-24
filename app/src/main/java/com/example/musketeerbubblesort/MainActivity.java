package com.example.musketeerbubblesort;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    public static final String DATA_INPUT_MESSAGE = "com.example.musketeerBubbleSort.DATAINPUT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void QuitApp(View view) {
        this.finishAffinity();
    }

    public void sortInputDataFromUser(View view) {
        Intent intent = new Intent(this, DisplaySortedInformationActivity.class);
        EditText editText = (EditText) findViewById(R.id.userInput);
        String message = editText.getText().toString();
        intent.putExtra(DATA_INPUT_MESSAGE, message);
        startActivity(intent);
    }


}