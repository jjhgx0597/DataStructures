package com.jj.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        //测试
        //创建一个队列
        CircleArrayQueue queue = new CircleArrayQueue(4);
        char key =' ' ;
        boolean loop = true;
        System.out.println("请输入你的选择：");
        Scanner scanner = new Scanner(System.in);
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出队列");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):取出队列数据");
            System.out.println("h(head):查看队列头的数据");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入你要添加到队列的数据：");
                    int n = scanner.nextInt();
                    queue.addQueue(n);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据为%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.printf("查看队列头数据为%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
//                    System.out.println("程序退出~~~");
//                    System.exit(0);

                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }

        }
        System.out.println("程序退出~~~");


    }
}

//使用数组模拟队列编写一个ArrayQueue类
class CircleArrayQueue{
    private int maxSize;//数组最大容量
    private int front;//队列头,指向队列的第一个元素， 也就是说arr[front]就是队列的第一个元素，初始值为0
    private int rear;//队列尾，指向队列最后一个元素的后一个位置，因为希望空出一个空间作为约定，初始值为0
    private int[] arr;//用于存放数据，模拟队列

    //   创建队列的构造器
    public CircleArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    //  判断队列是否满
    public boolean isFull(){
        return (rear+1)% maxSize == front;
    }
    //  判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }
    //  添加数据到队列
    public void addQueue(int n){
        if (isFull()){
            System.out.println("队列已满，不能再添加数据！");
            return;
        }
        //直接将数据加入
        arr[rear] = n;
        //将rear后移，必须考虑取模
        rear = (rear+1)%maxSize;
    }
    //  获取队列的数据，出队列
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，无法取出数据！");
        }
        //front是指向队列的第一个元素
        //1.先把front对应的值保存到临时变量
        //2.将front后移，考虑取模
        //3.将临时保存的变量取回
        int value = arr[front];
        front = (front+1)%maxSize;
        return value;
    }
    //  显示队列的所有数据
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空，没有数据！");
            return;
        }
        for (int i = front; i < front+size(); i++) {
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
        }
    }
    //获取对列的有效个数
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }

    //  获取队列的头数据，不是取出数据
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，没有数据！");
        }
        return arr[front];
    }
}
