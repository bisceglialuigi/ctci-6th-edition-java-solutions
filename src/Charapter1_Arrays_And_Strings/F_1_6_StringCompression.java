package Charapter1_Arrays_And_Strings;

import java.util.*;

public class F_1_6_StringCompression {
    /**
     * Implement a method to perform basic string compression using the counts
     * of repeated characters. For example, the string aabcccccaaa would become
     * a2b1c5a3. If the "compressed" string would not become smaller than the
     * original string, your method should return the original string.
     */
    public static void main(String[] args) {
        F_1_6_StringCompression stringCompression = new F_1_6_StringCompression();
        String[] words = new String[]{
                "aabcccccaab",
                "aabcccccaaa",
                "aaaaa",
                "aaaab",
                "aa"
        };

        StringBuilder stringBuilder = new StringBuilder();
        for(String word : words){
            stringBuilder.append("Word: ");
            stringBuilder.append(word);
            stringBuilder.append(" , solution: ");
            stringBuilder.append(stringCompression.solution1(word));
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }

    public String solution1(String word){
        // aabcccccaab -> a2b1c5a3

        if(word.length() == 0 || word.length() == 1 || word.length() == 2){
            return word;
        }

        StringBuilder stringBuilder = new StringBuilder();

        char lastEqualChar = word.charAt(0);
        int equalCharCounter = 1;

        for(int i=1; i<word.length(); i++){
            if(word.charAt(i-1) != word.charAt(i)){
                addCharToStringBuilder(stringBuilder, lastEqualChar, equalCharCounter);
                if(stringBuilder.length() > word.length()){
                    return word;
                }
                equalCharCounter = 1;
                lastEqualChar = word.charAt(i);
            } else{
                equalCharCounter++;
            }
        }

        addCharToStringBuilder(stringBuilder, lastEqualChar, equalCharCounter);
        if(stringBuilder.length() > word.length()){
            return word;
        }

        return stringBuilder.toString();
    }

    private void addCharToStringBuilder(StringBuilder stringBuilder, char lastEqualChar, int equalCharCounter){
        stringBuilder.append(lastEqualChar);
        stringBuilder.append(equalCharCounter);
    }
}
