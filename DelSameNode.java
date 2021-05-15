package com.example.demo.algorithm;

import java.util.HashMap;
import java.util.Map;

public class DelSameNode {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        Node n4 = new Node(1);
        Node n5 = new Node(2);
        Node n6 = new Node(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next=n6;

        solve(n1);
        System.out.println();
    }
    private static void solve(Node head){
        Map<Integer,Node> map=new HashMap<>();
        Node cur=head;
        Node newPre=null;
        while(cur!=null){
            Integer value=cur.value;
            if(map.get(value)==null){
               map.put(value,cur);
               newPre=cur;
            }else{
                Node next=cur.next;
                newPre.next=next;
                cur=newPre;
            }
            cur=cur.next;
        }

    }
}
