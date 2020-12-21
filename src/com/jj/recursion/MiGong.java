package com.jj.recursion;

/**
 * 迷宫问题
 */
public class MiGong {
    public static void main(String[] args) {
        //模拟迷宫，地图
        int[][] map = new int[8][7];
        //1代表墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
//        map[1][2] = 1;


        //打印迷宫
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~");

        //使用递归回溯给小球找路
        setWay(map,1,1);

        //打印回溯迷宫，小球走过，并标识过
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
    //迷宫问题如何求出最短路径？
    //用数组将不同的策略存储，遍历数组，得到不同的图解，获取迷宫中节点为2 的数量，最少的即为最短路径



    //使用递归回溯给小球找路
    //说明
    //1.map表示地图
    //2.i,j表示从哪个位置开始找 (1,1)
    //3.如果小球能到map[6][5],则说明通路找到
    //4.约定：当map[i][j]为0,表示该点没有走过
    //       当map[i][j]为1，表示该点为墙
    //       当map[i][j]为2，表示通路可以走
    //       当map[i][j]为3，表示该位置走过，但是走不通
    //5.在走迷宫时需要确定一个策略（方法） 下=》右=》上=》右，如果该点走不通，再回溯
    /**
     *
     * @param map 表示地图
     * @param i 从哪个位置开始找
     * @param j
     * @return 如果找到通路返回true，否则false
     */
    public static boolean setWay(int[][] map,int i,int j){
        if (map[6][5]==2){//通路已经找到
            return true;
        }else {
            if (map[i][j]==0){//如果当前这个点没有走过
                //按照策略 下->右->上->左 走
                map[i][j] = 2;//假定该点是可以走通的
                if (setWay(map,i+1,j)){ //向下走
                    return true;
                }else if (setWay(map,i,j+1)){ //向右走
                    return true;
                }else if (setWay(map,i-1,j)){ //向上走
                    return true;
                }else if (setWay(map,i,j-1)){ //向左走
                    return true;
                }else {
                    //说明该点是走不通的，是死路
                    map[i][j] = 3;
                    return false;
                }
            }else {//如果 map[i][j]！=0，可能是1，2，3
                return false;

            }
        }
    }
    public static boolean setWay2(int[][] map,int i,int j){
        if (map[6][5]==2){//通路已经找到
            return true;
        }else {
            if (map[i][j]==0){//如果当前这个点没有走过
                //按照策略 下->右->上->左 走
                map[i][j] = 2;//假定该点是可以走通的
                if (setWay(map,i+1,j)){ //向下走
                    return true;
                }else if (setWay(map,i,j+1)){ //向右走
                    return true;
                }else if (setWay(map,i-1,j)){ //向上走
                    return true;
                }else if (setWay(map,i,j-1)){ //向左走
                    return true;
                }else {
                    //说明该点是走不通的，是死路
                    map[i][j] = 3;
                    return false;
                }
            }else {//如果 map[i][j]！=0，可能是1，2，3
                return false;

            }
        }
    }
}
