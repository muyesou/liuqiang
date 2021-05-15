package com.example.demo.algorithm;

import com.alibaba.fastjson.support.odps.udf.JSONTuple;

import java.util.HashMap;
import java.util.Map;

public class FindMaxLengTree {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(-3);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(-9);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(0);
        TreeNode t6 = new TreeNode(2);
        TreeNode t7 = new TreeNode(1);
        TreeNode t8=new TreeNode(1);
        TreeNode t9=new TreeNode(6);
        t1.left=t2;
        t1.right=t3;

        t2.left=t4;
        t2.right=t5;

        t3.left=t6;
        t3.right=t7;

        t5.left=t8;
        t5.right=t9;
        int maxLength = getMaxLength(t1, 9);
        System.out.println();
    }
    private static int getMaxLength(TreeNode head,int sum){
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        map.put(0,0);
        int []maxLength={0};
        travel(head,1,map,0,sum,maxLength);
        return maxLength[0];
    }

    private static void travel(TreeNode head,int deep,Map<Integer,Integer>map,int preSum,int target,int[]maxLength){
        if(head==null){
            map.remove(preSum);
            return ;
        }
        preSum+=head.value;
        if(!map.containsKey(preSum)){
            map.put(preSum,deep);
        }
        if(map.containsKey(preSum-target)){
            int length=map.get(preSum)-map.get(preSum-target);
            if(maxLength[0]<length){
                maxLength[0]=length;
            }
        }
        travel(head.left,deep+1,map,preSum,target,maxLength);
        travel(head.right,deep+1,map,preSum,target,maxLength);
    }
}
