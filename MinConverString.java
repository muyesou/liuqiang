package com.example.demo.algorithm;

import java.util.HashMap;
import java.util.Map;

public class MinConverString {
    public static void main(String[] args) {
        int min = min("adabbca", "acb");
        System.out.println();
    }

    private static int min(String str1, String str2) {
        int left=0;
        int right=0;
        Map<Character, Integer> statistics = statistics(str2);
        char[] chars = str1.toCharArray();
        int match=str2.length();
        int minLenght=Integer.MAX_VALUE;
        while(right!=chars.length) {
            char c = chars[right];
            if(statistics.containsKey(c)){
                Integer num = statistics.get(c);
                if(num>0){
                    num--;
                    match--;
                    statistics.put(c,num);
                }else{
                    num--;
                    statistics.put(c,num);
                }
            }else{//不包含就不减
                statistics.put(c,-1);
            }
            if(match==0){
                minLenght=Math.min(minLenght,right-left);
                while(true){
                    char lc = chars[left];
                    Integer num = statistics.get(lc);
                    if(num==0){
                        statistics.put(lc,1);
                        match++;
                        left++;
                        break;
                    }else{
                        statistics.put(lc,num+1);
                    }
                    left++;
                }
            }
            right++;
        }


        return minLenght;
    }

    private static Map<Character,Integer> statistics(String str){
        char[] chars = str.toCharArray();
        Map<Character,Integer> map=new HashMap<>();
        for (int i = 0; i <chars.length ; i++) {
            if(map.containsKey(chars[i])){
              map.put(chars[i],map.get(chars[i])+1);
            }else{
                map.put(chars[i],1);
            }
        }
        return map;
    }
}
