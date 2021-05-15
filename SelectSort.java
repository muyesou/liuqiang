package com.example.demo.algorithm;

public class SelectSort {
    public static void main(String[] args) {
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        Node n4=new Node(4);
        Node n5=new Node(5);
        Node n6=new Node(6);
        Node n7=new Node(7);
        Node n8=new Node(8);

        n1.next=n8;
        n8.next=n2;
        n2.next=n7;
        n7.next=n3;
        n3.next=n6;
        n6.next=n4;
        n4.next=n5;
        Node solve = solve(n1);
        System.out.println();
    }

    private static Node solve(Node head) {

        Node newhead = null;
        Node newtail=null;
        Node minpre = null;
        Node pre = null;
        Node oldhead = head;
        while (oldhead.next!=null) {
            Node min = oldhead;
            Node cur = oldhead;
            while (cur != null) {
                if (cur.value < min.value) {
                    minpre = pre;
                    min = cur;
                }
                pre = cur;
                cur = cur.next;
            }
            if (newhead == null) {
                newhead = min;
                newtail=min;
            } else {
                newtail.next = min;
                newtail=min;
            }
            if (minpre == null) {//调整老的头部
                oldhead = oldhead.next;
            } else {
                minpre.next = min.next;
            }
        }
        newtail.next=oldhead;
        return newhead;
    }
}
