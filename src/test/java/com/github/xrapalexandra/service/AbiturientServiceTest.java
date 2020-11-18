package com.github.xrapalexandra.service;

import com.github.xrapalexandra.exception.AbiturientExceptoin;
import com.github.xrapalexandra.model.Abiturient;
import com.github.xrapalexandra.model.AbiturientList;
import com.github.xrapalexandra.model.Address;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class AbiturientServiceTest extends Assert {

    private AbiturientService abiturientService = new AbiturientService();
    private AbiturientList abiturientList = new AbiturientList();

    @BeforeClass
    public void setUp() throws AbiturientExceptoin {
        List<Integer> marks1 = Arrays.asList(10, 9, 8, 7);
        Address address1 = new Address("Минск", "Ленина", "12а");
        Abiturient abiturient1 = new Abiturient(
                "Петров", "Алексей", "Иванович",
                address1, "+375295554455", marks1
        );
        List<Integer> marks2 = Arrays.asList(4, 10, 7, 7);
        Address address2 = new Address("Витебск", "Молодежная", "25");
        Abiturient abiturient2 = new Abiturient(
                "Иванов", "Сергей", "Петрович",
                address2, "+375295553322", marks2
        );
        List<Integer> marks3 = Arrays.asList(6, 9, 8, 7);
        Address address3 = new Address("Гродно", "Революции", "14");
        Abiturient abiturient3 = new Abiturient(
                "Солнцева", "Дарья", "Сергеевна",
                address3, "+375295551122", marks3
        );
        List<Integer> marks4 = Arrays.asList(6, 6, 6, 6);
        Abiturient abiturient4 = new Abiturient(
                "Денисова", "Светлана", "Артемовна", marks1
        );

        abiturientList.add(abiturient1);
        abiturientList.add(abiturient2);
        abiturientList.add(abiturient3);
        abiturientList.add(abiturient4);
    }

    @Test
    public void testFindAllWithFailingGrades() {
        List<Abiturient> rightAbiturients = new ArrayList<>();
        rightAbiturients.add(abiturientList.getAbiturientByIndex(1));

        List<Abiturient> actual = rightAbiturients;
        List<Abiturient> expected = abiturientService.findAllWithFailingGrades(abiturientList);

        assertEquals(actual, expected);
    }

    @Test
    public void testHasAbiturientFailingGradeTrue() {
        Abiturient abiturient = abiturientList.getAbiturientByIndex(1);

        boolean expected = abiturientService.hasAbiturientFailingGrade(abiturient);

        assertTrue(expected);
    }

    @Test
    public void testHasAbiturientFailingGradeFalse() {
        Abiturient abiturient = abiturientList.getAbiturientByIndex(0);

        boolean expected = abiturientService.hasAbiturientFailingGrade(abiturient);

        assertFalse(expected);
    }

    @Test
    public void testFindAllWithMarksSumMoreThanGiven() {
        int number =  30;

        List<Abiturient> rightAbiturients = new ArrayList<>();
        rightAbiturients.add(abiturientList.getAbiturientByIndex(0));
        rightAbiturients.add(abiturientList.getAbiturientByIndex(3));

        List<Abiturient> actual = rightAbiturients;
        List<Abiturient> expected = abiturientService.findAllWithMarksSumMoreThanGiven(abiturientList, number);

        assertEquals(actual, expected);
    }
}