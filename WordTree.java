package com.example.demo.algorithm;

public class WordTree {
    static TreeNode head=new TreeNode();
    public static void main(String[] args) {
        insert("abcdefg");
        boolean abcdefg = search("abcdefg");
        System.out.println();
    }

    private static void  insert(String str){
        char[] chars = str.toCharArray();
        int i=0;
        TreeNode cur=head;
        while(i<chars.length){
            TreeNode treeNode = cur.map[chars[i] - 'a'];
            if(treeNode==null){
                treeNode=new TreeNode();
                treeNode.path=1;
                if(i==chars.length-1){
                    treeNode.end=1;
                }
                cur.map[chars[i] - 'a']=treeNode;
                cur=treeNode;
                i++;
            }else{
                treeNode.path++;
                if(i==chars.length-1){
                    treeNode.end++;
                }
                cur=treeNode;
                i++;
            }
        }
    }
    private static boolean search(String str){
        char[] chars = str.toCharArray();
        int i=0;
        TreeNode cur=head;
        while(cur!=null){
            cur=cur.map[chars[i]-'a'];
            if(i==chars.length-1){
             return cur!=null&&cur.end>0;
            }
            i++;

        }
        return false;
    }

    static class TreeNode{
        int path;
        int end;
        TreeNode[]map;
        public TreeNode(){
            path=0;
            end=0;
            map=new TreeNode[26];
        }

    }
}
