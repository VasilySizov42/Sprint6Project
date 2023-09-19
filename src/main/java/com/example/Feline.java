package com.example;

import java.util.List;

import static com.example.DataForTesting.*;

public class Feline extends Animal implements Predator {
    @Override
    public List<String> eatMeat() throws Exception {
        return getFood(PREDATOR);
    }
    @Override
    public String getFamily() {
        return FELINE_FAMILY;
    }
    public int getKittens() {
        return getKittens(ONE_MORE_ZERO);
    }
    public int getKittens(int kittensCount) {
        return kittensCount;
    }
}
