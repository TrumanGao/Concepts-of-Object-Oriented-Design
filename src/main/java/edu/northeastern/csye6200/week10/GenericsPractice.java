package edu.northeastern.csye6200.week10;

public class GenericsPractice {
    public static int max(int[] array) {
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static <T extends Comparable<T>> T maximum(T[] array) {
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(max) > 0) {
                max = array[i];
            }
        }
        return max;
    }

    public <T> Integer convertToIntger(T data) {
        return (Integer) data;
    }

    public static void main(String[] args) {
        int[] array = {11, 1, 200, 3, 4, 10, 111};
        System.out.println(max(array));
        System.out.println(maximum(array));
    }
}
