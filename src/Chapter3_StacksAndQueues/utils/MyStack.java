package Chapter3_StacksAndQueues.utils;

public class MyStack {
    public StackNode top;

    /*
        Time Complexity: O(1)
     */
    public void push(int data){
        StackNode newNode = new StackNode(data);
        if(top != null){
            newNode.next = top;
        }
        top = newNode;
    }

    /*
        Time Complexity O(1)
     */
    public int pop(){
        int data = top.data;
        top = top.next;
        return data;
    }

    public int peek(){
        if(top != null){
            return top.data;
        }
        return Integer.MAX_VALUE;
    }

    public void print(){
        top.print();
    }

}
