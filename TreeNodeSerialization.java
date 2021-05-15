package com.example.demo.algorithm;

public class TreeNodeSerialization {
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
        String serializ = serializ(t1);
        TreeNode treeNode = unSerializ(serializ);
        System.out.println();
    }

    private static String serializ(TreeNode head) {
        if (head == null) {
            return "#!";
        }
        String leftStr = serializ(head.left);
        String rightStr = serializ(head.right);
        return head.value + "!" + leftStr + rightStr;
    }

    private static TreeNode unSerializ(String str) {
        String[] nodes = str.split("!");
        int[] index=new int[1];
        index[0]=0;
        return makeTreeNode(nodes,index);
    }

    private static TreeNode makeTreeNode(String[] nodes, int[] index) {
        if (nodes[index[0]].equals("#")) {
            return null;
        }
        TreeNode father=new TreeNode(Integer.valueOf(nodes[index[0]]));
        ++index[0];
        father.left =makeTreeNode(nodes,index);
        ++index[0];
        father.right = makeTreeNode(nodes, index);
        return father;
    }
}
