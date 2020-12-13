package com.jj.sparsearray;

import java.io.*;

public class SparseArray {
    public static void main(String[] args) {
//        创建原始的二维数组 11*11
//        0表示没有棋子，1表示黑子，2表示蓝子
        int[][] chessArray1 = new int[11][11];
        chessArray1[1][2]=1;
        chessArray1[2][3]=2;
        chessArray1[3][4]=2;

//        输出原始的二维数组
        for (int[] row : chessArray1) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

//        将二维数组转换成稀疏数组
//        1.遍历二维数组的非0有效个数sum,
        int sum = 0;
        for (int i = 0; i < chessArray1.length; i++) {
            for (int j = 0; j < chessArray1[i].length; j++) {
                if (chessArray1[i][j]!=0){
                    sum++;
                }
            }
        }
        System.out.println("非0有效个数sum="+sum);
//        2.创建稀疏数组sparseArray
        int[][] sparseArray = new int[sum+1][3];
//        3.遍历原始二维数组，将其有效数据存入稀疏数组（给稀疏数组赋值）
        sparseArray[0][0] = chessArray1.length;
        sparseArray[0][1] = chessArray1[0].length;
        sparseArray[0][2] = sum;
        int count = 0; //用于记录第几个非0数据
        for (int i = 0; i < chessArray1.length; i++) {
            for (int j = 0; j < chessArray1[i].length; j++) {
                if (chessArray1[i][j]!=0){
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArray1[i][j];
                }
            }
        }

//        输出稀疏数组
        System.out.println("得到稀疏数组如下=============");
        for (int i = 0; i < sparseArray.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n",sparseArray[i][0],sparseArray[i][1],sparseArray[i][2]);
        }
        System.out.println();

//        将稀疏数组存到磁盘
        FileWriter fw = null;
        try {
            fw = new FileWriter(new File("D:\\IDEA_workspace_2019.3\\DataStructures\\src\\com\\jj\\sparsearray\\sparsearray.data"));
            for (int i = 0; i < sparseArray.length; i++) {
                fw.write(sparseArray[i][0]+"\t"+sparseArray[i][1]+"\t"+sparseArray[i][2]+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw!=null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

//        从磁盘中读取稀疏数组
        int[][] sparseArray2 = null;
        BufferedReader br = null;
        boolean isNotRead=false;
        try {
            String lineStr = null;
            int curCount =0;
            br = new BufferedReader(new FileReader(new File("D:\\IDEA_workspace_2019.3\\DataStructures\\src\\com\\jj\\sparsearray\\sparsearray.data")));
            while ((lineStr=br.readLine())!=null){
                String[] tempStr = lineStr.split("\t");
                if (!isNotRead){
                    sparseArray2 = new int[Integer.parseInt(tempStr[2])+1][3];
                    sparseArray2[curCount][0]=Integer.parseInt(tempStr[0]);
                    sparseArray2[curCount][1]=Integer.parseInt(tempStr[1]);
                    sparseArray2[curCount][2]=Integer.parseInt(tempStr[2]);
                    isNotRead = true;
                    curCount++;
                }else {
                    sparseArray2[curCount][0]=Integer.parseInt(tempStr[0]);
                    sparseArray2[curCount][1]=Integer.parseInt(tempStr[1]);
                    sparseArray2[curCount][2]=Integer.parseInt(tempStr[2]);
                    curCount++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


//        将稀疏数组恢复成二维数组
//        1.先读取稀疏数组第一行的值，根据第一行的数据，创建原始的二维数组
        int[][] chessArray2 = new int[sparseArray2[0][0]][sparseArray2[0][1]];
//        2.再读取稀疏数组后几行的值，并赋值给二维数组即可
        for (int i = 1; i < sparseArray2.length; i++) {
                chessArray2[sparseArray2[i][0]][sparseArray2[i][1]] = sparseArray2[i][2];
        }

//        输出恢复后的数组
        System.out.println("恢复后的二维数组如下=============");
        for (int[] row : chessArray2) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}
