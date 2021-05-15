package com.example.demo.algorithm;

import org.thymeleaf.expression.Lists;

import java.util.Arrays;
import java.util.List;

public class HannotaByRecursion {
    private static String a = "A 柱";
    private static String b = "B 柱";
    private static String c = "C 柱";

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2);

        solve(list);
    }
    static class Sum{
        int a=0;
        void add(){
            this.a+=1;
        }
        int get(){
            return this.a;
        }
    }
    private static void solve(List<Integer> list) {
        Sum s=new Sum();
        for (int i = list.size() - 1; i >= 0; i--) {
            doSolve(list.get(i), a, c, b,s);
        }
        System.out.println("一共走了"+s.get()+"步");
    }

    private static void doSolve(Integer a, String from, String to,String by,Sum s) {
        if (a == 1) {
            System.out.println("把"+a+"从" + from + "放到" + by);
            System.out.println("把"+a+"从" + by + "放到" + to);
            s.add();
            s.add();
            return;
        } else {
            doSolve(a-1,from,to,by,s);
            System.out.println("把"+a+"从" + from + "放到" + by);
            s.add();
            doSolve(a-1,to,from,by,s);
            System.out.println("把"+a+"从" + by + "放到" + to);
            s.add();
        }
    }
}
