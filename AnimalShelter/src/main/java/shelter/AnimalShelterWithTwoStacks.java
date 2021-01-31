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

import java.util.*;

public class AnimalShelterWithTwoStacks {

    private Queue<ShelteredAnimal> dogs;
    private Queue<ShelteredAnimal> cats;
    //using only the date, doesn't work for several insertions in same millisecond
    private Integer order;

    public AnimalShelterWithTwoStacks() {
        this.cats = new LinkedList<>();
        this.dogs = new LinkedList<>();
        this. order = 0;
    }

    public void enqueue(Dog animal) {
        this.dogs.add(new ShelteredAnimal(animal, new Date(),order++));
    }

    public void enqueue(Cat animal) {
        this.cats.add(new ShelteredAnimal(animal, new Date(),order++));
    }

    public Animal dequeueAny() {
        return getOldestAdmittedAnimal();
    }

    private Animal getOldestAdmittedAnimal() {
        if (dogs.isEmpty() && cats.isEmpty()) {
            throw new EmptyStackException();
        }

        if (dogs.isEmpty()) {
            return cats.poll().getAnimal();
        } else if (cats.isEmpty()) {
            return dogs.poll().getAnimal();
        }
        ShelteredAnimal oldestDog = dogs.peek();
        ShelteredAnimal oldestCat = cats.peek();
        if (oldestCat.getAdmissionNumber() > oldestDog.getAdmissionNumber()) {
            return dogs.poll().getAnimal();
        } else {
            return cats.poll().getAnimal();
        }

    }

    public Dog dequeueDog() {
        if (dogs.isEmpty()) {
            throw new EmptyStackException();
        }
        return (Dog) dogs.poll().getAnimal();
    }

    public Cat dequeueCat() {
        if (cats.isEmpty()) {
            throw new EmptyStackException();
        }
        return (Cat) cats.poll().getAnimal();
    }
}
