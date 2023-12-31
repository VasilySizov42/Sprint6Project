package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static com.example.DataForTesting.*;

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
    @Parameterized.Parameters(name = "Количество котят. Тестовые данные: {0} {1} {2}")
    public static Object[][] params() {
        return FELINE_TEST;
    }
    @Test
    public void getKittensTest() {
        feline.getKittens(kittensCount);
        Mockito.verify(feline, Mockito.times(ONE_MORE_ZERO)).getKittens(Mockito.anyInt());
        Mockito.verifyNoMoreInteractions(feline);
    }
    @Test
    public void getKittensSomeIterationTest() {
        for (int i = ZERO; i < iteration; i++) {
            feline.getKittens(kittensCount);
        }
        Mockito.when(feline.getKittens(kittensCount)).thenReturn(kittensCount);
        Mockito.verify(feline, Mockito.times(iteration)).getKittens(Mockito.anyInt());
        Mockito.verifyNoMoreInteractions(feline);
    }
    @Test
    public void getKittensReturnTest() {
            feline.getKittens(kittensCount);
        Mockito.when(feline.getKittens(kittensCount)).thenReturn(kittensCount);
        Mockito.verify(feline, Mockito.times(ONE_MORE_ZERO)).getKittens(expKittenCount);
        Mockito.verifyNoMoreInteractions(feline);
    }
}
