package com.example.demo.algorithm;

import java.util.HashMap;
import java.util.Map;

public class LongContinuous {
    public static void main(String[] args) {
        int[]arr={100,4,200,1,3,2};
        int max = getMax(arr);
        System.out.println();
    }

    private static int getMax(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int max=0;
        for (int i = 0; i < arr.length; i++) {
           if(!map.containsKey(arr[i])){
               map.put(arr[i],1);
               if(map.containsKey(arr[i]-1)) {
                   max = Math.max(max, merge(map, arr[i] - 1, arr[i]));
               } if(map.containsKey(arr[i]+1)){
                   max=Math.max(max,merge(map,arr[i],arr[i]+1));
               }

           }
        }
        return max;
    }
    private static int merge(Map<Integer,Integer>map,int left,int right){
        int less=left-map.get(left)+1;
        int more=right+map.get(right)-1;
        map.put(less,more-less+1);
        map.put(more,more-less+1);
        return more-less+1;
    }
}
