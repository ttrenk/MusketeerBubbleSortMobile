package com.example.musketeerbubblesort;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
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
        SpannableStringBuilder sortedMessage= BubbleSortAlgorithm.bubbleSort(unsortedInput, unsortedInput.length);

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
        public static SpannableStringBuilder bubbleSort(int[] unsortedValues, int numValues)
        {
            SpannableStringBuilder sortingIteration = new SpannableStringBuilder();
            sortingIteration.append("Input Array: ").append(Arrays.toString(unsortedValues)
                    .replaceAll("\\[|\\]|,", "")).append("\n\n")
                    .append("BubbleSort (Intermediate Steps)\n");
            int current = 0;
            while (current < numValues-1)
            {
                sortingIteration.append(bubbleUp(unsortedValues, current, numValues - 1)).append("\n");
                current++;
            }
            sortingIteration.append("Sorted Array: ");
            SpannableStringBuilder finalSortedResult = new SpannableStringBuilder(Arrays.toString(unsortedValues)
                    .replaceAll("\\[|\\]|,", "")).append("\n");
            finalSortedResult.setSpan(new ForegroundColorSpan(Color.RED), 0, unsortedValues.length * 2,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            return sortingIteration.append(finalSortedResult);
        }
        /*
         * Iterates through the array to return a string that outputs each intermediate sorting step
         * @param unsortedValues The user input in the form of an array of integers
         * @param startIndex The first element of the array
         * @param endIndex The last element of the array
         * @return The string containing all of the intermediate sorting steps of the iteration
         */
        public static SpannableStringBuilder bubbleUp(int[] unsortedValues, int startIndex, int endIndex)
        {
            // Initialize SpannableStringBuilder
            SpannableStringBuilder spanningString = new SpannableStringBuilder();

            // Grab the initial array of each pass
            spanningString.append(Arrays.toString(unsortedValues)
                    .replaceAll("\\[|\\]|,", "")).append("\n");

            // Stylize the initial array of each pass
            spanningString.setSpan(new ForegroundColorSpan(Color.RED), 0, startIndex * 2,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            spanningString.setSpan(new UnderlineSpan(), startIndex * 2, endIndex * 2 + 1,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

            int temp = 0;
            for (int index = endIndex; index > startIndex; index--)
            {
                // Grab array and underline numbers being switched
                SpannableStringBuilder sortingLoopStep = new SpannableStringBuilder(Arrays.toString(unsortedValues)
                        .replaceAll("\\[|\\]|,", "")).append("\n");
                sortingLoopStep.setSpan(new UnderlineSpan(), index * 2 - 2, index * 2 + 1,
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                // Bold the current number that is "bubbling up"
                sortingLoopStep.setSpan(new StyleSpan(Typeface.BOLD), index * 2, index * 2 + 1,
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                spanningString.append(sortingLoopStep);

                // Switch values if end value is smaller than front value
                if (unsortedValues[index] < unsortedValues[index-1])
                {
                    temp = unsortedValues[index];
                    unsortedValues[index] = unsortedValues[index-1];
                    unsortedValues[index-1] = temp;
                }
            }
            // Grab final array iteration then style text
            SpannableStringBuilder finalArrayStep = new SpannableStringBuilder(Arrays.toString(unsortedValues)
                    .replaceAll("\\[|\\]|,", "")).append("\n");
            finalArrayStep.setSpan(new StyleSpan(Typeface.BOLD), startIndex * 2, startIndex * 2 + 1,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            finalArrayStep.setSpan(new ForegroundColorSpan(Color.RED), 0, startIndex * 2,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            spanningString.append(finalArrayStep);
            return spanningString;
        }
    }
}