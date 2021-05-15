package com.example.demo.algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class MaxValueInArray {
    static int[]arr={2,4,5,67,66,55,1,23,22,45};
    public static void main(String[] args) {
        int[] maxValue = getMaxValue(arr, 3);
        System.out.println();
    }
    private static int[]getMaxValue(int[]arr,int n){
        int[]record=new int[arr.length-n+1];
        LinkedList<Integer> queue=new LinkedList<>();
        for(int index=0,recordIndex=0;index<arr.length; index++){
            if(queue.isEmpty()){
                queue.addFirst(index);
            }else{
                int last=arr[queue.getLast()];
                if(last>arr[index]){
                    queue.addLast(index);
                }else{
                    queue.removeLast();
                    while(true) {
                        if(queue.isEmpty()||arr[queue.getLast()]>arr[index]) {
                            queue.addLast(index);
                            break;
                        }
                        if(arr[queue.getLast()]<=arr[index])
                         queue.removeLast();

                    }
                }
            }
            if(queue.peekFirst()==index-n){
                queue.removeFirst();
            }
            if(index>=n-1)
            record[recordIndex++]= queue.peekFirst();
        }
        return record;
    }
}
