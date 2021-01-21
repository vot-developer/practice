package org.algorithms.dp.educative.fibonacci_numbers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FibonacciTest {
    private Fibonacci fibonacci;

    @BeforeEach
    void setUp() {
        fibonacci = new Fibonacci();
    }

    //NAIVE
    @Test
    void testNaive1() {
        assertEquals(1, fibonacci.calculateNaive(2));
    }

    @Test
    void testNaive2() {
        assertEquals(2, fibonacci.calculateNaive(3));
    }

    @Test
    void testNaive3() {
        assertEquals(3, fibonacci.calculateNaive(4));
    }

    //Top-Bottom with memorize
    @Test
    void testTopButtom1() {
        assertEquals(1, fibonacci.calculateTopBottomWithMemorize(2));
    }

    @Test
    void testTopButtom2() {
        assertEquals(2, fibonacci.calculateTopBottomWithMemorize(3));
    }

    @Test
    void testTopButtom3() {
        assertEquals(3, fibonacci.calculateTopBottomWithMemorize(4));
    }

    //Bottom-Up
    @Test
    void testButtomTop1() {
        assertEquals(1, fibonacci.calculateDownToUp(2));
    }

    @Test
    void testButtomTop2() {
        assertEquals(2, fibonacci.calculateDownToUp(3));
    }

    @Test
    void testButtomTop3() {
        assertEquals(3, fibonacci.calculateDownToUp(4));
    }

    //Bottom-Up space improvment
    @Test
    void testButtomTopSpaceImprovment() {
        assertEquals(1, fibonacci.calculateDownToUpSpaceImproved(2));
        assertEquals(2, fibonacci.calculateDownToUpSpaceImproved(3));
        assertEquals(3, fibonacci.calculateDownToUpSpaceImproved(4));
    }
}