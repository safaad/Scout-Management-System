package Model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Observable;

public class Secretary extends Person{

    private String id,deanid;
    public Meeting createMeeting(String objective,String Date,ArrayList<Person> invities){
        Meeting m= new Meeting(objective,Date,this);

        return m;
    }

    public Secretary(){
        super();
    }
    public Secretary(String email, String fullname, String birthdate, String password, String phone, String id ,String deanid) {
        super(email, fullname, birthdate, password, phone);
        this.id=id;
        this.deanid=deanid;

    }

    public Secretary(String email, String fullname, String birthdate, String password, String phone, String id ) {
        super(email, fullname, birthdate, password, phone);
        this.deanid=id;

    }

    @Override
    public void accept(PersonVisitor pv) {

    }
}
