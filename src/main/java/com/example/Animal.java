package com.example;

import java.util.List;

import static com.example.DataForTesting.*;
//import static com.example.DataForTesting.FAMILY;

public class Animal {
    public List<String> getFood(String animalKind) throws Exception {
        if (HERBIVORE.equals(animalKind)) {
            return HERBIVORE_FOOD;
        } else if (PREDATOR.equals(animalKind)) {
            return PREDATOR_FOOD;
        } else {
            throw new Exception(EXPAT_UNKNOWN_TYPE);
        }
    }
    public String getFamily() {
        return FAMILY;
    }
}