package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DataBaseModel {

    public static void Fill (ArrayList<Member> Members, ArrayList<Leaders> Leaders , ArrayList<Item> Item , ArrayList<Meeting> Meeting, ArrayList<Secretary> Secretary) throws Exception{
        Connection con = DataBaseConnection.getConnection();
        String qury ="select * from Person where deanid = pid";
        PreparedStatement preparedStmt = con.prepareStatement(qury);
        ResultSet resultSet = preparedStmt.executeQuery();
        while(resultSet.next()){
            String email = resultSet.getString("email");
            String name = resultSet.getString("pname");
            String phone = resultSet.getString("phone");
            String birthdate = resultSet.getString("birthdate");
            String pid = resultSet.getString("pid");
            String pass = resultSet.getString("pass");
            Dean.getDean(email,name,birthdate,pass,phone,pid);
            DataBaseConnection.ID=pid;
        }

        qury ="select * from Person where deanid <> pid";
        preparedStmt = con.prepareStatement(qury);
        resultSet = preparedStmt.executeQuery();
        while(resultSet.next()){
            String email = resultSet.getString("email");
            String name = resultSet.getString("pname");
            String phone = resultSet.getString("phone");
            String birthdate = resultSet.getString("birthdate");
            String pid = resultSet.getString("pid");
            String pass = resultSet.getString("pass");
            String deanid = resultSet.getString("deanid");
            String type = resultSet.getString("type");
            if(type.equals("Leader")){
                Leaders person=(Leaders) BuilderPerson.buildPerson(Dean.getDean(),type,email, name,birthdate,pass, phone, pid);
                Dean.getDean().addLeaderList(person);
                Leaders.add(person);
                System.out.println(pid+person.getId());
            }
            else{
                Secretary person=(Secretary) BuilderPerson.buildPerson(Dean.getDean(),type,email, name,birthdate,pass, phone, pid);
                Dean.getDean().addSecretayList(person);
                Secretary.add(person);
            }
        }
        Dean.getDean().setLeaderList(Leaders);
        Dean.getDean().setSecretaryList(Secretary);

        qury ="select * from Members";
        preparedStmt = con.prepareStatement(qury);
        resultSet = preparedStmt.executeQuery();
        while(resultSet.next()){
            String email = resultSet.getString("email");
            String name = resultSet.getString("mname");
            String phone = resultSet.getString("phone");
            String rank = resultSet.getString("rank");
            String birthdate = resultSet.getString("birthdate");
            String mid = resultSet.getString("mid");
            String pass = resultSet.getString("pass");
            String evaluation = resultSet.getString("evaluation");
            String lid = resultSet.getString("lid");
            Member m=BuilderPerson.buildMember(findLeader(lid ,Leaders) , email, name,  birthdate,  pass,  phone,  rank,evaluation,mid);
            System.out.println(m.getId());
            Members.add(m);
        }

        qury ="select * from Items";
        preparedStmt = con.prepareStatement(qury);
        resultSet = preparedStmt.executeQuery();
        while(resultSet.next()){
            String id = resultSet.getString("itid");
            String name = resultSet.getString("iname");
            String quantity = resultSet.getString("quantity");
            Item.add(new Item(id,name,quantity));
        }

        qury="select * from Meeting";
        preparedStmt=con.prepareStatement(qury);
        resultSet=preparedStmt.executeQuery();
        while(resultSet.next()){
            String meid=resultSet.getString("meid");
            String obj=resultSet.getString("objective");
            String date=resultSet.getString("mdate");
            Model.Secretary S = null;

            String query="select * from AttendMeetings where meid= "+meid+"";
            preparedStmt = con.prepareStatement(query);
            ResultSet rs = preparedStmt.executeQuery();
            Meeting.add(new Meeting(meid,obj,date,S));
            ArrayList<Person> P=new ArrayList<>();
            while(rs.next()){
                String pid = rs.getString("pid");
                String sid = rs.getString("sid");
                for(int i=0;i<Secretary.size();i++){
                    if(Secretary.get(i).getId().equals(sid)){
                        S=Secretary.get(i);
                        S.addAttendedMeetings(Meeting.get(Meeting.size()-1));
                        return;
                    }
                }
                for(int j=0;j<Leaders.size();j++) {
                    if (Leaders.get(j).getId().equals(pid)) {
                        P.add(Leaders.get(j));
                        Leaders.get(j).addAttendedMeetings(Meeting.get(Meeting.size()-1));
                        return;
                    }
                }
            }
            Meeting.get(Meeting.size()-1).setInvities(P);

        }

    }
    public static Person findPerson(String pid ,ArrayList<Secretary> Secretary , ArrayList<Leaders> Leaders){
        if(pid.equals(Dean.getDean().getId()))
            return Dean.getDean();
        for(Secretary s:Secretary)
            if(pid.equals(s.getId()))
                return s;
        for(Model.Leaders l:Leaders)
            if(pid.equals(l.getId()))
                return l;
        return null;
    }

    public static Leaders findLeader(String mid ,ArrayList<Leaders> Leaders){
        for(int i=0;i<Leaders.size();i++){
            if(Leaders.get(i).getId().equals(mid)){
                return Leaders.get(i);
            }
        }
        return null;
    }
    public static Model.Member findMember(String mid , ArrayList<Member>Members){
        for(Member m:Members)
            if(mid.equals(m.getId()))
                return m;
        return null;
    }
}
