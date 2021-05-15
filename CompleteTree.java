package com.example.demo.algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteTree {
    public static void main(String[] args) {
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(4);

        t1.left=t2;
        t1.right=t3;
        t2.left =t4;
        boolean complete = isComplete(t1);
        System.out.println();

    }

    private static boolean isComplete(TreeNode head){
        Queue<TreeNode> q=new LinkedList<>();
        q.add(head);
        while(!q.isEmpty()){
            TreeNode cur=q.poll();
            if(cur.left==null&&cur.right!=null){
                return false;
            }
            if(cur.left==null||cur.right==null){
                return isLeafAfter(q);
            }
            if(cur.left!=null){
                q.add(cur.left);
            }
            if(cur.right!=null){
                q.add(cur.right);
            }
        }

        return true;
    }
    private static boolean isLeafAfter(Queue<TreeNode> q){
        while(!q.isEmpty()){
            TreeNode t=q.poll();
            if(t.left!=null||t.right!=null){
                return false;
            }
        }
        return true;
    }

}
