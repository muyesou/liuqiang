package com.example.demo.algorithm;

public class TreeToDeque {
   static class ReturnNode {
        DeNode head;
        DeNode tail;

        public ReturnNode(DeNode head, DeNode tail) {
            this.head = head;
            this.tail = tail;
        }
    }

    public static void main(String[] args) {
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(4);
        TreeNode t5=new TreeNode(5);
        TreeNode t6=new TreeNode(6);
        TreeNode t7=new TreeNode(7);
        TreeNode t8=new TreeNode(8);
        TreeNode t9=new TreeNode(9);

        t6.left=t4;
        t6.right=t7;
        t4.left=t2;
        t4.right=t5;
        t2.left=t1;
        t2.right=t3;
        t7.right=t9;
        t9.left=t8;
        ReturnNode solve = solve(t6);
        System.out.println();
    }

    private static ReturnNode solve(TreeNode head) {
        if(head==null){
            return new ReturnNode(null,null);
        }
        DeNode mid = new DeNode(head.value);
        ReturnNode  left=solve(head.left);

        ReturnNode  right=solve(head.right);
        if(left.tail!=null){
            left.tail.next=mid;
            mid.last=left.tail;
        }
        if(right.head!=null){
            mid.next=right.head;
            right.head.last=mid;
        }
        return new ReturnNode(left.head==null?mid:left.head,right.tail==null?mid:right.tail);
    }
}
