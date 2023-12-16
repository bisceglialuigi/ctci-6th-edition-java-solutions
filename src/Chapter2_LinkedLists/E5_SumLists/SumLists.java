package Chapter2_LinkedLists.E5_SumLists;

import Chapter2_LinkedLists.utils.LinkedList;
import Chapter2_LinkedLists.utils.Node;

public class SumLists {
    /**
     * You have two numbers represented by a linked list, where each node contains a single
     * digit. The digits are stored in reverse order, such that the 1's digit is at the head of the list. Write a
     * function that adds the two numbers and returns the sum as a linked list. (You are not allowed to "cheat" and
     * just convert the linked list to an integer.
     * EXAMPLE
     * Input: (7->1->6) + (5->9->2). That is 617 + 295
     * Output: (2->1->9). That is, 912.
     * FOLLOW UP
     * Suppose the digits are stored in forward order. Repeat the above problem.
     * Input: (6->1->7) + (2->9->5). That is, 617 + 295.
     * Output: 9->1->2. That is, 912.
     */
    public static void main(String[] args) {
        SumLists e25SumLists = new SumLists();
        LinkedList firstLinkedList = new LinkedList();
        LinkedList secondLinkedList = new LinkedList();

        firstLinkedList.initializeFromIntValues(new Integer[]{7,1,6});

        secondLinkedList.initializeFromIntValues(new Integer[]{5,9,2});

        LinkedList result = new LinkedList();
        result = e25SumLists.solution(firstLinkedList, secondLinkedList);
        result.printList();
    }


    /*
        Time Complexity: O(n)
        Space Complexity: O(n)
     */
    public LinkedList solution(LinkedList firstLinkedList, LinkedList secondLinkedList){
        LinkedList resultLinkedList = new LinkedList();

        int firstDigit = 0;
        int secondDigit = 0;
        int report = 0;

        Node firstCurrentNode = firstLinkedList.getHead();
        Node secondCurrentNode = secondLinkedList.getHead();

        while(firstCurrentNode != null || secondCurrentNode != null){

            firstDigit = 0;
            secondDigit = 0;

            if(firstCurrentNode != null){
                firstDigit = firstCurrentNode.data;
                firstCurrentNode = firstCurrentNode.next;
            }
            if(secondCurrentNode != null){
                secondDigit = secondCurrentNode.data;
                secondCurrentNode = secondCurrentNode.next;
            }

            int sum = firstDigit + secondDigit + report;

            if(sum >= 10){
                report = 1;
                sum = sum - 10;
            }

            resultLinkedList.insertNode(sum);
        }

        return resultLinkedList;
    }

}
