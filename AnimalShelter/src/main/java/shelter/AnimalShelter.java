package shelter;/*
    An animal shelter, which holds only dogs and cats, operates on a strictly "first in, first out" basis.
    People must adopt either the "oldest" based on arrival time of all animals at the shelter, or they can select
    whether they would prefer a dog or a cat (and will receive the oldest animal of that type)
    They cannot select which specific animal they would like. Create the data structures to maintain this system and
    implement operations such as enqueue , dequeueAny, dequeueDog  and dequeueCat.
    You may use built-in LinkedList data structure
 */
import animals.Animal;
import animals.Cat;
import animals.Dog;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class AnimalShelter {
    private Queue<Animal> animals;


    public AnimalShelter() {
        this.animals = new LinkedList<>();
    }

    public void enqueue(Dog animal) {
        this.animals.add(animal);
    }

    public void enqueue(Cat animal) {
        this.animals.add(animal);
    }

    public Animal dequeueAny() {
        return this.animals.poll();
    }

    public Animal dequeueDog() {
        Iterator<Animal> iterator = animals.iterator();
        while (iterator.hasNext()) {
            Animal animal = iterator.next();
            if (animal instanceof Dog) {
                this.animals.remove(animal);
                return animal;
            }
        }
        throw new EmptyStackException();
    }

    public Animal dequeueCat() {
        Iterator<Animal> iterator = animals.iterator();
        while (iterator.hasNext()) {
            Animal animal = iterator.next();
            if (animal instanceof Cat) {
                this.animals.remove(animal);
                return animal;
            }else{

            }
        }
        throw new EmptyStackException();
    }
}
