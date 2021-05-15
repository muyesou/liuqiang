package com.example.demo.algorithm;

public class MaxSearchTree {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode( 6 );
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(12);
        TreeNode t4 = new TreeNode(0);
        TreeNode t5 = new TreeNode(3);
        TreeNode t6 = new TreeNode(10);
        TreeNode t7 = new TreeNode(13);
        TreeNode t8=new TreeNode(4);
        TreeNode t9=new TreeNode(14);
        TreeNode t10=new TreeNode(20);
        TreeNode t11=new TreeNode(16);
        TreeNode t12=new TreeNode(2);
        TreeNode t13=new TreeNode(5);
        TreeNode t14=new TreeNode(11);
        TreeNode t15=new TreeNode(15);
        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t2.right=t5;
        t3.left=t6;
        t3.right=t7;
        t6.left=t8;
        t6.right=t9;
        t7.left=t10;
        t7.right=t11;
        t8.left=t12;
        t8.right=t13;
        t9.left=t14;
        t9.right=t15;


        Result maxBSTHead = findMaxBSTHead(t1);

        System.out.println();
    }
    static class Result{
        int maxNum;
        TreeNode maxHead;
        int max;
        int min;

        public Result(int maxNum, TreeNode maxHead, int max, int min) {
            this.maxNum = maxNum;
            this.maxHead = maxHead;
            this.max = max;
            this.min = min;
        }
    }
    private static Result findMaxBSTHead(TreeNode head){
        if(head==null){
            return new Result(0,null,Integer.MIN_VALUE,Integer.MAX_VALUE);
        }
        Result left = findMaxBSTHead(head.left);
        Result right = findMaxBSTHead(head.right);

        int min=Math.min(Math.min(left.min,head.value),right.min);
        int max=Math.max(left.max,Math.max(head.value,right.max));
        if(left.maxHead==head.left&&right.maxHead==head.right&&head.value>left.max &&head.value<right.min){
            Result result=new Result(left.maxNum+right.maxNum+1,head,max,min);
            return result;
        }else if(left.maxNum>right.maxNum){
            return left;
        }else{
            return right;
        }
    }

}
