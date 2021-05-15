package com.example.demo.algorithm;

public class Jump {
    public static void main(String[] args) {

        int []arr={3,2,3,1,1,4};

        int min = getMin(arr);
        System.out.println();
    }

    private static int getMin(int[] arr) {
        int thisMax = 0;
        int times = 0;
        int nextMax = 0;
        int next=0;
        for (int i = 0; i < arr.length; i++) {
            thisMax=i+arr[i];
            nextMax=0;
            for(next=i+1;next<=thisMax&&next<arr.length;next++){
                if(arr[next]+next>nextMax) {
                    nextMax = arr[next]+next;
                }
            }
            if(thisMax>=arr.length-1){
                return times+1;
            }else{
                times++;
                i=next;
            }
        }

        return times;
    }
}
