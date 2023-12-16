package Chapter1_ArraysAndStrings.E5_OneWay;

import java.util.HashMap;

public class OneWay {
    /*
        There are three types of edits that can be performed on strings: insert a character, remove a character,
        or replace a character. Given two strings, write a function to check if they are one edit (or zero edits) away.

        EXAMPLE
            pale, ple   -> true
            pales, pale -> true
            pale, bale  -> true
            pale, bae   -> false
     */
    public static void main(String[] args) {
        OneWay oneWay = new OneWay();

        String[][] wordCouples = new String[][]{
                {"pale", "ple"},    // true
                {"pales", "pale"},  // true
                {"pale", "bale"},   // true
                {"pale", "bae"},    // false
                {"abbc", "abbd"},   // true
                {"abbc", "abb"},    // true
                {"abbc", "abcd"}    // false
        };

        StringBuilder stringBuilder = new StringBuilder();
        for(String[] couples : wordCouples){
            stringBuilder.append("WordA: ");
            stringBuilder.append(couples[0]);
            stringBuilder.append(", WordB: ");
            stringBuilder.append(couples[1]);
            stringBuilder.append(", sol1: ");
            stringBuilder.append(oneWay.solution1(couples[0], couples[1]));
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }

    /*
        Time Complexity: O(n)
        Space Complexity: O(n)
     */
    public boolean solution1(String wordA, String wordB){
        if(wordA.length() - wordB.length() > 1 || wordB.length() - wordA.length() > 1){
            return false;
        }

        HashMap<Character, Integer> mapOfWordA = getFrequencyLetterMapFromString(wordA);
        HashMap<Character, Integer> mapOfWordB = getFrequencyLetterMapFromString(wordB);

        HashMap<Character, Integer> longerMap = new HashMap<>();
        HashMap<Character, Integer> shorterMap = new HashMap<>();

        if(mapOfWordA.size() > mapOfWordB.size()){
            longerMap = mapOfWordA;
            shorterMap = mapOfWordB;
        } else{
            longerMap = mapOfWordB;
            shorterMap = mapOfWordA;
        }

        if(longerMap.size() - shorterMap.size() > 1){
            return false;
        }

        boolean foundTheDifferentLetter = false;

        for(Character key : longerMap.keySet()){
            if(!shorterMap.containsKey(key)){
                if(foundTheDifferentLetter){
                    return false;
                } else {
                    if(longerMap.get(key) > 1){
                        return false;
                    }
                    foundTheDifferentLetter = true;
                }
            } else {
                if(!shorterMap.get(key).equals(longerMap.get(key))){
                    return false;
                }
            }
        }
        return true;
    }

    HashMap<Character, Integer> getFrequencyLetterMapFromString(String word){
        HashMap<Character, Integer> mapOfWord = new HashMap<>();
        for(int i=0; i<word.length(); i++){
            if(mapOfWord.containsKey(word.charAt(i))){
                mapOfWord.put(word.charAt(i), mapOfWord.get(word.charAt(i))+1);
            } else {
                mapOfWord.put(word.charAt(i), 1);
            }
        }
        return mapOfWord;
    }
}
