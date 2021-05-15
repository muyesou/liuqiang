package com.example.demo.algorithm;


import java.util.Arrays;

public class EnvelopeCover {
    public static void main(String[] args) {
        int[][]arr={{3,4},{2,3},{4,5},{1,3},{2,2},{3,6},{1,2},{3,2},{2,4}};

        int maxNum = getMaxNum(arr);
        System.out.println();
    }

    private static int getMaxNum(int[][]arr){
        Envelope[]res=new Envelope[arr.length];
        int[]wigth=new int[arr.length];
        for (int i = 0; i <arr.length ; i++) {
            res[i]=new Envelope(arr[i][0],arr[i][1]);
        }
        Arrays.sort(res,(e1,e2)->{
            if(e1.longth-e2.longth==0){
                return e2.width-e1.width;
            }else{
                return e1.longth-e2.longth;
            }
        });
        Integer[] with = Arrays.stream(res).map(e -> e.width).toArray(Integer[]::new);
        return  LongestSubOrder.getMax(convert(with));
    }
    private static int[]convert(Integer[]arr){
        int[]res=new int[arr.length];
        for (int i = 0; i <arr.length ; i++) {
            res[i]=arr[i];
        }
        return res;
    }

    static class Envelope{
        int width;
        int longth;

        public Envelope(int width, int longth) {
            this.width = width;
            this.longth = longth;
        }
    }
}
