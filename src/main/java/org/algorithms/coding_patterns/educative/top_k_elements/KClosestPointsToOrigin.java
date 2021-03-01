package org.algorithms.coding_patterns.educative.top_k_elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;

/*
Given an array of points in the a 2D plane, find ‘K’ closest points to the origin.
 */
public class KClosestPointsToOrigin {
    //time - O(n * log k), space - O(k)
    public static List<Point> findClosestPoints(Point[] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> o2.distFromOrigin() - o1.distFromOrigin()); //reverse

        for (int i = 0; i < k; i++)
            pq.offer(points[i]);

        for (int i = k; i < points.length; i++){
            if (pq.peek().distFromOrigin() > points[i].distFromOrigin()){
                pq.poll();
                pq.offer(points[i]);
            }
        }

        return new ArrayList<>(pq);
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int distFromOrigin() {
        // ignoring sqrt
        return (x * x) + (y * y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

