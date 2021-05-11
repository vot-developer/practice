package org.multithreading;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TokenBucketFilterTest {
    private TokenBucketFilter filter;

    @BeforeEach
    void setUp() {
        filter = TokenBucketFilterFactory.createFilter(3);
    }

    @AfterEach
    void tearDown() {
        filter.stop();
    }

    @Test
    void test() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread1 = new Thread(() -> {
            int k = 10;
            while(k-- > 0){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(thread1);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        assertEquals(21, filter.getToken());
        assertTrue(System.currentTimeMillis() - start / 1000 > 20);
    }
}