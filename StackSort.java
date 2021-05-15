package com.example.demo.algorithm;

import java.util.Stack;

public class StackSort {
    static Stack<Integer> sortstack=new Stack<Integer>();
    public static void main(String[] args) {
        Stack<Integer> stack =new Stack<>();
        stack.add(0);
        stack.add(4);
        stack.add(5);
        stack.add(7);
        stack.add(1);
      //  int min = getMin(stack, stack.pop());

        sort(stack);
        System.out.println();
    }
    public static int getMin(Stack<Integer> stack,int min){
        if(stack.isEmpty()){
           return min;
        }
        Integer thisMin=stack.pop();
         if(thisMin<min){
             int min1 = getMin(stack, thisMin);
             stack.push(min );
             return min1;
         }else{
             int min1 = getMin(stack, min);
             stack.push(thisMin);
             return min1;
         }
    }


    public static void sort(Stack<Integer> stack){
        int size = stack.size();
        int count=size;
        while(size>0){
            sortstack.push(getMin(stack,stack.pop()));
            size--;
        }
        while(count>0){
            stack.push(sortstack.pop());
            count--;
        }
    }
}
