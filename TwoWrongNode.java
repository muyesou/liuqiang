package com.example.demo.algorithm;

import java.util.Stack;

public class TwoWrongNode {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t3.left = t5;
        t3.right = t2;
        t5.left = t1;
        t2.left = t4;
        TreeNode[] arr = new TreeNode[getLength(t3)];
        int[] num = {0};
        find(t3, num, arr);
        TreeNode[] wrong = getWrong(arr);
        TreeNode[] father = findFather(t3, wrong[0], wrong[1]);
        System.out.println();
    }

    private static TreeNode[] findFather(TreeNode head,TreeNode first,TreeNode second){
        TreeNode[]arr=new TreeNode[2];
        Stack<TreeNode>stack=new Stack<TreeNode>();
        TreeNode cur=head;
        while(!stack.isEmpty()||cur!=null){
             if(!stack.isEmpty()){
                 cur=stack.pop().right;
             }

             if(cur!=null){
                 if(cur.left!=null&&cur.left==first||cur.right!=null&&cur.right==first){
                     if(arr[0]==null){
                         arr[0]=cur;
                     }else{
                         arr[1]=cur;
                     }
                 }
                 if(cur.left!=null&&cur.left==second||cur.right!=null&&cur.right==second){
                     if(arr[0]==null){
                         arr[0]=cur;
                     }else{
                         arr[1]=cur;
                     }
                 }

                 stack.add(cur);
                 cur=cur.left;
             }


        }
        return arr;
    }

    private static void find(TreeNode head, int[] num, TreeNode[] arr) {
        if (head == null) {
            return;
        }
        find(head.left, num, arr);
        arr[num[0]] = head;
        num[0]++;
        find(head.right, num, arr);
    }


    private static TreeNode[] getWrong(TreeNode[] arr) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode first = null;
        TreeNode second = null;
        TreeNode may = null;
        TreeNode[] result = new TreeNode[2];
        int index = 0;
        stack.add(arr[index++]);
        while (index < arr.length) {
            TreeNode top = stack.peek();
            if (top.value > arr[index].value) {
                if (first == null) {
                    first = top;
                    may = arr[index];
                } else {
                    second = arr[index];
                }
            }
            stack.pop();
            stack.add(arr[index++]);
        }
        if (second == null) {
            second = may;
        }
        result[0] = first;
        result[1] = second;
        return result;
    }

    private static int getLength(TreeNode head) {
        if (head == null) {
            return 0;
        }
        return 1 + getLength(head.left) + getLength(head.right);
    }
}
