package Model;

import javax.swing.*;
import javax.swing.plaf.metal.MetalMenuBarUI;
import java.util.ArrayList;
import java.util.Observable;

public class Leaders extends Person {

    private String id ;
    private ArrayList<Member> memberList;

    public Leaders(){
        super();
        this.memberList=new ArrayList<Member>();
    }
    public Leaders(String email, String fullname, String birthdate, String password, String phone ,String id ) {
        super(email, fullname, birthdate, password, phone);
        this.memberList=new ArrayList<Member>();
        this.id=id;
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
    public Member createMemberAccount(String email, String fullname, String birthdate, String password, String phone, String rank, String evaluation,Leaders leaders ){
        return new Member(email,fullname,birthdate,password,phone,rank,evaluation,this);
    }

    @Override
    public void accept(PersonVisitor pv) {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
