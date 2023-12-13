package com.example;

import java.util.List;

public class Lion extends Feline{
    Feline feline;
    boolean hasMane;
    // при отсутствии конструктора без параметров: public Lion() {}, падают тесты в классе:LionTest.
    public Lion () {}
    public Lion(String sex, Feline feline) throws Exception {
        this.feline = feline;
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самей или самка");
        }
    }

    public int getKittens() {
        return feline.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return feline.getFood("Хищник");
    }

}