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

@RunWith(Parameterized.class)
public class LionTest {
    private final String sex;
    private boolean exMane;
    private final String type;
    private final List food;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Mock
    Feline feline;
    //Это this
    public LionTest(String sex, boolean exMane, String type, List food) {
        this.sex = sex;
        this.exMane = exMane;
        this.type = type;
        this.food = food;
    }
    //Это this.Lion
    @Parameterized.Parameters(name = "Проверка getKittens(), doesHaveMane(), getFood(). Тестовые данные: {0} {1} {2} {3}")
    public static Object[][] params() {
        return LION_TOLERABLE_SEX;
    }
    //Это тесты
    @Test
    public void getKittensTest() throws Exception {
            Lion lion = new Lion(feline, sex);
            lion.getKittens();
            Mockito.when(feline.getKittens()).thenReturn(ONE_MORE_ZERO);
            Mockito.verify(feline, Mockito.times(ONE_MORE_ZERO)).getKittens();
            Mockito.verifyNoMoreInteractions(feline);
            Assert.assertEquals(UNEXPECTED_RESULT, (int) ONE_MORE_ZERO, lion.getKittens());
    }
    @Test
    public void doesHaveManeTest() {
        try {
            Lion lion = new Lion(feline, sex);
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
            lion.getFood();
        Mockito.when(feline.getFood(type)).thenReturn(food);
        Mockito.verify(feline, Mockito.times(ONE_MORE_ZERO)).getFood(type);
        Mockito.verifyNoMoreInteractions(feline);
        Assert.assertEquals(INEDIBLE_FOOD, food, lion.getFood());
    }
}