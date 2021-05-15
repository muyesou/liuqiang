package com.example.demo.algorithm;

public class RevolveString {
    public static void main(String[] args) {
        boolean judge = judge("abcd", "dbac");
        System.out.println();
    }
    private static boolean judge(String str1,String str2){
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        boolean [][][]dp=new boolean[chars1.length][chars2.length][chars1.length+1];

        for (int width = 0; width <chars1.length ; width++) {
            for (int length = 0; length <chars2.length ; length++) {
                dp[width][length][1]=chars1[width]==chars2[length];
            }
        }

        for (int size = 2; size <= str1.length() ; size++) {
            for (int l1 = 0; l1 <chars1.length-size ; l1++) {
                for (int l2 = 0; l2 <chars2.length-size ; l2++) {
                    for(int lit=1;lit<size;lit++){
                       if((dp[l1][l2][lit]&&dp[l1+lit][l2+lit][size-lit])
                               ||(dp[l1][l2+size-lit][lit]&&dp[l1+lit][l2][size-lit])){
                           dp[l1][l2][size]=true;
                           break;
                        }
                    }
                }
            }
        }

        return dp[0][0][chars1.length];
    }
}
