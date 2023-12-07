package Chapter2_LinkedLists;

import Chapter2_LinkedLists.utils.LinkedList;
import Chapter2_LinkedLists.utils.Node;

import java.util.ArrayList;
import java.util.List;

public class B_2_2_ReturnKthToLast {
    public static void main(String[] args) {
        B_2_2_ReturnKthToLast returnKthToLast = new B_2_2_ReturnKthToLast();

        LinkedList linkedList = new LinkedList();
        linkedList.initializeFromIntValues(new Integer[]{1,2,3,4,5});

        linkedList = returnKthToLast.solution(linkedList, 4);
        linkedList.printList();
    }


    /*
        Time Complexity: O(n)
        Space Complexity: O(n)
     */
    public LinkedList solution(LinkedList linkedList, int k){
        Node currentNode = linkedList.getHead();

        if(currentNode == null){
            return linkedList;
        }

        int index = 0;
        List<Integer> values = new ArrayList<>();

        while(currentNode != null){
            index++;
            if(index >= k){
                values.add(currentNode.data);
            }
            currentNode = currentNode.next;
        }

        LinkedList kToEndLinkedList = new LinkedList();
        for(int i=0; i<values.size(); i++){
            kToEndLinkedList.insertNode(values.get(i));
        }

        return kToEndLinkedList;
    }
}
