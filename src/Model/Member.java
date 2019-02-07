package Model;

import javafx.geometry.Orientation;
import javafx.scene.control.ComboBox;
import org.controlsfx.control.Rating;

import java.util.Observable;

public class Member extends Person {
    private String rank;
    private int evaluation;
    private Leaders Leader;
    private String lid;
    private Rating rating=null;
    public Member(String email, String fullname, String birthdate, String password, String phone, String rank, String evaluation , Leaders leader,String mid) {
        super(email, fullname, birthdate, password, phone,mid);
        this.rank = rank;
        this.evaluation = Integer.parseInt(evaluation);
        this.Leader=leader;
        this.lid=leader.getId();
        rating = new Rating();
        rating.setUpdateOnHover(true);
        rating.setMax(5);
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(int evaluation) {
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
    public Rating getRating() {
        return rating;
    }

    @Override
    public void accept(PersonVisitor pv) {

    }
}
