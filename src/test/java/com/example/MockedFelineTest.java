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
    public void getKittens() {
        Mockito.verify(feline, Mockito.times(ONE_MORE_ZERO)).getKittens();
        Mockito.verifyNoMoreInteractions(feline);
    }
    /*@Test
    public void getKittensTest(int kittensCount) {
        Mockito.when(feline.getKittens()).thenReturn(expKittenCount);
        Mockito.verify(feline, Mockito.times(iteration)).getKittens(kittensCount);
        Mockito.verifyNoMoreInteractions(feline);
    }*/
}
