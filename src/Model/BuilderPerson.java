package Model;

import com.sun.xml.internal.ws.api.model.MEP;

import java.util.HashMap;

public class BuilderPerson {


    public static Person buildPerson(Dean dean, String type, String email, String fullname, String birthdate, String pass, String phone, String id) {

        if (type.equalsIgnoreCase("Dean")) {
            return Dean.getDean();
        }
            if (type.equalsIgnoreCase("Leader"))
                return dean.createLeadersAccount(email, fullname, birthdate, pass, phone, id);
            if(type.equalsIgnoreCase("Secretary"))
                return dean.createSecretaryAccount(email, fullname, birthdate, pass, phone, id);

            return null;
        }


    public static Member buildMember(Leaders l, String email, String fullname, String birthdate, String password, String phone, String rank,String evaluation, String mid) {
        Member m = null;
        m = l.createMemberAccount(email, fullname, birthdate, password, phone, rank,evaluation, mid);
        return m;
    }

}
