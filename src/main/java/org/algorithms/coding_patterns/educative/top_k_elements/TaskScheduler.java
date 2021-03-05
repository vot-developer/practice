package org.algorithms.coding_patterns.educative.top_k_elements;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
You are given a list of tasks that need to be run, in any order, on a server.
Each task will take one CPU interval to execute but once a task has finished, it has a cooling period during which
it can't be run again. If the cooling period for all tasks is 'K' intervals, find the minimum number of CPU intervals
that the server needs to finish all tasks.
 */
public class TaskScheduler {
    //time - O(n * log n), space - O(n)
    public static int scheduleTasks(char[] tasks, int k) {
        if (k == 0)
            return tasks.length;

        Map<Character, Integer> freq = new HashMap<>();
        for (char c : tasks)
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        PriorityQueue<Character> pq = new PriorityQueue(Comparator.comparingInt(c -> freq.get(c)).reversed());
        pq.addAll(freq.keySet());

        int count = 0;
        Queue<Character> queue = new LinkedList<>();
        while (!freq.isEmpty()){
            if (pq.size() != 0) {
                Character c = pq.poll();
                if (c != '\0') {
                    freq.put(c, freq.get(c) - 1);
                    if (freq.get(c) == 0) {
                        freq.remove(c);
                        queue.offer('\0');
                    } else
                        queue.offer(c);
                }
                else
                    queue.offer('\0');
            } else
                queue.offer('\0');

            count++;

            if (queue.size() > k)
                if (queue.peek() != '\0')
                    pq.offer(queue.poll());
                else
                    queue.poll();
        }
        return count;
    }
}
