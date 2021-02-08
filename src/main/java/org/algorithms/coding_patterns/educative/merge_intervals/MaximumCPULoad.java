package org.algorithms.coding_patterns.educative.merge_intervals;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
We are given a list of Jobs. Each job has a Start time, an End time, and a CPU load when it is running.
Our goal is to find the maximum CPU load at any time if all the jobs are running on the same machine.
 */
public class MaximumCPULoad {

    //time - O(n * log n), space - O(n)
    public static int findMaxCPULoad(List<Job> jobs) {
        if (jobs.size() == 0) return 0;

        if (jobs.size() == 1) return jobs.get(0).cpuLoad;

        int max = 0;
        int count = 0;
        Collections.sort(jobs, Comparator.comparingInt(job -> job.start));
        PriorityQueue<Job> activeJobs = new PriorityQueue<>(Comparator.comparingInt(job -> job.end));

        for (Job job : jobs){
            while (!activeJobs.isEmpty() && job.start >= activeJobs.peek().end)
                count -= activeJobs.poll().cpuLoad;

            activeJobs.add(job);
            count += job.cpuLoad;

            max = Math.max(count, max);
        }

        return max;
    }
}

class Job {
    int start;
    int end;
    int cpuLoad;

    public Job(int start, int end, int cpuLoad) {
        this.start = start;
        this.end = end;
        this.cpuLoad = cpuLoad;
    }
};
