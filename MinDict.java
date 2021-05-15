package com.example.demo.algorithm;

import java.util.HashMap;
import java.util.Map;

public class MinDict {
    public static void main(String[] args) {

        System.out.println("0123456".substring(1));
    }

    private static String getMinStr(String str) {
        String curStr = str;
        Map<Character, Integer> freqForRes = getFreq(curStr);
        char[] res = new char[freqForRes.size()];
        int resI = 0;
        while (!curStr.equals("")) {
            Map<Character, Integer> freq = getFreq(curStr);
            char[] chars = curStr.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                Character c = chars[i];
                Integer num = freq.get(c);
                if (num == 1) {
                    int minIndex = getMin(chars, 0, i);
                    res[resI++] = chars[minIndex];
                    curStr=curStr.substring(minIndex+1);
                    curStr=curStr.replace(chars[minIndex]+"","");
                    break;
                } else {
                    freq.put(c, num - 1);
                }
            }
        }
        return new String(res);

    }



    private static Map<Character, Integer> getFreq(String str) {
        Map<Character, Integer> freq = new HashMap<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (freq.containsKey(chars[i])) {
                freq.put(chars[i], freq.get(chars[i]) + 1);
            } else {
                freq.put(chars[i], 1);
            }
        }//词频统计
        return freq;
    }

    private static int getMin(char[] arr, int start, int end) {
        char min = Character.MAX_VALUE;
        int index = -1;
        for (int i = start; i <= end; i++) {
            if (min - arr[i] > 0) {
                min = arr[i];
                index = i;
            }

        }
        return index;
    }

}
