package com.example.demo.algorithm;

public class UpdateMin {
    public static void main(String[] args) {
        int solve = solve("abc", "abc", 5, 3, 100);
        System.out.println();
    }

    private static int solve(String str1, String str2, int insert, int del, int swap) {
        int [][]arr=new int[str1.length()+1][str2.length()+1];

        char[] chars1 =  new char[str1.length()+1];
        char[] chars2 = new char[str2.length()+1];
        System.arraycopy(str1.toCharArray(),0,chars1,1,str1.length());
        System.arraycopy(str2.toCharArray(),0,chars2,1,str2.length());
        chars1[0]=' ';
        chars2[0]=' ';
        int delSum=0;
        int insertSum=0;
        for (int row = 0; row < arr.length; row++) {
              arr[row][0]=delSum;
              delSum+=del;
        }
        for (int col = 0; col <arr[0].length ; col++) {
                arr[0][col]=insertSum;
                insertSum+=insert;
        }
        for (int row = 1; row < arr.length; row++) {
            for (int col = 1; col <arr[0].length ; col++) {
             int d=arr[row-1][col]+del;
             int ins=arr[row][col-1]+insert;
             int sw=0;
             if(chars1[row]!=chars2[col]){//不相等
                 sw=arr[row-1][col-1]+swap;
             }else{
                 sw=arr[row-1][col-1];
             }
               int min=Math.min(d,ins);
                min=Math.min(min,sw);
                arr[row][col]=min;
            }
        }

        return arr[arr.length-1][arr[0].length-1];
    }
}
