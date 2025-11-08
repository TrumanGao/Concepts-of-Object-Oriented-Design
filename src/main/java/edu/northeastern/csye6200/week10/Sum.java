package edu.northeastern.csye6200.week10;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;

public class Sum {
    public static void main(String[] args) {
        ArrayList<Integer> _arrays = new ArrayList<>();
        _arrays.add(1);
//        new Sum().hasDuplicate(new ArrayList<Integer>());

        new Sum().hasDuplicate(_arrays);
    }

    public <T extends Comparable<T>> boolean hasDuplicate(ArrayList<T> arrays) {
        for (int i = 0; i < arrays.size(); i++) {
            for (int j = i + 1; j < arrays.size(); j++) {
                if (arrays.get(i).compareTo(arrays.get(j)) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

}
