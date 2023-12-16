package Chapter2_LinkedLists.E4_Partition;

import Chapter2_LinkedLists.utils.LinkedList;
import Chapter2_LinkedLists.utils.Node;

import java.util.ArrayList;
import java.util.List;

public class Partition {
    /**
     *  Write code to partition a linked list around a value x, such that all nodes less than x come before
     *  all nodes greater than or equal to x. (IMPORTANT: The partition element x can appear anywhere int the
     *  "right partition"; it does not need to appear between the left and the right partitions. The additional
     *  spacing the example below indicates the partition.)
     *  EXAMPLE
     *  Input:      3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition=5]
     *  Output:     3 -> 1 -> 2     ->      10 -> 5 -> 5 -> 8
     */
    public static void main(String[] args) {
        Partition d24Partition = new Partition();
        LinkedList linkedList = new LinkedList();
        linkedList.initializeFromIntValues(new Integer[]{3,5,8,5,10,2,1});
        linkedList = d24Partition.solution(linkedList, 5);
        linkedList.printList();
    }


    /*
        Time Complexity: O(n)
        Space Complexity: O(n)
     */
    public LinkedList solution(LinkedList linkedList, int partition){

        List<Integer> leftValues = new ArrayList<>();
        List<Integer> rightValues = new ArrayList<>();

        Node currentNode = linkedList.getHead();

        while(currentNode != null){
            if(currentNode.data < partition){
                leftValues.add(currentNode.data);
            } else {
                rightValues.add(currentNode.data);
            }
            currentNode = currentNode.next;
        }

        LinkedList returnLinkedList = new LinkedList();
        for(Integer value : leftValues){
            returnLinkedList.insertNode(value);
        }
        for(Integer value : rightValues){
            returnLinkedList.insertNode(value);
        }

        return returnLinkedList;
    }
}
