package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
        assertNotEquals(person1.getSiblings(), person2.getSiblings());
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

    //Test voor bonusopdracht1
    @Test
    void shouldGetPetsFromGrandchildren() {
        //arrange
        Person grandParent = new Person("Willem", "Defoe", "Male", 75);
        Person parent1 = new Person("Bob", "defoe", "Male", 44);
        Person grandChild1 = new Person("Lesly", "defoe", "Male", 18);
        Pet snoopy = new Pet("Snoopy", 7, "bulldog");

        //act
        grandParent.addChild(parent1);
        parent1.addChild(grandChild1);
        grandChild1.addPet(snoopy);

        List<Pet> petsFromGrandchildren = grandParent.getPetsFromGrandchildren();

        //assert
        assertEquals(petsFromGrandchildren.size(), 1);
    }

    //Below are the tests for all the getters and setters from the Person class.
    @Test
    void shouldGetName() {
        //arrange
        Person person = new Person("Getty", "Thierry", "Female", 21);
        //act
        person.getName();
        //assert
        assertEquals("Getty", person.getName());
    }

    @Test
    void shouldSetName() {
        //arrange
        Person person = new Person("Getty", "Thierry", "Female", 21);
        //act
        person.setName("Henriette");
        //assert
        assertEquals("Henriette", person.getName());
    }

    @Test
    void shouldGetMiddleName() {
        //arrange
        Person person = new Person("Getty", "Petty", "Thierry", "Female", 21);
        //act
        person.getMiddleName();
        //assert
        assertEquals("Petty", person.getMiddleName());
    }

    @Test
    void shouldSetMiddleName() {
        //arrange
        Person person = new Person("Getty", "Petty", "Thierry", "Female", 21);
        //act
        person.setMiddleName("Verpetty");
        //assert
        assertEquals("Verpetty", person.getMiddleName());
    }

    @Test
    void shouldGetLastName() {
        //arrange
        Person person = new Person("Getty", "Thierry", "Female", 21);
        //act
        person.getLastName();
        //assert
        assertEquals("Thierry", person.getLastName());
    }

    @Test
    void shouldSetLastName() {
        //arrange
        Person person = new Person("Getty", "Thierry", "Female", 21);
        //act
        person.setLastName("Fury");
        //assert
        assertEquals("Fury", person.getLastName());
    }

    @Test
    void shouldGetSex() {
        //arrange
        Person person = new Person("Getty", "Thierry", "Female", 21);
        //act
        person.getSex();
        //assert
        assertEquals("Female", person.getSex());
    }

    @Test
    void shouldSetSex() {
        //arrange
        Person person = new Person("Getty", "Thierry", "Female", 21);
        //act
        person.setSex("Male");
        //assert
        assertEquals("Male", person.getSex());
    }

    @Test
    void shouldGetAge() {
        //arrange
        Person person = new Person("Getty", "Thierry", "Female", 21);
        //act
        person.getAge();
        //assert
        assertEquals(21, person.getAge());
    }

    @Test
    void shouldSetAge() {
        //arrange
        Person person = new Person("Getty", "Thierry", "Female", 21);
        //act
        person.setAge(44);
        //assert
        assertEquals(44, person.getAge());
    }

    @Test
    void shouldGetMother() {
        //arrange
        Person person = new Person("Getty", "Thierry", "Female", 21);
        //act
        person.getAge();
        //assert
        assertEquals(21, person.getAge());
    }

    @Test
    void shouldSetMother() {
        //arrange
        Person mother = new Person("Getty", "Thierry", "Female", 29);
        Person child = new Person("Jordy", "Defoe", "Male", 2);
        //act
        child.setMother(mother);
        //assert
        assertEquals(child.getMother(), mother);
    }

    @Test
    void shouldSetFather() {
        //arrange
        Person father = new Person("Willem", "Defoe", "Male", 40);
        Person child = new Person("Jordy", "Defoe", "Female", 12);
        //act
        child.setFather(father);
        //assert
        assertEquals(child.getFather(), father);
    }

    @Test
    void shouldSetSiblings() { //deze test kan denk ik beter!
        //arrange
        List<Person> siblings = new ArrayList<>();
        Person sibling1 = new Person("Kwik", "Duck", "Male", 14);
        Person sibling2 = new Person("Kwak", "Duck", "Female", 12);
        //act
        siblings.add(sibling1);
        siblings.add(sibling2);

        sibling1.setSiblings(siblings);
        sibling2.setSiblings(siblings);

        //assert
        assertEquals(siblings.size(), 2);
    }

    @Test
    void shouldSetChildren() {
        //arrange
        List<Person> children = new ArrayList<>();
        Person parent = new Person("Getty", "Defoe", "Male", 30);
        Person child = new Person("Jordy", "Defoe", "Female", 3);
        Person child2 = new Person("Wimmy", "Defoe", "Male", 2);
        //act
        children.add(child);
        children.add(child2);

        parent.setChildren(children);
        //asset
        assertEquals(children.size(), 2);
    }

    @Test
    void shouldSetPets() {
        //arrange
        List<Pet> pets = new ArrayList<>();
        Person owner = new Person("Willem", "Defoe", "Male", 30);
        Pet dog = new Pet("Goofy", 8, "wild dog");
        Pet cat = new Pet("Toofy", 5, "wild cat");
        //act
        pets.add(dog);
        pets.add(cat);

        owner.setPets(pets);
        //assert
        assertEquals(pets.size(), 2);
    }
}