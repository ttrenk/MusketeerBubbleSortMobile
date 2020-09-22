package com.example.musketeerbubblesort;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
class BubbleSortTest {

    private MainActivity.BubbleSortAlgorithm sorter = new MainActivity.BubbleSortAlgorithm();

    @Test
    public void emptyArrayDoesNothing() {
        int[] userArray = {};
        sorter.bubbleSort(userArray, userArray.length);
    }

    @Test
    public void oneElementArrayDoesNothing() {
        int[] userArray = {11};
        sorter.bubbleSort(userArray, userArray.length);
        assertArrayEquals(new int[] {11}, userArray);
    }

    @Test
    public void validArrayShouldBeSorted() {
        int[] userArray = {5, 4, 3, 2, 1};
        int[] expectedOrder = {1, 2, 3, 4, 5};
        sorter.bubbleSort(userArray, userArray.length);
        assertArrayEquals(expectedOrder, userArray);
    }
}
