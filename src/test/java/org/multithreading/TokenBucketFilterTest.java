package org.multithreading;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TokenBucketFilterTest {
    private TokenBucketFilter filter;

    @BeforeEach
    void setUp() {
        filter = TokenBucketFilterFactory.createFilter(5);
    }

    @AfterEach
    void tearDown() {
        filter.stop();
    }

    @Test
    void test() throws InterruptedException {
        Thread.sleep(5000);
        long start = System.currentTimeMillis();
        Thread thread1 = new Thread(() -> {
            int k = 5;
            while(k-- > 0){
                System.out.println(Thread.currentThread() + " : " + filter.getToken());
            }
        });
        Thread thread2 = new Thread(thread1);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        assertEquals(11, filter.getToken());
        long end = System.currentTimeMillis();
        assertTrue((end - start) / 1000 >= 5);
        assertTrue((end - start) / 1000 <= 6);
    }
}