package Chapter3_StacksAndQueues.E6_AnimalShelter;

public class AnimalShelter {
    /**
     *  An animal shelter, which holds only dogsa and cats, operates on a strictly "first in, first out" basis. People
     *  must adopt either the "oldest" (based on arrival time) of all animals at the shelter, or they can select whether
     *  they would prefer a dog or a cat (and will receive the oldest animal of that type). They cannot select which specific
     *  animal they would like. Create the data structure to maintain this system and implement operations such as
     *  enqueue, dequeueAny, dequeueDog, and dequeueCat. You may use the built-in LinkedList data structure.
     */

    public static void main(String[] args) {
        Animals[] animals = new Animals[]{
                Animals.DOG,
                Animals.CAT,
                Animals.DOG,
                Animals.DOG,
                Animals.CAT,
                Animals.CAT
        };

        MyQueue shelter = new MyQueue();
        for(Animals animal : animals){
            shelter.enqueue(new Animal(animal));
        }

        shelter.dequeDog();
        shelter.dequeDog();
        shelter.dequeCat();

        shelter.print();
    }
}
