package Chapter3_StacksAndQueues.E2_StackMin.utils;

public class StackWithMin {
    MyStack myStack;
    MyStack minStack;

    public StackWithMin(){
        myStack = new MyStack();
        minStack = new MyStack();
    }

    public void push(int data){
        myStack.push(data);

        if(data <= minStack.peek()){
            minStack.push(data);
        }
    }

    public int pop(){
        int data = myStack.pop();

        if(data == minStack.peek())
            minStack.pop();

        return data;
    }

    public int min(){
        return minStack.peek();
    }

    public void print(){
        myStack.print();
    }

    public void printMin(){
        System.out.println("Min: " + minStack.peek());
    }
}
