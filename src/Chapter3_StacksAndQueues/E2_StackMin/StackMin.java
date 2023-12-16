package Chapter3_StacksAndQueues.E2_StackMin;

public class StackMin {
    /**
     *  How would you design a stack which, in addition to push and pop, has a function min which returns the
     *  minimum element? Push, pop and min should all operate in O(1) time.
     */
    public static void main(String[] args) {
        StackWithMin myStack = new StackWithMin();

        myStack.push(5);
        myStack.print();
        myStack.printMin();

        myStack.push(2);
        myStack.print();
        myStack.printMin();

        myStack.push(5);
        myStack.print();
        myStack.printMin();

        myStack.push(1);
        myStack.print();
        myStack.printMin();

        myStack.push(1);
        myStack.print();
        myStack.printMin();

        myStack.push(2);
        myStack.print();
        myStack.printMin();

        System.out.println("----------------");

        myStack.pop();
        myStack.print();
        myStack.printMin();

        myStack.pop();
        myStack.print();
        myStack.printMin();

        myStack.pop();
        myStack.print();
        myStack.printMin();

        myStack.pop();
        myStack.print();
        myStack.printMin();
    }
}
