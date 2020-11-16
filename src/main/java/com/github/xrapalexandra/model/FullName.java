package com.github.xrapalexandra.model;

import java.util.Objects;

public class FullName {

    private String surname;
    private String name;
    private String patronymic;

    public FullName() {
    }

    public FullName(String surname, String name, String patronymic) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
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

    @Override
    public String toString() {
        return  surname + '\'' +
                " " + name + '\'' +
                " " + patronymic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FullName fullName = (FullName) o;
        return surname.equalsIgnoreCase(fullName.surname) &&
                name.equalsIgnoreCase(fullName.name) &&
                patronymic.equalsIgnoreCase(fullName.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, patronymic);
    }
}

