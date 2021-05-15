package com.example.demo.algorithm;

import java.util.Stack;

public class ReverseK {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next=n6;
        Node solve = solve(n1, 2);
        System.out.println();
    }

    public static Node solve(Node head, int k) {
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        Node resultHead=null;
        Node preTail=null;
        Node fixCur=null;
        while (cur != null) {
            while (stack.size() < k) {
                if(cur==null){//维持原序列
                    preTail.next=pushButton(stack);
                    preTail.next.next=null;
                    return resultHead;
                }
                stack.add(cur);
                cur = cur.next;
            }
            if(preTail==null){//第一次反转 得到头节点
                resultHead=stack.pop();
                fixCur=resultHead;
            }else{
                fixCur=stack.pop();
                preTail.next=fixCur;
            }
            while(!stack.isEmpty()){
                fixCur.next=stack.peek();
                fixCur=stack.pop();
            }
            preTail=fixCur;

        }

        return resultHead;
    }

    private static Node pushButton(Stack<Node>stack){
        while(stack.size()!=1){
            stack.pop();
        }

        return stack.pop();
    }
}
