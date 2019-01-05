package Model;
import java.util.ArrayList;

public class Dean extends Leaders{
    private ArrayList<Leaders> leaderList;
    private ArrayList<Secretary> secretaryList;
    private static Dean dean=null;
    private static String id ;

    private Dean(String email, String fullname, String birthdate, String password, String phone) {
        super(email, fullname, birthdate, password, phone);
        this.leaderList=new ArrayList<Leaders>();
        this.secretaryList=new ArrayList<Secretary>();
        id=null;

    }

    private Dean(String email, String fullname, String birthdate, String password, String phone,String id) {
        super(email, fullname, birthdate, password, phone);
        this.leaderList=new ArrayList<Leaders>();
        this.secretaryList=new ArrayList<Secretary>();
        this.id =id;

    }
    public static Dean getDean(String email, String fullname, String birthdate,String password, String phone ,String id) {
        if (dean == null) {
            dean = new Dean(email, fullname, birthdate, password, phone ,id);
        } else {
            System.out.println("already exists");

        }
        return dean;
    }
    public void addLeaderList(ArrayList<Leaders> leaderList) {
        for(Leaders l:leaderList){
            this.leaderList.add(l);
        }
    }
    public boolean removeLeader(Leaders l){
        if(leaderList.contains(l) && l!=null){
            leaderList.remove(l);
            return true;
        }
        return false;
    }
    public Leaders createLeadersAccount(String email, String fullname, String birthdate, String password, String phone){
        return new Leaders(email,fullname,birthdate,password,phone);
    }

    public void addSecretaryList(ArrayList<Secretary> secretaryList) {
        for(Secretary l:secretaryList){
            this.secretaryList.add(l);
        }
    }
    public boolean removeSecretary(Secretary l){
        if(secretaryList.contains(l) && l!=null){
            secretaryList.remove(l);
            return true;
        }
        return false;
    }
    public Secretary createSecretaryAccount(String email, String fullname, String birthdate, String nationality, String gender, String username, String password, String phone){
        return new Secretary(email,fullname,birthdate,nationality,gender,username,password,phone);
    }

    @Override
    public void accept(PersonVisitor pv) {

    }
}
