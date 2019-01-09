package Model;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Observable;
//import javax.mail.*;
//import javax.mail.internet.*;
//import javax.activation.*;
//import javax.mail.Session;
//import javax.mail.Transport;

public class Meeting extends Observable {
    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public ArrayList<Person> getInvities() {
        return invities;
    }

    public Secretary getSec() {
        return sec;
    }

    public void setSec(Secretary sec) {
        this.sec = sec;
    }

    private String objective;
    private String Date;
    private ArrayList<Person> invities;
    private Secretary sec;

    public Meeting(String objective, String date,Secretary s) {
        this.objective = objective;
        Date = date;
        sec=s;
        invities=new ArrayList<Person>();
    }

    public void setInvities(ArrayList<Person> p){
        invities=p;
    }
    private void sendEmail(Secretary sender, ArrayList<Person> invities){

    }
    public void invite(ArrayList<Person> persons){
        for(Person p:persons){
            this.addObserver(p);
        }
        setChanged();
        sendEmail(sec,invities);
        notifyObservers();
    }


}
