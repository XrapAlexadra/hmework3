package com.github.xrapalexandra.runner;

import com.github.xrapalexandra.exception.AbiturientExceptoin;
import com.github.xrapalexandra.model.Abiturient;
import com.github.xrapalexandra.model.Address;
import com.github.xrapalexandra.model.ContactInfo;
import com.github.xrapalexandra.model.FullName;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AbiturientListCreator {

    private static final String[] STREETS = {"Ангарская", "Ленина", "Победы", "Революции", "Молодежная", "Машерова"};
    private static final String[] CITIES = {"Минск", "Брест", "Витебск", "Гродно", "Могилев", "Гомель"};
    private static final Integer BUILDING_COUNT = 100;
    private static final Integer MAX_PHONE_NUMBER = 9999999;
    private static final Integer MIN_PHONE_NUMBER = 1000000;
    private static final Integer MAX_MARK = 10;

    private final Random random = new Random();

    public List<Abiturient> createAbiturientList(List<FullName> fullNameList, int markNumber) {
        List<Address> addressList = createAddressList(fullNameList.size());
        List<ContactInfo> contactInfoList = createContactInfoList(addressList);
        List<Abiturient> abiturientList = new ArrayList<>();
        for (int i = 0; i < fullNameList.size(); i++) {
            try {
                abiturientList.add(new Abiturient(fullNameList.get(i), contactInfoList.get(i), createMarksList(markNumber)));
            } catch (AbiturientExceptoin ignored) {
            }
        }
        return abiturientList;
    }

    private List<ContactInfo> createContactInfoList(List<Address> addressList) {
        List<ContactInfo> contactInfoList = new ArrayList<>();
        for (Address address : addressList) {
            int phone = MIN_PHONE_NUMBER + random.nextInt(MAX_PHONE_NUMBER - MIN_PHONE_NUMBER);
            String phoneNumber = "37529" + phone;
            try {
                contactInfoList.add(new ContactInfo(address, phoneNumber));
            } catch (AbiturientExceptoin e) {
                contactInfoList.add(null);
            }
        }
        return contactInfoList;
    }

    private List<Integer> createMarksList(int number) {
        List<Integer> markList = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            markList.add(1 + random.nextInt(MAX_MARK));
        }
        return markList;
    }

    private List<Address> createAddressList(int number) {
        List<Address> addressList = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            String city = CITIES[random.nextInt(CITIES.length - 1)];
            String street = STREETS[random.nextInt(STREETS.length - 1)];
            String building = String.valueOf(random.nextInt(BUILDING_COUNT));
            addressList.add(new Address(city, street, building));
        }
        return addressList;
    }

}
