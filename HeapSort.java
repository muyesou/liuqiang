package com.example.demo.algorithm;

public class HeapSort {
    public static void main(String[] args) {
        int[]arr={2,1,4,3,7,99,77,45};
//        adjust(arr,0,arr.length-1);
        sort(arr);
        System.out.println();
    }
    private static void sort(int []arr){
        for (int i = arr.length-1; i >0 ; i--) {
            adjust(arr,0,i);
            swap(arr,0,i);
        }
    }
    private static void adjust(int[] arr, int first, int end) {//使符合堆结构
        int fin=end;
        if(fin-first==1){
            int left=fin;
            if(arr[left]>arr[first]){
                swap(arr,left,first);
            }
            fin--;
        }
        while (fin != 0) {
            int lastFather = (fin - 1) / 2;
            int left = 2 * lastFather+1;
            int right =2 * lastFather + 2;

            if (arr[left] > arr[lastFather] && arr[left] > (right>end?0:arr[right])) {
                swap(arr, lastFather, left);
            }
            if ((right>end?0:arr[right]) > arr[lastFather] && (right>end?0:arr[right]) > arr[left]) {
                swap(arr, lastFather, right);
            }
            fin = fin-1;
            if((fin - 1) / 2==lastFather){
                fin--;
            }
        }

    }

    private static void swap(int[] arr, int res, int target) {
        int temp = arr[res];
        arr[res] = arr[target];
        arr[target] = temp;
    }
}
