package com.example.demo.algorithm;

public class FlipString {
    public static void main(String[] args) {
//        char[] arr = {'d', 'o', 'g', ' ', 'l', 'o', 'v', 'e', 's', ' ', 'p', 'i', 'g'};
//        solve(arr);
        char[] arr = {'A', 'B', 'C', 'D', 'E','F','G','H'};
//        reverse(arr, 2);
        reverse1(arr,1);
        System.out.println();
    }

    private static void solve(char[] arr) {
        allSwap(arr, 0, arr.length - 1);
        int charS = -1;
        int charE = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                allSwap(arr, charS, charE);
                charS = i;
                charE = i;
            } else {
                if (charS == -1 || arr[charS] == ' ') {
                    charS++;
                }
                charE++;
            }
        }
        allSwap(arr, charS, charE);

    }

    public static void reverse(char[] arr, int size) {
        allSwap(arr, 0, size - 1);
        allSwap(arr, size, arr.length - 1);
        allSwap(arr, 0, arr.length - 1);
    }
    public static void reverse(int[] arr, int size,int start,int end) {
        allSwap(arr, start, start+size - 1);
        allSwap(arr, start+size, end);
        allSwap(arr, start, end);
    }

    private static void reverse1(char[]arr,int size){
        reverseD(arr,0,size-1,size,arr.length-1);
    }
    private static void reverseD(char[]arr,int leftS,int leftE,int rightS,int rightE){
        int leftLen=leftE-leftS+1;
        int rightLen=rightE-rightS+1;
        if(leftLen>rightLen){
            for (int i =rightS,j=leftS; i <= rightE; i++,j++) {
                swap(arr,j,i);
            }
            reverseD(arr,leftS+rightLen,leftE,rightS,rightE);
        }else if(rightLen>leftLen){
            for (int i = leftE,j=rightE; i >=leftS ; i--,j--) {
                swap(arr,i,j);
            }
            reverseD(arr,leftS,leftE,rightS,rightE-leftLen);
        }else{
            for (int i = leftS,j=rightS; i <=leftE ; i++,j++) {
                swap(arr,i,j);
            }
        }

    }
    private static void allSwap(char[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        if (end - 1 == start) {
            swap(arr, start, end);
        } else {
            int mid = start + (end - start + 1) / 2;
            for (int i = start; i < mid; i++) {
                swap(arr, i, mid + (mid - i));
            }
        }
    }
    private static void allSwap(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        if (end - 1 == start) {
            swap(arr, start, end);
        } else {
            for (int i = start,j=end; i < j;) {
                swap(arr, i++,j--);
            }
        }
    }
    private static void swap(char[] arr, int start, int end) {
        char temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
