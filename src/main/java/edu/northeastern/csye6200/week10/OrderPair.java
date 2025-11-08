package edu.northeastern.csye6200.week10;

public class OrderPair<T, R> {
    public T key;
    public R value;


    public T getKey() {
        return this.key;
    }

    public void setKey(T _key) {
        this.key = _key;
    }

    public R getValue() {
        return this.value;
    }

    public void setValue(R _value) {
        this.value = _value;
    }

    public OrderPair(T _key, R _value) {
        this.key = _key;
        this.value = _value;
    }

    public static void main(String[] args) {
        OrderPair<Integer, String> o1 = new OrderPair(1, "");

    }
}
