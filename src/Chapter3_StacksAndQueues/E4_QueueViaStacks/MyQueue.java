package Chapter3_StacksAndQueues.E4_QueueViaStacks;

import Chapter3_StacksAndQueues.utils.MyStack;

public class MyQueue {

    MyStack myStack;
    MyStack tempStack;

    public MyQueue(){
        myStack = new MyStack();
        tempStack = new MyStack();
    }

    /*
        Time Complexity: O(1)
     */
    public void push(int data){
        myStack.push(data);
    }

    /*
        Time Complexity: O(n)
     */
    public int pop(){
        int data;

        while(!myStack.isEmpty()){
            tempStack.push(myStack.pop());
        }

        data = tempStack.pop();

        while(!tempStack.isEmpty()){
            myStack.push(tempStack.pop());
        }

        return data;
    }
}
