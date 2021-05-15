package com.example.demo.algorithm;

public class TraverTreeNode {
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
        t3.left = t6;
        t3.right = t7;
        solve(t1);
    }

    private static void solve(TreeNode head) {
        TreeNode cur = head;
        System.out.println(cur.value);
        while (cur.left != null || cur.right != null) {
            while (cur.left != null) {
                TreeNode right = findRight(cur.left, cur);
                if (right.right == null) {
                    right.right = cur;
                }else if(right.right==cur){
                    right.right=null;
                    break;
                }
                cur = cur.left;
                System.out.println(cur.value);
            }
            cur = cur.right;
            System.out.println(cur.value);
        }

    }

    //找到左子树的最右子树
    private static TreeNode findRight(TreeNode cur, TreeNode head) {
        if (cur.right == null || cur.right == head) {
            return cur;
        }
        return findRight(cur.right, head);
    }
}
