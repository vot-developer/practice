package org.algorithms.coding_patterns.educative.subsets;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UniqueTreesTest {

    @Test
    void findUniqueTrees2() {
        List<TreeNode> result = UniqueTrees.findUniqueTrees(2);
        assertEquals(2, result.size());

        assertEquals(1, result.get(0).val);
        assertEquals(2, result.get(0).right.val);

        assertEquals(2, result.get(1).val);
        assertEquals(1, result.get(1).left.val);
    }
}