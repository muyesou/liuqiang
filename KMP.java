package com.example.demo.algorithm;

public class KMP {
    public static void main(String[] args) {
//        int[] abc1abc1s = getNextArr("aaaaaaa");
        int match = match("liuqiang0014mu00142019muyemuyesou", "muyesou");
        System.out.println();

    }

    public static int match(String str, String match) {
        int[] nextArr = getNextArr(match);
        char[] chars = str.toCharArray();
        char[] matchChars = match.toCharArray();
        for (int i = 0,matchIndex=0; i < chars.length;) {
                if(chars[i]==matchChars[matchIndex]){
                        i++;
                        matchIndex++;
                        if(matchIndex==matchChars.length){
                            return i-matchChars.length;
                        }
                }else{
                    if(matchIndex==0){
                        i++;
                        continue;
                    }
                    int maxLength = nextArr[matchIndex];
                    matchIndex=maxLength;

                }
        }
        return -1;
    }

    private static int[] getNextArr(String str) {
        int[] nextArr = new int[str.length()];
        char[] chars = str.toCharArray();
        nextArr[0] = -1;
        nextArr[1] = 0;
        int i = 2;
        if(str.length()>2) {
            nextArr[2] = chars[0] == chars[1] ? 1 : 0;
            i=3;
        }
        for (; i < chars.length; i++) {
            int maxLength = nextArr[i - 1];
            char next = chars[maxLength];
            char last=chars[i - 1];
            if (next == last) {
                nextArr[i] = maxLength + 1;
            } else {
                while (next != last&&maxLength>0) {
                    maxLength = nextArr[maxLength + 1];
                    next = chars[maxLength];
                    if (next == last) {
                        nextArr[i] = maxLength + 1;
                        break;
                    }
                }
                if (next != last) {
                    nextArr[i] = 0;
                }

            }
        }
        return nextArr;
    }

}
