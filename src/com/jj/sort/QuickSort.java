package com.jj.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1,-3,0,2,-5,9};

        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr,int left,int right){
        int l = left;
        int r = right;
        int privot = arr[(l+r)/2];
        int temp = 0;

        while (l<r){
            while (arr[l]<privot){
                l++;
            }
            while (arr[r]>privot){
                r--;
            }
            if (l>=r){
                break;
            }

            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后，发现arr[l]==privot,r--,前移
            if (arr[l]==privot){
                r-=1;
            }
            //如果交换完后，发现arr[r]==privot,l++,前移
            if (arr[r]==privot){
                l+=1;
            }

        }
        if (l==r){
            l++;
            r--;
        }
        //向左递归
        if (left<r){
            quickSort(arr,left,r);
        }
        //向右递归
        if (right>l){
            quickSort(arr,l,right);
        }
    }
}
