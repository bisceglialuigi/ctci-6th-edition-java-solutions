package Chapter2_LinkedLists.utils;

public class Node {
    public int data;
    public Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }

    public void print(){
        System.out.print("Node data: " + this.data);
    }
}
