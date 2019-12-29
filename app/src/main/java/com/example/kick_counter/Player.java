package com.example.kick_counter;

public class Player {

    private int score;

    public Player() {

    }

    public void setScore (int s ){
        this.score = s;
    }

    public int getScore (){  //為什麼這裡的括號不用方東西
        return this.score;
    }
    public void addScore (int ad) {
        this.score+= ad ;
    }
}
