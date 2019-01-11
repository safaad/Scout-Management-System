package Model;

import javax.swing.*;
import javax.swing.plaf.metal.MetalMenuBarUI;
import java.util.ArrayList;
import java.util.Observable;

public class Leaders extends Person {
    private ArrayList<Member> memberList;
    private String deanid;
    public Leaders(){
        super();
        this.memberList=new ArrayList<Member>();
    }
    public Leaders(String email, String fullname, String birthdate, String password, String phone ,String id,String deanid ) {
        super(email, fullname, birthdate, password, phone,id);
        this.deanid=deanid;
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
    public Member createMemberAccount(String email, String fullname, String birthdate, String password, String phone, String rank,String mid ){
        Member m= new Member(email,fullname,birthdate,password,phone,rank,this,mid);
        this.memberList.add(m);
        return m;
    }

    public String getDeanid() {
        return deanid;
    }

    public void setDeanid(String deanid) {
        this.deanid = deanid;
    }

    public void setMemberList(ArrayList<Member> memberList) {
        this.memberList = memberList;
    }

    @Override
    public void accept(PersonVisitor pv) {

    }
}
