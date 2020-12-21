package com.jj.sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{-2,-3,-1,3,2,4,6,5,1};

        selectSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr){
        int insertVal = 0;
        int insertIndex = 0;
        for (int i = 1; i < arr.length ; i++) {
            insertVal = arr[i];
            insertIndex = i-1;

            while (insertIndex>=0&&arr[insertIndex]>insertVal){
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }
            if (insertIndex-1!=i){
                arr[insertIndex+1] = insertVal;
            }
        }

    }
}
