package com.lin.dataStructure.queue;

import java.util.Scanner;

/**
 * @program: DataStructureAndAlg
 * @description: 队列 数组实现
 * @author: linsz
 * @create: 2022-09-10 02:09
 **/
public class ArrayQueue {

    public static void main(String[] args) {
        ArrQueue queue = new ArrQueue(3);
        showSelectors();
        descArrayQueue(queue);

    }

    public static void descArrayQueue(ArrQueue queue){
        // 当flag为true时将进行循环
        Scanner scanner = new Scanner(System.in);
        char key = ' ';
        boolean flag = true ;
        while (flag){
            System.out.println("请输入序号进行查询---->");
             key = scanner.next().charAt(0);
            switch (key){
               case 'a':
                   try {
                       System.out.println("头结点为====>"+queue.getHead());
                   } catch (Exception e) {
                       e.printStackTrace();
                   }
                   break;
               case 'b':
                   System.out.println("当前队列如下====>");
                   queue.showArrayQueue();
                   break;
               case 'c':
                   int inputValue = scanner.nextInt();
                   System.out.println(queue.inputQueue(inputValue));
                   break;
                case 'd':
                    try {
                        System.out.println("出队列的是=====>"+queue.outputQueue());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'e':
                    scanner.close();
                    flag = false;
                    break;
                default:
                    break;

            }

        }
    }
    public static void showSelectors(){
        System.out.println("----------------------------");
        System.out.println("a. 展示头结点");
        System.out.println("b. 展示队列");
        System.out.println("c. 入队列");
        System.out.println("d. 出队列");
        System.out.println("e. 退出队列");
        System.out.println("----------------------------");
    }



}


class ArrQueue{
    /**
     * 最大容量
     */
    private int maxSize;
    /**
     * 数组存放
     */
    private int arr[];
    /**
     * 头指针 指向当前节点的前一个位置
     */
    private int front ;
    /**
     * 尾指针  指向最后一个节点的位置
     */
    private int rear;

    public ArrQueue(){}
    /**
     * 构造函数
     */
    public ArrQueue(int maxSize) {
        this.maxSize = maxSize ;
        arr = new int[maxSize];//赋初始值
        /**
         * 头指针 指向当前节点的前一个位置
         */
        front = -1;
        /**
         * 尾指针  指向最后一个节点的位置
         */
        rear = -1;

    }

    /**
     * 判断是否队列为空
     * @return
     */
    public boolean isEmpty(){
        if (this.rear != this.front){
            return false;
        }else
            return true;
    }

    /**
     * 判断队列是否满
     * @return
     */
    public boolean isFull(){
        return this.rear == maxSize - 1 ;
    }

    /**
     * 添加一个元素 入队操作  头出front  尾插 rear
     * @param num
     * @return
     */
    public boolean inputQueue(int num){
        // 先判断队列是否为满
        if (isFull()){
            throw new RuntimeException("当前队列为满，不可继续增加元素");
        }else {
            //rear 为空为 -1 那是不是要让arr[0] 等于num 那是不是rear == 0 所以要先自增rear
            arr[++rear] = num;
        }

        return true;

    }

    public int outputQueue(){
        int outNum;
        //判断队列是否为空
        if (isEmpty()){
            throw new RuntimeException("队列为空，不可出队");
        }else {
            //front 指向第一个元素的前一个位置 最先front 为 -1
            // 那是不是应该让front++ 到 0 所以才能赋值给outNum
            front++;
            outNum = arr[front];
        }

        return outNum;
    }

    /**
     * 返回头结点
     * @return
     */
    public int getHead(){
        if (isEmpty()){
            throw new RuntimeException("队列为空,无头结点");
        }
        return arr[front+1];
    }

    /**
     * 展示整个队列
     */
    public void showArrayQueue(){
        for (int data : arr) {
            System.out.print(data+"\t");
        }
    }
}
