package com.example.kick_counter;

public class Pair<T1, T2> {
    private T1 key;
    private T2 value;
    public Pair(T1 k, T2 v) {
        this.key = k;
        this.value = v;
    }
    public T1 getKey() {
        return this.key;
    }
    public T2 getValue() {
        return this.value;
    }
}
