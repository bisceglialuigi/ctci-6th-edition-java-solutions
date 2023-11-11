package Charapter1_Arrays_And_Strings;

import java.util.HashMap;
import java.util.Map;

public class C_1_3_URLify {

    /*
        Write a method to replace all spaces in a string with '%20'. You may assume that the string has
        sufficient space at the end to hold the additional characters, and that you are given the "true"
        lenght of the string.

        EXAMPLE
            Input: "Mr John Smith     " 13
            Output: "Mr%20John%20%20Smith"
     */
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Mr John Smith     ", 13);
        map.put("Sopra la panca la capra canta     ", 29);
        map.put("It's better to light a candle than to curse the darkness     ", 56);

        StringBuilder stringBuilder;
        for(Map.Entry entry : map.entrySet()){
            stringBuilder = new StringBuilder();
            stringBuilder.append("String: ");
            stringBuilder.append(entry.getKey());
            stringBuilder.append(" , sol1: ");
            stringBuilder.append(solution1((String) entry.getKey(), (int) entry.getValue()));
            System.out.println(stringBuilder);
        }
    }

    /*
        Time Complexity: O(N)
        Space Complexity: O(1)

     */
    public static char[] solution1(String word, int trueLength){
        /*
            Input: "Mr John Smith     " 13
            Output: "Mr%20John%20%20Smith"
         */

        char[] charsOfWord = word.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();

        int index = 0;

        while(index < word.length()){
            if(charsOfWord[index] != ' '){
                stringBuilder.append(charsOfWord[index]);
                trueLength--;
            }
            if(charsOfWord[index] == ' ' && trueLength != 0){
                stringBuilder.append("%20");
                trueLength--;
            }
            index++;
        }
        return stringBuilder.toString().toCharArray();
    }

}
