package com.example.demo.algorithm;

public class RebuildTreePost {

    public static void main(String[] args) {
        int []arr={2,1,3,6,5,7,4};
        TreeNode solve = solve(arr, 0, arr.length - 1);
        System.out.println();
    }

    private static TreeNode solve(int[] arr,int first,int end) {
        if(end==first){
            return new TreeNode(arr[first]);
        }
        TreeNode head=new TreeNode(arr[end]);
        int rightStart=-1;
        int leftStart=-1;
        for (int i=first;i<end;i++){
            if(arr[i]>arr[end]){
                rightStart=rightStart==-1?i:rightStart;

            }else if(arr[i]<arr[end]){
                leftStart=leftStart==-1?i:leftStart;

            }
        }
        if(leftStart!=-1)
        head.left=solve(arr,leftStart,rightStart==-1?end-1:rightStart-1);
        if(rightStart!=-1)
        head.right=solve(arr,rightStart,end-1);

        return head;
    }

}
