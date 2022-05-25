package sample;


import java.io.Serializable;

public class Passenger implements Serializable {
    private String fullName;
    private String seat;
    private int secondsInQueue;

    public String getFullName(){ //use to access get name of the objects
        return fullName;
    }

    public void setName(String fullName){ //use to set name to object
        this.fullName=fullName;
    }

    public int getSeconds(){
        return secondsInQueue;
    }

    public void setSecondsInQueue(int seconds){
        this.secondsInQueue=seconds;
    }

    public void setSeat(String seat){ //use to set seat number in object
        this.seat = seat;
    }

    public String getSeat(){ //use to access seat number of the objects
        return seat;
    }



}
