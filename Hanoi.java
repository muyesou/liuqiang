package com.example.demo.algorithm;

public class Hanoi {
    public static void main(String[] args) {
        int[] arr = {1, 1};
       int index = getIndex(arr, 0, arr.length - 1);
        int index1 = getIndex(arr);
        System.out.println();
    }

    private static int getIndex(int[] arr, int first, int end) {
        if (first > end) {
            return 0;
        }
        if (arr[end] == 2) {
            if (end == arr.length - 1) {
                return -1;
            }
            return (int) Math.pow(2.0, end);

        } else if (arr[end] == 3) {
            return (int) Math.pow(2.0, end) + getIndex(arr, first, end - 1);
        } else {
            return getIndex(arr, first, end - 1);
        }
    }


    private static int getIndex(int[] arr) {
        int from=0;
        int end=arr.length-1;
        int sum=0;
        int index=end;
        int left=1;
        int mid=2;
        int right=3;
        while(index>=0){
            if(arr[index]==left){
                index--;
            }else if(arr[index]==mid){
                if(index==end){
                    return -1;
                }
                return (int)Math.pow(2.0,index);
            }else{
                sum+=(int)Math.pow(2.0,index)+1;
                index--;
            }
        }

        return sum;
    }
}
