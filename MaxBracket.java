package com.example.demo.algorithm;

import com.alibaba.fastjson.support.odps.udf.JSONTuple;

public class MaxBracket {
    public static void main(String[] args) {
        int maxBracket = getMaxBracket("(()())");
        System.out.println();
    }

    private static int getMaxBracket(String str) {
        int[]dp=new int[str.length()];
        char[] chars = str.toCharArray();
        dp[0]=0;
        for (int i = 1; i <chars.length ; i++) {
             char cur=chars[i];
             if(cur=='('){
                 dp[i]=0;
             }else if(cur==')'){
                 int pre = dp[i - 1];
                 int perBrack=i-pre-1;
                 if(chars[perBrack]=='('){
                     dp[i]=dp[i-1]+2;
                     if(i-pre-2>0){
                         dp[i]=dp[i]+dp[i-pre-2];
                     }
                 }
             }
        }
        int max=0;
        for (int i = 0; i <dp.length ; i++) {
            max=Math.max(max,dp[i]);
        }

        return max;
    }
}
