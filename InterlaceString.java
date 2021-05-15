package com.example.demo.algorithm;

public class InterlaceString {
    public static void main(String[] args) {
        boolean ab = solve("AB", "12", "1AB2");
        System.out.println();
    }
    private static boolean solve(String a,String b, String aim){
        if(aim.length()!=a.length()+b.length()){
            return false;
        }
        char[] chars1 = new char[a.length()+1];
        char[] chars2 = new char[b.length()+1];
        boolean [][]arr=new boolean[a.length()+1][b.length()+1];
        char[] aimChars = aim.toCharArray();
        System.arraycopy(a.toCharArray(),0,chars1,1,a.length());
        System.arraycopy(b.toCharArray(),0,chars2,1,b.length());
        chars1[0]=' ';
        chars2[0]=' ';
        arr[0][0]=true;
        boolean per=true;
        for (int row = 1; row <chars1.length ; row++) {
            arr[row][0]=per&&chars1[row]==aimChars[row-1];
            per=arr[row][0];
        }
        per=true;
        for (int col = 1; col <chars2.length ; col++) {
            arr[0][col]=per&&chars2[col]==aimChars[col-1];
            per=arr[0][col];
        }
        for (int row = 1; row <chars1.length ; row++) {
            for (int col = 1; col <chars2.length ; col++) {
                boolean up=arr[row-1][col]&&chars1[row]==aimChars[row+col-1];
                boolean left=arr[row][col-1]&&chars2[col]==aimChars[row+col-1];
                arr[row][col]=up?up:left;
            }
        }


        return arr[arr.length-1][arr[0].length-1];
    }
}
