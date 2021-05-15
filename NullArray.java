package com.example.demo.algorithm;

public class NullArray {
    public static void main(String[] args) {
        String []arr={null,"a",null,"a",null,"b",null,"c","v"};

        int a = findLeft(arr, "v");
        System.out.println();
    }

    private static int findLeft(String[] arr, String c) {
        if (c == null) {
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;

        int res = Integer.MAX_VALUE;
        while (end >= start) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == null) {
                end=mid;
                while (arr[--end] == null&&end>=start) {
                }
                if(end<start){//从右边二分查找
                    end=arr.length-1;
                    start=mid+1;
                    mid=start + (end - start) / 2;
                }
                if(arr[end].equals(c)){
                    res = Math.min(res, end);
                    end=end-1;
                }else if(arr[end].toCharArray()[0]>c.toCharArray()[0]){
                      end=end-1;
                }else if(arr[end].toCharArray()[0]<c.toCharArray()[0]){
                       start=end+1;
                       end=arr.length-1;
                }
                continue;
            }
            if (arr[mid].equals(c)) {
                res = Math.min(res, mid);
                end = mid - 1;
            } else if (arr[mid].toCharArray()[0] > c.toCharArray()[0]) {
                end = mid - 1;
            } else if (arr[mid].toCharArray()[0] < c.toCharArray()[0]) {
                start = mid + 1;
            }
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}

