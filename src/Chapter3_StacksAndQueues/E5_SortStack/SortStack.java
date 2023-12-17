package Chapter3_StacksAndQueues.E5_SortStack;

public class SortStack {
    /**
     *  Write a program to sort a stack such that the smallest items are on the top. You can use
     *  an additional temporary stack, but you may not copy the elements into any other data structure (such an array).
     *  The stack supports the following operations: push, pop, peek, isEmpty.
     */
    public static void main(String[] args) {
        Integer[] values = new Integer[]{
                5, 6, 3, 1, 2, 4
        };

        CustomStack customStack = new CustomStack(values);

        customStack.sort();
        customStack.print();
    }
}
