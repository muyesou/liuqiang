package com.example.demo.algorithm;

public class delMidNode {
    public static void main(String[] args) {
        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);
        Node node4=new Node(4);
        Node node5=new Node(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
       // del(node1);
        System.out.println(sum(5,4,2));
        System.out.println();
    }
    private  static Node del(Node head){
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        if(head.next.next==null){
            return head.next;
        }else {
            Node mid = head;
            Node last=head.next.next;
            while(last!=null&&last.next!=null&&last.next.next!=null){
                mid=mid.next;
                last=last.next.next;
            }
            mid.next=mid.next.next;

        return head;
        }
    }
    private  static int sum(int a,int b,int length){
        return (int)Math.ceil(((double)a*(double)length)/ (double)b);
    }

    private static Node delPro(Node head,int a,int b){
            int length=0;
            int delIndex=0;
            Node cur=head;
            while(cur!=null){
                cur=cur.next;
                length++;
            }
        delIndex=(int)Math.ceil(((double)a*(double)length)/ (double)b);


        return null;
    }
}
