package com.radha;

import static org.junit.Assert.*;

import org.junit.Test;

public class KeyPositionTest {
    @Test
    public void testGetChar() {
        KeyPosition keyPosition = new KeyPosition();

        char actual = keyPosition.getChar(2, 0);
        System.out.println("Actual="+actual);

        assertEquals('A', actual);
    }

}