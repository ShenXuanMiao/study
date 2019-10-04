package com.xuan.sort;

import com.xuan.util.SortUtil;

public class ShellSort {
    private ShellSort() {
    }

    public static int[] sort(int[] array) {
        int length = array.length;

        int gap = length;
        while (gap > 0) {
            gap =gap / 2;
            for (int i = gap; i < length; i++) {
                int currentIndex = i;
                while (currentIndex-gap > 0 && array[currentIndex - gap] < array[currentIndex]) {
                    SortUtil.swap(array, currentIndex - gap, currentIndex);
                    currentIndex-=gap;
                }
            }
        }
        return array;
    }
}
