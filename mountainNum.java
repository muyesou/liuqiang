package com.example.demo.algorithm;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Stack;

public class mountainNum {
    @Data
    @AllArgsConstructor
    private static class Mountain {
        private int hight;
        private int num;

    }

    public static void main(String[] args) {
        int compose = compose(1);
        System.out.println();
    }

    private static int solve(int[] arr) {
        int[] changeArr = new int[arr.length];
        Stack<Mountain> stack = new Stack<>();
        int total=0;
        copy(arr, changeArr);
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty() || stack.peek().getHight() >= arr[i]) {
                if (stack.peek().getHight() > arr[i])
                    stack.add(new Mountain(arr[i], 1));
                if (stack.peek().getHight() == arr[i]) {
                    Mountain top = stack.pop();
                    top.setNum(top.getNum() + 1);
                    stack.add(top);
                }
            } else {
                while(!stack.isEmpty()&&stack.peek().getHight()<arr[i]){
                      Mountain top=stack.pop();
                      if(top.getNum()==1){
                          total+=2;
                      }else{
                          total+=(2*top.getNum()+compose(top.getNum()));
                      }
                }
                stack.add(new Mountain(arr[i], 1));
            }

        }
        while(!stack.isEmpty()){
            Mountain top=stack.pop();
            if(stack.size()>=2){
                if(top.getNum()==1){
                    total+=2;
                }else{
                    total+=(2*top.getNum()+compose(top.getNum()));
                }
            }else if(stack.size()==1){
                Mountain last=stack.peek();
                if(last.getNum()==1){
                    total+=top.getNum();
                }else{
                    total+=(last.getNum()*top.getNum()+compose(top.getNum()));
                }

            }else if(stack.size()==0){
                total+=compose(top.getNum());
            }
        }



        return 0;
    }

    private static void copy(int[] source, int[] arr) {
        out:
        for (int i = findMax(arr); ; i++) {
            for (int j = 0; ; j++) {
                source[j] = arr[i];
                if (j == arr.length) {
                    break out;
                } else if (i == arr.length) {
                    i = 0;
                }
            }
        }
    }

    private static int findMax(int[] arr) {
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private static int compose(int total) {
        double param = (double) total;
        double avg = param / 2;
        double result = avg * (total - 1);
        return new Double(result).intValue();
    }
}

