package com.example.demo.algorithm;

import java.util.Arrays;

public class Recursion {
    public static void main(String[] args) {
        int[][]base={{1,1},{1,0}};
        int[][]first={{1},{1}};
        int[][] pow = pow(base, 7);
        int[][] multi = multi(pow, first);

//        int[] resolve = resolve(75);
//        long pow = pow(10, 8);

        System.out.println();
    }

//    private static long pow(int base,int index){
//        long result[]=new long[index+2];
//        long cur=base;
//        for (int i = 1; i <result.length ;) {
//            result[i]=cur;
//            cur=cur*cur;
//            i=i*2;
//        }
//        return result[index];
//    }

    private static int[][]pow(int[][]arr,int index){
        int[][]result=arr;//把1，2，4，8，64 的结果累计下来
        int[][]cur=multi(arr,arr);
        int[] resolve = resolve(index);//那些需要计算
        for (int i = 2; i <=index;) {
            if(needCombine(resolve,i)){
                result= multi(result,cur);
            }
            cur=multi(cur,cur);
            i=i*2;
        }
        return result;
    }


    private static int[][] multi(int[][]matrix1,int[][]matrix2){
        int[][]result=new int[matrix1.length][matrix2[0].length];
        for (int i = 0; i <matrix1.length ; i++) {
            for (int j = 0; j <matrix2[0].length ; j++) {   //
                for (int k = 0,l = 0; k < matrix1[0].length&&l <matrix2.length; k++,l++) {//不需要两个限制  其前一个列树等于后一个行数
                        result[i][j]+=matrix1[i][k]*matrix2[l][j];
                }
            }
        }
            return result;
    }
    private static  boolean needCombine(int []indexs,int index){
        if(index<=0){
            return false;
        }
        for (int i = 0; i <indexs.length ; i++) {
            if(indexs[i]==index){
                return true;
            }
        }
        return false;
    }
    private static int[] resolve(int num) {//把一个数字换成2进制的形式
        int[] need = new int[num];
        int[] result = new int[num];
        int lastOne=0;
        while(num!=0){
            if((num&1)==1){
                need [lastOne++]=1;
            }else{
                lastOne++;
            }
            num=num>>1;
        }
        int base=1;
        int limit = 0;
        for (int resultIndex=0; limit <need.length ; limit++) {
            if(need[limit]!=0){
                result[resultIndex++]=base;
            }
            base=base*2;
        }
        return Arrays.copyOfRange(result,  0 ,  limit );
    }
}
