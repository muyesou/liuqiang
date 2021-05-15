package com.example.demo.algorithm;

public class StringMatch {
    public static void main(String[] args) {

       boolean match = match("", "..*");
//        "".toCharArray()

        System.out.println();
    }

    private static boolean match(String str, String exp) {

        char[]strArr=new char[str.length()+1];
        char[]expArr=new char[exp.length()+1];
        boolean [][]res=new boolean[strArr.length][expArr.length];
        System.arraycopy(str.toCharArray(),0,strArr,0,str.length());
        System.arraycopy(exp.toCharArray(),0,expArr,0,exp.length());
        strArr[strArr.length-1]=' ';
        expArr[expArr.length-1]=' ';
        res[strArr.length-1][expArr.length-1]=true;
        //str 完了 exp 没完
        for (int ei = expArr.length-2; ei >0 ; ei=ei-2) {
              char last=expArr[ei];
              char pre=expArr[ei-1];
              if(last=='*'&&(pre!='*')){
                  res[strArr.length-1][ei]=true;
                  res[strArr.length-1][ei-1]=true;
                  continue;
              }else{
                   break;
              }
        }
        //exp 最后一个匹配str 从第一个到最后一个
        char expLast=expArr[expArr.length-2];
         if(expLast=='.'||expLast==strArr[strArr.length-2]){
             res[expArr.length-2][strArr.length-2]=true;
         }

        for (int si = strArr.length-2; si >=0 ; si--) {
            for (int ei =expArr.length-2 ; ei >=0 ; ei--) {
                char s=strArr[si];
                char e=expArr[ei];
                char e2=expArr[ei+1];
                if(s==e||e=='.'){
                    if(e2=='*'){
                        int sindex=si;
                        while(sindex<strArr.length) {
                            if(res[sindex][ei+2]){
                              res[si][ei]=true;
                            }
                            sindex++;
                        }
                    }else {
                        res[si][ei] = res[si + 1][ei + 1];
                    }
                }
                else if(s!=e){
                    if(e2=='*'){
                       res[si][ei]=res[si][ei+2];
                    }
                }
            }
        }



        return res[0][0];
    }
}
