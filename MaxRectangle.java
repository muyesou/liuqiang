package com.example.demo.algorithm;

import java.util.Stack;

public class MaxRectangle {
    public static void main(String[] args) {
        int[][] arr = {{1, 0, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 0}};
        int sum=solve(arr);
        System.out.println();

    }

    private static int solve(int[][] arr) {
        int[] hight = new int[arr[0].length];
        int max=0;

        for (int h = 0; h < arr.length; h++) {
            for (int index = 0; index < arr[0].length; index++) {
                hight[index] = arr[h][index] == 0 ? 0 : hight[index] + 1;
            }
            //每次跟新完一行后计算以这一行为底 最大的矩形
            int result = countMax(hight);
            max= result>max?result:max;
        }
        return max;
    }

    private static int countMax(int[] arr) {
        Stack<Integer> stack = new Stack<Integer>();
        int[][]leftAndRight=new int[arr.length][2];
        for(int index=0;index<arr.length;index++){
            if(stack.isEmpty()||arr[stack.peek()]<=arr[index]){
                stack.add(index);
            }else{
                while(!stack.isEmpty()&&arr[stack.peek()]>arr[index]) {
                    getLeft(leftAndRight, stack, arr, index, index);
                }
                stack.add(index);
            }
        }
        int button=getButton(stack);
        while(stack.size()!=1){
            Integer cur = stack.pop();
            leftAndRight[cur][1]=-1;
            leftAndRight[cur][0]=button;
        }
        leftAndRight[stack.peek()][1]=-1;
        leftAndRight[stack.peek()][0]=-1;
        int max=0;
        for (int i = 0; i <leftAndRight.length ; i++) {
           int left=leftAndRight[i][0]==-1?0:leftAndRight[i][0];
           int right=leftAndRight[i][1]==-1?arr.length-1:leftAndRight[i][1];

            max=(right-left)*arr[i]>max?(right-left)*arr[i]:max;
        }
        return max;
    }
    private static int getButton(Stack<Integer>stack){
        if(stack.size()==1){
            return stack.peek();
        }
        int top=stack.pop();
        int button=getButton(stack);
        stack.add(top);
        return button;
    }
    private static int getLeft(int[][]leftAndRight,Stack<Integer>stack,int[]arr,int current,int right){
            if(stack.isEmpty()){
                return -1;
            }else{
                int mid=stack.pop();
                int left=stack.isEmpty()?-1:arr[stack.peek()]==arr[mid] ?
                        getLeft(leftAndRight,stack,arr,mid,right):stack.peek();

                leftAndRight[mid][0]=left;
                leftAndRight[mid][1]=right;
                return left;
            }

    }

}
