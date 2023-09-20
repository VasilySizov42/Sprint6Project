package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static com.example.DataForTesting.*;
import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)

public class LionTest {
    private final String sex;
    private boolean exMane;
    private final String type;
    private final List food;
    private final int kittenCount;
    private final int expKittenCount;
    private final int iteration;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    Feline feline;

    //Это this
    public LionTest(String sex, boolean exMane, String type,  List food,
                    int kittenCount, int expKittenCount, int iteration) {
        this.sex = sex;
        this.exMane = exMane;
        this.type = type;
        this.food = food;
        this.kittenCount = kittenCount;
        this.expKittenCount = expKittenCount;
        this.iteration = iteration;
    }

    //Это this.Lion
    @Parameterized.Parameters
    public static Object[][] params() {
        return LION_TOLERABLE_SEX;
    }

    //Это тесты
    @Test
    public void getKittensTest() throws Exception {
        /*try {*/
            Lion lion = new Lion(feline, sex);
        for (int i = ZERO; i < iteration; i++) {
            System.out.println(i);
            lion.getKittens();
        }
            Mockito.when(feline.getKittens()).thenReturn(expKittenCount);
            Mockito.verify(feline, Mockito.times(iteration)).getKittens();
            Mockito.verifyNoMoreInteractions(feline);
            Assert.assertEquals("", expKittenCount, lion.getKittens());
        /*} catch (Exception e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(
                    EXPAT_UNKNOWN_MANE,
                    e.getMessage());
        }*/
    }

    @Test
    public void doesHaveManeTest() {
        try {
            Lion lion = new Lion(feline, sex);
            //assertThrows(Exception.class, () -> new Lion(feline, PERVERT));
            lion.doesHaveMane();
        } catch (Exception e) {
            Assert.assertEquals(
                    EXPAT_UNKNOWN_MANE,
                    e.getMessage());
        }
    }

    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion(feline, sex);
        //assertThrows(Exception.class, () -> new Lion(feline, PERVERT));
        for (int i = ZERO; i < iteration; i++) {
            lion.getFood();
        }
        Mockito.when(feline.getFood(type)).thenReturn(food);
        Mockito.verify(feline, Mockito.times(iteration)).getFood(type);
        Mockito.verifyNoMoreInteractions(feline);
        Assert.assertEquals(INEDIBLE_FOOD, food, lion.getFood());
    }
}