package com.example.demo.algorithm;

import java.util.Stack;

public class LinkAdd {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        n1.next = n2;
        n2.next = n4;

        n5.next=n6;
       Node solve = solve(n1, n5);
        System.out.println("123".substring("123".length()-1));

    }

    private static Node solve(Node head1,Node head2) {
        Stack<Node> stack1=new Stack<>();
        Stack<Node> stack2=new Stack<>();
        Node cur1=head1;
        Node cur2=head2;
        int ca=0;
        while(cur1!=null||cur2!=null){
            if(cur1!=null) {
                stack1.add(cur1);
                cur1=cur1.next;
            }
            if(cur2!=null) {
                stack2.add(cur2);
                cur2=cur2.next;
            }
        }
        Node last=null;
        while(!stack1.isEmpty()||!stack2.isEmpty()){
            Node node1=null;
            Node node2=null;
            if(!stack1.isEmpty()){
                node1=stack1.pop();
            }
            if(!stack2.isEmpty()){
                 node2=stack2.pop();
            }
            int result=node1==null?0:node1.value+(node2==null?0:node2.value)+ca;
            if(String.valueOf(result).length()>1){
                ca=1;
                String s = String.valueOf(result);
                Node node=new Node(Integer.valueOf(s.substring(s.length()-1)));
                node.next=last;
                last=node;
            }else{
                Node node=new Node(result);
                node.next=last;
                last=node;
            }

        }

        return last;

    }
}
