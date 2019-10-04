package com.xuan.sort;

import com.xuan.util.SortUtil;

public class InsertionSort {
    private InsertionSort() {
        System.out.println("aaaa");
    }

    public static int[] sort(int[] array) {
        int length = array.length;
        for (int i = 1; i < length; i++) {
            int currentIndex = i;
            while (currentIndex > 0 && array[currentIndex - 1] > array[currentIndex]) {
                SortUtil.swap(array, currentIndex - 1, currentIndex);
                currentIndex--;
            }
        }
        return array;
    }

}