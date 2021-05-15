package com.example.demo.algorithm;

public class MinPathSum {
    public static void main(String[] args) {
  int[][]arr={{1,3,5,9},{8,1,3,4},{5,0,6,1},{8,8,4,0}};

        int solve = solve(arr);
        System.out.println();
    }

    private static int solve(int[][] arr) {//定义一个状态  比如走到这个格子需要最少的步数和
        int [][]result=new int[arr.length][arr[0].length];
        int row=0;
        int col=0;
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(i==0||j==0){
                    if(i==0){
                        row+=arr[i][j];
                        result[i][j]=row;
                    }
                    if(j==0){
                        col+=arr[i][j];
                        result[i][j]=col;
                    }
                }else{
                    int up=result[i-1][j];
                    int left=result[i][j-1];
                    result[i][j]=Math.min(up,left)+arr[i][j];
                }
            }
        }

        return result[result.length-1][result[0].length-1];
    }
}
