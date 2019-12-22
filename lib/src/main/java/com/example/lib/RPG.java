package com.example.lib;

public class RPG {

    public static void main(String[] args) {

        Role swordsMan = new SwordsMan();
        swordsMan.setName("Justin");
        swordsMan.setLevel(5);
        swordsMan.setBlood(60);

        Role magician = new Magician();
        magician.setName("Monica");
        magician.setLevel(2);
        magician.setBlood(100);

        Role magician2 = new Magician();
        magician.setName("Abby");
        magician.setLevel(2);
        magician.setBlood(100);

        showRole(swordsMan);
        showRole(magician);
        System.out.println("\nTotal "+Role.count+" roles");


    }

    public static void showRole(Role role) {

        System.out.printf("%s blood:%d level:%d\n", role.getName(), role.getBlood(), role.getLevel());

        if (role instanceof Magician) {
            ((Magician)role).fight();
            ((Magician)role).cure();
        }
        if (role instanceof SwordsMan) {
            ((SwordsMan)role).fight();
        }

    }

}

class SwordsMan extends Role {

    public SwordsMan(){
        this.count++;
    }

    public void fight(){
        System.out.println("sword hit");
    }

}

class Magician extends Role {

    public Magician(){
        this.count++;
    }

    public void fight(){
        System.out.println("magic");
    }

    public void cure(){
        System.out.println("cure");
    }

}

class Role {
    public static int count;
    private int blood;
    private int level;
    private String name;
    public void setBlood(int b){
        this.blood = b;
    }
    public int getBlood(){
        return  this.blood;
    }
    public void setLevel(int l){
        this.level= l;
    }
    public int getLevel(){
        return  this.level;
    }
    public void setName (String n){
        this.name =n;
    }
    public String getName (){
        return this.name;

    }
}