package com.example.demo;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

// Extension (called Runner in JUnit 4) helps us to enable some functionalities
// In our case, we need to enable mocking at class level.
@ExtendWith(MockitoExtension.class)
class MyTest {

    // Mocking using @Mock annotation
    @Mock
    private List<String> list;

    // class specific variable which can be shared by tests
    public static List<String> strings = new ArrayList<>();

    // method executed before each test (@Test, @ParameterizedTest, @RepeatedTest or @TestFactory)
    @BeforeEach
    void setUp() {
        System.out.println("setting everything up...");
    }

    // method executed after each test (@Test, @ParameterizedTest, @RepeatedTest or @TestFactory)
    @AfterEach
    void tearDown() {
        System.out.println(strings);
        System.out.println("cleaning up...");
        //strings.clear();
    }

    // method executed once before all tests
    @BeforeAll
    static void beforeAll() {
        System.out.println("before all");
    }

    // method executed once after all tests
    @AfterAll
    static void afterAll() {
        System.out.println("after all");
    }

    // @Test enables the method as being and executable test
    @Test
    void testSomething() {
        System.out.println("salut");
        strings.add("test1");

        int x = 5;
        int y = 6;

        // assertions validate that a given condition is true or false.
        assertEquals(5, x);
    }

    // @ParameterizedTest allows you to provide parameters to a test
    @ParameterizedTest
    // here you provide the source for the parameter. It can also be a csv-like list @CsvSource, or even a file @CsvFileSource
    @ValueSource(strings = {"DE", "RO", "HU"})
    void testParameterized(String value) {
        switch (value) {
            case "RO" -> System.out.println("romania");
            case "DE" -> System.out.println("germany");
            case "HU" -> System.out.println("hungary");
        }
        strings.add("test2");
    }

    // Repeat a test for n times, works as a for loop
    @RepeatedTest(5)
    void testRepeated() {
        System.out.println("Salut");
        strings.add("test3");
    }

    // can create dynamic tests, must return a list of DynamicTest
    @TestFactory
    Collection<DynamicTest> dynamicTestsWithCollection() {
        return Arrays.asList(
                DynamicTest.dynamicTest("Add test",
                        () -> {
                            System.out.println("Add Test!");
                            assertEquals(2, Math.addExact(1, 1));
                        }),
                DynamicTest.dynamicTest("Multiply Test",
                        () -> {
                            System.out.println("Multiply Test!");
                            assertEquals(4, Math.multiplyExact(2, 2));
                        }));
    }



    @Test
    void gwtTest() {
        // given
        List mock = mock(List.class);

        // when
        when(mock.size()).thenReturn(100);

        // then
        assertEquals(100, mock.size());
    }

    @Test
    void gwtInjectMocksTest() {
        // given
        list.add("element");

        // when
        when(list.size()).thenReturn(100);

        // then
        assertEquals(100, list.size());
        verify(list).add(any());
    }
}
