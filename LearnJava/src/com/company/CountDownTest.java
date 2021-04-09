package com.company;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class CountDownTest {

    public static void main(String[] args){

        Queue<Integer> queue = new LinkedList<Integer>();

        for(int i=10; i >=0; i--){
            queue.add(i);
        }
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }


        Queue<Integer> queues = new PriorityQueue<>();
        queues.add(5);
        queues.add(1);
        queues.add(10);

        while (!queues.isEmpty()){
            System.out.println(queues.poll());
        }
    }
}
