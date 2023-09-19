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
//@RunWith(MockitoJUnitRunner.class)
public class NegativeLionTest {
    private final String sex;
    private boolean exMane;
    private final String type;
    private final List food;
    private int kittenCount;
    private final int exKittenCount;
    private final int iteration;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    Feline feline;

    //Это this
    public NegativeLionTest(String sex, boolean exMane, String type, List food,
                            int kittenCount, int exKittenCount, int iteration) {
        this.sex = sex;
        this.exMane = exMane;
        this.type = type;
        this.food = food;
        this.kittenCount = kittenCount;
        this.exKittenCount = exKittenCount;
        this.iteration = iteration;
    }
    //Это this.Lion
    @Parameterized.Parameters
    public static Object[][] params() {
        return LION_NEGATIVE_SEX;
    }
    //Это тесты
    @Test
    public void getKittensTest() /*throws Exception*/ {
        try {
            Lion lion = new Lion(feline, sex);
            assertThrows(Exception.class, () -> new Lion(feline, PERVERT));
            for (int i = ZERO; i < iteration; i++) {
                lion.getKittens();
            }
            Mockito.when(feline.getKittens()).thenReturn(exKittenCount);
            Mockito.verify(feline, Mockito.times(iteration)).getKittens();
            Mockito.verifyNoMoreInteractions(feline);
            Assert.assertEquals("", exKittenCount, lion.getKittens());
        } catch (Exception e) {
            Assert.assertEquals(EXPAT_UNKNOWN_MANE,
                    EXPAT_UNKNOWN_MANE,
                    e.getMessage());
        }
    }
    /*
    @Test
     public void doesHaveManeTest(){
         try {
             Lion lion = new Lion(feline, sex);
             assertThrows(Exception.class, () -> new Lion(feline, PERVERT));
             lion.doesHaveMane();
         }
         catch (Exception e) {
             Assert.assertEquals(
                     EXPAT_UNKNOWN_MANE,
                     e.getMessage());
         }
     }
     */
    @Test(expected = Exception.class)
    public void getFoodTest() throws Exception {
        Lion lion = new Lion(feline, sex);
        assertThrows(Exception.class, () -> new Lion(feline, sex));
        for (int i = ZERO; i < iteration; i++) {
            lion.getFood();
            Mockito.when(feline.getFood(type)).thenReturn(food);
            Mockito.verify(feline, Mockito.times(iteration)).getFood(type);
            Mockito.verifyNoMoreInteractions(feline);
            Assert.assertEquals(INEDIBLE_FOOD, food, lion.getFood());
        }

    }
}