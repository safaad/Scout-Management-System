package Model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public abstract class Person implements Observer {
    private ArrayList<Message> inbox;
    private String email;
    private String fullname;
    private String birthdate;//yyyy-mm-dd
    private String password;
    private String phone;
    private ArrayList<Meeting> attendedMeetings;
    private String id;
    public Person() {
        this.email=null;
        this.fullname=null;
        this.birthdate=null;
        this.password=null;
        this.phone=null;
        this.attendedMeetings=new ArrayList<Meeting>();
    }

    public Person(String email, String fullname, String birthdate, String password, String phone,String id){
        this.id=id;
        this.email=email;
        this.fullname=fullname;
        this.birthdate=birthdate;
        this.password=password;
        this.phone=phone;
        this.attendedMeetings=new ArrayList<Meeting>();
        this.inbox=new ArrayList<Message>();
    }

    public ArrayList<Message> getInbox() {
        return inbox;
    }
    public void addToInbox(Message m){
        this.inbox.add(m);
    }

    public void setInbox(ArrayList<Message> inbox) {
        this.inbox = inbox;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public ArrayList<Meeting> getAttendedMeetings() {
        return attendedMeetings;
    }

    public void addAttendedMeetings(Meeting m) {
        this.attendedMeetings.add(m);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public  void update(Observable o, Object arg) {
        attendedMeetings.add((Meeting)o);
        Message m=(Message)arg;
        m.setTo(this.email);
        this.addToInbox(m);
    }

    public abstract void accept(PersonVisitor pv);
}
