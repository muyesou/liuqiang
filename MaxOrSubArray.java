package com.example.demo.algorithm;

import java.util.HashMap;
import java.util.Map;

public class MaxOrSubArray {
    public static void main(String[] args) {
        int []arr={3,2,1,9,0,7,0,2,1,3};
        int maxOr = getMaxOr(arr);
        System.out.println();
    }

    private static int getMaxOr(int[] arr) {
        Map<Integer,Integer> map=new HashMap<>();
        int []res=new int[arr.length];
        map.put(0,-1);
        int preMax=0;
        for (int i = 0; i <arr.length ; i++) {
            int or = getOr(arr, 0, i);
            if(!map.containsKey(or)){
                map.put(or,i);
                res[i]=preMax;
            }else{
                int pre=map.get(or);
                res[i] = Math.max((pre==-1?0:res[pre]) + 1, preMax);
                preMax=res[i];
                map.put(or,i);//跟新
            }
        }

        return res[res.length-1];
    }
    private static int getOr(int []arr,int first,int end){
        int result=0;
        if(first==end){
            return arr[first];
        }
        for (int i = first; i <= end; i++) {
            result=result^arr[i];
        }
        return result;
    }
}
