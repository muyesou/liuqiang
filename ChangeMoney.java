package com.example.demo.algorithm;

public class ChangeMoney {
    public static void main(String[] args) {
        int []arr={5,2,3};
        int solve = solve(arr, 20);
        System.out.println();
    }

    private static int solve(int[] arr, int money) {
        int [][]result=new int[arr.length+1][money+1];
        for (int i = 1; i <result[arr.length].length ; i++) {
            result[arr.length][i]=-1;
        }
        for (int i = result.length-2; i >=0 ; i--) {
            for (int rest = 0; rest >=0&&rest<=money ; rest++) {
                int left=rest - arr[i];//左边的index
                int behand=result[i+1][rest];
                if(left>=0&&result[i][left]!=-1) {//有左边 有效
                    if(behand>0){
                        result[i][rest]=Math.min(result[i][left]+1,behand);
                    }else{
                        result[i][rest]=result[i][left]+1;
                    }
                }else{
                    if(behand!=-1){
                        result[i][rest]=behand;
                    }else{
                        result[i][rest]=-1;
                    }

                }
            }
        }


        return result[0][money];
    }
}
