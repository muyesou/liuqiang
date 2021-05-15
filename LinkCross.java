package com.example.demo.algorithm;

import reactor.core.publisher.Mono;

public class LinkCross {

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
        n5.next=n2;
        n6.next=n5;

//        Node loop = findLoop(n1);
//        Node crossNoLoop = findCrossNoLoop(n1, n4,null);
        Node crossLoop = findCrossLoop(n1, n6);
        System.out.println();
    }

    private static Node findLoop(Node head){
        Node fast=head;
        Node low=head.next.next;
        while(fast.next!=null&&low.next!=null){
            if(fast==low){
                fast=head;
                while(fast!=low){
                    fast=fast.next;
                    low=low.next;
                }

                return fast;
            }
            fast=fast.next.next;
            low=low.next;
        }

        return null;
    }

    private static Node findCrossNoLoop(Node head1,Node head2,Node tail){
        Node cur1=head1;
        Node cur2=head2;
        int leng1=0;
        int leng2=0;
        while(cur1.next!=tail||cur2.next!=tail){
            if(cur1.next!=tail){
                leng1++;
                cur1=cur1.next;
            }
            if(cur2.next!=tail) {
                leng2++;
                cur2 = cur2.next;
            }
        }
        if(cur1!=cur2){
          return null;
        }
        int first=Math.abs(leng1-leng2);
         cur1=head1;
         cur2=head2;
        if(leng1>leng2){
            while(first--!=0){
                cur1=cur1.next;
            }
        }else if(leng1<leng2){
            while(first--!=0){
                cur2=cur2.next;
            }
        }
        while(cur1!=cur2){
            cur1=cur1.next;
            cur2=cur2.next;
        }
        return cur1;
    }

    private static Node findCrossLoop(Node head1,Node head2){
        Node loop1 = findLoop(head1);
        Node loop2 = findLoop(head2);
        if(loop1==loop2){//之前就相遇了
           return  findCrossNoLoop(head1,head2,loop1);
        }else if(loop1!=loop2){//可能相遇 可能没有
            Node cur=loop1;
            while(cur!=loop2){
                cur=cur.next;
                if(cur==loop1){
                    return null;
                }
            }
            return loop1;
        }
        return null;
    }
}
