package com.example.demo.algorithm;

public class CompleteTreeNum {
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
        int sum = sum(t1);
        System.out.println();

    }

    private static int sum(TreeNode head){
        if(head==null){
            return 0;
        }
        int high=getHight(head);
        int subhigh = getHight(head.right);
        if(subhigh==high-1){//左子树一定是满二叉树
            return sum(head.right)+(int)Math.pow(2.0,subhigh);
        }else{//右子树一定是满二叉树
            return sum(head.left)+(int)Math.pow(2.0,subhigh);
        }
    }

    private static int  getHight(TreeNode head){
        if(head==null){
            return 0;
        }
          int left=getHight(head.left);
          int right=getHight(head.right);
          return Math.max(left,right)+1;
    }
}
