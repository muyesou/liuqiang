package com.example.demo.algorithm;

public class ExperssDesired {
    public static void main(String[] args) {

        int solve = solve("1", false);
        System.out.println();
    }

    private static int solve(String experss, boolean exp) {
        char[] chars = experss.toCharArray();
        int[][] trueArr = new int[experss.length()][experss.length()];
        int[][] falseArr = new int[experss.length()][experss.length()];
//        trueArr[0][0]=chars[0]=='1'?1:0;
//        falseArr[0][0]=chars[0]=='0'?1:0;
        for (int i = 0; i < chars.length; i = i + 2) {
            trueArr[i][i] = chars[i] == '1' ? 1 : 0;
            falseArr[i][i] = chars[i] == '0' ? 1 : 0;
        }
        for (int row = 0; row < trueArr.length; row = row + 2) {
            for (int col = row + 2; col < trueArr[0].length; col = col + 2) {
                char sign = chars[col - 1];
                if (sign == '|') {
                    trueArr[row][col] = trueArr[row][col - 2]
                            + trueArr[col][col];
                    falseArr[row][col] = falseArr[row][col - 2] * falseArr[col][col];
                } else if (sign == '^') {
                    trueArr[row][col] = trueArr[row][col - 2] * falseArr[col][col]
                            + falseArr[row][col - 2] * trueArr[col][col];
                    falseArr[row][col] = trueArr[row][col - 2] * trueArr[col][col]
                            + falseArr[row][col - 2] * falseArr[col][col];
                } else if (sign == '&') {
                    trueArr[row][col] = trueArr[row][col - 2] * trueArr[col][col];
                    falseArr[row][col] = falseArr[col][col]
                            + falseArr[row][col - 2];
                }
            }
        }
//        char sign = chars[i];
        if (exp) {
            return trueArr[0][trueArr.length - 1];
//                if (sign == '|') {
//                    sum+=trueArr[start][i-1]+trueArr[i+1][end];
//                } else if (sign == '^') {
//                    sum+=trueArr[start][i-1]*falseArr[i+1][end];
//                    sum+=falseArr[start][i-1]*trueArr[i+1][end];
//                } else if (sign == '&') {
//                    sum+=trueArr[start][i-1]*trueArr[i+1][end];
//                }
        } else {//为假
//                if (sign == '|') {
//                    sum+=falseArr[start][i-1]*falseArr[i+1][end];
//                } else if (sign == '^') {
//                    sum+=trueArr[start][i-1]*trueArr[i+1][end];
//                    sum+=falseArr[start][i-1]*falseArr[i+1][end];
//                } else if (sign == '&') {
//                    sum+=falseArr[start][i-1]*falseArr[i+1][end];
//                }
            return falseArr[0][falseArr.length - 1];
        }

    }

    private static boolean isValid(String experss) {
        char[] chars = experss.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i % 2 == 0) {
                if (chars[i] < '0' && chars[i] > '9') {
                    return false;
                }
            } else {
                if (chars[i] != '|' && chars[i] != '&' && chars[i] != '^') {
                    return false;
                }

            }
        }

        return true;
    }

}
