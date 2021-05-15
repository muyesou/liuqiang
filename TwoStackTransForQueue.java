package com.example.demo.algorithm;

import java.util.Stack;

public class TwoStackTransForQueue {
     Stack<Integer> resource=new Stack<Integer>();
     Stack<Integer> reverse=new Stack<Integer>();


     public void add(Integer i){
         resource.add(i);
     }

     public Integer pop(){
         if(reverse.isEmpty()){
            if(!resource.isEmpty()){
                transFor(resource,reverse);
                return reverse.pop();
            }else{
                return null;
            }
         }else{
           return reverse.pop();
         }
     }

     private void transFor(Stack<Integer>source,Stack<Integer> target){
            while(!source.isEmpty()){
                target.add(source.pop());
            }
     }
}
