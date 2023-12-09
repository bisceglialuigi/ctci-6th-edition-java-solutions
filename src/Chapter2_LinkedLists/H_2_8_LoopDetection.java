package Chapter2_LinkedLists;

import Chapter2_LinkedLists.utils.LinkedList;
import Chapter2_LinkedLists.utils.Node;

import java.util.HashSet;

public class H_2_8_LoopDetection {

    /**
     *  Given a linked list which might contain a loop, implement an algoruthm that returns the node at the
     *  beginning of the loop (if one exists).
     *  EXAMPLE
     *  Input: A -> B -> C -> D -> E -> C[the same as earlier]
     *  Output: C
     */
    public static void main(String[] args) throws Exception {
        H_2_8_LoopDetection loopDetection = new H_2_8_LoopDetection();

        LinkedList linkedList = new LinkedList();

        Node nodeA = new Node(0);
        Node nodeB = new Node(1);
        nodeA.next = nodeB;
        Node nodeC = new Node(2);
        nodeB.next = nodeC;
        Node nodeD = new Node(3);
        nodeC.next = nodeD;
        Node nodeE = new Node(4);
        nodeD.next = nodeE;
        nodeE.next = nodeC;

        linkedList.insertNode(nodeA);
        Node loopNode = loopDetection.solution(linkedList);
        loopNode.print();
    }

    /*
        Time Complexity: O(n)
        Space Complexity: O(n)
     */
    Node solution(LinkedList linkedList) throws Exception {
        HashSet<Node> alreadyVisitedNodes = new HashSet<>();

        Node currentNode = linkedList.getHead();

        while(currentNode != null){
            if(alreadyVisitedNodes.contains(currentNode)){
                return currentNode;
            }
            alreadyVisitedNodes.add(currentNode);
            currentNode = currentNode.next;
        }

        throw new Exception();
    }
}
