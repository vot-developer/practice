package org.algorithms.coding_patterns.educative.top_k_elements;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KClosestPointsToOriginTest {

    @Test
    void findClosestPoints1() {
        Point[] points = new Point[] { new Point(1, 3), new Point(3, 4), new Point(2, -1) };
        List<Point> result = KClosestPointsToOrigin.findClosestPoints(points, 2);
        assertEquals(2, result.size());
        assertEquals(new Point(1, 3), result.get(0));
        assertEquals(new Point(2, -1), result.get(1));
    }

    @Test
    void findClosestPoints2() {
        Point[] points = new Point[] { new Point(3, 3), new Point(5, -1), new Point(-2, 4) };
        List<Point> result = KClosestPointsToOrigin.findClosestPoints(points, 2);
        assertEquals(2, result.size());
        assertEquals(new Point(-2, 4), result.get(0));
        assertEquals(new Point(3, 3), result.get(1));
    }
}