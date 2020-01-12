package com.radha;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.List;

public class KeyPositionTest {
    @Test
    public void testGetChar() {
        KeyPosition keyPosition = new KeyPosition();

        char actual = keyPosition.getChar(2, 0);
        System.out.println("Actual="+actual);

        assertEquals('A', actual);
    }

    @Test
    public void testGetWordsForGivenKey() {
        KeyPosition keyPosition = new KeyPosition();

        List<String> actual = keyPosition.getWordsForGivenKey(4, 5, 6);

        assertEquals(27,actual.size());
        assertEquals("GJO",actual.get(2));
    }
}