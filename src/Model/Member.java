package Model;

import javafx.scene.control.ComboBox;

import java.util.Observable;

public class Member extends Person {
    private String rank;
    private String evaluation;
    private Leaders Leader;
    private String lid;
//    public Member(String email, String fullname, String birthdate, String password, String phone, String rank, String evaluation , Leaders leader,String mid,String combo) {
//        super(email, fullname, birthdate, password, phone,mid);
//        this.rank = rank;
//        this.evaluation = evaluation;
//        this.Leader=leader;
//        this.comboBox=new ComboBox<String>();
//    }
    public Member(String email, String fullname, String birthdate, String password, String phone, String rank, String evaluation , Leaders leader,String mid) {
        super(email, fullname, birthdate, password, phone,mid);
        this.rank = rank;
        this.evaluation = evaluation;
        this.Leader=leader;
        this.lid=leader.getId();
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }


    public Leaders getLeader() {
        return Leader;
    }

    public void setLeader(Leaders leader) {
        Leader = leader;
    }

    public String getLid() {
        return lid;
    }

    public void setLid(String lid) {
        this.lid = lid;
    }
    //
//    public ComboBox<String> getComboBox() {
//        comboBox=new ComboBox<>();
//        comboBox.getItems().addAll("0","1","2","3","4","5");
//        return comboBox;
//    }

    @Override
    public void accept(PersonVisitor pv) {

    }
}
