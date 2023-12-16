package Chapter2_LinkedLists.E7_Intersection;

import Chapter2_LinkedLists.utils.LinkedList;
import Chapter2_LinkedLists.utils.Node;

public class Intersection {
    /**
     *  Given two singly linked list, determine if two lists intersect. Return the intersecting node. Note that
     *  the intersection is defined based on reference, not value. That is, if the kth node of the first linked list is
     *  the exact same node (by reference) as the jth node of the second linked list, then they are intersecting.
     */
    public static void main(String[] args) throws Exception {
        Intersection intersection = new Intersection();

        Node commonNode = new Node(7);

        LinkedList firstLinkedList = new LinkedList();
        firstLinkedList.insertNode(3);
        firstLinkedList.insertNode(1);
        firstLinkedList.insertNode(5);
        firstLinkedList.insertNode(9);
        firstLinkedList.insertNode(commonNode);

        LinkedList secondLinkedList = new LinkedList();
        secondLinkedList.insertNode(4);
        secondLinkedList.insertNode(6);
        secondLinkedList.insertNode(commonNode);

        Node intersectionNode = intersection.solution(firstLinkedList, secondLinkedList);

        intersectionNode.print();
    }


    /*
        Time Complexity: O(n)
        Space Complexity: O(1)
     */
    public Node solution(LinkedList firstLinkedList, LinkedList secondLinkedList) throws Exception {
         Node firstListCurrentNode = firstLinkedList.getHead();
         int firstListLength = 0;
         while(firstListCurrentNode != null){
             firstListLength++;
             firstListCurrentNode = firstListCurrentNode.next;
         }

         Node secondListCurrentNode = secondLinkedList.getHead();
         int secondListLength = 0;
         while(secondListCurrentNode != null){
             secondListLength++;
             secondListCurrentNode = secondListCurrentNode.next;
         }

         int lengthDifference = 0;

         Node currentNodeLongerList;
         Node currentNodeShorterList;

         if(firstListLength > secondListLength){
             lengthDifference = firstListLength - secondListLength;
             currentNodeShorterList = secondLinkedList.getHead();
             currentNodeLongerList = firstLinkedList.getHead();

         } else {
             lengthDifference = secondListLength - firstListLength;
             currentNodeShorterList = firstLinkedList.getHead();
             currentNodeLongerList = secondLinkedList.getHead();
         }

         int newStartingIndex = 0;

         while(newStartingIndex < lengthDifference){
             currentNodeLongerList = currentNodeLongerList.next;
             newStartingIndex++;
         }


         while(true){
             if(currentNodeLongerList.equals(currentNodeShorterList)){
                 return currentNodeLongerList;
             }
             if(currentNodeLongerList.next == null)
                 break;
             currentNodeLongerList = currentNodeLongerList.next;
             currentNodeShorterList = currentNodeShorterList.next;
         }
        throw new Exception();
    }
}
