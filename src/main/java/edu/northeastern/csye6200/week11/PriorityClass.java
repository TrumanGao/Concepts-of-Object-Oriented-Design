package edu.northeastern.csye6200.week11;

import java.util.PriorityQueue;

public class PriorityClass {
    public static void main(String[] args) {
        PriorityQueue<Integer> in = new PriorityQueue<>();
        in.add(10);
        in.add(25);
        in.add(-110);
        in.add(55);

        System.out.println(in);
    }
}
