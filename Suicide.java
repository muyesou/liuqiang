package com.example.demo.algorithm;

public class Suicide {

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
        n6.next = n1;
//        Node solve = solve(n1);
//        int a=99;
//        System.out.println(a%2==a%2%2%2);
        Node solve = solve(n1, 3);
        System.out.println();

    }
    private static Node solve(Node head){
        while(head.next!=head){
            Node pre=head.next;
            Node kill=pre.next;
            head=kill.next;
            pre.next=head;
        }
        return head;
    }

    private static Node solve(Node head,int m){
        int num=1;
        Node cur=head;
        while(cur.next!=head){
            cur=cur.next;
            num++;
        }
        int live = getLive(num, m);
        cur=head;
        while(--live!=0){
            cur=cur.next;
        }
        return cur;
    }
    private static int getLive(int num,int m){
        if(num==1){
            return 1;
        }
        return (getLive(num-1,m)+m-1)%m+1;
    }
}
