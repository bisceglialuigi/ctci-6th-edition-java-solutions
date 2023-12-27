package Chapter4_TreesAndGraphs.utils;

import java.util.List;

public class Node {
    public int data;
    public boolean visited;
    public List<Node> neighbours;

    public Node(int data){
        this.data = data;
    }

    void setNeighbours(List<Node> neighbours){
        this.neighbours = neighbours;
    }
}
