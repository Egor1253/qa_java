package com.example;

import java.util.List;

public class Lion extends Feline implements Food{

    Food food;
    public Lion (Food food){
        this.food = food;
    }

    String sex;
    boolean hasMane;
    public Lion(String sex) throws Exception {
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    Feline feline = new Feline();

    public int getKittens() {
        return feline.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return getFood("Хищник");
    }
    public void lionMan(String sex,boolean hasMane){
        this.sex = sex;
        this.hasMane = hasMane;
    }
}