package com.example.demo.algorithm;

public class LongestSubOrder {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 3, 6, 4, 8, 9, 7};
        int[] arr1 = {1, 2, 4, 8, 9, 11, 23, 77, 88};
//        int index = getIndex(arr1, 0, arr.length - 1, 99);
        int max = getMax(arr);

        System.out.println();
    }

    public static int getMax(int[] arr) {
        int[] ends = new int[arr.length];
        int end = 0;
        int[] result = new int[arr.length];
        result[0] = 1;
        ends[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int cur = arr[i];
            int min = getIndex(ends, 0, end, cur);
            if (min == end) {//没有比他大的
                end++;
                ends[end] = cur;
                result[i] = end + 1;
            } else {
                ends[min + 1] = cur;
                result[i] = min + 1 + 1;
            }
        }

        return getMaxNum(result);

    }
    private static int getMaxNum(int []arr){
        int result=0;
        for (int i = 0; i <arr.length ; i++) {
          result=arr[i]>result?arr[i]:result;
        }
        return result;
    }
    private static int[] getResult(int[] arr,int []dp) {
        int []result=new int[arr.length];
        int res=0;
        int pre=arr[0];
        result[0]=arr[0];
        for (int i = 1; i <dp.length ; i++) {
            if(dp[i]==pre){
                result[res]=arr[i];
            }else{
                if(dp[i]>pre) {
                    result[++res] = arr[i];
                }
                else{
                    result[i-dp[i]]=arr[i];
                }
            }
            pre=dp[i];
        }

        return result;
    }

    //找到刚好比他小的
    private static int getIndex(int[] arr, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        if (start == end) {
            return arr[start] > target ? start - 1 : start;
        }
        if (end - start == 1) {
            return arr[start] > target ? start - 1 : arr[end] > target ? start : end;
        }
        int mid = start + (end - start) / 2;
        if (arr[mid] < target) {
            return getIndex(arr, mid + 1, end, target);
        } else if (arr[mid] > target) {
            return getIndex(arr, start, mid, target);
        } else {
            return mid - 1;
        }
    }
}
