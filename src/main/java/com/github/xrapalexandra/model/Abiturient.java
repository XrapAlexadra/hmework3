package com.github.xrapalexandra.model;

import com.github.xrapalexandra.exception.AbiturientExceptoin;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Abiturient implements Comparable<Abiturient> {

    private static Integer count = 0;

    private Integer id;
    private FullName fullName;
    private ContactInfo contactInfo;
    private List<Integer> marks;

    {
        id = count++;
    }

    public Abiturient() {
    }

    public Abiturient(FullName fullName, List<Integer> marks) throws AbiturientExceptoin {
        isValidMarks(marks);
        this.fullName = fullName;
        this.marks = marks;
    }

    public Abiturient(FullName fullName, ContactInfo contactInfo, List<Integer> marks) throws AbiturientExceptoin {
        isValidMarks(marks);
        this.fullName = fullName;
        this.contactInfo = contactInfo;
        this.marks = marks;
    }

    private void isValidMarks(List<Integer> marks) throws AbiturientExceptoin {
        for (Integer mark : marks) {
            if (mark == null ||mark < 1 || mark > 10){
                throw new AbiturientExceptoin("Marks is invalid!");
            }
        }
    }

    public Integer getId() {
        return id;
    }

    public FullName getFullName() {
        return fullName;
    }

    public void setFullName(FullName fullName) {
        this.fullName = fullName;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public List<Integer> getMarks() {
        return new ArrayList<>(marks);
    }

    public void setMarks(List<Integer> marks) throws AbiturientExceptoin {
        isValidMarks(marks);
        this.marks = marks;
    }

    public int getMarksSum() {
        Optional<Integer> markSum = marks.stream().reduce(Integer::sum);
        return markSum.orElse(0);
    }

    @Override
    public String toString() {
        return "Abiturient{" +
                "id=" + id +
                ", " + fullName +
                ", " + contactInfo +
                ", marks=" + marks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Abiturient that = (Abiturient) o;
        return id.equals(that.id) &&
                fullName.equals(that.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName);
    }

    @Override
    public int compareTo(Abiturient abiturient) {
        return abiturient.getMarksSum() - this.getMarksSum();
    }
}
