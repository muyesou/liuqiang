package com.example.demo.algorithm;

public class PalindromeString {
    public static void main(String[] args) {
//        findPalindrome("AB");
        String minPalindromeString = findMinPalindromeString("A1BC22DE1F", "1221");

    }
    private static String findPalindrome(String str){
        char[] chars = str.toCharArray();
        int[][]dp=new int[str.length()][str.length()];
        for (int row = 0, add=1; row <dp.length||add<str.length() ; row++) {
            if(row==dp.length){
                add++;
                row=0;
            }
            for (int col = row; col<=row+add ; col++) {
                if(col==dp.length){
                    break;
                }
                if(col==row){
                    dp[row][col]=0;
                }
                else if(col-row==1){
                    if(chars[col]==chars[row]){
                        dp[row][col]=0;
                    }else{
                        dp[row][col]=1;
                    }
                }else{
                    char left=chars[row];
                    char right=chars[col];
                    if(left==right){
                        if(row+1<dp.length&&col>1) {
                            dp[row][col] = dp[row + 1][col - 1];
                        }else if(row+1<dp.length){
                            dp[row][col]=dp[row+1][col];
                        }else if(col>1){
                            dp[row][col]=dp[row][col-1];
                        }
                    }else{
                        dp[row][col]=Math.min(dp[row][col-1]+1,dp[row+1][col]+1);
                    }
                }
            }
        }
        char []res=new char[dp[0][str.length()-1]+str.length()];
        makeStr(dp,res,chars);
        return new String(res);
    }

    private static void makeStr(int[][]dp,char[]res,char[]chars){
        int left=0;
        int right=chars.length-1;
        int resLeft=0;
        int resRight=res.length-1;
        while(resLeft<=resRight){
           if(chars[left]==chars[right]){
               res[resLeft++]=chars[left++];
               res[resRight--]=chars[right--];
           }else{
               int saveL=dp[left+1][right];
               int saveR=dp[left][right-1];
               if(saveL<saveR){
                   res[resLeft++]=chars[left];
                   res[resRight--]=chars[left++];
               }else{
                   res[resLeft++]=chars[right];
                   res[resRight--]=chars[right--];
               }
           }
        }
    }


    private static String findMinPalindromeString(String source,String subStr){
        char[] sources = source.toCharArray();
        char[] subs = subStr.toCharArray();
        char[]res=new char[2*source.length()-subStr.length()];
        int resL=0;//结果序列
        int resR=res.length-1;
        int subL=0;//最长回文序列索引
//        int sourceL=0;//原始序列
//        int sourceR=source.length()-1;
        int sourceStartL=0;//原始序列
        int sourceStartR=source.length()-1;
        while(resL<=resR){
            char first=subs[subL++];
            char []left=getOutLeft(first,sources,sourceStartL,sourceStartR);
            char []right=getOutRight(first,sources,sourceStartR,sourceStartL);
            setArray(res,sources,left,right,resL,resR);
            sourceStartL=sourceStartL+left.length+1;
            sourceStartR=sourceStartR-right.length-1;
            resL=resL+left.length+right.length;
            resR=resR-right.length-left.length;
            res[resL++]= first;
            res[resR--]=first;
        }

        return new String(res);
    }

    private static void setArray(char[]res,char[]sources,char []left,char []right,int resL,int resR){
        StringBuffer leftSb=new StringBuffer();
        StringBuffer rightSb=new StringBuffer();
        leftSb.append(left);
        StringBuffer leftSbTemp=new StringBuffer(leftSb);
        rightSb.append(right);

       char[]leftPart=leftSb.append(rightSb.reverse()).toString().toCharArray();
        int leftIndex=0;
        int rightIndex=0;
       while(leftIndex<leftPart.length){
           res[resL++]=leftPart[leftIndex++];
           res[resR--]=leftPart[rightIndex++];
       }
    }
    private static char[]getOutLeft(char target,char[]sources,int start,int end){
        int length=0;
        for (int i = start; i <=end; i++) {
            if(sources[i]!=target){
                continue;
            }else{
                length=i;
                break;
            }
        }
        char []res=new char[length-start];
        for (int v = start,i=0; i <res.length ; i++) {
            res[i]=sources[start++];
        }
        return res;
    }

    private static char[]getOutRight(char target,char[]sources,int start,int end){
        int length=0;
        for (int i = start; i >=end; i--) {
            if(sources[i]!=target){
                continue;
            }else{
                length=i;
                break;
            }
        }
        char []res=new char[start-length];
        for (int v = start,i=0; i <res.length ; i++) {
            res[i]=sources[start--];
        }
        return res;
    }

}
