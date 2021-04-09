package com.company;

import java.util.Deque;
import java.util.LinkedList;

public class DequeTest {
    public static void  main(String[] args){
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(100);
        deque.addLast(50);
        deque.addFirst(30);

        while (!deque.isEmpty()){
            System.out.println(deque.pollFirst());
        }
    }
}
