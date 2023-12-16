package Chapter3_StacksAndQueues.E4_QueueViaStacks;

public class MyQueue {


    // 0, 1, 2, 3, 4

    // 4,3,2,1,0
    // 0,1,2,3,4


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
