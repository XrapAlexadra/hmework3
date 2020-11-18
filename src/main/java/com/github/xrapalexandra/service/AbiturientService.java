package com.github.xrapalexandra.service;

import com.github.xrapalexandra.model.Abiturient;
import com.github.xrapalexandra.model.AbiturientList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AbiturientService {

    private static final int MIN_GOOD_MARK = 6;

    public List<Abiturient> findAllWithFailingGrades(AbiturientList abiturients) {
        List<Abiturient> rightAbiturients = new ArrayList<>();

        for (Abiturient abiturient : abiturients.getAbiturients()) {
            if (hasAbiturientFailingGrade(abiturient)) {
                rightAbiturients.add(abiturient);
            }
        }
        return rightAbiturients;
    }

    public boolean hasAbiturientFailingGrade(Abiturient abiturient) {
        List<Integer> marks = abiturient.getMarks();
        Optional<Integer> failingGrade = marks.stream()
                .filter(x -> x < MIN_GOOD_MARK)
                .findAny();
        return failingGrade.isPresent();
    }

    public List<Abiturient> findAllWithMarksSumMoreThanGiven(AbiturientList abiturients, int minMarkSum) {
        List<Abiturient> rightAbiturients = new ArrayList<>();

        for (Abiturient abiturient : abiturients.getAbiturients()) {
            if (abiturient.getMarksSum() > minMarkSum) {
                rightAbiturients.add(abiturient);
            }
        }
        return rightAbiturients;
    }
}
