package com.example.musketeerbubblesort;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    public static final String DATA_INPUT_MESSAGE = "com.example.musketeerBubbleSort.DATAINPUT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void sortInputDataFromUser(View view) {
        Intent intent = new Intent(this, DisplaySortedInformationActivity.class);
        EditText editText = (EditText) findViewById(R.id.userInput);
        String message = editText.getText().toString();
        int[] unsortedInput = Arrays.stream(message.split(" ")).mapToInt(Integer::parseInt).toArray();
        BubbleSortAlgorithm.bubbleSort(unsortedInput, unsortedInput.length);
        String sortedMessage = Arrays.toString(unsortedInput);
        intent.putExtra(DATA_INPUT_MESSAGE, sortedMessage);
        startActivity(intent);
    }

    public static class BubbleSortAlgorithm {
        public static void bubbleSort(int[] unsortedValues, int numValues)
        {
            int current = 0;
            while (current < numValues-1)
            {
                bubbleUp(unsortedValues, current, numValues-1);
                current++;
            }
        }

        public static void bubbleUp(int[] unsortedValues, int startIndex,
                             int endIndex)
        {
            int temp = 0;
            for (int index = endIndex; index > startIndex; index--)
            {
                if (unsortedValues[index] < unsortedValues[index-1])
                {
                    temp = unsortedValues[index];
                    unsortedValues[index] = unsortedValues[index-1];
                    unsortedValues[index-1] = temp;
                }
            }
        }
    }


}