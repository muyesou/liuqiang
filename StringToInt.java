package com.example.demo.algorithm;

public class StringToInt {
    public static void main(String[] args) {
        System.out.println(convert("2147483648"));
    }

    private static int convert(String a) {
        int minR=Integer.MIN_VALUE/10;
        int minL=Integer.MIN_VALUE%10;
        char[] chars = a.toCharArray();
        int res=0;
        int i=0;
        boolean positive=true;
        if(chars[0]=='-'){
            i=1;
            positive=false;
        }
        for (; i <chars.length ; i++) {
            int nextNum='0'-chars[i];
            if(res<minR||(res==minR&&nextNum<minL)){
                return 0;
            }
            res=res*10+nextNum;
        }
        if(res==Integer.MIN_VALUE&&positive){
            return 0;
        }
        return positive?(-1)*res:res;
    }
}
