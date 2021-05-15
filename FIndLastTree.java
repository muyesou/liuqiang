package com.example.demo.algorithm;

public class FIndLastTree {
    public static void main(String[] args) {
        NewTreeNode n1=new NewTreeNode(1);
        NewTreeNode n2=new NewTreeNode(2);
        NewTreeNode n3=new NewTreeNode(3);
        NewTreeNode n4=new NewTreeNode(4);
        NewTreeNode n5=new NewTreeNode(5);
        NewTreeNode n6=new NewTreeNode(6);
        NewTreeNode n7=new NewTreeNode(7);
        NewTreeNode n8=new NewTreeNode(8);
        NewTreeNode n9=new NewTreeNode(9);
        NewTreeNode n10=new NewTreeNode(10);

        n6.left=n3;
        n6.right=n9;
        n3.left=n1;
        n3.right=n4;
        n3.parent=n6;
        n9.left=n8;
        n9.right=n10;
        n9.parent=n6;
        n1.right=n2;
        n1.parent=n3;
        n4.right=n5;
        n4.parent=n3;
        n8.left=n7;
        n8.parent=n9;
        n10.parent=n9;
        n2.parent=n1;
        n5.parent=n4;
        n7.parent=n8;


        NewTreeNode next = findNext(n10);
        System.out.println();


    }

    private static NewTreeNode findNext(NewTreeNode any) {
        if(any.right!=null){//右子树最左边
            return getLeft(any.right);
        }
        NewTreeNode parent=any.parent;
        while(parent!=null) {
            if (parent.left == any) {
                return parent;
            } else {//是父节点的右子树
                any = any.parent;
                parent = parent.parent;
            }
        }
        return null;
    }

    private static NewTreeNode getLeft(NewTreeNode head){
        if(head.left==null){
            return head;
        }
        else{
            return getLeft(head.left);
        }
    }
}
