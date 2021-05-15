package com.example.demo.algorithm;

public class MaxSameSubOrder {
    public static void main(String[] args) {
        String b1D23CA45B6A = solve("1A2C3D4B56", "B1D23CA45B6A");
        System.out.println();
    }
    private static String solve(String str1,String str2){
        int [][]arr=new int[str1.length()][str2.length()];
        char[] rows = str1.toCharArray();
        char[] cols = str2.toCharArray();
        for (int row = 0; row <rows.length ; row++) {
             char colFirst=cols[0];
             char rowChar = rows[row];
            if(rowChar==colFirst){
                arr[row][0]=1;
                while(row<rows.length){
                    arr[row][0]=1;
                    row++;
                }
            }
        }
        for (int col = 0; col <cols.length ; col++) {
            char rowChar=rows[0];
            char colChar=cols[col];
            if(rowChar==colChar){
                arr[0][col]=1;
                while(col<cols.length){
                    arr[0][col]=1;
                    col++;
                }
            }
        }
        for (int row = 1; row < arr.length; row++) {
            for (int col = 1; col <arr[0].length ; col++) {
                int left=arr[row][col-1];
                int up=arr[row-1][col];
                int leftUp=arr[row-1][col-1];
                arr[row][col]=Math.max(left,up);
                if(rows[row]==cols[col]){
                    leftUp++;
                }
                arr[row][col]=Math.max(arr[row][col],leftUp);
            }
        }
        StringBuffer str=new StringBuffer();
        for (int row = arr.length-1; row >=0;  ) {
            for (int col =arr[0].length-1; col >=0 ;  ) {
                int cur=arr[row][col];
                int left=0;
                int up=0;
                if(col>0) {
                    left= arr[row][col - 1];
                }
                if(row>0) {
                    up = arr[row - 1][col];
                }
                if(cur>left&&cur>up&&col>0&&row>0){
                    row--;
                    col--;
                    str.append(cur);
                }else if(cur==left&&cur==up){
                    if(col>0){
                        col--;
                    }else if(row>0){
                        row--;
                    }
                }
                else if(cur==left){
                    col--;
                }else if(cur==up){
                    row--;
                }else if(cur>up&&cur>left&&(col==0||row==0)){//边界节点
                    if(rows[row]==cols[col]){
                        str.append(rows[row]);
                        if(col>0){
                            col--;
                        }else{
                            row--;
                        }
                    }
                }
                if(row==0&&col==0&&rows[0]!=cols[0]){
                    return str.reverse().toString();
                }
            }
        }


        return str.reverse().toString();
    }
}
