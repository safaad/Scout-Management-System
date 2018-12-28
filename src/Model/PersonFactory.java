package Model;

import com.sun.xml.internal.ws.api.model.MEP;

import java.util.HashMap;

public class PersonFactory {
    private static HashMap<String,Person> hm=new HashMap<String,Person>();
    public static Person getPerson(Dean dean,String type,String email, String fullname, String birthdate, String nationality, String gender, String username, String password, String phone){
        Person person = null;
        if(hm.containsKey(type)){
            return hm.get(type);
        }
        else{
            if(type.equalsIgnoreCase("Leader")){
                person=dean.createLeadersAccount(email,fullname,birthdate,nationality,gender,username,password,phone);
            }
            else{
                    if(type.equalsIgnoreCase("Secretary"))
                        person =dean.createSecretaryAccount(email,fullname,birthdate,nationality,gender,username,password,phone);
                }
            }
            hm.put(type,person);

        return person;
    }
    public static Member getMember(Leaders l,String email, String fullname, String birthdate, String nationality, String gender, String username, String password, String phone, String rank, String evaluation){
        Member m= null;
        if(hm.containsKey("member")) {
            return (Member) hm.get("member");
        }
        m=l.createMemberAccount(email,fullname,birthdate,nationality,gender,username,password,phone,rank,evaluation);
        hm.put("member",m);
        return m;
    }

}
