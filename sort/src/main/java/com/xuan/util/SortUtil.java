package com.xuan.util;

import java.util.Random;

public class SortUtil {

    private SortUtil() {
    }

    /***
     *随机生成一个长度为length ，元素为小于bound 的随机生成的正整数 的数组
     *@param length 数组长度
     * @param  bound  随机数的约束
     *@return int[]
     */
    public static int[] getArray(int length, int bound) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            Random random = new Random();
            array[i] = random.nextInt(bound);
        }
        return array;
    }


    public static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
    }
}
