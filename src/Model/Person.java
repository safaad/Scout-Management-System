package Model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public abstract class Person implements Observer {
    private String email;
    private String fullname;
    private String birthdate;//yyyy-mm-dd
    private String nationality;
    private String gender;
    private String username;
    private String password;
    private String phone;
    private ArrayList<Meeting> attendedMeetings;

    public Person() {
        this.email=null;
        this.fullname=null;
        this.birthdate=null;
        this.nationality=null;
        this.gender=null;
        this.username=null;
        this.password=null;
        this.phone=null;
        this.attendedMeetings=new ArrayList<Meeting>();
    }

    public Person(String email, String fullname, String birthdate, String nationality, String gender, String username, String password, String phone){
        this.email=email;
        this.fullname=fullname;
        this.birthdate=birthdate;
        this.nationality=nationality;
        this.gender=gender;
        this.username=username;
        this.password=password;
        this.phone=phone;
        this.attendedMeetings=new ArrayList<Meeting>();
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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getGender() {
        return gender;
    }

    public ArrayList<Meeting> getAttendedMeetings() {
        return attendedMeetings;
    }

    public void addAttendedMeetings(Meeting m) {
        this.attendedMeetings.add(m);
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    @Override
    public  void update(Observable o, Object arg) {
        attendedMeetings.add((Meeting)o);
    }

    public abstract void accept(PersonVisitor pv);
}
