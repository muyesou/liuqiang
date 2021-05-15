package com.example.demo.algorithm;

public class MaxCard {
    public static void main(String[] args) {
        int[] arr = {1, 2,100, 4};
//        int max = getMax(arr, 0, arr.length - 1);
        int max1 = getMax1(arr);
        System.out.println();
    }
        //暴力递归
    private static int getMax(int[] arr, int start, int end) {
        int[] pre = {-1};
        int first = first(arr, start, end, pre);
        int second = second(arr, start, end);
        return Math.max(first, second);
    }

    private static int first(int[] arr, int start, int end, int[] good) {
        System.out.println("计算" + start + "到" + end + "的先手最大");
        if (start == end) {
            return arr[start];
        }
        int left = second(arr, start + 1, end) + arr[start];
        int right = second(arr, start, end - 1) + arr[end];
        good[0] = (good[0] == -1) ? (left > right ? start : end) : good[0];
        return Math.max(left, right);
    }

    private static int second(int[] arr, int start, int end) {
        System.out.println("计算" + start + "到" + end + "的后手最大");
        if (start == end) {
            return 0;
        }
        int[] pre = {-1};
        first(arr, start, end, pre);//先等别人先手那完 ，知道别人拿的是什么
        int left = 0;
        int right = 0;
        if (pre[0] == start) {//左边
            if (start + 1 <= end - 1) {
                left = first(arr, start + 2, end, pre);
                right = first(arr, start + 1, end - 1, pre);
            } else {
                left = first(arr, start + 1, start + 1, pre);//只有一个
            }
        } else if (pre[0] == end) {
            if (start + 1 <= end - 1) {
                left = first(arr, start + 1, end - 1, pre);
                right = first(arr, start, end - 2, pre);
            } else {
                left = first(arr, end - 1, end - 1, pre);//只有一个
            }
        }
        return Math.max(left, right);
    }

//动态规划
    private static int getMax1(int[] arr) {
        int[][] fArr = new int[arr.length][arr.length];
        int[][] sArr = new int[arr.length][arr.length];
        for (int i = 0; i < fArr.length; i++) {
            fArr[i][i] = arr[i];
            sArr[i][i] = 0;
        }
        int add = 0;
        while (add <= fArr.length - 1) {
            for (int start = 0; start < fArr.length; start++) {
                int end = start + add;//处理相邻的
                if (start<fArr.length-1&&end < fArr.length&&end>0) {
                    fArr[start][end] = Math.max(sArr[start + 1][end] + arr[start], sArr[start][end - 1] + arr[end]);
                    sArr[start][end] = Math.min(fArr[start + 1][end], fArr[start][end - 1]);
                }
            }
            add++;
        }
        return Math.max(fArr[0][fArr.length - 1], sArr[0][sArr.length - 1]);
    }
}