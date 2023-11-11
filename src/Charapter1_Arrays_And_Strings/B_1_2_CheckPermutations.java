package Charapter1_Arrays_And_Strings;

import java.util.Arrays;
import java.util.HashMap;

public class B_1_2_CheckPermutations {
    /*
        Given two strings, write a method to decide if one is a permutation of the other.
     */

    public static void main(String[] args) {
        String[][] wordCouples = new String[][]{
                {"abc", "bca"},
                {"abc", "bce"},
                {"abcdef", "fedcba"},
                {"ababab", "bbbaaa"},
                {"", "aaa"}
        };

        StringBuilder stringBuilder;
        for(String[] wordCouple : wordCouples){
            stringBuilder = new StringBuilder();
            stringBuilder.append("Word A: ");
            stringBuilder.append(wordCouple[0]);
            stringBuilder.append(", word B: ");
            stringBuilder.append(wordCouple[1]);
            stringBuilder.append(" are permutaions: ");
            stringBuilder.append(" sol1: ");
            stringBuilder.append(solution1(wordCouple[0], wordCouple[1]));
            stringBuilder.append(" sol2: ");
            stringBuilder.append(solution2(wordCouple[0], wordCouple[1]));
            System.out.println(stringBuilder);
        }

    }

    /*
        Time Complexity: O(n)
        Space Complexity: O(n)
     */
    public static boolean solution1(String wordA, String wordB){
        if(wordA.length() != wordB.length()){
            return false;
        }
        if(wordA.length() == 0){
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        char currentChar;
        for(int i=0; i<wordA.length(); i++){
            currentChar = wordA.charAt(i);
            if(map.containsKey(currentChar)){
                map.put(currentChar, map.get(currentChar)+1);
            } else {
                map.put(currentChar, 1);
            }
        }

        for(int i=0; i<wordB.length(); i++){
            currentChar = wordB.charAt(i);
            if(!map.containsKey(currentChar)){
                return false;
            } else {
                map.put(currentChar, map.get(currentChar)-1);
                if(map.get(currentChar) < 0){
                    return false;
                }
            }
        }
        return true;
    }

    /*
        Time Complexity: O(n log n)
        Space Complexity: O(1)

        Hypothesis: letter a-z
     */

    public static boolean solution2(String wordA, String wordB){
        if(wordA.length() != wordB.length()){
            return false;
        }
        if(wordA.length() == 0){
            return false;
        }

        char[] charsOfWordA = wordA.toCharArray();
        char[] charsOfWordB = wordB.toCharArray();

        Arrays.sort(charsOfWordA);
        Arrays.sort(charsOfWordB);

        for(int i=0; i<wordA.length(); i++){
            if(charsOfWordA[i] != charsOfWordB[i]){
                return false;
            }
        }
        return true;
    }
}
