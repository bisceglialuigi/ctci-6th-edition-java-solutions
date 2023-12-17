package Chapter3_StacksAndQueues.E6_AnimalShelter;

public class MyQueue {
    Animal top;
    Animal bottom;

    /*
        Time Complexity: O(1)
     */
    public void enqueue(Animal animal){
        if(top != null){
            bottom.next = animal;
            animal.previous = bottom;
        } else {
            top = animal;
        }
        bottom = animal;
    }


    /*
        Time Complexity: O(1)
     */
    public Animal dequeueAny(){
        if(bottom == null)
            return null;

        Animal animalDequeued = bottom;
        bottom = bottom.previous;
        bottom.next = null;
        return animalDequeued;
    }

    /*
        Time Complexity: O(n)
     */
    public Animal dequeDog(){
        return dequeueByType(Animals.DOG);
    }

    /*
        Time Complexity: O(n)
     */
    public Animal dequeCat(){
        return dequeueByType(Animals.CAT);
    }

    /*
        Time Complexity: O(n)
     */
    private Animal dequeueByType(Animals type){
        Animal current = bottom;
        Animal dequeued;
        while(current != null){
            if(current.type.equals(type)){
                dequeued = current;
                if(current.previous != null)
                    current.previous.next = current.next;
                if(current.next != null)
                    current.next.previous = current.previous;
                return dequeued;
            }
            current = current.previous;
        }
        return null;
    }

    /*
        Time Complexity: O(n)
     */
    public void print(){
        StringBuilder stringBuilder = new StringBuilder();
        Animal current = top;
        while(current != null){
            stringBuilder.append(current.toString());
            stringBuilder.append(", ");
            current = current.next;
        }
        System.out.println(stringBuilder);
    }

}
