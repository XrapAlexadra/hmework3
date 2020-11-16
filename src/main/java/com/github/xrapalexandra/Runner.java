package com.github.xrapalexandra;

import com.github.xrapalexandra.model.Abiturient;
import com.github.xrapalexandra.model.FullName;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    private final static AbiturientListCreator creator = new AbiturientListCreator();

    public static void main(String[] args) {
        List<FullName> fullNameList = new ArrayList<>();
        fullNameList.add(new FullName("Иванов", "Петр", "Анатольевич"));
        fullNameList.add(new FullName("Петрова", "Ольга", "Ивановна"));
        fullNameList.add(new FullName("Сидоров", "Илья", "Сергеевич"));
        fullNameList.add(new FullName("Иванова", "Дарья", "Петровна"));

        List<Abiturient> abiturients = creator.createAbiturientList(fullNameList, 3);

        AbiturientList abiturientList = new AbiturientList(abiturients);

        printList(abiturientList.getAbiturients());
        System.out.println();
        printList(abiturientList.findAllWithFailingGrades());
        System.out.println();
        printList(abiturientList.findAllWithMarksSumMoreThanGiven(20));
    }

    private static void printList(List<Abiturient> abiturients) {
        for (Abiturient abiturient : abiturients) {
            System.out.println(abiturient);
        }
    }
}
