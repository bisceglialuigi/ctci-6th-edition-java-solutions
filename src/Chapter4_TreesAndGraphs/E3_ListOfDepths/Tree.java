package Chapter4_TreesAndGraphs.E3_ListOfDepths;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Tree {
    Node root;

    ArrayList<LinkedList<Node>> getLinkedListOfAllNodesAtEachDepth(){

        ArrayList<LinkedList<Node>> returnList = new ArrayList<>();
        LinkedList<Node> nodes = new LinkedList<>();
        LinkedList<Node> tempList = new LinkedList<>();

        nodes.add(root);

        if(root.children != null)
            tempList.addAll(root.children);

        while(!tempList.isEmpty()){
            nodes = tempList;

            returnList.add(nodes);

            tempList = new LinkedList<>();

            for(Node node : nodes){
                if(node.children != null)
                    tempList.addAll(node.children);
            }

        }
        return returnList;
    }
}
