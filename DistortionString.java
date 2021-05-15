package com.example.demo.algorithm;

import com.alibaba.fastjson.support.odps.udf.JSONTuple;

public class DistortionString {
    public static void main(String[] args) {
        boolean solve = solve("1231", "3211");
        System.out.println();
    }
    private static boolean solve(String a,String b){
        int[]arr=new int[Character.MAX_VALUE];
        char[] aChars= a.toCharArray();
        char[] bChars = b.toCharArray();
        for (int i = 0; i <aChars.length ; i++) {
            arr[aChars[i]]++;
        }
        for (int i = 0; i <bChars.length ; i++) {
            arr[bChars[i]]--;
            if(arr[bChars[i]]<0){
                return false;
            }
        }
        return true;
    }
}
