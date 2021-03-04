package org.algorithms.coding_patterns.educative.top_k_elements;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
Design a class that simulates a Stack data structure, implementing the following two operations:

push(int num): Pushes the number 'num' on the stack.
pop(): Returns the most frequent number in the stack. If there is a tie, return the number which was pushed later.
 */
public class FrequencyStack {
    private final PriorityQueue<Key> pq;
    private final Map<Integer, Integer> freq;
    private int id = 0;

    public FrequencyStack() {
        freq = new HashMap<>();
        Comparator<Key> comparator = (a, b) -> {
            if (a.freq == b.freq)
                return b.id - a.id;
            else
                return b.freq - a.freq;
        };
        pq = new PriorityQueue<>(comparator);
    }

    public void push(int num) {
        freq.put(num, freq.getOrDefault(num, 0) + 1);
        pq.offer(new Key(num, id++, freq.get(num)));
    }

    public int pop() {
        Key key = pq.poll();
        if (freq.get(key.num) == 1)
            freq.remove(key.num);
        else
            freq.put(key.num, freq.get(key.num) - 1);
        return key.num;
    }
}

class Key {
    int num;
    int id;
    int freq;
    public Key(int num, int id, int freq) {
        this.num = num;
        this.id = id;
        this.freq = freq;
    }
}
