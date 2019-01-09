package Driver;

import Model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.plaf.metal.MetalMenuBarUI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Main extends Application {

    public static ArrayList<Member> Members = new ArrayList<Member>();
    public static ArrayList<Leaders> Leaders = new ArrayList<Leaders>();
    public static ArrayList<Secretary> Secretary = new ArrayList<Secretary>();
    public static ArrayList<Item> Item = new ArrayList<Item>();
    public static ArrayList<Meeting> Meetings=new ArrayList<Meeting>();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/Login.fxml"));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        try {
            Fill(Members, Leaders, Item);
            for(int i=0 ;i<Leaders.size();i++){
                System.out.println(Leaders.get(i).getId());
            }
            for(int i=0 ;i<Secretary.size();i++){
                System.out.println(Secretary.get(i).getId());
            }
        }catch (Exception e){
            System.out.println("Error while reading from the database");
        }
        launch(args);
    }

    public static void Fill (ArrayList<Member> Member, ArrayList<Leaders> Leader ,ArrayList<Item> Item) throws Exception{
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
            if(type.equals("Leader"))
                Leaders.add((Leaders) PersonFactory.getPerson(Dean.getDean(),type,email, name,birthdate,pass, phone, pid));
            else
                Secretary.add((Secretary) PersonFactory.getPerson(Dean.getDean(),type,email, name,birthdate,pass, phone, pid));
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
            Members.add(PersonFactory.getMember(findLeader(lid) , email, name,  birthdate,  pass,  phone,  rank, evaluation,mid));
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
            String query="select * from attendmeetings where meid ="+meid;
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet res=ps.executeQuery();
            ArrayList<Person> invitees=new ArrayList<Person>();
            String sid=res.getString("sid");
            Secretary sec=null;
            for(Secretary s : Main.Secretary)
                if(s.getId().equals(sid))
                    sec=s;

            while(res.next()){
                String pid=res.getString("pid");
                boolean f1=false;
                if(Dean.getDean().getId().equals(pid))
                    invitees.add(Dean.getDean());
                for(Leaders l:Main.Leaders){
                    if(l.getId().equals(pid)){
                        invitees.add(l);
                        f1=true;
                        break;
                    }
                }
                if(!f1){
                    for(Secretary s : Main.Secretary)
                        if(s.getId().equals(pid))
                            invitees.add(s);

                }
                f1=false;
                Meeting m=new Meeting(obj,date,sec);

                Main.Meetings.add(m);
                m.setInvities(invitees);
            }
        }

    }


    public static Leaders findLeader(String mid ){
        for(int i=0;i<Leaders.size();i++){
            if(Leaders.get(i).getId().equals(mid)){
                return Leaders.get(i);
            }
        }
        return null;
    }
}
