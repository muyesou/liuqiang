package com.example.demo.algorithm;

public class GrandFloor {
    public static void main(String[] args) {
        int[][]arr={{-2,-9,3},{-5,-10,1},{0,30,-5}};
        int blood = blood(arr);
        System.out.println();
    }
    private static int blood(int[][]arr){
        int [][]res=new int[arr.length][arr[0].length];
        res[res.length-1][res[0].length-1]=Math.max(1-arr[arr.length-1][arr[0].length-1],1);


        for (int col = res[0].length-2; col >=0 ;col--) {
            int left=Math.max(res[res.length-1][col+1]-arr[res.length-1][col],1);
            res[res.length-1][col]=left;
        }
        for (int row = res.length-2; row >=0 ;row--) {
            int up=Math.max(res[row+1][res[0].length-1]-arr[row][res[0].length-1],1);
            res[row][res[0].length-1]=up;
        }
        for (int col = res[0].length-2; col >=0 ;col--) {
            for (int row = res.length-2; row >=0 ;row--) {
               int right=Math.max(res[row][col+1]-arr[row][col],1);
               int down=Math.max(res[row+1][col]-arr[row][col],1);
               res[row][col]=Math.min(down,right);
            }
        }

        return res[0][0];
    }
}
