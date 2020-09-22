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

        //Convert user's input: string --> array of integers
        int[] unsortedInput = Arrays.stream(message.split(" ")).mapToInt(Integer::parseInt).toArray();

        //Sort the array and display the output on the next screen as a string
        String sortedMessage= BubbleSortAlgorithm.bubbleSort(unsortedInput, unsortedInput.length);
        intent.putExtra(DATA_INPUT_MESSAGE, sortedMessage);
        startActivity(intent);
    }

    public static class BubbleSortAlgorithm {
        public static String bubbleSort(int[] unsortedValues, int numValues)
        {
            /**
             * Iterates through the unsorted data to return a string that outputs the sorted data
             * @param unsortedValues The user input in the form of an array of integers
             * @param numValues The length of the array
             * @return The string containing all of the sorting iterations and intermediate steps
            **/
            StringBuilder sortingIteration = new StringBuilder();
            sortingIteration.append("Input Array: ").append(Arrays.toString(unsortedValues)).append("\n")
                            .append("BubbleSort (Intermediate Steps)\n");
            int current = 0;
            while (current < numValues-1)
            {
                sortingIteration.append(bubbleUp(unsortedValues, current, numValues - 1)).append("\n");
                current++;
            }
            return sortingIteration.toString();
        }
        public static String bubbleUp(int[] unsortedValues, int startIndex, int endIndex)
        {
            /**
             * Iterates through the array to return a string that outputs each intermediate sorting step
             * @param unsortedValues The user input in the form of an array of integers
             * @param startIndex The first element of the array
             * @param endIndex The last element of the array
             * @return The string containing all of the intermediate sorting steps of the iteration
             */
            StringBuilder sortingIteration = new StringBuilder();
            sortingIteration.append(Arrays.toString(unsortedValues)).append("\n");
            int temp = 0;
            for (int index = endIndex; index > startIndex; index--)
            {
                sortingIteration.append(Arrays.toString(unsortedValues)).append("\n");
                if (unsortedValues[index] < unsortedValues[index-1])
                {
                    temp = unsortedValues[index];
                    unsortedValues[index] = unsortedValues[index-1];
                    unsortedValues[index-1] = temp;
                }
            }
            return sortingIteration.toString();
        }
    }
}