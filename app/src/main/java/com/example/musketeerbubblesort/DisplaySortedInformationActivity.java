package com.example.musketeerbubblesort;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Arrays;

public class DisplaySortedInformationActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_sorted_information);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.DATA_INPUT_MESSAGE);

        //Convert user's input: string --> array of integers
        int[] unsortedInput = Arrays.stream(message.split(" ")).mapToInt(Integer::parseInt).toArray();

        //Sort the array and display the output on the next screen as a string
        String sortedMessage= BubbleSortAlgorithm.bubbleSort(unsortedInput, unsortedInput.length);

        TextView textView = findViewById(R.id.displaySortedInformationTextView);
        textView.setText(sortedMessage);
    }

    public void QuitApp(View view) {
        this.finishAffinity();
    }

    public static class BubbleSortAlgorithm {
        /*
         * Iterates through the unsorted data to return a string that outputs the sorted data
         * @param unsortedValues The user input in the form of an array of integers
         * @param numValues The length of the array
         * @return The string containing all of the sorting iterations and intermediate steps
         */
        public static String bubbleSort(int[] unsortedValues, int numValues)
        {
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
        /*
         * Iterates through the array to return a string that outputs each intermediate sorting step
         * @param unsortedValues The user input in the form of an array of integers
         * @param startIndex The first element of the array
         * @param endIndex The last element of the array
         * @return The string containing all of the intermediate sorting steps of the iteration
         */
        public static String bubbleUp(int[] unsortedValues, int startIndex, int endIndex)
        {
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