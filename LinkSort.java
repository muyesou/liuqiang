package com.example.demo.algorithm;

import sun.rmi.runtime.Log;

public class LinkSort {
    public static void main(String[] args) {
        Node n1 = new Node(5);
        Node n2 = new Node(1);
        Node n4 = new Node(0);
        Node n5 = new Node(1);

        n1.next = n2;
        n2.next = n4;
//        n3.next = n4;
        n4.next = n5;

        Node solve = solve(n1, 2);

        System.out.println();
    }

    private static Node solve(Node head, int mid) {
        Node lowF = null;
        Node lowE = null;
        Node midF = null;
        Node midE = null;
        Node LogF = null;
        Node LogE = null;
        Node cur = head;
        while (cur != null) {
            if (cur.value > mid) {
                if (LogF == null) {
                    LogF = cur;
                    cur=cur.next;
                    LogF.next=null;
                } else {
                    Node curadd = LogF;
                    while (curadd.next != null) {
                        curadd = curadd.next;
                    }
                    curadd.next = cur;
                    cur=cur.next;
                    curadd.next.next=null;

                }
            } else if (cur.value == mid) {
                if (midF == null) {
                    midF = cur;
                    cur=cur.next;
                    midF.next=null;
                } else {
                    Node curadd = midF;
                    while (curadd.next != null) {
                        curadd = curadd.next;
                    }
                    curadd.next = cur;
                    cur=cur.next;
                    curadd.next.next=null;
                }
            } else if (cur.value < mid) {
                if (lowF == null) {
                    lowF = cur;
                    cur=cur.next;
                    lowF.next=null;

                } else {
                    Node curadd = lowF;
                    while (curadd.next != null) {
                        curadd = curadd.next;
                    }
                    curadd.next = cur;
                    cur=cur.next;
                    curadd.next.next=null;
                }
            }

        }
        lowE=getTail(lowF);
        midE=getTail(midF);
        LogE=getTail(LogF);
        if(lowF==null){
            if(midF==null){
                    if(LogF==null){
                        return null;
                    }else{
                        return LogF;
                    }
            }else{
                midE.next=LogF;
                return midF;
            }
        }else{
            lowE.next=midF;
            if(midF!=null){
               midE.next=LogF;
            }else{
              lowE.next=LogF;
            }
            return lowF;
        }

    }



    private static  Node getTail(Node head){
        if(head==null)
            return null;
        Node cur = head;
        while (cur.next!= null) {
            cur = cur.next;
        }
        return cur;
    }
}
