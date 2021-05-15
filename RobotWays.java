package com.example.demo.algorithm;

public class RobotWays {
    public static void main(String[] args) {
        int solve = solve(5, 2, 3, 3);
        System.out.printf("");
    }

    //N 边长 M 机器人初始所在位置  K 能走几步  p 目标位置
    private static int solve(int N, int M, int k, int p) {
        int[][] result = new int[k+1][N];
        result[0][p - 1] = 1;
        for (int i = 1; i <result.length ; i++) {
            for (int j = 0; j <result[0].length ; j++) {
                if(j==0){
                    result[i][j]+=result[i-1][j+1];
                    continue;
                }else if(j==result[0].length-1){
                    result[i][j]+=result[i-1][j-1];
                    continue;
                }
                result[i][j]+=result[i-1][j-1]+result[i-1][j+1];
            }

        }
        return result[k][M - 1];
    }


}
