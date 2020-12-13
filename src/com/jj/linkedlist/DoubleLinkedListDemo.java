package com.jj.linkedlist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        System.out.println("双向链表的测试~~~~~~~~~~~");
        //进行测试，先创建节点
        HeroNode2 hero1 = new HeroNode2(1,"宋江","及时雨");
        HeroNode2 hero2 = new HeroNode2(2,"卢俊义","玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3,"吴用","智多星");
        HeroNode2 hero4 = new HeroNode2(4,"林冲","豹子头");

        //创建显示双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();

        //修改双向链表
        HeroNode2 newHeroNode = new HeroNode2(4,"林冲哥哥","豹子头");
        doubleLinkedList.update(newHeroNode);
        System.out.println("修改后显示链表~~~");
        doubleLinkedList.list();

        //删除节点
        doubleLinkedList.del(3);
        System.out.println("删除后显示链表~~~");
        doubleLinkedList.list();
    }
}

//定义DoubleLinkedList管理我们的英雄
class DoubleLinkedList{
    //初始化一个头结点，不存放任何数据,
    private HeroNode2 head = new HeroNode2(0,"","");

    public HeroNode2 getHead() {
        return head;
    }

    //遍历双向链表的方法
    //显示链表
    public void list(){
        //判断链表是否为空
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        while (true){
            if (temp==null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
        System.out.println();
    }

    //添加节点到双向链表
    //当不考虑编号顺序时
    //1.找到当前链表的最后一个节点
    //2.将最后这个节点的next指向新的节点
    public void add(HeroNode2 heroNode){
        //因为head不能动，我们需要借助一个辅助节点
        HeroNode2 temp = head;
        //遍历列表，找到最后
        while (true){
            if (temp.next==null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    //修改节点的信息，根据英雄编号来修改，即no不可变
    public void update(HeroNode2 newHeroNode){
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;//判断是否找到该节点
        while (true){
            if (temp==null){//说明到链表尾部
                break;
            }
            if (temp.no==newHeroNode.no){//说明已经找到要修改的节点位置
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }else {
            System.out.printf("没有找到编号为%d的英雄，不能修改\n",newHeroNode.no);
        }
    }

    //删除节点的信息
    public void del(int no){
        if (head.next==null){
            System.out.println("链表为空，无法删除");
        }
        HeroNode2 temp = head.next;//借助temp节点找到待删除节点
        boolean flag = false;//标志是否找到待删除节点
        while (true){
            if (temp==null){//已经遍历结束
                break;
            }
            if (temp.no==no){//找到要删除的节点temp
                flag=true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
//            temp.next = temp.next.next;
            temp.pre.next=temp.next;
            if (temp.next!=null){
                temp.next.pre = temp.pre;
            }
        }else{
            System.out.printf("不存在编号为%d的待删除英雄\n",no);
        }

    }
}

//定义HeroNode2,每个HeroNode2对象就是一个节点
class HeroNode2{
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;//指向下一个节点，默认为null
    public HeroNode2 pre;//指向上一个节点，默认为null

    //构造器
    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}