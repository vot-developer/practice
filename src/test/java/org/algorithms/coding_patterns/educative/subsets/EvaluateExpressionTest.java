package org.algorithms.coding_patterns.educative.subsets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EvaluateExpressionTest {

    @Test
    void diffWaysToEvaluateExpression1() {
        assertArrayEquals(new Integer[]{7, 9},
                EvaluateExpression.diffWaysToEvaluateExpression("1+2*3").toArray());
    }

    @Test
    void diffWaysToEvaluateExpression2() {
        assertArrayEquals(new Integer[]{8, -12, 7, -7, -3},
                EvaluateExpression.diffWaysToEvaluateExpression("2*3-4-5").toArray());
    }
}