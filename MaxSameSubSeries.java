package com.example.demo.algorithm;

public class MaxSameSubSeries {
    public static void main(String[] args) {
        String solve = solve("1AB2345CD", "12345EF");
        System.out.println();
    }

    private static String solve(String str1, String str2) {
        int[][]arr=new int[str1.length()][str2.length()];
        char[] rows = str1.toCharArray();
        char[] cols = str2.toCharArray();
        int max=0;
        for (int row = 0; row <arr.length ; row++) {
            for (int col = 0; col <arr[0].length ; col++) {
                if(rows[row]==cols[col]){
                    if(row>1&&col>1){
                        int leftup=arr[row-1][col-1];
                        max=Math.max(max,leftup+1);
                    }else{
                        max=Math.max(max,1);
                    }
                    arr[row][col]=max;
                }
            }
        }
        int maxRow=0;
        for (int row = 0; row <arr.length ; row++) {
            for (int col = 0; col <arr[0].length ; col++) {
                    if(arr[row][col]==max){
                        maxRow=row;
                    }
            }
        }

        return str1.substring(maxRow-max+1,maxRow+1);
    }
}
