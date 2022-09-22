package com.ahmadi.leetcode;

import java.util.*;
import java.util.stream.IntStream;

public class CountFruits {

    public void findLettersCount(String[] fruits) {
        Map<Character, Integer> lettersCountMap = new HashMap<>();

        // Remove duplicates. I'm not sure if this is a valid requirement, but it is not clear in the description
        Set<String> fruitSet = new HashSet<>(Arrays.asList(fruits));
        for (String fruit : fruitSet) {
            // Check if first char is alphabet
            char firstChar = fruit.charAt(0);
            if(Character.isAlphabetic(firstChar)) {
                // Assuming that all the words should start with uppercase firstCharacter, if not I convert to uppercase
                Character firstCharacter = Character.toUpperCase(firstChar);
                // Map each firstCharacter with number of occurrences
                if ( lettersCountMap.containsKey(firstCharacter) ) {
                    lettersCountMap.put(firstCharacter, lettersCountMap.get(firstCharacter) + 1);
                } else {
                    lettersCountMap.put(firstCharacter, 1);
                }
            }
        }

        printLettersCount(lettersCountMap);
    }

    private void printLettersCount(Map<Character, Integer> lettersCountMap) {
        IntStream.rangeClosed('a', 'z').forEach(i -> {
            Character key = Character.toUpperCase((char) i);
            int value = lettersCountMap.containsKey(Character.toUpperCase((char) i))? lettersCountMap.get(Character.toUpperCase((char) i)): 0;
            System.out.println(key + ": " +  value);
        });
    }

    public static void main(String[] args) {

/*        String[] fruits = {"Strawberry", "Mango", "Cherry", "Lime", "Guava", "Papaya", "Nectarine", "Pineapple",
                "Lemon", "Plum", "Tangerine", "Fig", "Blueberry", "Grape", "Jackfruit", "Pomegranate", "Apple", "Pear"
                , "Orange", "Watermelon", "Raspberry", "Banana"};*/

        String[] fruits = {"Apple", "Apricot", "Cherry", "Banana", "Cherry", "Papaya", "Cantaloupe"};
        new CountFruits().findLettersCount(fruits);

    }
}
