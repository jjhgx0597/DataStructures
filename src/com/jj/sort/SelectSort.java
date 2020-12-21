package com.jj.sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
//        int arr[] = new int[]{-1,-3,2,3,1,4,-5};
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) Math.random()*80000000;
        }

        long begin = System.currentTimeMillis();
        System.out.println(begin);

        selectSort(arr);
       // System.out.println(Arrays.toString(arr));

        long end = System.currentTimeMillis();
        System.out.println(end);
        System.out.println("花费的时间为："+(end-begin)/1000+"秒");

    }

    public static void selectSort(int[] arr){
        int minIndex = 0;
        int min = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            min = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                if (min>arr[j]){//说明min不是最小值
                    min = arr[j];//重置min
                    minIndex = j;//重置minIndex
                }
            }
            if (minIndex!=i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
