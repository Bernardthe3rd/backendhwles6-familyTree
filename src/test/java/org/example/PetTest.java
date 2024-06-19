package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PetTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void getName() {
        //arrange
        Pet pet1 = new Pet("Snuf", 5, "Shepperd");
        //act
        pet1.getName();
        //assert
        assertEquals("Snuf", pet1.getName());
    }

    @Test
    void setName() {
        //arrange
        Pet pet2 = new Pet("Snuf", 5, "Shepperd");
        //act
        pet2.setName("Waffy");
        //assert
        assertEquals(pet2.getName(), "Waffy");
    }

    @Test
    void getAge() {
        //arrange
        Pet pet3 = new Pet("Snuf", 5, "Shepperd");
        //act
        pet3.getAge();
        //assert
        assertEquals(5, pet3.getAge());
    }

    @Test
    void setAge() {
        //arrange
        Pet pet4 = new Pet("Snuf", 5, "Shepperd");
        //act
        pet4.setAge(3);
        //assert
        assertEquals(pet4.getAge(), 3);
    }

    @Test
    void getSpecies() {
        //arrange
        Pet pet5 = new Pet("Snuf", 5, "Shepperd");
        //act
        pet5.getSpecies();
        //assert
        assertEquals("Shepperd", pet5.getSpecies());
    }

    @Test
    void setSpecies() {
        //arrange
        Pet pet6 = new Pet("Snuf", 5, "Shepperd");
        //act
        pet6.setSpecies("Golden Retriever");
        //assert
        assertEquals(pet6.getSpecies(), "Golden Retriever");
    }
}