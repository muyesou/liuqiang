package com.example.demo.algorithm;

public class ReplaceBlacK {
    public static void main(String[] args) {
//        char[]arr=new char[100];
//        arr[0]='a';
//        arr[1]=' ';
//        arr[2]='b';
//        arr[3]=' ';
//        arr[4]=' ';
//        arr[5]='c';
//        replace(arr);
        char[]arr={'1','2','*','4','5','*','8','9','0','*','*'};

        replaceSnow(arr);
        System.out.println();
    }
    private static void replace(char[]arr){
        int len=0;
        int black=0;
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i]!=0){
                len++;
            }
            if(arr[i]==' '){
                black++;
            }
        }
        for (int w = len+black*2-1,r=len-1; w >=0 ; r--) {
            if(arr[r]==' '){
                arr[w--]='0';
                arr[w--]='2';
                arr[w--]='%';
            }
            else{
                arr[w--]=arr[r];
            }
        }

    }

    private static void replaceSnow(char[]arr){
        int numIndex=arr.length-1;
        for (int i = numIndex; i >=0 ; i--) {
            if(Character.isDigit(arr[i])){
               arr[numIndex--]=arr[i];
            }
        }
        for (int i = 0; i <=numIndex; i++) {
            arr[i]='*';
        }

    }
}
