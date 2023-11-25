package Charapter1_Arrays_And_Strings;

public class I_1_9_StringRotation {
    /**
     *  Assume you have a method isSubstring which checks if one word is a substring of another. Given two strings,
     *  s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring
     *  (e.g., "waterbottle" is a rotation of "erbottlewat").
     */

    public static void main(String[] args) {
        I_1_9_StringRotation stringRotation = new I_1_9_StringRotation();

        String[][] stringCouples = new String[][]{
                {"abcde", "deabc"},             // true
                {"luigi", "gi"},                // false
                {"matrix", "xmatria"},          // false
                {"helloworld", "worldhello"}    // true
        };


        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i< stringCouples.length; i++){
            stringBuilder.append("s1: ");
            stringBuilder.append(stringCouples[i][0]);
            stringBuilder.append(", s2: ");
            stringBuilder.append(stringCouples[i][1]);
            stringBuilder.append(", rotation: ");
            stringBuilder.append(stringRotation.solution(stringCouples[i][0], stringCouples[i][1]));
            stringBuilder.append("\n");
        }
        System.out.print(stringBuilder);
    }


    /*
        Time Complexity: O(n)
        Space Complexity: O(1)
     */
    public boolean solution(String s1, String s2){
        if(s1.length() != s2.length() || s1.isEmpty() || s2.isEmpty()){
            return false;
        }
        return isSubstring(s1+s1, s2);
    }


    /*
        Time Complexity: O(n), where n is the length of the longest string
        Space Complexity: O(1)
     */
    public boolean isSubstring(String s1, String s2){

        if(s2.length() > s1.length()){
            return false;
        }

        int iS1 = 0;
        int iS2 = 0;

        while(true){
            if(s1.charAt(iS1) == s2.charAt(iS2)){
                iS2++;
                if(iS2 == s2.length()){
                    return true;
                }
            } else {
                iS2 = 0;
            }
            iS1++;
            if(s1.length() - iS1 + 1 < s2.length() - iS2 - 1){
                return false;
            }
        }
    }
}
