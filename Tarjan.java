package com.example.demo.algorithm;

import java.util.*;

public class Tarjan {
    static UnionFind<TreeNode> unionFind = null;


    public static void main(String[] args) {
        List<TreeNode> list = new ArrayList<>();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.right = t6;
        t5.left = t7;
        t5.right = t8;
        t6.left = t9;
        traverse(t1, list);
        unionFind = new UnionFind<TreeNode>(list);
        Query[] query = new Query[7];
        query[0] = new Query(t4, t7);
        query[1] = new Query(t7, t8);
        query[2] = new Query(t8, t9);
        query[3] = new Query(t9, t3);
        query[4] = new Query(t6, t6);
        query[5] = new Query(null, t5);
        query[6] = new Query(null, null);
        findSmallFather(query, t1);
    }

    private static void traverse(TreeNode head, List<TreeNode> list) {
        if (head == null) {
            return;
        }
        list.add(head);
        traverse(head.left, list);
        traverse(head.right, list);
    }

    private static TreeNode[] findSmallFather(Query[] arr, TreeNode head) {
        Map<TreeNode, LinkedList<TreeNode>> query = new HashMap<TreeNode, LinkedList<TreeNode>>();
        Map<TreeNode, LinkedList<Integer>> resIndex = new HashMap<TreeNode, LinkedList<Integer>>();
        Map<TreeNode, TreeNode> father = new HashMap<TreeNode, TreeNode>();
        TreeNode[] result = new TreeNode[arr.length];
        TreeNode cur = head;
        for (int i = 0, index = 0; i < arr.length; i++) {
            if (arr[i].o1 == null && arr[i].o2 == null) {
                result[i] = null;
            } else if (arr[i].o1 == null) {
                result[i] = arr[i].o2;
            } else if (arr[i].o2 == null) {
                result[i] = arr[i].o1;
            } else if (arr[i].o1 == arr[i].o2) {
                result[i] = arr[i].o1;
            } else {
                format(arr[i].o1, arr[i].o2, query, resIndex, index);
                format(arr[i].o2, arr[i].o1, query, resIndex, index++);
            }
        }
        dealQues(query, head, father, resIndex, result);

        return result;
    }

    private static void union(TreeNode h1, TreeNode lastFather, Map<TreeNode, TreeNode> fatherMap) {
        if(h1==null){
            return;
        }
        TreeNode perFather1=unionFind.findFather(h1);
        TreeNode perFather2=unionFind.findFather(lastFather);
        unionFind.union(h1, lastFather);
        TreeNode unionFather = unionFind.findFather(h1);//聚合之后的头节点
        fatherMap.remove(perFather1);
        fatherMap.remove(perFather2);
        fatherMap.remove(unionFather);
        fatherMap.put(unionFather, lastFather);
    }

    private static TreeNode dealQues(Map<TreeNode, LinkedList<TreeNode>> query, TreeNode tree, Map<TreeNode, TreeNode> father, Map<TreeNode, LinkedList<Integer>> resIndex, TreeNode[] result) {
        if (tree == null) {
            return null;
        }
        TreeNode left = dealQues(query, tree.left, father, resIndex, result);
        TreeNode fatherNode = unionFind.findFather(tree);
        father.put(fatherNode, fatherNode);
        while (query.get(tree) != null&&query.get(tree).size()>0) {//寻找是否存在问题
            TreeNode treeNode = father.get(unionFind.findFather(query.get(tree).pollFirst()));
            int index = resIndex.get(tree).pollFirst();
            if (treeNode != null) {
                result[index] = treeNode;
            }
        }
        union(left, tree, father);
        TreeNode right = dealQues(query, tree.right, father, resIndex, result);
        union(right, tree, father);
        return tree;
    }

    private static void format(TreeNode o1, TreeNode o2, Map<TreeNode, LinkedList<TreeNode>> query, Map<TreeNode, LinkedList<Integer>> resIndex, Integer index) {
        LinkedList<TreeNode> treeNodeLinkedList = query.get(o1);
        if (treeNodeLinkedList == null) {
            treeNodeLinkedList = new LinkedList<TreeNode>();
        }
            treeNodeLinkedList.add(o2);
        query.put(o1, treeNodeLinkedList);

        ////
        LinkedList<Integer> integerLinkedList = resIndex.get(o1);
        if (integerLinkedList == null) {
            integerLinkedList = new LinkedList<Integer>();
        }
        integerLinkedList.add(index);

        resIndex.put(o1, integerLinkedList);
    }
}
