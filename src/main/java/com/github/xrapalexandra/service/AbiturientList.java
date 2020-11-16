package com.github.xrapalexandra.service;

import com.github.xrapalexandra.model.Abiturient;

import java.util.*;

public class AbiturientList {

    private static final int MIN_GOOD_MARK = 6;

    private List<Abiturient> abiturients;

    public AbiturientList(List<Abiturient> abiturients) {
        this.abiturients = abiturients;
    }


    public List<Abiturient> findAllWithFailingGrades() {
        List<Abiturient> rightAbiturients = new ArrayList<>();

        for (Abiturient abiturient : abiturients) {
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

    public List<Abiturient> findAllWithMarksSumMoreThanGiven(int minMarkSum) {
        List<Abiturient> rightAbiturients = new ArrayList<>();

        for (Abiturient abiturient : abiturients) {
            if (abiturient.getMarksSum() > minMarkSum) {
                rightAbiturients.add(abiturient);
            }
        }
        return rightAbiturients;
    }

    public List<Abiturient> getAbiturients() {
        return new ArrayList<>(abiturients);
    }
}
