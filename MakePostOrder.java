package com.example.demo.algorithm;

public class MakePostOrder {
    public static void main(String[] args) {
        int []pre={1,2,4,5,3,6,7};
        int []  mid={4,2,5,1,6,3,7};
        int []post=new int[pre.length];
        int []index={post.length-1};
        solve(pre,0,pre.length-1,mid,0,mid.length-1,post,index);
        System.out.println();
    }

    private static void solve(int[] pre,int preF,int preEnd, int[] mid, int midF,int midE,int[] post,int[] index) {
        int head=pre[preF];
        int midIndex = findIndex(mid, head);
        if(preF==preEnd){
            post[index[0]]=mid[midIndex];
            return;
        }
        int leftEndIndex=findIndex(pre,mid[midIndex-1]);
        post[index[0]]=mid[midIndex];
        index[0]-=1;
        solve(pre, leftEndIndex + 1, preEnd, mid, midIndex + 1, midE, post, index );
        index[0]-=1;
        solve(pre,preF+1,leftEndIndex,mid,midF,midIndex-1,post,index);
        return ;
    }

    private  static int findIndex(int []arr,int value){
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i]==value){
                return i;
            }
        }
        return -1;
    }
}
