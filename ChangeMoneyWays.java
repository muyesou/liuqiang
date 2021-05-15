package com.example.demo.algorithm;

public class ChangeMoneyWays {
    public static void main(String[] args) {
            int arr[]={5,10,25,1};
        int solve = solve(arr, 15);
        System.out.println();
    }

    private static int solve(int[] arr, int money) {
        int [][]result=new int[arr.length][money+1];
        for (int i = 0; i < result.length; i++) {
            if(i==0){
                for (int j = 0; j <result[0].length ; j++) {
                    result[i][j]=(j)%(arr[i])==0?1:0;
                }
            }
            for (int j = 0; j <result[0].length ; j++) {
                if(j==0){
                    result[i][j]=1;
                    break;
                }
            }
        }
        for (int i = 1; i <result.length ; i++) {
            for (int j = 1; j <result[0].length ; j++) {

                int left=j-arr[i];
                if(left>=0) {
                    result[i][j] = result[i - 1][j] + result[i][j - arr[i]];
                }else{
                    result[i][j] = result[i - 1][j];
                }
            }
        }

        return result[arr.length-1][money];
    }
}
