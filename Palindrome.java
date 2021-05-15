package com.example.demo.algorithm;

public class Palindrome {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n4 = new Node(2);
        Node n5 = new Node(1);
//        Node n6 = new Node(6);
        n1.next = n2;
        n2.next = n4;
//        n3.next = n4;
        n4.next = n5;
//        n5.next = n6;
        boolean reverse = solve(n1);
        System.out.println();
    }

    private static boolean solve(Node head) {
        Node cur=head;
        Node mid=cur.next;
        cur=cur.next.next;
        Node rStart=null;
        while(cur.next!=null&&cur.next.next!=null){
           cur=cur.next.next;
           mid=mid.next;
        }
        rStart=mid;
        Node reverseStart = reverse(mid);
        while(reverseStart!=null&&head!=null){
            if(reverseStart.value!=head.value){
                return false;
            }else{
                reverseStart=reverseStart.next;
                head=head.next;
            }
        }

        return true;
    }

    private  static Node reverse(Node node){
        Node pre=null;
        Node cur=node;
        while(cur.next!=null){
            Node next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        cur.next=pre;
        return cur;
    }


}
