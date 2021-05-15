package com.example.demo.algorithm;

public class PrintBorderNode {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
            t1.left=t2;
            t1.right=t3;
            t2.left=t4;
            t2.right=t5;
            t3.left=t6;
            t3.right=t7;
          solve(t1);
//        System.out.println(getHight(t1));

    }

    private static void solve(TreeNode head) {
       TreeNode[][] leftAndRight = new TreeNode[getHight(head)][2];
        setEdgeMap(head,0,leftAndRight);
        for (int i = 0; i <leftAndRight.length ; i++) {
            System.out.println(leftAndRight[i][0].value);
        }
        printLeafNotLeftOrRight(head,0,leftAndRight);
        for (int i = leftAndRight.length-1; i >=0 ; i--) {
            TreeNode treeNode = leftAndRight[i][1];
            if(treeNode!=leftAndRight[i][0])
                System.out.println(treeNode.value);
        }
    }
    private static void setEdgeMap(TreeNode n,int l,TreeNode[][]edgeMap){
            if(n==null){
                return;
            }//最左是第一个赋值的 最右是最后一个赋值的
            edgeMap[l][0]=edgeMap[l][0]==null?n:edgeMap[l][0];
          edgeMap[l][1]=n;
        setEdgeMap(n.left,l+1,edgeMap);
        setEdgeMap(n.right,l+1,edgeMap);
    }


    private static int getHight(TreeNode head) {
        if (head == null) {
            return 0;
        }
        int left = getHight(head.left);
        int right = getHight(head.right);
        return Math.max(left, right) + 1;
    }

    private static void printLeafNotLeftOrRight(TreeNode head,int l,TreeNode[][]map){
        if(head==null){
            return;
        }
        if(head.left==null&&head.right==null&&head!=map[l][0]&&head!=map[l][1]){
            System.out.println(head.value);
        }
        printLeafNotLeftOrRight(head.left,l+1,map);
        printLeafNotLeftOrRight(head.right,l+1,map);

    }
}
