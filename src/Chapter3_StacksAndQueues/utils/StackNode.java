package Chapter3_StacksAndQueues.utils;

public class StackNode {
    int data;
    StackNode next;

    public StackNode(int data){
        this.data = data;
    }

    public void print(){
        System.out.println("Node: " + data);
    }
}
