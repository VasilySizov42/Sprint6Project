package com.example;

import org.junit.Test;

import static com.example.DataForTesting.*;
import static org.junit.Assert.assertEquals;

public class FelineTest {
    @Test
    public void eatMeatTest() throws Exception {
        Feline feline = new Feline();
        var actual = feline.eatMeat();
        assertEquals(PREDATOR_FOOD, actual);
    }
    @Test
    public void getFamilyTest() {
        Feline feline = new Feline();
        var actual = feline.getFamily();
        assertEquals(FELINE_FAMILY, actual);
    }
    @Test
    public void getKittensTest() {
        Feline feline = new Feline();
        var actual = feline.getKittens();
        assertEquals((int)ONE_MORE_ZERO, actual);
    }
    @Test
    public void getSomeKittensTest() {
        Feline feline = new Feline();
        var expected = VAR_FOR_MATH*(Math.random());
        var actual = feline.getKittens((int) expected);
        assertEquals((int) expected, actual);
    }
}