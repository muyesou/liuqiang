package com.example.demo.algorithm;

public class InsertLoop {

    public static void main(String[] args) {
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        n1.next=n2;
        n2.next=n3;
        n3.next=n1;

        Node solve = solve(n1, 66);
        System.out.println();
    }

    private static Node solve(Node head,int num){
        Node node=new Node(num);
        Node pre=head;
        Node last=head.next;
        while(!(pre.value<=num&&last.value>num)){
            if(last==head){
                break;
            }
            pre=pre.next;
            last=last.next;
        }
        node.next=last;
        pre.next=node;
        if(num<head.value){

            return node;
        }else{
            return head;
        }

    }
}
