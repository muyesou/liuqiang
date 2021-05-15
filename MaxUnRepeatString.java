package com.example.demo.algorithm;

import java.util.HashMap;
import java.util.Map;

public class MaxUnRepeatString {
    public static void main(String[] args) {
        int aabcb = solve("aabcb");
        System.out.println();

    }
    private static int solve(String s){
        int []res=new int[s.length()];
        char[] chars = s.toCharArray();
        Map<Character,Integer> map=new HashMap<>();
        int preStart=-1;
        int max=0;
        map.put(chars[0],0);
        res[0]=1;
        for (int i = 1; i <chars.length ; i++) {
            if(!map.containsKey(chars[i])){
                res[i]=res[i-1]+1;
                map.put(chars[i],i);
                max=Math.max(max,res[i]);
            }else{
                int last=map.get(chars[i]);
                if(last>preStart){
                    preStart=last;
                    res[i]=i-preStart;
                }else{
                    res[i]=i-preStart;
                }
                map.put(chars[i],i);
            }
        }
        return max;
    }
}
