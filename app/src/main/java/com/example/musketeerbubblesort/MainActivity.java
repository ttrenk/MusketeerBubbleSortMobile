package com.example.musketeerbubblesort;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Arrays;


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

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void sortInputDataFromUser(View view) {
        Intent intent = new Intent(this, DisplaySortedInformationActivity.class);
        EditText editText = (EditText) findViewById(R.id.userInput);
        Button submit = (Button) findViewById(R.id.button);
        String message = editText.getText().toString();
        try {

            if (message.isEmpty() || message == null ) {
                editText.setError("Please refer to the directions for the proper format to input text");
            }
            else {


                int[] unsortedInput = Arrays.stream(message.split(" ")).mapToInt(Integer::parseInt).toArray();

                boolean singleDigit = true;
                for (int i = 0; i < unsortedInput.length; i++) {
                    if (unsortedInput[i] > 9 || unsortedInput[i] < 0) {
                        singleDigit = false;
                    }
                }


                   if (editText.getText().length() == 0) {
                    editText.setError("Please refer to the directions for the proper format to input text");
                } else if (unsortedInput.length > 8) {
                    editText.setError("Please refer to the directions for the proper format to input text");
                } else if (unsortedInput.length < 3) {
                    editText.setError("Please refer to the directions for the proper format to input text");
                } else if (!message.contains("")) {
                    editText.setError("Please refer to the directions for the proper format to input text");
                } else if (message.contains(",")) {
                    editText.setError("Please refer to the directions for the proper format to input text");
                } else if (!singleDigit) {
                    editText.setError("Please refer to the directions for the proper format to input text");
                } else {

                    intent.putExtra(DATA_INPUT_MESSAGE, message);
                    startActivity(intent);
                }
            }
        } catch (Exception e)
        {
            editText.setError("Please contact Musketeer Bubblesort support team for assistance");
        }
    }
}