package Chapter3_StacksAndQueues.E5_SortStack;

import Chapter3_StacksAndQueues.utils.MyStack;

public class CustomStack {
    MyStack firstStack;
    MyStack secondStack;
    int tempSlot;

    public CustomStack(Integer[] values){
        firstStack = new MyStack();
        for(int i=0; i<values.length; i++){
            firstStack.push(values[i]);
        }
        secondStack = new MyStack();
    }

    /*
        Time Complexity: O(n^2)
        Space Complexity: O(n)
     */
    public void sort(){
        while(!firstStack.isEmpty()){
            tempSlot = firstStack.pop();
            while(secondStack.peek() != null && tempSlot > secondStack.peek()){
                firstStack.push(secondStack.pop());
            }
            secondStack.push(tempSlot);
        }
    }

    public void print(){
        secondStack.print();
    }

}
