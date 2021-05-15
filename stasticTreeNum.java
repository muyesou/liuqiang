package com.example.demo.algorithm;

import java.util.ArrayList;
import java.util.List;

public class stasticTreeNum {
    public static void main(String[] args) {

//        int i = howMuch(9);
//        System.out.println();

        List<TreeNode> disperse = disperse(make(3), 0, 2);
        System.out.println();
    }

    private static int howMuch(int n) {
        if (n < 2) {
            return 1;
        }
        int[] result = new int[n + 1];
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        int sum = 0;
        int head = 0;
        int end = 0;
        for (int i = 3; i <= n; i++) {//数量
            for (int j = 0; j < i; j++) {//第几个位置
                head = head == 0 ? result[i - 1] : 0;
                end = end == 0 ? result[i - 1] : 0;
                sum += result[j] * result[i - j - 1];
            }
            result[i] = sum + head + end;
            sum = 0;
            head = 0;
            end = 0;
        }
        return result[n];

    }



    private static List<TreeNode> disperse(List<TreeNode> list, int from, int end) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        if(from==end){
            result.add(new TreeNode(list.get(from).value));
            return result;
        }
        if(from>end){
            return result;
        }
        for (int h = from; h <= end; h++) {

            List<TreeNode> leftTrees = disperse(list, from, h - 1 );
            List<TreeNode> rightTrees = disperse(list, h + 1, end);
            int i=0;
            int j=0;
            while(i < leftTrees.size()||j<rightTrees.size()){//嵌套循环 和普通循环放在一起
                TreeNode head = new TreeNode(list.get(h).value);
                if(i < leftTrees.size()) {
                    head.left = leftTrees.get(i++);
                }
                if(j<rightTrees.size()) {
                    head.right = rightTrees.get(j++);
                }else if(j<rightTrees.size()&&leftTrees.size()!=0){
                    i++;
                    j=0;
                }

                result.add(head);
            }
        }
        return result;
    }


    private static List<TreeNode> make(int n) {
        List<TreeNode> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(new TreeNode(i));
        }
        return list;
    }
}
