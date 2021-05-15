package com.example.demo.algorithm;

import java.util.LinkedList;

public class ZigZagPrint {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(6);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(12);
        TreeNode t4 = new TreeNode(0);
        TreeNode t5 = new TreeNode(3);
        TreeNode t6 = new TreeNode(10);
        TreeNode t7 = new TreeNode(13);
        TreeNode t8 = new TreeNode(4);
        TreeNode t9 = new TreeNode(14);
        TreeNode t10 = new TreeNode(20);
        TreeNode t11 = new TreeNode(16);
        TreeNode t12 = new TreeNode(2);
        TreeNode t13 = new TreeNode(5);
        TreeNode t14 = new TreeNode(11);
        TreeNode t15 = new TreeNode(15);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t6.left = t8;
        t6.right = t9;
        t7.left = t10;
        t7.right = t11;
        t8.left = t12;
        t8.right = t13;
        t9.left = t14;
        t9.right = t15;

        print(t1);
    }

    private static void print(TreeNode head) {
        LinkedList<TreeNode> list = new LinkedList<>();
        TreeNode cur = head;
        boolean right = true;
        list.addFirst(cur);
        TreeNode last = head;
        TreeNode nLast = null;
        while (!list.isEmpty()) {
            TreeNode treeNode = null;
            if (right) {
                treeNode = list.pollFirst();
                if (treeNode.left != null) {
                    list.addLast(treeNode.left);
                    nLast = nLast == null ? treeNode.left : nLast;
                }
                if (treeNode.right != null) {
                    list.addLast(treeNode.right);
                }

            } else {
                treeNode = list.pollLast();
                if (treeNode.right != null) {
                    list.addFirst(treeNode.right);
                    nLast = nLast == null ? treeNode.right : nLast;
                }
                if (treeNode.left != null) {
                    list.addFirst(treeNode.left);
                }
            }


            if (treeNode == last) {
                last = nLast;
                nLast = null;
                System.out.println(treeNode.value);
                right = !right;
            } else {
                System.out.print(treeNode.value + "  ");
            }


        }
    }
}
