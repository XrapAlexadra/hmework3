package com.github.xrapalexandra.model;

import java.util.ArrayList;
import java.util.List;

public class AbiturientList {

    private List<Abiturient> abiturients;

    public AbiturientList() {
        this.abiturients = new ArrayList<>();
    }

    public AbiturientList(List<Abiturient> abiturients) {
        this.abiturients = abiturients;
    }

    public void setAbiturients(List<Abiturient> abiturients) {
        this.abiturients = abiturients;
    }

    public List<Abiturient> getAbiturients() {
        return new ArrayList<>(abiturients);
    }

    public Abiturient getAbiturientByIndex(int index){
        return abiturients.get(index);
    }

    public void add(Abiturient abiturient){
        abiturients.add(abiturient);
    }

    @Override
    public String toString() {
        return "AbiturientList{" +
                "abiturients=" + abiturients +
                '}';
    }

}
