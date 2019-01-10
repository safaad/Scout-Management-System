package Model;

import com.sun.xml.internal.ws.api.model.MEP;

import java.util.HashMap;

public class PersonFactory {
    public static HashMap<String,Person> hm=new HashMap<String,Person>();
    public static Person getPerson(Dean dean,String type,String email, String fullname, String birthdate, String pass ,String phone ,String id){
        Person person = null;
        if(hm.containsKey(type)){
            person=hm.get(type);
            //person.setBirthdate();
            return hm.get(type);
        }
        else{
            if(type.equalsIgnoreCase("Leader")){
                 hm.put("Leader",dean.createLeadersAccount(email,fullname,birthdate,pass,phone,id));
                 return hm.get(type);
            }
            else{
                    if(type.equalsIgnoreCase("Secretary")) {
                        hm.put("Secretary", dean.createSecretaryAccount(email, fullname, birthdate,pass ,phone, id));
                        return hm.get(type);
                    }
                }
            }


        return person;
    }

    public static Member getMember(Leaders l,String email, String fullname, String birthdate, String password, String phone, String rank, String evaluation,String mid){
        Member m= null;
        if(hm.containsKey("member")) {
            return (Member) hm.get("member");
        }
        m=l.createMemberAccount(email,fullname,birthdate,password,phone,rank,evaluation,mid,l);
        hm.put("member",m);
        return m;
    }

}
