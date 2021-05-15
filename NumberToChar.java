package com.example.demo.algorithm;

public class NumberToChar {
    public static void main(String[] args) {
        int solve = solve("10".toCharArray(), 0);
        System.out.println();
    }
    private static int solve(char[]arr,int cur){
        if(cur==arr.length){
            return 1;
        }
        if(arr[cur]=='0'){
            return 0;
        }
        int two=0;
        int one=0;
        if(arr[cur]<'3'&&arr[cur]>'0'&&arr[cur+1]>='0'&&arr[cur+1]<'5') {
            two =solve(arr, cur + 2);
        }
         if(arr[cur]<='9'&&arr[cur]>'0'){
            one=solve(arr,cur+1);
        }
        return two+one;
    }
}
