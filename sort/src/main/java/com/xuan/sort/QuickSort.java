package com.xuan.sort;

import com.xuan.util.SortUtil;

public class QuickSort {
    private QuickSort() {
    }


    public  static void sort(int[] array, int left, int right) {
        if (left>right){
            return;
        }
        int pivotValue=array[left];
        int begin = left + 1;
        int end = right;
        while (begin < end) {
            while (array[end] >= pivotValue && begin < end) {
                end--;
            }

            while (array[begin] <= pivotValue && begin < end) {
                begin++;
            }
            if (begin < end) {
                SortUtil.swap(array,begin,end);

            }

        }
        array[left]=array[begin];
        array[begin]=pivotValue;
        sort(array, left, begin - 1);
        sort(array, begin + 1, right);

    }
}
