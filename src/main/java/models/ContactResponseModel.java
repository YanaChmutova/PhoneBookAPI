package models;

public class ContactResponseModel {
    String message;

    public ContactResponseModel(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ContactResponseModel{" +
                "message='" + message + '\'' +
                '}';
    }
}