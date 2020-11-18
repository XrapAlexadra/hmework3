package com.github.xrapalexandra.model;

import com.github.xrapalexandra.Indexing;
import com.github.xrapalexandra.exception.AbiturientExceptoin;
import com.google.common.base.Objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Abiturient{

    private static final Indexing indexing = new Indexing();

    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private Address address;
    private String phoneNumber;
    private List<Integer> marks;

    public Abiturient() {
        id = indexing.getId();
    }

    public Abiturient(String surname, String name, String patronymic, List<Integer> marks) throws AbiturientExceptoin {
        isValidMarks(marks);
        id = indexing.getId();
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.marks = marks;
    }

    public Abiturient(String surname, String name, String patronymic, Address address, String phoneNumber, List<Integer> marks) throws AbiturientExceptoin {
        isValidMarks(marks);
        id = indexing.getId();
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    private void isValidMarks(List<Integer> marks) throws AbiturientExceptoin {
        for (Integer mark: marks){
            if(mark > 10 || mark < 1){
                throw new AbiturientExceptoin(mark + " is invalid mark!");
            }
        }
    }

    @Override
    public String toString() {
        return "Abiturient{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", address=" + address +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", marks=" + marks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Abiturient that = (Abiturient) o;
        return id == that.id &&
                Objects.equal(surname, that.surname) &&
                Objects.equal(name, that.name) &&
                Objects.equal(patronymic, that.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, surname, name, patronymic);
    }
}
