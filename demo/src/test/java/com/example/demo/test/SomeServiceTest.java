package com.example.demo.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class SomeServiceTest {

    @Test
    void computeAverage_CorrectArray_ThenCorrectValue() {
        // given (set of pre-conditions, prerequisites or given variables)
        SomeService mock = mock(SomeService.class);
        int[] numbers = new int[]{1, 2, 3, 4, 5};
        float expected = 3f;

        // when (set behaviors that should take place in a given context)
        when(mock.getArrayLength(numbers)).thenReturn(5);
        when(mock.computeAverage(numbers)).thenCallRealMethod();

        // then (validations on the results, compare the expected result with the actual result)
        float actual = mock.computeAverage(numbers);
        Assertions.assertEquals(expected, actual);

        verify(mock).getArrayLength(numbers);
        verify(mock).computeAverage(numbers);
    }
}