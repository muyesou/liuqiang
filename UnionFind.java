package com.example.demo.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnionFind<V> {
    Map<V,Element<V>> value=new HashMap<V,Element<V>>();
    Map<Element<V>,Integer> rank=new HashMap<Element<V>,Integer>();
    Map<Element<V>,Element<V>> father=new HashMap<>();
    public UnionFind(List<V> list){//初始化
        for (int i = 0; i <list.size() ; i++) {
            V v = list.get(i);
            Element<V> e=new Element<>(v);
            value.put(v,e);
            rank.put(e,1);
            father.put(e,e);
        }
    }

    public static void main(String[] args) {
//        List<Integer> list= Arrays.asList(1,23,4,5,6,7,8,9,0,11);
//
//        UnionFind u=new UnionFind(list);
//        u.union(1,23);
//        u.union(4,1);
//        u.union(8,1);
//        boolean sameSet = u.isSameSet(8, 23);
//        System.out.println();
    }

    public  V findFather(V v) {
        Element<V> element = value.get(v);
        Element<V> fatherElement = father.get(element);
        if(fatherElement==element){
            return fatherElement.value;
        }
        V fv = findFather(fatherElement.value);
        father.remove(element);
        father.put(element,value.get(fv));
        return fv;
    }
    public boolean isSameSet(V v1,V v2){
        Element<V>e1 =value.get(v1);

        Element<V>e2=value.get(v2);
        return isSameSet(e1,e2);
    }
    public    boolean  isSameSet(Element<V>e1,Element<V>e2){


        V father1 =  findFather(e1.value);
        V father2 = findFather(e2.value);
        return father1==father2;
    }

    public  void union(V v1,V v2){

        Element<V> fElement1 = value.get(findFather(v1));
        Element<V> fElement2 = value.get(findFather(v2));
        int ranNumk1=rank.get(fElement1);
        int rankNum2=rank.get(fElement2);
        if(ranNumk1>=rankNum2){//把2移动到以1为头节点
            father.remove(fElement2);
            father.put(fElement2,fElement1);
            rank.remove(fElement2);
            rank.remove(fElement1);
            rank.put(fElement1,ranNumk1+rankNum2);
        }else{
            father.remove(fElement1);
            father.put(fElement1,fElement2);
            rank.remove(fElement1);
            rank.remove(fElement2);
            rank.put(fElement2,ranNumk1+rankNum2);
        }

    }
}
