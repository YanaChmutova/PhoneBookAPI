package models;

public class ContactModel {

    private String id;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String description;

    public ContactModel id(String id) {
        this.id = id;
        return this;
    }
    public ContactModel name(String name) {
        this.name = name;
        return this;
    }

    public ContactModel lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ContactModel email(String email) {
        this.email = email;
        return this;
    }
    public ContactModel phone(String phone) {
        this.phone = phone;
        return this;
    }
    public ContactModel address(String address) {
        this.address = address;
        return this;
    }
    public ContactModel description(String description) {
        this.description = description;
        return this;
    }


    public ContactModel(String id, String name, String lastName, String email, String phone, String address, String description) {

        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}