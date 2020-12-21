package com.jj.sort;

import java.util.Arrays;

/**
 * 基数排序法
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53,3,542,748,14,214};
        radixSort(arr);
    }

    public static void radixSort(int[] arr){

        //根据推导过程，可以得到最终的基数排序代码
        //1.得到数组中最大的数的位数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]>max){
                max = arr[i];
            }
        }
        //得到最大数是几位数
        int maxLength = (max+"").length();

        //定义一个二维数组，表示10个数，每个桶就是一个一维数组
        int[][] bucket = new int[10][arr.length];

        //定义一个一维数组记录各个桶的每次放入的个数（桶中实际个数）
        int[] bucketElementCounts = new int[10];

        for (int l = 0; l < maxLength; l++) {
            for (int i = 0; i < arr.length; i++) {
                //取出每个元素的个位值
                int digitOfElement = arr[i]/(int) Math.pow(10,l )%10;
                //放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
                bucketElementCounts[digitOfElement]++;
            }
            //按照桶的顺序（一维数组的下标依次取出数据，放入原来数组）
            int index= 0;
            //遍历每一个桶，并将桶中数据放入到原数组
            for (int j = 0; j < bucketElementCounts.length; j++) {
                //如果桶中有数据，才放入到数组中
                if (bucketElementCounts[j]!=0){
                    //循环该桶，放入到arr
                    for (int k=0;k<bucketElementCounts[j];k++){
                        arr[index] = bucket[j][k];
                        index++;
                    }
                }
                //第一轮处理后，需要将bucketElementCounts[j]置零
                bucketElementCounts[j]=0;
            }
            System.out.println(Arrays.toString(arr));
        }

       /* //第一轮，针对每个元素的个位数进行排序处理
        //第一轮，
        for (int i = 0; i < arr.length; i++) {
            //取出每个元素的个位值
            int digitOfElement = arr[i]%10;
            //放入到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
            bucketElementCounts[digitOfElement]++;
        }
        //按照桶的顺序（一维数组的下标依次取出数据，放入原来数组）
        int index= 0;
        //遍历每一个桶，并将桶中数据放入到原数组
        for (int j = 0; j < bucketElementCounts.length; j++) {
            //如果桶中有数据，才放入到数组中
            if (bucketElementCounts[j]!=0){
                //循环该桶，放入到arr
                for (int k=0;k<bucketElementCounts[j];k++){
                    arr[index] = bucket[j][k];
                    index++;
                }
            }
            //第一轮处理后，需要将bucketElementCounts[j]置零
            bucketElementCounts[j]=0;
        }
        System.out.println(Arrays.toString(arr));



        //第二轮，
        for (int i = 0; i < arr.length; i++) {
            //取出每个元素的个位值
            int digitOfElement = arr[i]/10%10;
            //放入到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
            bucketElementCounts[digitOfElement]++;
        }
        //按照桶的顺序（一维数组的下标依次取出数据，放入原来数组）
        index= 0;
        //遍历每一个桶，并将桶中数据放入到原数组
        for (int j = 0; j < bucketElementCounts.length; j++) {
            //如果桶中有数据，才放入到数组中
            if (bucketElementCounts[j]!=0){
                //循环该桶，放入到arr
                for (int k=0;k<bucketElementCounts[j];k++){
                    arr[index] = bucket[j][k];
                    index++;
                }
            }
            //第一轮处理后，需要将bucketElementCounts[j]置零
            bucketElementCounts[j]=0;
        }
        System.out.println(Arrays.toString(arr));


        //第三轮，
        for (int i = 0; i < arr.length; i++) {
            //取出每个元素的个位值
            int digitOfElement = arr[i]/100%10;
            //放入到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
            bucketElementCounts[digitOfElement]++;
        }
        //按照桶的顺序（一维数组的下标依次取出数据，放入原来数组）
        index= 0;
        //遍历每一个桶，并将桶中数据放入到原数组
        for (int j = 0; j < bucketElementCounts.length; j++) {
            //如果桶中有数据，才放入到数组中
            if (bucketElementCounts[j]!=0){
                //循环该桶，放入到arr
                for (int k=0;k<bucketElementCounts[j];k++){
                    arr[index] = bucket[j][k];
                    index++;
                }
            }
            //第一轮处理后，需要将bucketElementCounts[j]置零
            bucketElementCounts[j]=0;
        }
        System.out.println(Arrays.toString(arr));*/
    }

}
