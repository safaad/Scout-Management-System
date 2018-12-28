package Model;

import javax.swing.*;
import javax.swing.plaf.metal.MetalMenuBarUI;
import java.util.ArrayList;
import java.util.Observable;

public class Leaders extends Person {
    private ArrayList<Member> memberList;

    public Leaders(){
        super();
        this.memberList=new ArrayList<Member>();
    }
    public Leaders(String email, String fullname, String birthdate, String nationality, String gender, String username, String password, String phone) {
        super(email, fullname, birthdate, nationality, gender, username, password, phone);
        this.memberList=new ArrayList<Member>();
    }

    public ArrayList<Member> getMemberList() {
        return memberList;
    }

    public void addMemberList(ArrayList<Member> memberList) {
        for(Member m:memberList){
            this.memberList.add(m);
        }
    }
    public boolean removeMember(Member m){
        if(memberList.contains(m) && m!=null){
            memberList.remove(m);
            return true;
        }
        return false;
    }
    public Member createMemberAccount(String email, String fullname, String birthdate, String nationality, String gender, String username, String password, String phone, String rank, String evaluation){
        return new Member(email,fullname,birthdate,nationality,gender,username,password,phone,rank,evaluation);
    }

    @Override
    public void accept(PersonVisitor pv) {

    }
}
