package com.example.demo.algorithm;

import java.util.LinkedList;
import java.util.Stack;

public class SubArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 55, 45, 22, 45, 66, -1, 44, 2, 1, 66, 90, 44};
        int i = howMuchSubArray(arr, 20);
        System.out.println();
    }

    private static  int howMuchSubArray(int[] arr, int num) {
        LinkedList<Integer> max = new LinkedList<>();
        LinkedList<Integer> min = new LinkedList<>();
        int resultCount = 0;
        for (int first = 0, secord = 0; first < arr.length || secord < arr.length; ) {
            keepInRange(secord,first,max,min);
            boolean canRight = max.isEmpty() || min.isEmpty() || (!max.isEmpty()
                    && !min.isEmpty() && arr[max.peekFirst()] - arr[min.peekFirst()] <= num)&&first < arr.length;
            if (canRight) {
                if (max.isEmpty()) {
                    max.addFirst(first);
                } else {
                    Integer Max_min = max.peekLast();
                    if (arr[Max_min] >= arr[first]) {
                        max.addLast(first);
                    } else {
                        while (!max.isEmpty() && arr[max.peekLast()] < arr[first]) {
                            max.pollLast();
                        }
                        max.addLast(first);
                    }
                }
                if (min.isEmpty()) {
                    min.addFirst(first);
                } else {
                    Integer Min_max = min.peekLast();
                    if (arr[Min_max] <= arr[first]) {
                        min.addLast(first);
                    } else {
                        while (!min.isEmpty() && arr[min.peekLast()] > arr[first]) {
                            min.pollLast();
                        }
                        min.addLast(first);
                    }
                }
                first++;
            } else {//没法往右移动
                secord++;
            }
            boolean canSum=(!max.isEmpty() && !min.isEmpty() && arr[max.peekFirst()] - arr[min.peekFirst()] <= num);
            if(canSum){
                resultCount++;
            }
        }

        return resultCount;
    }

    private static void keepInRange(int left, int right, LinkedList<Integer> max, LinkedList<Integer> min) {
        if(max.isEmpty()||min.isEmpty()){
            return;
        }
        while (max.peek() < left || max.peek() > right) {
            max.pollFirst();
        }
        while (min.peek() < left || min.peek() > right) {
            min.pollFirst();
        }
    }
}
