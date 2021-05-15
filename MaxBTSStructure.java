package com.example.demo.algorithm;

import java.util.HashMap;
import java.util.Map;

public class MaxBTSStructure {

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


        getMaxBSTNum(t1);
    }

    static class Record {
        int left;
        int right;

        public int getLeft() {
            return left;
        }

        public void setLeft(int left) {
            this.left = left;
        }

        public int getRight() {
            return right;
        }

        public void setRight(int right) {
            this.right = right;
        }

        public Record(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    private static int getMaxBSTNum(TreeNode head) {
        Map<TreeNode, Record> map = new HashMap<TreeNode, Record>();
        getTotal(head, map);
        int max = 0;
        for (Record r : map.values()) {
            if (r.getRight() + r.getLeft() > max) {
                max = r.getLeft() + r.getRight();
            }
        }
        return max;
    }

    private static void getTotal(TreeNode head, Map<TreeNode, Record> map) {
        if (head == null) {
            return;
        }
        map.put(head, new Record(0, 0));
        getTotal(head.left, map);
        getTotal(head.right, map);
        if (head.left != null) {
            Record record = map.get(head);
            if (head.left.value < head.value) {
                record.setLeft(1 + map.get(head.left).getLeft() + getRight(head.left, head.value, map));
            }
        }
        if (head.right != null) {
            Record record = map.get(head);
            if (head.right.value > head.value) {
                record.setRight(1 + map.get(head.right).getRight() + getLeft(head.right, head.value, map));
            }

        }

    }

    private static int getRight(TreeNode head, int father, Map<TreeNode, Record> map) {
        int right = map.get(head).getRight();
        TreeNode cur = head;
        while (cur != null) {
            if (cur.value > father) {
                right = right - map.get(cur).getLeft() - map.get(cur).getRight() - 1;
                break;
            }
            cur = cur.right;
        }

        return right;
    }

    private static int getLeft(TreeNode head, int father, Map<TreeNode, Record> map) {
        int left = map.get(head).getLeft();
        TreeNode cur = head;
        while (cur != null) {
            if (cur.value < father) {
                left = left - map.get(cur).getLeft() - map.get(cur).getRight() - 1;
                break;
            }
            cur = cur.left;
        }

        return left;
    }

}
