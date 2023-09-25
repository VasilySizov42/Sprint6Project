package com.example;

import java.util.List;

import static com.example.DataForTesting.CAT_SOUND;

public class Cat {
    Predator predator;

    public Cat(Feline feline) {
        this.predator = feline;
    }
    public String getSound() {
        return CAT_SOUND;
    }
    public List<String> getFood() throws Exception {
        return predator.eatMeat();
    }
}
