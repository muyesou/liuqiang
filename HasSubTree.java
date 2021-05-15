package com.example.demo.algorithm;

public class HasSubTree {
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
        TreeNode t10=new TreeNode(10);
        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t2.right=t5;
        t3.left=t6;
        t3.right=t7;
        t4.left=t8;
        t4.right=t9;
        t5.left=t10;



        TreeNode s1=new TreeNode(2);
        TreeNode s2=new TreeNode(4);
        TreeNode s3=new TreeNode(8);
        TreeNode s4=new TreeNode(5);

        s1.left=s2;
        s1.right=s4;
        s2.left=s3;
        boolean same = same(t1, s1);
        System.out.println();
    }
    private static boolean same(TreeNode head1,TreeNode head2){
        if(head1==null&&head2==null||head2==null){
            return true;
        }
        if(head1==null&&head2!=null){
            return false;
        }

        if(head1.value==head2.value){
           return same(head1.left,head2.left)&&same(head1.right,head2.right);
        }

        if(head1.value!=head2.value){
           return same(head1.left,head2)||same(head1.right,head2)||
                   same(head1,head2.left)||same(head1,head2.right);
        }
        return false;
    }

}
