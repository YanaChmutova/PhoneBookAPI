package models;

import java.util.List;

public class ContactListModel {
    private List<ContactModel> contacts;

    public List<ContactModel> getContacts(){
        return contacts;
    }
    public ContactListModel contacts(){
        this.contacts=contacts;
        return this;
    }

    @Override
    public String toString() {
        return "ContactListModel{" +
                "contacts=" + contacts +
                '}';
    }
}