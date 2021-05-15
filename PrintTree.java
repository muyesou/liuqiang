package com.example.demo.algorithm;

public class PrintTree {
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
        solve(t1,1,null);

    }

    private static void solve(TreeNode head,int deep,Boolean right){
        if(head==null){
            return;
        }
        solve(head.right,deep+1,true);
        if(deep==1){
            printStr(head.value,"H",1);
        }else if(right) {
            printStr(head.value,"v",deep);
        }else if(!right){
            printStr(head.value,"^",deep);
        }
        solve(head.left,deep+1,false);
    }
    private static void printStr(int value,String pre,int deep){
        String str=pre+value+pre;
        int[] black = getBlackNum(str);
        System.out.println(getBlack(deep*17)+getBlack(black[0])+str+getBlack(black[1]));
    }
    private static String getBlack(int num){
        StringBuffer stringBuffer=new StringBuffer("");
        for (int i = 0; i <num ; i++) {
            stringBuffer.append(" ");
        }
        return stringBuffer.toString();
    }

    private static int[] getBlackNum(String str){
        int []arr=new int[2];
        arr[0]= (17-str.length())/2;
        arr[1]=17-str.length()-arr[0];
        return arr;
    }
}
