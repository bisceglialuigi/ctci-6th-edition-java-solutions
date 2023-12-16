package Chapter2_LinkedLists.E1_RemoveDups;

import Chapter2_LinkedLists.utils.LinkedList;
import Chapter2_LinkedLists.utils.Node;

import java.util.HashSet;

public class RemoveDups {

    /**
     * Write code to remove duplicates from unsorted linked list.
     * FOLLOW UP
     * How would you solve this problem if a temporary buffer is not allowed?
     */
    public static void main(String[] args) {
        RemoveDups removeDups = new RemoveDups();

        int[][] values = new int[][]{
                {1,2,3,4},
                {1,1,2,3},
                {9,8,8,8,7,6,5,3}
        };

        for(int i=0; i<values.length; i++){
            LinkedList linkedList = new LinkedList();
            for(int j=0; j<values[i].length; j++){
                linkedList.insertNode(values[i][j]);
            }
            linkedList = removeDups.solution(linkedList);
            linkedList.printList();
        }
    }


    /*
        Time Complexity: O(n)
        Space Complexity: O(1)
     */
    public LinkedList solution(LinkedList linkedList){
        Node currentNode = linkedList.getHead();
        HashSet<Integer> intSet = new HashSet<>();

        Node previousNode = currentNode;

        while(currentNode != null){
            if(intSet.contains(currentNode.data)){
                previousNode.next = currentNode.next;
            } else {
                intSet.add(currentNode.data);
                previousNode = currentNode;
            }
            currentNode = currentNode.next;
        }

        return linkedList;
    }
}
