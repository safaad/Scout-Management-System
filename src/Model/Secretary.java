package Model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Observable;

public class Secretary extends Person{
    public Meeting createMeeting(String objective,String Date,ArrayList<Person> invities){
        Meeting m= new Meeting(objective,Date,this);

        return m;
    }

    public Secretary(){
        super();
    }
    public Secretary(String email, String fullname, String birthdate, String nationality, String gender, String username, String password, String phone) {
        super(email, fullname, birthdate, nationality, gender, username, password, phone);
    }

    @Override
    public void accept(PersonVisitor pv) {

    }
}
