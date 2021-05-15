package com.example.demo.algorithm;

import com.alibaba.fastjson.support.odps.udf.JSONTuple;

public class CopyRandom {
    public static void main(String[] args) {
        RandomNode r1=new RandomNode(1);
        RandomNode r2=new RandomNode(2);
        RandomNode r3=new RandomNode(3);
        RandomNode r4=new RandomNode(4);
        RandomNode r5=new RandomNode(5);
        RandomNode r6=new RandomNode(6);
        r1.next=r2;
        r2.next=r3;
        r3.next=r4;
        r4.next=r5;
        r5.next=r6;
        r1.random=r6;
        r2.random=r3;
        r3.random=r3;
        r4.random=r1;
        r5.random=r5;
        r6.random=r6;
        RandomNode copy = copy(r1);

        System.out.println();
    }

    private static  RandomNode copy(RandomNode head){
        RandomNode cur=head;
        while(cur!=null){
          RandomNode copy=new RandomNode(cur.value);
          RandomNode next=cur.next;
          cur.next=copy;
          copy.next=next;
          cur=next;
        }
        cur=head;
        while(cur!=null&&cur.next!=null){
           cur.next.random=cur.random.next;
           cur=cur.next.next;
        }
        cur=head;
        RandomNode copyHead=cur.next;
        RandomNode curCopy=copyHead;
        while(cur!=null&&cur.next!=null&&curCopy!=null&&curCopy.next!=null){
            cur.next=curCopy.next;
            curCopy.next=curCopy.next.next;
            cur=cur.next;
            curCopy=curCopy.next;
        }

        return copyHead;
    }


}
