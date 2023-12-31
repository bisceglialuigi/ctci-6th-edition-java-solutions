package Chapter2_LinkedLists.E3_DeleteMiddleNode;

import Chapter2_LinkedLists.utils.LinkedList;
import Chapter2_LinkedLists.utils.Node;

public class DeleteMiddleNode {
    public static void main(String[] args) {
        DeleteMiddleNode c23DeleteMiddleNode = new DeleteMiddleNode();

        LinkedList linkedList = new LinkedList();
        linkedList.initializeFromIntValues(new Integer[]{1,2,3,4,5});
        linkedList = c23DeleteMiddleNode.solution(linkedList);

        linkedList.printList();
    }


    /*
        Time Complexity: O(n)
        Space Complexity: O(n)
     */
    public LinkedList solution(LinkedList linkedList){
        Node currentNode = linkedList.getHead();
        int counter = 0;
        while (currentNode != null){
            counter++;
            currentNode = currentNode.next;
        }

        int centerNodeIndex;

        if(counter % 2 != 0){
            centerNodeIndex = (counter / 2) + 1;
        } else {
            return linkedList;
        }

        currentNode = linkedList.getHead();
        Node previousNode = null;
        counter = 0;
        while (currentNode != null){
            counter++;
            if(counter == centerNodeIndex){
                previousNode.next = currentNode.next;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        return linkedList;
    }
}
