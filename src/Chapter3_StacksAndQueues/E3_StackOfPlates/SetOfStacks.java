package Chapter3_StacksAndQueues.E3_StackOfPlates;

import java.util.HashMap;

public class SetOfStacks {
    HashMap<Integer, CustomStack> setOfStacks;
    int currentStackIndex;
    int capacity;

    SetOfStacks(int capacity){
        setOfStacks = new HashMap<>();
        currentStackIndex = 0;
        setOfStacks.put(currentStackIndex, new CustomStack());
        this.capacity = capacity;
    }

    /*
        Time Complexity: O(1)
     */
    void push(int data){
        CustomStack currentStack = setOfStacks.get(currentStackIndex);
        currentStack.push(data);
        if(currentStack.size == capacity){
            addStack();
        }
    }

    /*
        Time Complexity: O(1)
     */
    int pop(){
        CustomStack currentStack = setOfStacks.get(currentStackIndex);
        int data = currentStack.pop();

        if(currentStack.size == 0){
            removeStack();
        }

        return data;
    }

    /*
        FOLLOW UP
        Time Complexity: O(1)
     */
    public int popAt(int stackIndex) throws Exception {
        if(stackIndex > currentStackIndex || stackIndex < currentStackIndex){
            throw new Exception();
        }
        return setOfStacks.get(stackIndex).pop();
    }

    private void addStack(){
        currentStackIndex++;
        setOfStacks.put(currentStackIndex, new CustomStack());
    }

    private void removeStack(){
        if(currentStackIndex > 0){
            setOfStacks.put(currentStackIndex, new CustomStack());
            currentStackIndex--;
        }
    }


}
