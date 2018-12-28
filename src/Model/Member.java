package Model;

import java.util.Observable;

public class Member extends Person {
    private String rank;
    private String evaluation;

    public Member(){
        super();
        this.rank=null;
        this.evaluation=null;
    }
    public Member(String email, String fullname, String birthdate, String nationality, String gender, String username, String password, String phone, String rank, String evaluation) {
        super(email, fullname, birthdate, nationality, gender, username, password, phone);
        this.rank = rank;
        this.evaluation = evaluation;
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

    @Override
    public void accept(PersonVisitor pv) {

    }
}
