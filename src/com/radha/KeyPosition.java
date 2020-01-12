package com.radha;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
        KeyPosition keyOfKeyPositionMap = new KeyPosition(key, position);
        if(this.keyPositionMap.containsKey(keyOfKeyPositionMap)){
            return this.keyPositionMap.get(keyOfKeyPositionMap);
        }
        else{
            return ' ';
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof KeyPosition){
            if(this.key == ((KeyPosition)obj).key && this.position == ((KeyPosition)obj).position){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, position);
    }

    /**
     * Returns a List of all words from the given key combinations
     * @param key1 a int value which represents the first key
     * @param key2 a int value which represents the second key
     * @param key3 a int value which represents the third key
     * @return List<String> that contains combination of words</String>
     */

    public List<String> getWordsForGivenKey(int key1, int key2, int key3){
        List<String> words = new ArrayList<>();
        IntStream.range(0,3).forEach(i -> {
            IntStream.range(0,3).forEach(j -> {
                IntStream.range(0,3).forEach(k -> {
                    StringBuilder sb = new StringBuilder();
                    StringBuilder append = sb.append(getChar(key1, i)).append(getChar(key2, j)).append(getChar(key3, k));
                    words.add(append.toString());
                } );
            });
        });
        return IntStream.range(0, 3).boxed()
                .flatMap(i -> IntStream.range(0, 3).boxed()
                        .flatMap(j -> IntStream.range(0, 3).boxed()
                                .map(k -> "" + getChar(key1, i) + getChar(key2, j) + getChar(key3, k))))
                .collect(Collectors.toList());
       /* for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                for(int k = 0; k < 3; k++){
                    words.add(""+getChar(key1,i)+getChar(key2,j)+getChar(key3,k));
                }
            }
        }*/
        
    }

    /*
    Algorithm(Recursive phone words)
     input => index, phoneNumber[]
     Step 1: If index = length of the phone number - 1 then return getchar(phoneNumber[index],0);
     Step 2: Otherwise return getChar(phoneNumber[index],0)+ phoneWords(index+1,phoneWords);
     */

    /*
    Algorithm(Full Recursive of phoneWords)
    input => index, phoneNumber[]
    Step 0: Create a List of String called words
    Step 1: If index = length of the phone number - 1 then
                1.1: for each position from i = 0 to 2 do
                        add getChar(phoneNumber[index],i) to the list
                1.2:  return the words.
    Step 2: Otherwise for each position from i = 0 to 2 do
                2.1:  curChar =  getChar(phoneNumber[index],i)
                2.2:  combinations = phoneWords(index+1,phoneNumber)
                2.3: For each combination do
                        2.3.1: concatenate the curCombination with curChar
                        2.3.2: Add it to words
                2.4: return the words
     */
}
