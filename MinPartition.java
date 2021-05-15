package com.example.demo.algorithm;

public class MinPartition {
    public static void main(String[] args) {
        int acdcdcdad = min("ACDCDCDAD");

        System.out.println();

    }

    private static int min(String str) {
        char[] chars = str.toCharArray();
        int[] res = new int[str.length()];
        boolean[][] p = new boolean[chars.length][chars.length];
        res[chars.length - 1] = 0;
        for (int i = chars.length - 2; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < chars.length; j++) {
                if (i==j||(p[i+1][j-1]&&chars[i]==chars[j])){
                    p[i][j]=true;
                    if(j==chars.length-1){
                        min=0;
                    }else {
                        min = Math.min(min, res[j + 1] + 1);
                    }
                    res[i] = min;
                }
            }
        }

        return res[0];
    }


}
