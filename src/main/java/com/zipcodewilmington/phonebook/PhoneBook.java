package com.zipcodewilmington.phonebook;

import java.util.*;
import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;
    }

    public PhoneBook() {
        this.phonebook = new HashMap<>();
    }

    public void add(String name, String phoneNumber) {
        List<String> manyPhoneNumber = new ArrayList<>();
        manyPhoneNumber.add(phoneNumber);
        phonebook.put(name, manyPhoneNumber);
    }

    public void addAll(String name, String... phoneNumbers) {
        List<String> manyPhoneNumber = Arrays.asList(phoneNumbers);
        phonebook.put(name, manyPhoneNumber);
    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasNameEntry(String name) {
        return phonebook.containsKey(name);
    }

    public Boolean hasEntry(String name, String phoneNumber) {
        return phonebook.containsKey(name) && phonebook.get(name).contains(phoneNumber);
    }
    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        for (Map.Entry<String,List<String>> x: phonebook.entrySet()){
            if(x.getValue().contains(phoneNumber)){
                return x.getKey();
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        List<String> contactNames = new ArrayList<>();
        for(String key: phonebook.keySet()){
            contactNames.add(key);
        }
        return contactNames;
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
