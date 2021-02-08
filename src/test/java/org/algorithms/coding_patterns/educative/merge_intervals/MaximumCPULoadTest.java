package org.algorithms.coding_patterns.educative.merge_intervals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MaximumCPULoadTest {

    @Test
    void findMaxCPULoad1() {
        List<Job> input = new ArrayList<Job>(Arrays.asList(
                new Job(1, 4, 3), new Job(2, 5, 4), new Job(7, 9, 6)));
        assertEquals(7, MaximumCPULoad.findMaxCPULoad(input));
    }

    @Test
    void findMaxCPULoad2() {
        List<Job> input = new ArrayList<Job>(Arrays.asList(
                new Job(6, 7, 10), new Job(2, 4, 11), new Job(8, 12, 15)));
        assertEquals(15, MaximumCPULoad.findMaxCPULoad(input));
    }

    @Test
    void findMaxCPULoad3() {
        List<Job> input = new ArrayList<Job>(Arrays.asList(
                new Job(1, 4, 2), new Job(2, 4, 1), new Job(3, 6, 5)));
        assertEquals(8, MaximumCPULoad.findMaxCPULoad(input));
    }
}