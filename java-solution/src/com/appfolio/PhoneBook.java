package com.appfolio;

import java.util.HashMap;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-08-24
 **/
public class PhoneBook {
    HashMap<String, ContactInfo> map;
    HashMap<String, String> relationMap;

    public PhoneBook() {
        this.map = new HashMap<>();
        this.relationMap = new HashMap<>();
    }

    public void addContact(String name, String number) {
        ContactInfo contactInfo = new ContactInfo(number, name);
        map.put(number, contactInfo);
        relationMap.put(name, number);
    }

    public ContactInfo findByNumber(String number) {
        return map.getOrDefault(number, null);
    }

    public ContactInfo findByName(String name) {
        String number = relationMap.getOrDefault(name, null);
        return number == null ? null : findByNumber(number);
    }

    public boolean deleteByNumver(String number) {
        ContactInfo info = map.remove(number);
        if (info == null) return false;
        relationMap.remove(info.name);
        return true;
    }

    public static class ContactInfo {
        private String number;
        private String name;
        // some other information. email.birthday

        public ContactInfo(String number, String name) {
            this.number = number;
            this.name = name;
        }
    }

}
