package com.example.demo.algorithm;

public class MaxDistanceTree {
    public static void main(String[] args) {
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(4);
        TreeNode t5=new TreeNode(5);
        TreeNode t6=new TreeNode(6);
        TreeNode t7=new TreeNode(7);
       t1.left=t2;
       t1.right=t3;
       t2.left=t4;
       t2.right=t5;
       t3.left=t6;
       t3.right=t7;

        int maxDistance = getMaxDistance(t1);
        System.out.println();


    }
    private static int getMaxDistance(TreeNode head){

        return getResult(head).maxDistance;
    }
    private static Return getResult(TreeNode head){
        if(head==null){
            return new Return(0,0);
        }
        Return left = getResult(head.left);
        Return right = getResult(head.right);
        Return mid=new Return(Math.max(left.high,right.high)+1,left.high+right.high+1);
        return new Return(Math.max(left.high,right.high)+1,
                Math.max(mid.maxDistance,Math.max(left.maxDistance,right.maxDistance)));

    }
    static class Return{
         int high;
         int maxDistance;

        public Return(int high, int maxDistance) {
            this.high = high;
            this.maxDistance = maxDistance;
        }
    }
}
