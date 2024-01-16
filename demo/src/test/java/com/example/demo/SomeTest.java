package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class SomeTest {

    @Mock
    private List<String> list;

    @Test
    void testAddElementToList() {
        // Alternative to @Mock can be mock(Class) method which
        // doesn't require the MockitoExtension
        // List mock = Mockito.mock(List.class);
        list.add("element");

        // we verify that a given method has been called once.
        Mockito.verify(list).add("element");
        assertEquals(0, list.size());

        // we provide custom behaviors on method calls
        // even though the list size if not 10, because it is a mock
        // we can impose that the return value when the list.size() method is called will be 10.
        Mockito.when(list.size()).thenReturn(10);
        assertEquals(10, list.size());
    }
}
