package com.example.demo.algorithm;

import java.util.Stack;

public class HannotaByStack {
    static enum Option{
       NO,LTOM,MTOL,MTOR,RTOM;

      public static  boolean isContrary(Option a,Option b){
            if(a.equals(LTOM)&&b.equals(MTOL)||a.equals(MTOL)&&b.equals(LTOM))
                return true;
            if (a.equals(MTOR)&&b.equals(RTOM)||a.equals(RTOM)&&b.equals(MTOR))
                return true;
            return false;

        }
    }

    static Option[] preoption={Option.NO};
    static Stack<Integer>left=new Stack<>();
    static Stack<Integer>mid=new Stack<>();
    static Stack<Integer>right=new Stack<>();

    static{
        left.push(Integer.MAX_VALUE);
        mid.push(Integer.MAX_VALUE);
        right.push(Integer.MAX_VALUE);
       // left.push(2);
//        left.push();
        left.push(3);
        left.push(2);
        left.push(1);
    }

    public static void main(String[] args) {
        solve(left,mid,right);
    }
    private static void solve(Stack<Integer>left,Stack<Integer>mid,Stack<Integer>right){
        int num=left.size();
        int count=0;
        while(right.size()!=num) {
            count+= move(preoption, Option.LTOM, left, mid, "LEFT", "MID");
            count+= move(preoption, Option.MTOL, mid, left, "MID", "LEFT");
            count+= move(preoption, Option.MTOR, mid, right, "MID", "RIGHT");
            count+= move(preoption, Option.RTOM, right, mid, "RIGHT", "MID");
        }
        System.out.println(count);
    }
   private static int move(Option[] preoption,Option nowOption,Stack<Integer>from ,Stack<Integer>to,String fromName,String toName){
            if(preoption.equals(nowOption)||Option.isContrary(preoption[0],nowOption)||from.isEmpty()||from.peek()>to.peek()){
                return 0;
            }
            System.out.println("现在把"+fromName+"的"+from.peek()+"移动到"+toName);
            to.push(from.pop());

            preoption[0]=nowOption;
            return 1;

   }

}
