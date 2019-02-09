package Model;


import java.util.ArrayList;
import java.util.Observable;


public class Meeting extends Observable {
    private String objective;
    private String Date;
    private ArrayList<Person> invities;
    private Secretary sec;
    private String meid;
    public Meeting(String objective, String date,Secretary s) {
        this.objective = objective;
        Date = date;
        sec=s;
        invities=new ArrayList<Person>();
    }
    public Meeting(String meid,String objective, String date,Secretary s) {
        this.objective = objective;
        Date = date;
        sec=s;
        invities=new ArrayList<Person>();
        this.meid=meid;
    }
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


    public void setInvities(ArrayList<Person> p){
        invities=p;
    }

    public void invite(ArrayList<Person> persons,String subject){
        for(Person p:persons){
            this.addObserver(p);
        }
        Message m=new Message(this.sec.getEmail(),subject);
        setChanged();
        notifyObservers(m);
    }

    public String getMeid() {
        return meid;
    }

    public void setMeid(String meid) {
        this.meid = meid;
    }
}
