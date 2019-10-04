package com.xuan.sort;

import com.xuan.util.SortUtil;

public class SelectionSort {
    private SelectionSort(){}
    public static int[] sort(int[] array){
        int length=array.length;
        for (int i = 0; i < length - 1; i++) {
            int maxIndex = length - 1 - i;
            for (int j = 0; j < length - 1 - i; j++) {
                if (array[maxIndex] < array[j]) {
                    maxIndex = j;
                }
            }
            int temp = array[maxIndex];
            array[maxIndex] = array[length - 1 - i];
            array[length - 1 - i] = temp;

            SortUtil.swap(array,maxIndex,length - 1 - i);

        }
        return  array;
    }
}
