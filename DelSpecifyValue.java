package com.example.demo.algorithm;

public class DelSpecifyValue {

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
        Node solve = solve(n1,1);
        System.out.println();
    }

    private static Node solve(Node head,int num){
        Node cur=head;
        Node tail=null;
        Node newHead=head;
        while(cur!=null){
            if(cur.value==num){
                if(tail==null){
                   cur=cur.next;
                }else{
                   Node next=cur.next;
                   tail.next=next;
                   cur=next;
                }
            }else{
              if(tail==null){
                  newHead=cur;
                  tail=cur;
              }else{
                  tail.next=cur;
                  tail=cur;
                  cur=cur.next;
              }
              cur=cur.next;
            }
        }

        return newHead;
    }
}
