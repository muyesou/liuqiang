package com.example.demo.algorithm;

public class SameLink {

    public static void main(String[] args) {

    }
    private static void printSame(Node head1,Node head2){
        while(head1!=null&&head2!=null){
             if(head1.getValue()>head2.getValue()){
                 head1=head1.next;
             }else if(head1.getValue()<head2.getValue()){
                 head2=head2.next;
             }else{
                 System.out.println(head1.getValue());
                 head1=head1.next;
                 head2=head2.next;
             }
        }

    }
}
