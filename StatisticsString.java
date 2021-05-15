package com.example.demo.algorithm;

public class StatisticsString {
    public static void main(String[] args) {
        String a_22_b_11_c_3 = getIndex("a_22_b_11_C_3", 34);
        System.out.println();
    }

    private static String getIndex(String patten, int index) {
        char[] chars = patten.toCharArray();
        boolean nextChar=true;
        int charNum=0;
        int sum=0;
        char curChar=' ';
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]=='_'){
                nextChar=!nextChar;
                if(nextChar){
                    sum+=charNum;
                    if(sum>=index){
                        return curChar+"";
                    }
                    charNum=0;
                }
                continue;
            }
            if(!nextChar){
                charNum=charNum*10+(chars[i]-'0');
            }
            if(nextChar){
                 curChar=chars[i];
            }

        }
        sum+=charNum;
        if(sum>=index){
            return curChar+"";
        }
        return "";
    }
}
