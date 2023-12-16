package Chapter3_StacksAndQueues.E1_ThreeInOne;

public class ThreeInOne {

    /**
     *  Describe how you could use a single array to implement three stacks.
     *
     *  My assumptions:
     *      - fixed size stacks
     */
    public static void main(String[] args) throws Exception {

        int STACK_SIZES = 3;

        ThreeInOne threeInOne = new ThreeInOne(STACK_SIZES);

        threeInOne.push(0,1);
        threeInOne.push(0,2);
        threeInOne.push(0,3);

        threeInOne.push(1,4);
        threeInOne.push(1,5);
        threeInOne.push(1,6);

        threeInOne.push(2,7);
        threeInOne.push(2,8);
        threeInOne.push(2,9);

        threeInOne.printArray();

        threeInOne.pop(0);
        threeInOne.pop(0);
        threeInOne.pop(0);

        threeInOne.pop(1);
        threeInOne.pop(1);
        threeInOne.pop(1);

        threeInOne.pop(2);
        threeInOne.pop(2);
        threeInOne.pop(2);
    }

    final int STACKS_NUMBER = 3;
    int[] stackArray;
    int[] topPointers;
    int[] firstElementPointers;
    int[] lastElementPointers;

    public ThreeInOne(int stackSize){
        stackArray = new int[stackSize * STACKS_NUMBER];
        initializeTopPointers();
        initializeFirstElementPointers();
        initializeLastElementPointers();
    }

    private void initializeTopPointers(){
        topPointers = new int[STACKS_NUMBER];
        for(int i=0; i<STACKS_NUMBER; i++){
            topPointers[i] = i * (STACKS_NUMBER);
        }
    }

    private void initializeFirstElementPointers(){
        firstElementPointers = new int[STACKS_NUMBER];
        for(int i=0; i<STACKS_NUMBER; i++){
            firstElementPointers[i] = i * (STACKS_NUMBER);
        }
    }

    private void initializeLastElementPointers(){
        lastElementPointers = new int[STACKS_NUMBER];
        for(int i=0; i<STACKS_NUMBER; i++){
            lastElementPointers[i] = firstElementPointers[i] + STACKS_NUMBER - 1;
        }
    }

    /*
        Time Complexity: O(1)
     */
    public void push(int stackNumber, int data) throws Exception {
        if(topPointers[stackNumber] == lastElementPointers[stackNumber] + 1){
            throw new Exception();
        }

        stackArray[topPointers[stackNumber]] = data;
        topPointers[stackNumber]++;
    }

    /*
        Time Complexity: O(1)
     */
    public int pop(int stackNumber) throws Exception {
        if(topPointers[stackNumber] == firstElementPointers[stackNumber] - 1){
            throw new Exception();
        }

        topPointers[stackNumber]--;
        int popElement = stackArray[topPointers[stackNumber]];
        System.out.print("Popped: " + popElement + "\n");

        return popElement;
    }

    /*
        Time Complexity: O(1)
     */
    public int peek(int stackNumber){
        return stackArray[topPointers[stackNumber]];
    }

    void printArray(){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<stackArray.length; i++){
            stringBuilder.append(stackArray[i]);
            stringBuilder.append(", ");
        }
        stringBuilder.append("\n");
        System.out.print(stringBuilder);
    }
}
