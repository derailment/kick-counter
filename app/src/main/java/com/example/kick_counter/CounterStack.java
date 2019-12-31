package com.example.kick_counter;

import java.util.ArrayList;

public class CounterStack {
    private ArrayList<Pair<Player, Integer>> hits;
    public CounterStack() {
        this.hits = new ArrayList<Pair<Player, Integer>>();
    }
    public void push(Pair<Player, Integer> hit){
        this.hits.add(hit);
    }
    public Pair<Player, Integer> pop(){
        if (this.hits.size() == 0) {
            return null;
        } else {
            Pair<Player, Integer> lastHit = hits.get(hits.size() - 1);
            this.hits.remove(hits.size() - 1);
            return lastHit;
        }
    }
}
