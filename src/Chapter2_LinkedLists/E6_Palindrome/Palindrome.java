package Chapter2_LinkedLists.E6_Palindrome;

import Chapter2_LinkedLists.utils.LinkedList;
import Chapter2_LinkedLists.utils.Node;

import java.util.ArrayList;

public class Palindrome {
    /**
     *  Implement a function to check if a linked list is palindrome.
     */
    public static void main(String[] args) {
        Palindrome f26Palindrome = new Palindrome();
        Integer[][] solutions = new Integer[][]{
            new Integer[]{0,1,2,1,0},               // true
            new Integer[]{0,1,2,2,2},               // false
            new Integer[]{0,1,1,1,0},               // false
            new Integer[]{0,1,1,0},                 // true
            new Integer[]{0,1,2,2,2,3,0},           // false

        };
        LinkedList linkedList;

        StringBuilder stringBuilder = new StringBuilder();

        for(int i=0; i<solutions.length; i++){
            linkedList = new LinkedList();
            linkedList.initializeFromIntValues(solutions[i]);
            stringBuilder.append("Is boolean: ");
            stringBuilder.append(f26Palindrome.solution(linkedList));
            stringBuilder.append("\n");
        }
        System.out.print(stringBuilder);
    }


    /*
        Time Complexity: O(n)
        Space Complexity: O(n)
     */
    private boolean solution(LinkedList linkedList){
        ArrayList<Integer> list = new ArrayList<>();
        Node currentNode = linkedList.getHead();

        while(currentNode != null){
            list.add(currentNode.data);
            currentNode = currentNode.next;
        }

        int start = 0;
        int end = list.size() - 1;

        while(start < end){
            if(!list.get(start).equals(list.get(end)))
                return false;
            start++;
            end--;
        }
        return true;
    }
}
