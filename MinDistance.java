package com.example.demo.algorithm;

public class MinDistance {
    public static void main(String[] args) {
        String []arr={"1","3","3","3","2","3","1"};

        int solve = solve(arr, "1", "2");
        System.out.println();
    }
    private static int solve(String[]arr,String a,String b){
        int min=Integer.MAX_VALUE;
        int lastA=-1;
        int lastB=-1;
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i].equals(a)){
                lastA=i;
                if(lastB!=-1){
                    min=Math.min(min,i-lastB);
                }
            }
            if(arr[i].equals(b)){
                lastB=i;
                if(lastA!=-1){
                    min=Math.min(min,i-lastA);
                }
            }

        }
        return min;
    }
}
