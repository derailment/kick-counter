package com.example.kick_counter;

public class Player {
    private int score;
    public Player() {

    }
    public void setScore (int s ){
        this.score = s;
    }
    public int getScore (){
        return this.score;
    }
    public void addScore (int ad) {
        this.score+= ad ;
    }

    public void delScore (int s) {
        this.score-= s ;
    }
}
