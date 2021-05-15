package com.example.demo.algorithm;

import java.util.*;
import java.util.stream.Collectors;

public class StringPath {
    public static void main(String[] args) {
        List<String>list=Arrays.asList("cab","acc","cbc","ccc","cac","cbb","aab","abb");
        solve(list,"abc","cab");
        System.out.println();
    }
    private static List<List<String>> solve(List<String>list,String start,String to){
        Map<String,List<String>>simily=new HashMap<String,List<String>>();
        Map<String,Integer>distance=new HashMap<>();
        Queue<String>queue=new LinkedList<>();
        Set<String> source=new HashSet(list);

        source.add(start);
        source.forEach(sourceStr->{
            List<String> simaly = getSimaly(sourceStr).stream()
                    .filter(e->source.contains(e)).collect(Collectors.toList());
            simily.put(sourceStr,simaly);
        });
        int dis=1;
        distance.put(start,0);
        queue.add(start);
        Set<String> hasReach=new HashSet();
        hasReach.add(start);
        while(!queue.isEmpty()){
            String poll = queue.poll();
            List<String> strings = simily.get(poll);
            for (int i = 0; i <strings.size() ; i++) {
                String s = strings.get(i);
                if(!hasReach.contains(s)){
                    distance.put(s,distance.get(poll)+1);
                    hasReach.add(s);
                }else{
                    continue;
                }
                queue.add(s);
            }
        }
        List<List<String>>res=new ArrayList<List<String>>();
        List<String> curList=new ArrayList<>();
        move(distance,simily,res,start,curList,to,0);
        return res;
    }
    private static void move(Map<String,Integer>distance,Map<String,List<String>>simily,List<List<String>>res,String cur,List<String> curList,String target,int length){
        if(distance.get(cur)!=length){
            curList.add(cur);
            return;
        }
        if(cur.equals(target)){
                curList.add(cur);
                List<String>temp=new ArrayList<>(curList);
                res.add(temp);
                return;
        }
        curList.add(cur);
        List<String> strings = simily.get(cur);
        for (int i = 0; i <strings.size() ; i++) {
            move(distance,simily,res,strings.get(i),curList,target,length+1);
            curList.remove(strings.get(i));
        }
        curList.remove(cur);
    }

    private static Set<String> getSimaly(String str){
        Set<String> arr=new HashSet<>(str.length()*26);
        char[] chars = str.toCharArray();
        for (int i = 0; i <chars.length ; i++) {
            char pre=chars[i];
            for (char c = 'a'; c <='z' ; c++) {
                if(pre!=c) {
                    chars[i] = c;
                    arr.add(new String(chars));
                }
            }
            chars[i]=pre;
        }

        return arr;
    }
}
