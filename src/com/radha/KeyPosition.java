package com.radha;

import java.util.HashMap;
import java.util.Map;

public class KeyPosition {
    private int key;
    private int position;
    private Map<KeyPosition, Character> keyPositionMap = new HashMap<>();

    public KeyPosition() {
    }

    public KeyPosition(int key, int position) {
        this.key = key;
        this.position = position;
    }

    /**
     * populate the keyPositionMap with keyPosition as key and corresponding character as value
     * @return void
     */
    private void populateKeyPositionMap(){
        /* Algorithm
            Step 1: Put the key as KeyPosition and value as corresponding character in the map
         */
        this.keyPositionMap.put(new KeyPosition(2, 0), 'A');
        this.keyPositionMap.put(new KeyPosition(2, 1), 'B');
        this.keyPositionMap.put(new KeyPosition(2, 2), 'C');
        this.keyPositionMap.put(new KeyPosition(3, 0), 'D');
        this.keyPositionMap.put(new KeyPosition(3, 1), 'E');
        this.keyPositionMap.put(new KeyPosition(3, 2), 'F');
        this.keyPositionMap.put(new KeyPosition(4, 0), 'G');
        this.keyPositionMap.put(new KeyPosition(4, 1), 'H');
        this.keyPositionMap.put(new KeyPosition(4, 2), 'I');
        this.keyPositionMap.put(new KeyPosition(5, 0), 'J');
        this.keyPositionMap.put(new KeyPosition(5, 1), 'K');
        this.keyPositionMap.put(new KeyPosition(5, 2), 'L');
        this.keyPositionMap.put(new KeyPosition(6, 0), 'M');
        this.keyPositionMap.put(new KeyPosition(6, 1), 'N');
        this.keyPositionMap.put(new KeyPosition(6, 2), 'O');
        this.keyPositionMap.put(new KeyPosition(7, 0), 'P');
        this.keyPositionMap.put(new KeyPosition(7, 1), 'Q');
        this.keyPositionMap.put(new KeyPosition(7, 2), 'R');
        this.keyPositionMap.put(new KeyPosition(7, 3), 'S');
        this.keyPositionMap.put(new KeyPosition(8, 0), 'T');
        this.keyPositionMap.put(new KeyPosition(8, 1), 'U');
        this.keyPositionMap.put(new KeyPosition(8, 2), 'V');
        this.keyPositionMap.put(new KeyPosition(9, 0), 'W');
        this.keyPositionMap.put(new KeyPosition(9, 1), 'X');
        this.keyPositionMap.put(new KeyPosition(9, 2), 'Y');
        this.keyPositionMap.put(new KeyPosition(9, 3), 'Z');
        System.out.println("Inside populate method size="+keyPositionMap.size());

    }

    /**
     * get the specific character of the given key and position
     * @param key The number or key number in the telephone
     * @param position The position of the key
     * @return char type value which corresponds to the given key and position
     */
    public char getChar(int key, int position){
        /* Algorithm
                Step 0: Populate the keyPositionMap by calling the populateKeyPositionMap method
                Step 1: If the keyPositionMap contains the key(ie keyPosition object of given key,position)
                then return the corresponding value from the map

                Step 2: Otherwise return empty character
         */
        populateKeyPositionMap();
        System.out.println("Inside get char method");
        KeyPosition keyOfKeyPositionMap = new KeyPosition(key, position);
        if(this.keyPositionMap.containsKey(keyOfKeyPositionMap)){
            System.out.println("Inside if");
            return this.keyPositionMap.get(keyOfKeyPositionMap);
        }
        else{
            System.out.println("Inside else");
            return ' ';
        }
    }


}
