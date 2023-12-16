package Chapter3_StacksAndQueues.CH3E3_StackOfPlates;

public class CustomStack {
    public class StackNode {
        int data;
        StackNode next;
       StackNode(int data){
           this.data = data;
       }
    }

    StackNode top;
    int size = 0;

    /*
        Time Complexity: O(1)
     */
    public void push(int data){
        StackNode newNode = new StackNode(data);
        if(top != null){
            newNode.next = top;
        }
        top = newNode;
        size++;
    }

    /*
        Time Complexity: O(1)
     */
    public int pop(){
        size--;
        int data = top.data;
        top = top.next;
        return data;
    }


}
