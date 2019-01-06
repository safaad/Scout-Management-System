package Model;

import com.sun.xml.internal.ws.api.model.MEP;

import java.util.HashMap;

public class PersonFactory {
    private static HashMap<String,Person> hm=new HashMap<String,Person>();
    public static Person getPerson(Dean dean,String type,String email, String fullname, String birthdate, String pass ,String phone ,String id){
        Person person = null;
        if(hm.containsKey(type)){
            return hm.get(type);
        }
        else{
            if(type.equalsIgnoreCase("Leader")){
                person=dean.createLeadersAccount(email,fullname,birthdate,pass,phone,id);
            }
            else{
                    if(type.equalsIgnoreCase("Secretary"))
                        person =dean.createSecretaryAccount(email,fullname,birthdate,phone,id);
                }
            }
            hm.put(type,person);

        return person;
    }
    public static Member getMember(Leaders l,String email, String fullname, String birthdate, String password, String phone, String rank, String evaluation){
        Member m= null;
        if(hm.containsKey("member")) {
            return (Member) hm.get("member");
        }
        m=l.createMemberAccount(email,fullname,birthdate,password,phone,rank,evaluation,l);
        hm.put("member",m);
        return m;
    }

}
