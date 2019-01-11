package Model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Observable;

public class Secretary extends Person{

    private String deanid;

    public Secretary(String email, String fullname, String birthdate, String password, String phone, String id ,String deanid) {
        super(email, fullname, birthdate, password, phone,id);
        this.deanid=deanid;

    }

    public String getDeanid() {
        return deanid;
    }

    public void setDeanid(String deanid) {
        this.deanid = deanid;
    }

    public Meeting createMeeting(String objective,String Date,ArrayList<Person> invities){
        Meeting m= new Meeting(objective,Date,this);

        return m;
    }
    @Override
    public void accept(PersonVisitor pv) {

    }

}
