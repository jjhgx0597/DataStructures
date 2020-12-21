package com.jj.search;

import java.util.Arrays;

public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i+1;
        }
        int resIndex = insertValueSearch(arr, 0, arr.length - 1, 111);
        System.out.println(resIndex);

//        System.out.println(Arrays.toString(arr));

    }

    public static int insertValueSearch(int[] arr,int left,int right,int findVal){

        if (left>right||findVal<arr[0]||findVal>arr[arr.length-1]){
            return -1;
        }
        int mid = left+(right-left)*(findVal-arr[left])/(arr[right]-arr[left]);
        int midVal = arr[mid];
        if (findVal<midVal){
            return insertValueSearch(arr,left,mid-1,findVal);
        }else if (findVal>midVal){
            return insertValueSearch(arr,mid+1,right,findVal);
        }else {
            return mid;
        }

    }
}
