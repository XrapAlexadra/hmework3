package com.github.xrapalexandra.model;

import com.github.xrapalexandra.exception.AbiturientExceptoin;

import java.util.Objects;

public class ContactInfo {

    private Address address;
    private String phoneNumber;

    public ContactInfo() {
    }

    public ContactInfo(Address address, String phoneNumber) throws AbiturientExceptoin {
        isValidPhoneNumber(phoneNumber);
        this.address = address;
        this.phoneNumber = phoneNumber;
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

    public void setPhoneNumber(String phoneNumber) throws AbiturientExceptoin {
        isValidPhoneNumber(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    private void isValidPhoneNumber(String phoneNumber) throws AbiturientExceptoin {
        if (!phoneNumber.trim().matches("[0-9]{12}")) {
            throw new AbiturientExceptoin("Phone number is invalid!");
        }
    }

    @Override
    public String toString() {
        return "ContactInfo: " + address + ", " + phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactInfo that = (ContactInfo) o;
        return address.equals(that.address) &&
                phoneNumber.equalsIgnoreCase(that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, phoneNumber);
    }
}
