package Model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Observable;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.mail.Session;
import javax.mail.Transport;
public class Meeting extends Observable {
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
