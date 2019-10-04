package com.xuan;

import com.xuan.sort.InsertionSort;
import com.xuan.util.SortUtil;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int bound = scanner.nextInt();
        int[] array = SortUtil.getArray(length,bound);
        System.out.println(Arrays.toString(array) + "\n");
        int[] sortAfter = InsertionSort.sort(array);
        System.out.println(Arrays.toString(sortAfter));
    }
}
