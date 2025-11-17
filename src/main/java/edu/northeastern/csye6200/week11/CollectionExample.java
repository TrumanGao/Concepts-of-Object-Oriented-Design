package edu.northeastern.csye6200.week11;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

// Arrays 是普通数组的工具类，和 collection 没有直接关系
// Arrays.asList() 是 普通数组和 collection 的桥接，它把普通数组转化成了 List：
// 类型上是 List（符合 Collection 接口）
// 但本质上还是数组（底层仍然是那个 array）
public class CollectionExample {
    public static void main(String[] args) {
        Integer[] in = {1, 2, 3, 4, 5};
        List<Integer> inn = Arrays.asList(in);

        Character[] ch = {'h', 'e', 'l', 'l', 'o'};
        List<Character> chh = Arrays.asList(ch);

        Double[] db = {2.5, 1.112};
        List<Double> dbb = Arrays.asList(db);

        Float[] fl = {2.1f, 2.3f, 3.2f};
        List<Float> fll = Arrays.asList(fl);

        List<Integer> innl = new ArrayList<Integer>(Arrays.asList(in));
        System.out.println(innl.getClass());

        System.out.println(Arrays.toString(ch).getClass());
    }
}
