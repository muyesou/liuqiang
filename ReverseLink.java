package com.example.demo.algorithm;

public class ReverseLink {

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
        Node solve = reversePart(n1,2,5);
        System.out.println();
    }

    private static Node solve(Node head) {
        Node pre = null;
        Node cur = head;
        while (cur.next != null) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        cur.next = pre;
        return cur;
    }

    private static  Node reversePart(Node head, int from, int to) {
        int index=1;
        Node cur=head;
        Node froms=null;
        Node toend=null;
        Node pre=null;
        Node end=null;
        Node headPart=null;
        while(cur.next!=null&&index<from){
            if(index==from-1){
                froms=cur;
            }
            cur=cur.next;
            index++;
        }
        headPart=cur;
        pre=headPart;
        cur=cur.next;
        index++;
        while(cur.next!=null&&index<=to){
            Node next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
            index++;
            if(index==to){
                end=cur;
            }

        }
        toend=cur;
        froms.next=end;
        headPart.next=toend;
        if(from>1)
            return head;
        else
            return end;
    }
}
