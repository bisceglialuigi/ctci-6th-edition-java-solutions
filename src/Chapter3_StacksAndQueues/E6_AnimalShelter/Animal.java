package Chapter3_StacksAndQueues.E6_AnimalShelter;

public class Animal {
    Animal previous;
    Animal next;
    Animals type;

    public Animal(Animals type){
        this.type = type;
    }


    public String toString(){
        return this.type.toString();
    }
}
