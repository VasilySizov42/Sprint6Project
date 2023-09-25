package com.example;

import java.util.List;

import static com.example.DataForTesting.*;

public class Lion {
    Feline feline;
    boolean hasMane;

    public Lion(Feline feline, String sex) throws Exception {
        this.feline = feline;
        if (MAN.equals(sex)) {
            hasMane = true;
        } else if (WOMAN.equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception(EXPAT_UNKNOWN_MANE);
        }
    }
    public int getKittens() {
        return feline.getKittens();
    }
    public boolean doesHaveMane() {
        return hasMane;
    }
    public List<String> getFood() throws Exception {
        return feline.getFood(PREDATOR);
    }
}
