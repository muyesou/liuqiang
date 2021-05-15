package com.example.demo.algorithm;

public class ComposeHalf {
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
        n5.next = n6;
        solve(n1);
        System.out.println();
    }

    private static void solve(Node head) {
        Node cur = head;
        Node curFast = head.next;
        Node lastLeft = null;
        Node firstRight = null;
        Node rightcur = null;
        while (curFast != null && curFast.next != null && curFast.next.next != null) {
            cur = cur.next;
            curFast = curFast.next.next;
        }
        lastLeft = cur;
        firstRight = cur.next;

        cur = head;
        rightcur = firstRight;

        while (cur.next != firstRight && rightcur != null) {
            Node leftNext = cur.next;
            cur.next = rightcur;
            cur = leftNext;
            Node rightNext=rightcur.next;
            rightcur.next=cur;
            rightcur = rightNext;
        }
        cur.next=rightcur;

    }
}
