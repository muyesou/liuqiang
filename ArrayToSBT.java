package com.example.demo.algorithm;

public class ArrayToSBT {
    public static void main(String[] args) {
        int []arr={1,2,3,4,5,6,7};

        TreeNode convert = convert(arr, 0, arr.length - 1);
        System.out.printf("");
    }

    private static TreeNode convert(int[] arr,int first,int end) {
        if(first>end){
            return null;
        }
        if(first==end){
            return new TreeNode(arr[first]);
        }
        int mid=first+(end-first)/2;
        TreeNode head=new TreeNode(arr[mid]);
        head.left=convert(arr,first,mid-1);
        head.right=convert(arr,mid+1,end);
        return head;
    }
}
