package com.example;

import org.junit.Assert;
import org.junit.Test;

import static com.example.DataForTesting.*;
import static org.junit.Assert.assertEquals;

public class AnimalTest {
    @Test
    public void getFoodForPredatorTest() throws Exception {
        Animal animal = new Animal();
        var actual = animal.getFood(PREDATOR);
        assertEquals(PREDATOR_FOOD, actual);
    }
    @Test
    public void getFoodForHerbivoreTest() throws Exception {
        Animal animal = new Animal();
        var actual = animal.getFood(HERBIVORE);
        assertEquals(HERBIVORE_FOOD, actual);
    }
    @Test
    public void getFoodForOthersTest() {
        Animal animal = new Animal();
        try {
            animal.getFood(OMNIVORE);
            Assert.fail(EXCEPTION_MESSAGE);
        } catch (Exception e) {
            Assert.assertEquals(EXPAT_UNKNOWN_TYPE, e.getMessage());
        }
    }
    @Test
    public void getFamilyTest() {
        Animal animal = new Animal();
        var actual = animal.getFamily();
        assertEquals(FAMILY, actual);
    }
}