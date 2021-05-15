package com.example.demo.algorithm;

public class BalenceTree {

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
        TreeNode t11=new TreeNode(11);
        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t2.right=t5;
        t3.left=t6;
        t3.right=t7;
        t4.left=t8;
        t4.right=t9;
        t5.left=t10;
        t8.left=t11;
        Return solve = solve(t1);
        System.out.println();

    }


    private static Return solve(TreeNode head){
        if(head==null){
            return new Return(0,true);
        }
        Return left = solve(head.left);
        Return right = solve(head.right);
        if(Math.abs(left.high-right.high)>1||!left.isBalence||!right.isBalence){
            return new Return(left.high>right.high?left.high+1:right.high+1,false);
        }
        return new Return(left.high>right.high?left.high+1:right.high+1,true);
    }

    static class Return{
        int high;
        boolean isBalence;

        public Return(int high, boolean isBalence) {
            this.high = high;
            this.isBalence = isBalence;
        }
    }
}
