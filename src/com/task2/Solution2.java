package com.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Solution2 {

    public static ArrayList<Integer> getNewArray(ArrayList<Integer> array) {
        int maxValue = getMax(array);
        int startIndex = array.indexOf(getMax(array)) + 1;
        int addendMod = (maxValue + maxValue % array.size()) / array.size();
        int addendDiv = maxValue / array.size();
        array.set(startIndex - 1, 0);
        for (int i = 0; i < array.size(); i++) {
            if (startIndex >= array.size()) {
                startIndex = 0;
            }
            if (maxValue == addendDiv) {
                array.set(startIndex, array.get(startIndex) + addendDiv);
                break;
            }
            array.set(startIndex, array.get(startIndex) + addendMod);
            maxValue -= addendMod;
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
        ArrayList<Integer> modifiedList = new ArrayList<>(Arrays.asList(2000000000, 0));
        HashSet<ArrayList<Integer>> hashSet = new HashSet<>();
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        int count = 1;

        while (true) {
            ArrayList<Integer> list = new ArrayList<>(modifiedList);
            hashSet.add(list);
            arrayList.add(list);
            getNewArray(modifiedList);
            if (hashSet.contains(modifiedList)) {
                ArrayList<Integer> lastModifiedList = new ArrayList<>(modifiedList);
                hashSet.add(lastModifiedList);
                arrayList.add(lastModifiedList);
                break;
            }
            count++;
        }

        for (ArrayList<Integer> list : arrayList) {
            System.out.println(list);
        }
        System.out.printf("Number of steps: %d \nLoop length: %d", count, count - arrayList.indexOf(modifiedList));
    }
}