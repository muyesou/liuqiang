package com.example.demo.algorithm;

import java.util.Stack;

public class GetMinStack {
        private Stack<Integer> resource=new Stack<>();
        private Stack<Integer> min=new Stack<>();
        public Integer pop(){
            Integer pop = resource.pop();
            min.pop();
            return pop;
        }
        public void  add(Integer i){
           resource.add(i);
           if(min.isEmpty()){
               min.add(i);
               return ;
           }
            Integer peek = min.peek();
            if(peek<i){
                min.add(peek);
            }else{
               min.add(i);
            }
        }

        public Integer getMin(){
           return  min.peek();
        }

}
