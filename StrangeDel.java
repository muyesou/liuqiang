package com.example.demo.algorithm;

public class StrangeDel {

    public static void main(String[] args) {
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        n1.next=n2;
        n2.next=n3;

        solve(n2);
        System.out.println();

    }

    private static void solve(Node anyNode){
        Node next=anyNode.next;
        anyNode.value=next.value;
        anyNode.next=next.next;
       return ;
    }
}
