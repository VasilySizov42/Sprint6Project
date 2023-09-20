package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static com.example.DataForTesting.FELINE_TOLERABLE_SEX;
import static com.example.DataForTesting.ZERO;

@RunWith(Parameterized.class)
public class ParameterizedFelineTest {
    private final int kittensCount;
    private final int expKittenCount;
    private final int iteration;

    public ParameterizedFelineTest(int kittensCount, int expKittenCount, int iteration) {
        this.kittensCount = kittensCount;
        this.expKittenCount = expKittenCount;
        this.iteration = iteration;
    }
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Mock
    Feline feline;
    @Parameterized.Parameters
    public static Object[][] params() {
        return FELINE_TOLERABLE_SEX;
    }
    @Test
    public void getKittensTest() {
        for (int i = ZERO; i < iteration; i++) {
            feline.getKittens(kittensCount);
        }
        Mockito.when(feline.getKittens(kittensCount)).thenReturn(expKittenCount);
        Mockito.verify(feline, Mockito.times(iteration)).getKittens(kittensCount);
        Mockito.verifyNoMoreInteractions(feline);
    }
}
