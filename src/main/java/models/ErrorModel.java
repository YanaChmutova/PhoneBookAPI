package models;

public class ErrorModel {

    int status;
    String error;
    Object message;

    public ErrorModel status(int status){
        this.status=status;
        return this;
    }
    public ErrorModel error(String error){
        this.error=error;
        return this;
    }
    public  ErrorModel message(Object message){
        this.message=message;
        return  this;
    }

    public ErrorModel(int status, String error, Object message) {
        this.status = status;
        this.error = error;
        this.message = message;
    }

    @Override
    public String toString() {
        return "ErrorModel{" +
                "status=" + status +
                ", error='" + error + '\'' +
                ", message=" + message +
                '}';
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }
}