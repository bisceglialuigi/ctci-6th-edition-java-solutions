package Charapter1_Arrays_And_Strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class D_1_4_PalindromePermutation {
    /*
        Given a string, write a function to check if it is a permutation of palindrome. A palindrome
        is a phrase that is the same forwards or backwards. A permutation is a rearrangement of letters.
        The palindrome does not need to be limited to just dictionary words. You can ignore casing and
        non-letter characters.

        EXAMPLE
        INPUT: "Tact Coa"
        OUTPUT: True (because "tact coa" is a permutation of "taco cat", "atco cta", etc.)
     */
    public static void main(String[] args) {
        D_1_4_PalindromePermutation palindromePermutation = new D_1_4_PalindromePermutation();
        String[] phrases = new String[]{
                "Taco cat", // true
                "I topi non avevano nipoti", // true
                "This phrase is definitely not palindrome", // false
                "" // false
        };

        StringBuilder stringBuilder;
        for(String phrase : phrases){
            stringBuilder = new StringBuilder();
            stringBuilder.append("Phrase: ");
            stringBuilder.append(phrase);
            stringBuilder.append(" , sol1: ");
            stringBuilder.append(palindromePermutation.solution1(phrase));
            System.out.println(stringBuilder);
        }

    }

    /*
        Time Complexity: O(n)
        Space Complexity: O(n)

        Explanations:
            - If the phrase length is pair, each letter frequency must be a multiple of 2, else is not palindrome
            - If the phrase length is odd, each letter frequency must be a multiple of 2, with an odd frequency
     */
    public boolean solution1(String phrase){
        if(phrase.length() == 0){
            return false;
        }
        if(phrase.length() == 1){
            return true;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        phrase = phrase.toLowerCase();
        phrase = phrase.replace(" ", "");

        for(int i=0; i<phrase.length(); i++){
            if(map.containsKey(phrase.charAt(i))){
                map.put(phrase.charAt(i), map.get(phrase.charAt(i))+1);
            } else {
                map.put(phrase.charAt(i), 1);
            }
        }
        boolean foundOddFrequencyLetter = false;
        for(Integer value : map.values()){
            if(!isIntegerOdd(value) && isIntegerOdd(phrase.length())){
                return false;
            }
            if(!isIntegerOdd(value) && !isIntegerOdd(phrase.length()) && foundOddFrequencyLetter){
                return false;
            }
            if(!isIntegerOdd(value) && !isIntegerOdd(phrase.length()) && !foundOddFrequencyLetter){
                foundOddFrequencyLetter = true;
            }
        }
        return true;
    }

    private boolean isIntegerOdd(int value){
        return value % 2 == 0;
    }
}
