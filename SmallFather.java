package com.example.demo.algorithm;

public class SmallFather {
    public static void main(String[] args) {
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(4);

        t1.left=t2;
        t1.right=t3;
        t2.left =t4;


        TreeNode father = findFather(t1, t4, t3);
        System.out.println();
    }

    private static TreeNode findFather(TreeNode cur,TreeNode any1, TreeNode any2) {
        if(cur==any1||cur==any2||cur==null){
            return cur;
        }
        TreeNode left = findFather(cur.left, any1, any2);
        TreeNode right = findFather(cur.right, any1, any2);
        if(left!=null&&right!=null){
            return cur;
        }else{
            return left==null?right:left;
        }

    }
}
