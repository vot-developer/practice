package org.algorithms.coding_patterns.educative.top_k_elements;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConnectRopesTest {

    @Test
    void minimumCostToConnectRopes() {
        assertEquals(33, ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5 }));
        assertEquals(36, ConnectRopes.minimumCostToConnectRopes(new int[] { 3, 4, 5, 6 }));
        assertEquals(42, ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5, 2 }));
    }
}