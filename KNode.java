package com.example.demo.algorithm;

public class KNode {

    public static void main(String[] args) {


    }
    private static Node solve(Node head,int k){
        Node cur=head;
        int sum=k;
        while(cur!=null){
        cur=cur.next;
            sum--;
        }
        if(sum==0)
            return head.next;
        else if(sum>0)
            return head;
        else{
            Node cur1=head;
          while(sum!=0){
              cur1=cur1.next;
              sum++;
          }
          return cur1;
        }
    }
}
