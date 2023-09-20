package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static com.example.DataForTesting.ONE_MORE_ZERO;

@RunWith(MockitoJUnitRunner.class)
public class MockedFelineTest {
    @Mock
    Feline feline;
    @Test
    public void eatMeatTest() throws Exception {
        Mockito.verify(feline, Mockito.times(ONE_MORE_ZERO)).eatMeat();
        Mockito.verifyNoMoreInteractions(feline);
    }
    @Test
    public void getFamilyTest() {
        Mockito.verify(feline, Mockito.times(ONE_MORE_ZERO)).getFamily();
        Mockito.verifyNoMoreInteractions(feline);
    }
    @Test
    public void getKittensTest() {
        Mockito.verify(feline, Mockito.times(ONE_MORE_ZERO)).getKittens();
        Mockito.verifyNoMoreInteractions(feline);
    }
    @Test
    public void getSomeKittensTest() {

        int kittensCount = ONE_MORE_ZERO;

        Integer expKittenCount = ONE_MORE_ZERO;

        feline.getKittens(kittensCount);

        Mockito.when(feline.getKittens(kittensCount)).thenReturn(kittensCount);
        Mockito.verify(feline, Mockito.times(ONE_MORE_ZERO)).getKittens(expKittenCount);
        Mockito.verifyNoMoreInteractions(feline);
    }
}
