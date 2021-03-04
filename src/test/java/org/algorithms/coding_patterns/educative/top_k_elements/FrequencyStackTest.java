package org.algorithms.coding_patterns.educative.top_k_elements;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrequencyStackTest {

    @Test
    void push() {
        FrequencyStack frequencyStack = new FrequencyStack();
        frequencyStack.push(1);
        frequencyStack.push(2);
        frequencyStack.push(3);
        frequencyStack.push(2);
        frequencyStack.push(1);
        frequencyStack.push(2);
        frequencyStack.push(5);
        assertEquals(2, frequencyStack.pop());
        assertEquals(1, frequencyStack.pop());
        assertEquals(2, frequencyStack.pop());
    }
}