package Chapter3_StacksAndQueues.E4_QueueViaStacks;

public class QueueViaStacks {
    /**\
     *  Implement a MyQueue class which implements a queue using two stacks.
     */
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();

        myQueue.push(0);
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);

        int data = myQueue.pop();   // data = 0 (First In - First Out)
    }
}
