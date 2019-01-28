package com.task;

import java.util.*;

public class Solution {

    public static ArrayList<Integer> getNewArray(ArrayList<Integer> array) {
        int maxValue = getMax(array);
        int startIndex = array.indexOf(getMax(array)) + 1;
        array.set(startIndex - 1, 0);
        while (true) {
            if (startIndex >= array.size()) {
                startIndex = 0;
            }
            if (maxValue == 0) break;
            array.set(startIndex, array.get(startIndex) + 1);
            maxValue--;
            startIndex++;
        }
        return array;
    }

    public static int getMax(ArrayList<Integer> array) {
        int maxValue = array.get(0);
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i) > maxValue) {
                maxValue = array.get(i);
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        ArrayList<Integer> modifiedList = new ArrayList<>(Arrays.asList(0, 5, 10, 0, 11, 14, 13, 4, 11, 8, 8, 7, 1, 4, 12, 11));
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        int count = 1;

        while (true) {
            arrayList.add(new ArrayList<>(modifiedList));
            getNewArray(modifiedList);
            if (arrayList.contains(modifiedList)) {
                arrayList.add(new ArrayList<>(modifiedList));
                break;
            }
            count++;
        }

        for (ArrayList<Integer> list : arrayList) {
            System.out.println(list);
        }
        System.out.printf("Number of steps: %d \nLoop length: %d", count, count-arrayList.indexOf(modifiedList));
    }
}



