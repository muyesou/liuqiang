package com.example.demo.algorithm;

import java.util.Stack;

public class TreeTraversal {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
//        firstRecursion(t1);
//        midRecursion(t1);
//       preUnRecursion(t1);
//        midUnRecursion(t1);
        postUnRecursion(t1);
    }

    private static void firstRecursion(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.println(head.value);
        firstRecursion(head.left);

        firstRecursion(head.right);
    }

    private static void midRecursion(TreeNode head) {
        if (head == null) {
            return;
        }
        firstRecursion(head.left);
        System.out.println(head.value);
        firstRecursion(head.right);
    }

    private static void preUnRecursion(TreeNode head) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = head;
        stack.add(cur);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            System.out.println(pop.value);
            if (pop.right != null)
                stack.add(pop.right);
            if (pop.left != null)
                stack.add(pop.left);
        }
    }

    private static void midUnRecursion(TreeNode head){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = head;
        stack.add(cur);
        while(!stack.isEmpty()||cur.left!=null) {
            while (cur.left != null) {
                stack.add(cur.left);
                cur = cur.left;
            }
            TreeNode pop = stack.pop();
            System.out.println(pop.value);
            if (pop.right != null) {
                stack.add(pop.right);
                cur = pop.right;
            }
        }

    }

    private static void postUnRecursion(TreeNode head){
        Stack<TreeNode> stack1=new Stack<>();
        Stack<TreeNode> stack2=new Stack<>();
        TreeNode cur=head;
        stack1.add(cur);
        while(!stack1.isEmpty()){
            TreeNode pop = stack1.pop();
            stack2.add(pop);
            if(pop.left!=null){
                stack1.add(pop.left);
            }
            if(pop.right!=null){
                stack1.add(pop.right);
            }
        }

        while(!stack2.isEmpty()){
            System.out.println(stack2.pop().value);
        }

    }

}
