package Model;

import java.util.Observable;

public class Member extends Person {
    private String rank;
    private String evaluation;
    private String mid;
    private Leaders Leader;

    public Member(){
        super();
        this.rank=null;
        this.evaluation=null;
        this.Leader=null;
        this.mid=null;
    }
    public Member(String email, String fullname, String birthdate, String password, String phone, String rank, String evaluation ) {
        super(email, fullname, birthdate, password, phone);
        this.rank = rank;
        this.evaluation = evaluation;
    }
    public Member(String email, String fullname, String birthdate, String password, String phone, String rank, String evaluation , Leaders leader) {
        super(email, fullname, birthdate, password, phone);
        this.rank = rank;
        this.evaluation = evaluation;
        this.Leader=leader;
    }

    public Member(String email, String fullname, String birthdate, String password, String phone, String rank, String evaluation , String mid, Leaders leader) {
        super(email, fullname, birthdate, password, phone);
        this.rank = rank;
        this.evaluation = evaluation;
        this.Leader=leader;
        this.mid=mid;
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

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public Leaders getLeader() {
        return Leader;
    }

    public void setLeader(Leaders leader) {
        Leader = leader;
    }

    @Override
    public void accept(PersonVisitor pv) {

    }
}
