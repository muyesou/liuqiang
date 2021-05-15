package com.example.demo.algorithm;

import java.util.Stack;

// 只能用递归函数逆序一个栈
public class RecursionAndStack {

    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
//        Integer integer = popLast(stack);
        reversal(stack);
        System.out.printf("");
    }

    public static Integer popLast(Stack<Integer> stack){
        Integer pop = stack.pop();
        if(stack.isEmpty()){
            return pop;
        }
        Integer last = popLast(stack);
        stack.push(pop);
        return last;
    }

    public static void reversal(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        Integer last = popLast(stack);
        reversal(stack);
        stack.push(last);

    }
}
