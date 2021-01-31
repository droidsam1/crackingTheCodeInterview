import animals.Cat;
import animals.Dog;
import org.junit.jupiter.api.Test;
import shelter.AnimalShelter;
import shelter.AnimalShelterWithTwoStacks;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class AnimalShelterWithTwoStacksTest {

    @Test
    void enqueue_should_add_animals() {
        AnimalShelterWithTwoStacks shelter = new AnimalShelterWithTwoStacks();
        shelter.enqueue(new Cat("cat1"));
        shelter.enqueue(new Cat("cat2"));
        shelter.enqueue(new Cat("cat3"));
        shelter.enqueue(new Cat("cat4"));

        shelter.enqueue(new Dog("dog1"));
        shelter.enqueue(new Dog("dog2"));
        shelter.enqueue(new Dog("dog3"));

    }


    @Test
    void dequeueAny_should_return_any_animal() {
        AnimalShelterWithTwoStacks shelter = new AnimalShelterWithTwoStacks();
        shelter.enqueue(new Cat("cat1"));
        shelter.enqueue(new Dog("cat2"));
        shelter.enqueue(new Cat("cat3"));

        assertNotNull(shelter.dequeueAny());
        assertNotNull(shelter.dequeueAny());
        assertNotNull(shelter.dequeueAny());
    }


    @Test
    void dequeueAny_should_return_any_animal_in_order() {
        AnimalShelterWithTwoStacks shelter = new AnimalShelterWithTwoStacks();
        shelter.enqueue(new Cat("cat1"));
        shelter.enqueue(new Dog("dog1"));
        shelter.enqueue(new Cat("cat2"));

        assertEquals("cat1", shelter.dequeueAny().getName());
        assertEquals("dog1", shelter.dequeueAny().getName());
        assertEquals("cat2", shelter.dequeueAny().getName());
    }


    @Test
    void dequeueDog_should_return_dogs_only() {
        AnimalShelterWithTwoStacks shelter = new AnimalShelterWithTwoStacks();
        shelter.enqueue(new Cat("cat1"));
        shelter.enqueue(new Dog("dog1"));
        shelter.enqueue(new Cat("cat2"));
        shelter.enqueue(new Dog("dog2"));

        assertEquals(Dog.class, shelter.dequeueDog().getClass());
        assertEquals(Dog.class, shelter.dequeueDog().getClass());
    }

    @Test
    void dequeueCat_should_return_oldest_dog() {
        AnimalShelterWithTwoStacks shelter = new AnimalShelterWithTwoStacks();
        shelter.enqueue(new Cat("cat1"));
        shelter.enqueue(new Dog("dog1"));
        shelter.enqueue(new Cat("cat2"));
        shelter.enqueue(new Dog("dog2"));

        assertEquals("dog1", shelter.dequeueDog().getName());
        assertEquals("dog2", shelter.dequeueDog().getName());
    }


    @Test
    void dequeueDog_should_return_throw_exception_if_empty() {
        AnimalShelterWithTwoStacks shelter = new AnimalShelterWithTwoStacks();
        shelter.enqueue(new Dog("dog1"));

        assertEquals(Dog.class, shelter.dequeueDog().getClass());
        assertThrows(EmptyStackException.class, shelter::dequeueDog);
    }

    @Test
    void dequeueCat_should_return_cats_only() {
        AnimalShelterWithTwoStacks shelter = new AnimalShelterWithTwoStacks();
        shelter.enqueue(new Cat("cat1"));
        shelter.enqueue(new Dog("dog1"));
        shelter.enqueue(new Cat("cat2"));

        assertEquals(Cat.class, shelter.dequeueCat().getClass());
        assertEquals(Cat.class, shelter.dequeueCat().getClass());
    }

    @Test
    void dequeueCat_should_return_oldest_cat() {
        AnimalShelterWithTwoStacks shelter = new AnimalShelterWithTwoStacks();
        shelter.enqueue(new Cat("cat1"));
        shelter.enqueue(new Dog("dog1"));
        shelter.enqueue(new Cat("cat2"));

        assertEquals("cat1", shelter.dequeueCat().getName());
        assertEquals("cat2", shelter.dequeueCat().getName());
    }


    @Test
    void dequeueCat_should_return_throw_exception_if_empty() {
        AnimalShelterWithTwoStacks shelter = new AnimalShelterWithTwoStacks();
        shelter.enqueue(new Cat("cat1"));

        assertEquals(Cat.class, shelter.dequeueCat().getClass());
        assertThrows(EmptyStackException.class, shelter::dequeueCat);
    }



    @Test
    void mixed_dequeues_should_return_adequate_type() {
        AnimalShelterWithTwoStacks shelter = new AnimalShelterWithTwoStacks();
        shelter.enqueue(new Cat("cat1"));
        shelter.enqueue(new Dog("dog1"));
        shelter.enqueue(new Cat("cat2"));
        shelter.enqueue(new Dog("dog2"));

        assertEquals(Dog.class, shelter.dequeueDog().getClass());
        assertEquals(Cat.class, shelter.dequeueCat().getClass());
        assertEquals(Cat.class, shelter.dequeueAny().getClass());
        assertEquals(Dog.class, shelter.dequeueAny().getClass());
    }


}