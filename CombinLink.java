package com.example.demo.algorithm;

public class CombinLink {

    public static void main(String[] args) {
        Node n1=new Node(1);
        Node n2=new Node(4);
        Node n3=new Node(5);

        Node n4=new Node(2);
        Node n5=new Node(3);
        Node n6=new Node(6);
        n1.next=n2;
        n2.next=n3;

        n4.next=n5;
        n5.next=n6;
        Node solve = solve(n1, n4);
        System.out.println();

    }
    private static Node solve(Node head1,Node head2){
        Node cur1=head1;
        Node cur2=head2;
        Node pre=null;
        Node preHead=null;
        while(cur1!=null||cur2!=null){
            if(cur1!=null&&cur2!=null){
                if(cur1.value<cur2.value){
                    if(pre==null){
                        pre=cur1;
                        preHead=cur1;
                    }else{
                        pre.next=cur1;
                        pre=cur1;
                    }
                    cur1=cur1.next;
                    continue;
                }else if(cur1.value>cur2.value){
                    if(pre==null){
                        pre=cur2;
                        preHead=cur2;
                    }else{
                        pre.next=cur2;
                        pre=cur2;
                     }
                    cur2=cur2.next;
                    continue;
                }
            }else if(cur1!=null){
                pre.next=cur1;
                pre=cur1;
                cur1=cur1.next;
            }else if(cur2!=null){
                pre.next=cur2;
                pre=cur2;
                cur2=cur2.next;
            }
        }
        return preHead;
    }
}
