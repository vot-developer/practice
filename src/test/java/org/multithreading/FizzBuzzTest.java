package org.multithreading;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FizzBuzzTest {
    private StringBuilder sb;
    private FizzBuzz object;
    private Runnable fizz, buzz, fizzbuzz, number;

    @Test
    void test() throws InterruptedException {
        Thread a = new Thread(fizz);
        Thread b = new Thread(buzz);
        Thread c = new Thread(fizzbuzz);
        Thread d = new Thread(number);

        a.start();
        b.start();
        c.start();
        d.start();
        a.join();
        b.join();
        c.join();
        d.join();

        assertEquals("1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz ", object.getResult());
    }

    @BeforeEach
    void setUp(){
        sb = new StringBuilder();
        object = new FizzBuzz(15, sb);

        fizz = () -> {
            try {
                object.fizz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        buzz = () -> {
            try {
                object.buzz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        fizzbuzz = () -> {
            try {
                object.fizzbuzz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        number = () -> {
            try {
                object.number();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    }
}