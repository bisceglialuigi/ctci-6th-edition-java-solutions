package Chapter4_TreesAndGraphs.E1_RouteBetweenNodes;

import Chapter4_TreesAndGraphs.E1_RouteBetweenNodes.utils.Node;

import java.util.Arrays;
import java.util.LinkedList;

public class RouteBetweenNodes {

    /**
     *  Given a directed graph and two nodes (S and E), design an algorithm to find out
     *  whether there is a route from S to E.
     */
    public static void main(String[] args) {

        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node5 = new Node(5);
        Node node4 = new Node(4);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node0.neighbours = Arrays.asList(node1, node4, node5);
        node1.neighbours = Arrays.asList(node3, node4);
        node3.neighbours = Arrays.asList(node2, node4);

        RouteBetweenNodes routeBetweenNodes = new RouteBetweenNodes();

        System.out.println("Is there a route: " + routeBetweenNodes.isThereARouteBetweenNodes(node0, node2));

    }

    public boolean isThereARouteBetweenNodes(Node s, Node e){
        if(s == e)
            return true;

        LinkedList<Node> nodesQueue = new LinkedList<>(s.neighbours);

        Node currentNode;

        while(!nodesQueue.isEmpty()){
            currentNode = nodesQueue.removeFirst();
            currentNode.visited = true;
            if(currentNode.neighbours != null){
                for(Node node : currentNode.neighbours){
                    if(node != null && !node.visited){
                        if(e.equals(node)){
                            return true;
                        }
                        nodesQueue.add(node);
                    }
                }
            }
        }

        return false;
    }


}
