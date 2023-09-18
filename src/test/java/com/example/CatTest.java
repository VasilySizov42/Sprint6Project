package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static com.example.DataForTesting.CAT_SOUND;
import static com.example.DataForTesting.ONE_MORE_ZERO;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    Feline feline;

    @Test
    public void getSoundTest() {
        Cat cat = new Cat(feline);
        var actual = cat.getSound();
        assertEquals(CAT_SOUND, actual);
    }
    @Test
    public void getFoodTest() throws Exception {
        Cat cat = new Cat(feline);
        cat.getFood();
        Mockito.verify(feline, Mockito.times(ONE_MORE_ZERO)).eatMeat();
        Mockito.verifyNoMoreInteractions(feline);
    }
}