package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void shouldAddParents() {
        //arrange
        Person mother = new Person("Lisa", "Demo", "Female", 21);
        Person father = new Person("Mark", "Mother", "Male", 22);
        Person child = new Person("Bob", "de", "Bouwer", "Female", 3);
        //act
        child.addParents(mother, father);
        //assert
        assertEquals(child.getMother(), mother);
        assertEquals(child.getFather(), father);
    }

    @Test
    void shouldAddChild() {
        //arrange
        Person parent = new Person("Lisa", "Demo", "Female", 21);
        Person newChild = new Person("Jordy", "Bree", "Male", 28);
        //act
        parent.addChild(newChild);
        //assert
        assertTrue(parent.getChildren().contains(newChild));
    }

    @Test
    void shouldAddPetAndOwner() {
        //arrange
        Person dogOwner = new Person("Snoop", "Dog", "Male", 49);
        Pet snoopy = new Pet("Snoopy", 7, "bulldog");
        //act
        dogOwner.addPet(snoopy);
        snoopy.setOwner(dogOwner);
        //assert
        assertTrue(dogOwner.getPets().contains(snoopy));
        assertNotNull(snoopy.getOwner());
    }

    @Test
    void shouldAddSibling() {
        //arrange
        Person person1 = new Person("Kwik", "Duck", "Male", 14);
        Person person2 = new Person("Kwak", "Duck", "Female", 12);
        //act
        person1.addSiblings(person2);
        person2.addSiblings(person1);
        //assert
        assertEquals(person1.getLastName(), person2.getLastName());
    }

    @Test
    void shouldGetGrandchildren() {
        //arrange
        Person grandParent = new Person("Willem", "Defoe", "Male", 75);
        Person parent1 = new Person("Bob", "defoe", "Male", 44);
        Person parent2 = new Person("Selma", "hayek-defoe", "Female", 40);
        Person grandChild1 = new Person("Lesly", "defoe", "Male", 18);
        Person grandChild2 = new Person("Sammy", "defoe", "Female", 16);

        //act
        grandParent.addChild(parent1);
        grandParent.addChild(parent2);
        parent1.addChild(grandChild1);
        parent2.addChild(grandChild2);

        List<Person> grandChildren = grandParent.getGrandChildren();
        //assert
        assertEquals(grandChildren.size(), 2);
    }
}