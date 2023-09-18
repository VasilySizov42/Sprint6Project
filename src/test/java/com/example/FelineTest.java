package com.example;

import org.junit.Test;

import static com.example.DataForTesting.ONE_MORE_ZERO;
import static com.example.DataForTesting.PREDATOR_FOOD;
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
        assertEquals("Кошачьи", actual);
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
        var expected = 10*(Math.random());
        var actual = feline.getKittens((int) Math.round(expected));
        assertEquals((int) Math.round(expected), actual);
    }
}