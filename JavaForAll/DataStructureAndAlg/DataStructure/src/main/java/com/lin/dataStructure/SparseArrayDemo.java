package com.lin.dataStructure;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: DataStructureAndAlg
 * @description: 稀疏矩阵解决棋盘数据存储问题
 * @author: linsz
 * @create: 2022-09-07 16:21
 **/
public class SparseArrayDemo {

    public static void main(String[] args) {

        System.out.println("--------------以下是将棋盘保存为稀疏矩阵并直接测试使用---------------------");
        //1. 得到初始棋盘
        System.out.println("=================得到初始棋盘====================");
        int[][] originalChess = OriginalChess();
        showChess(originalChess);
        //2. 得到稀疏矩阵的棋盘
        System.out.println("=================得到稀疏矩阵的棋盘====================");
        int[][] sparseArr = getSparseArr(originalChess);
        showChess(sparseArr);


        //3. 将稀疏矩阵还原为 初始棋盘
        System.out.println("=================将稀疏矩阵还原为 初始棋盘====================");
        int[][] returnChess = getReturnChess(sparseArr);
        showChess(returnChess);

        System.out.println("----------------------------------------------------------------------");

        System.out.println("--------------以下是将棋盘保存为稀疏矩阵写出到本地磁盘并且重新从磁盘读入还原回棋盘---------------------");
        System.out.println("=================将稀疏矩阵写入磁盘====================");
        writeToFile(sparseArr);
        System.out.println("写入成功，到该路径去查看是否成功写入 '/Users/linsz/Downloads/chess.txt'");
        System.out.println("=================将稀疏矩阵从磁盘读出====================");
        showChess(readFromTheFile());


    }

    /**
     * 构造一个原始棋盘  假设棋盘大小为 11 * 11
     */
    public static int[][] OriginalChess(){

        int[][] chessArr = new int[11][11];
        chessArr[1][3] = 1;  // 第二行的第四个位置
        chessArr[2][4] = 2;  // 第三行的第五个位置
        chessArr[4][3] = 1;
        return chessArr;
    }

    /**
     * 展示整个棋盘
     * @param chess
     */
    public static void showChess(int[][] chess){
        for (int[] ints : chess) {
            for(int data: ints){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }

    /**
     * 获得稀疏矩阵 得到一个 Y * 3 即Y行3列的矩阵
     * 说明如下     row   col  value
     * @param chess
     */
    public static int[][] getSparseArr(int[][] chess){
        int rows = getRowsOfSparseArr(chess);
        int count = 1;
        // 得到需要保存的稀疏矩阵为几行三列 row;
       int[][] sparseArr = new int[rows+1][3];
       sparseArr[0][0] = chess.length;
       sparseArr[0][1] = chess.length;
       sparseArr[0][2] = rows;

        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess.length; j++) {
                if (chess[i][j] != 0){
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chess[i][j];
                    count++;
                }
            }
        }
        return sparseArr;
    }

    /**
     * 获得棋盘非空棋子的个数
     * @param chess
     * @return
     */
    public static int getRowsOfSparseArr(int[][] chess){
        int row = 0;
        for (int[] ints : chess) {
            for (int data : ints){
                if (data != 0){
                    row++;
                }
            }
        }
        return row;
    }

    /**
     * 通过稀疏矩阵返回初始棋盘
     * @param sparseArr
     */
    public static int[][] getReturnChess(int[][] sparseArr){
        //1. 得到初始棋盘的大小 未赋值本身默认值就是0
        int[][] originalChess = new int[sparseArr[0][0]][sparseArr[0][1]];

        //2. 插入其中的非空棋子
        int num = sparseArr[0][2];
        for (int i = 1; i <=num; i++) {
            int row = sparseArr[i][0];
            int col = sparseArr[i][1];
            int value = sparseArr[i][2];

            originalChess[row][col] = value;
        }
        return originalChess;
    }

    /**
     * 拓展： 将稀疏矩阵写出到本地路径进行存储
     * @param sparseArr
     */
    public static void writeToFile(int[][] sparseArr){
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter("/Users/linsz/Downloads/chess.txt");
            bufferedWriter = new BufferedWriter(fileWriter);
            StringBuffer stringBuffer = new StringBuffer();
            for (int[] arr : sparseArr) {
                String str = new String();
                for(int data : arr){
                    str = str + data + "\t";
                }
                bufferedWriter.write(str);
                bufferedWriter.newLine();
                stringBuffer.append(str);
            }
           // System.out.println("stringBuffer is =============>"+"\t"+stringBuffer);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bufferedWriter !=null){
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileWriter!=null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    /**
     * 从磁盘读取文件写会原先的棋盘
     * @return
     */
    public static int[][] readFromTheFile(){
        BufferedReader bufferedReader = null;
        ArrayList<Integer> list = new ArrayList<>();
        try {
            bufferedReader = new BufferedReader(new FileReader("/Users/linsz/Downloads/chess.txt"));
            String readStr = null;

            while ( (readStr = bufferedReader.readLine()) != null) {
                String[] strings = readStr.split("\t");
                for (String string : strings) {
                    list.add(Integer.parseInt(string));
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader!= null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //上述得到的list 的内容即为稀疏矩阵 eg: [11, 11, 2, 1, 3, 1, 2, 4, 2]
        int[][] chessArr = new int[list.get(2)+1][3];
        int count = 0;
        for (int i = 0; i < list.size(); i=i+3) {
            chessArr[count][0] = list.get(i);
            chessArr[count][1] = list.get(i+1);
            chessArr[count][2] = list.get(i+2);
            count++;
        }
        return chessArr;
    }

}
