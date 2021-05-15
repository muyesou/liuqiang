package com.example.demo.algorithm;

import java.util.Stack;

public class DullStack {

    public static void main(String[] args) {
        int[] arr = {3, 1, 3, 4, 3, 5, 3, 2, 2};
        int[][] solve = solve(arr);
        System.out.println();

    }

    private static int[][] solve(int[] arr) {
        int[][] result = new int[arr.length][2];
        Stack<Integer> stack = new Stack<Integer>();
        for (int index = 0; index < arr.length; index++) {
            while (true) {
                if (stack.isEmpty() || arr[stack.peek()] <= arr[index]) {
                    int left = stack.isEmpty() ? -1 : stack.peek();
                    stack.add(index);
                    int right = -1;
                    result[index][0] = left;
                    result[index][1] = right;
                    break;
                } else {
                    findShort(stack,result,arr,index,index);
                }
            }
        }
        while (stack.size() > 1) {
            int top = stack.pop();
            result[top][0] = findShort(stack,result,arr,top,-1);

        }
        return result;
    }

    //index 拐点index
    private static int findShort(Stack<Integer> stack, int[][] result,int[]arr, int index,int right) {
        if (stack.isEmpty()) {
            return -1;
        }
        int mid = stack.pop();
        int left =stack.isEmpty()?-1:stack.peek();

        if (!stack.isEmpty()&&arr[left] == arr[mid]) {
            left=findShort(stack, result,arr, left,right);
            result[mid][0] = left;
        } else {
            result[mid][0] = left;
        }
        result[mid][1] = right;
        return left;
    }
//    rffrrrrrrrrrrrrrrrrrrrrr
}
