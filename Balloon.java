package com.example.demo.algorithm;

import java.util.Arrays;

public class Balloon {
    public static void main(String[] args) {
//        String a = "325";
//        print(a.toCharArray(),0,a.length()-1);
//        System.out.println();
        int[]arr={4,2};
        int maxScore = getMaxScore(arr);
        System.out.println();

    }

    private static int getMaxScore(int[] arr) {
        int []suitArr=new int[arr.length+2];
        int [][]socre=new int[arr.length+2][arr.length+2];
        System.arraycopy(arr,0,suitArr,1,arr.length);
        suitArr[0]=1;
        suitArr[suitArr.length-1]=1;
        for (int i = 1; i <socre.length-1 ; i++) {
            for (int j = 1; j <socre[0].length-1 ; j++) {
                if(i==j) {
                    socre[i][j]=suitArr[i-1]*suitArr[i]*suitArr[i+1];
                }
            }
        }
        for (int left = socre.length-1; left >=1 ; left--) {//Left
            for (int right = left+1; right <socre[0].length-1 ; right++) {//Right
                int leftLast=suitArr[left-1]*suitArr[left]*suitArr[right+1]+socre[left+1][right];
                int rightLast=suitArr[left-1]*suitArr[right]*suitArr[right+1]+socre[left][right-1];
                int max=Math.max(leftLast,rightLast);
                socre[left][right]=max;
                for (int i = left+1; i <right ; i++) {
                    int sum=socre[left][i-1]+socre[i+1][right]+suitArr[i]*suitArr[i-1]*suitArr[i+1];
                    max=Math.max(max,sum);
                }

            }
        }
        return socre[1][socre.length-2];
    }


    private static void print(char[] chars, int fixed, int last) {
        if (fixed == last) {
            print(chars);
            return;
        }
        for (int i = fixed, swap = 0; i + swap <= last; swap++) {
            swap(chars, i, i + swap);
            print(chars, i + 1, last);
            swap(chars, i + swap, i);
        }

    }

    private static void swap(char[] chars, int a, int b) {
        char charA = chars[a];
        chars[a] = chars[b];
        chars[b] = charA;
    }

    private static void print(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.println(arr[i]);
            } else {
                System.out.print(arr[i]);
            }
        }
    }
}
