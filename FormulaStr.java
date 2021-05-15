package com.example.demo.algorithm;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class FormulaStr {
    public static void main(String[] args) {

        int sum = sum("3-(3+1)*4",0)[0];
        System.out.println();

    }


    private static int[] sum(String str,int start){
        char[] chars = str.toCharArray();
        int []res=new int[2];
        Deque<String> queue=new LinkedList<>();
        int first=0;
        int i = start;
        for (; i <str.length(); i++) {
            if(chars[i]>='0'&&chars[i]<='9'){
                first=first*10+chars[i]-'0';
            }else if(chars[i]=='+'||chars[i]=='-'||chars[i]=='*'||chars[i]=='/'){
                first=multi(queue,first);
                queue.addLast(first+"");
                queue.addLast(chars[i]+"");
                first=0;
            }else if(chars[i]=='('){
                int[] sum = sum(str, i+1);
                i=sum[1];
               first=sum[0];
            }else if(chars[i]==')'){
                break;
            }
        }
        res[0]=add(queue,first);
        res[1]=i;
       return  res;
    }
    private static int multi(Deque<String> queue,int cur) {
        if (!queue.isEmpty()) {
            String labe = queue.pollLast();
            if (labe.equals("*") || labe.equals("/")) {
                Integer first = Integer.valueOf(queue.pollLast());
                first = labe.equals("*") ? (first * cur) : (first / cur);
                return first;
            }else{
                queue.addLast(labe);
            }
        }
         return cur;
    }
    private static int add(Deque<String> queue,int cur){
        int sum=cur;
        while(!queue.isEmpty()){
            String labe=queue.pollLast();
            Integer first=Integer.valueOf(queue.pollLast());
            if(labe.equals("+")){
                sum+=first;
            }else if(labe.equals("-")){
                sum=first-sum;
            }else if(labe.equals("*") || labe.equals("/")){
                sum=labe.equals("*")?first*cur:first/cur;
            }
        }
        return sum;
    }

}
