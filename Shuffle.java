package com.example.demo.algorithm;

public class Shuffle {
    public static void main(String[] args) {
//        int begin = findBegin(6);
        int []arr={1,2,3,4,5,6,7,8,9,10};
//       FlipString.reverse(arr,2,1,3);
        solve(arr,0,arr.length-1);
        System.out.println();
    }

    private static void solve(int[]arr,int start,int end){
        while(end>start) {
            int begin = findBegin(end - start + 1);
            int fixThis= (int) Math.pow(3, begin) - 1;//确定可以通过几个点遍历交换完的
            int N=(end-start+1)/2;
            FlipString.reverse(arr,N-fixThis/2,start+fixThis/2,start+fixThis/2+N-1);
            shuffle(arr, start, start +fixThis-1 , begin);
            start=start + fixThis;
        }

    }
    private static void shuffle(int[]arr,int start,int end,int beginPoint){//找到自己的位置，并放入自己的值，挤出他人的值
        for (int i = 0; i <beginPoint ; i++) {
            int head=(int)Math.pow(3,i)+start-1;
            int cur=-1;
            int firstPop=arr[head];
            int secPop=0;
            while(cur!=head) {
                cur=cur==-1?head:cur;
                int next = start + findNext(start,cur, end - start + 1);
                secPop = arr[next];
                arr[next] =firstPop;
                firstPop=secPop;
                cur=next;
            }
        }
    }
    private static int findBegin(int length){//多少个点能遍历完整
        int cur=0;
        while(Math.pow(3,++cur)-1<=length){

        }
        return cur-1;
    }

    private static int findNext(int start,int i,int length){

        return 2*((i-start)+1)%(length+1) -1;
    }
}
