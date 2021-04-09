package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ServerTest {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(ServerTest.class.getResourceAsStream("case.txt")));
        String kStr = br.readLine();
        String kTimes = br.readLine();
        String kLoads = br.readLine();
        br.close();
        int k = Integer.parseInt(kStr);
        int[] times = toInts(kTimes);
        int[] loads = toInts(kLoads);
        long start = System.currentTimeMillis();
        busiestServers(k, times, loads);
        long end = System.currentTimeMillis();
        System.out.println(kStr + " used " + (end - start));


        int k1 = 3;
        int[] times1 = {1,2,3,4,8,9,10};
        int[] loads1 ={5,2,10,3,1,2,2};

        start = System.currentTimeMillis();
        System.out.println(busiestServers2(k1, times1, loads1));
        System.out.println(busiestServers(k1, times1, loads1));
        end = System.currentTimeMillis();
        System.out.println(k1 + " used " + (end - start));


        int k2 = 10;
        int[] time2 = {6,8,10,11,12,15,18,19,20,23,24,25,27,28,30,31,32,34,36,38};
        int[] loads2 = {15,15,5,12,8,13,2,8,10,6,4,18,9,20,4,5,14,11,4,2};

        start = System.currentTimeMillis();
        System.out.println(busiestServers2(k2, time2, loads2));
        System.out.println(busiestServers(k2, time2, loads2));
        end = System.currentTimeMillis();
        System.out.println(k1 + " used " + (end - start));



    }

    private static int[] toInts(String arrays){
        arrays= arrays.substring(1);
        arrays = arrays.substring(0, arrays.length()-1);
        String[] strs = arrays.split(",");
        int[] nums = new int[strs.length];
        for(int i=0; i<strs.length; i++){
            String str = strs[i];
            nums[i] = Integer.parseInt(str);
        }
        return nums;
    }


    public static List<Integer> busiestServers(int k, int[] arrival, int[] loads) {
        TreeSet<Integer> freeServersSet = new TreeSet<>();
        TreeMap<Integer, Set<Integer>> handleServerMap = new TreeMap<>();
        int[] handleRequests = new int[k];
        for(int i=0; i<k; i++){
            freeServersSet.add(i);
        }
        for(int i=0; i<arrival.length; i++){
            int id = i%k;
            int start = arrival[i];
            NavigableMap<Integer,Set<Integer>> navigableMap = handleServerMap.headMap(start, true);
            Iterator<Map.Entry<Integer, Set<Integer>>> it = navigableMap.entrySet().iterator();
            while (it.hasNext()){
                Map.Entry<Integer, Set<Integer>> entry = it.next();
                freeServersSet.addAll(entry.getValue());
                it.remove();
            }

            if(freeServersSet.isEmpty()){
                continue;
            }

            Integer server = freeServersSet.ceiling(id);
            if(server == null){
                server = freeServersSet.first();
            }

            if(server == null){
                continue;
            }

            freeServersSet.remove(server);
            handleRequests[server]++;
            int endTime = arrival[i] + loads[i];
            Set<Integer> endTimeServers = navigableMap.get(endTime);
            if(endTimeServers == null){
                endTimeServers = new HashSet<>();
                handleServerMap.put(endTime, endTimeServers);
            }
            endTimeServers.add(server);
        }

        System.out.println(Arrays.toString(handleRequests));

        int maxIndex = 0;
        for(int i=0; i<handleRequests.length; i++){
            if(handleRequests[i] > handleRequests[maxIndex]){
                maxIndex = i;
            }
        }

        List<Integer> results = new ArrayList<>();
        for(int i=0; i<handleRequests.length; i++){
            if(handleRequests[i] == handleRequests[maxIndex]){
                results.add(i);
            }
        }
        return results;
    }


    public static List<Integer> busiestServers2(int k, int[] arrival, int[] load) {
        int count[] = new int[k];
        //key为结束时间，value为结束时间为key时的服务器id集合
        TreeMap<Integer, List<Integer>> endTimeMap = new TreeMap<>();
        //空闲的服务器ID
        TreeSet<Integer> free = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            free.add(i);
        }

        for (int i = 0; i < arrival.length; i++) {

            int id = i % k;
            int start = arrival[i];
            //map中取出小于等于当前时间线的集合，相当增量取出空闲出的服务器ID
            NavigableMap<Integer, List<Integer>> map = endTimeMap.headMap(start, true);
            Iterator<Map.Entry<Integer, List<Integer>>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, List<Integer>> entry = iterator.next();
                //增量更新空闲的服务器
                free.addAll(entry.getValue());
                iterator.remove();
            }
            //空闲服务器为空集，抛弃当前请求。
            if (free.isEmpty()) continue;
            //取出大于等于当前服务器的ID
            Integer hit = free.ceiling(id);
            if (hit == null) {
                //可能是一个环
                hit = free.first();
            }
            count[hit]++;
            //服务器由闲变忙
            free.remove(hit);
            endTimeMap.computeIfAbsent(load[i] + arrival[i], (key) -> new ArrayList<>(5)).add(hit);
        }

        System.out.println(Arrays.toString(count));

        int max = Arrays.stream(count).max().orElse(0);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] == max) res.add(i);
        }
        return res;
    }
}

