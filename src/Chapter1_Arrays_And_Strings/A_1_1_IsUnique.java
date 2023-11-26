package Chapter1_Arrays_And_Strings;

import java.util.Arrays;
import java.util.HashSet;

public class A_1_1_IsUnique {

   /*
       Implement an algorithm to determine if a string has all unique characters.
       What if you can not use additional data structure?
    */

    public static void main(String[] args) {
        String[] words = new String[]{
                "abcdef",
                "aabbccdd",
                "abcdefghijklmnopqrstuvwxyz",
                "zxyal"
        };
        StringBuilder stringBuilder;
        for(String word : words){
            stringBuilder = new StringBuilder();
            stringBuilder.append("Word: ");
            stringBuilder.append(word);
            stringBuilder.append(" , isUnique: ");
            stringBuilder.append("sol1: ");
            stringBuilder.append(solution1(word));
            stringBuilder.append(", sol2: ");
            stringBuilder.append(solution2(word));
            stringBuilder.append(", sol3: ");
            stringBuilder.append(solution3(word));
            System.out.println(stringBuilder);
        }
    }

    /*
        Time Complexity: O(n)
        Space Complexity: O(n)
     */
    public static boolean solution1(String word){
        if(word.length() == 0){
            return false;
        }
        if(word.length() == 1){
            return true;
        }
        HashSet<Character> charSet = new HashSet<>();

        char[] charArrayOfWord = word.toCharArray();
        char currentChar;

        for(int i=0; i<charArrayOfWord.length; i++){
            currentChar = charArrayOfWord[i];
            if(charSet.contains(currentChar)){
                return false;
            } else {
                charSet.add(currentChar);
            }
        }
        return true;
    }

    /*
        Constraint:  What if you can not use additional data structure?

        Time Complexity: O(n log n)
        Space Complexity: O(n)
     */
    public static boolean solution2(String word){
        if(word.length() == 0){
            return false;
        }
        if(word.length() == 1){
            return true;
        }
        char[] charArrayOfWord = word.toCharArray();
        Arrays.sort(charArrayOfWord);
        for(int i=1; i<charArrayOfWord.length; i++){
            if(charArrayOfWord[i-1] == charArrayOfWord[i]){
                return false;
            }
        }
        return true;
    }

    /*
        Time Complexity: O(n^2)
        Space Complexity: O(1)
     */
    public static boolean solution3(String word){
        if(word.length() == 0){
            return false;
        }
        if(word.length() == 1){
            return true;
        }
        for(int i=0; i<word.length(); i++){
            for(int j=i+1; j<word.length(); j++){
                if(word.charAt(i) == word.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }
}
