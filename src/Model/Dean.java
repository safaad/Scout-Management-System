package Model;
import java.util.ArrayList;

public class Dean extends Leaders{
    private ArrayList<Leaders> leaderList;
    private ArrayList<Secretary> SecretaryList;

    public ArrayList<Secretary> getSecretaryList() {
        return SecretaryList;
    }

    public void setSecretaryList(ArrayList<Secretary> secretaryList) {
        SecretaryList = secretaryList;
    }

    private static Dean dean=null;

    public ArrayList<Leaders> getLeaderList() {
        return leaderList;
    }

    public void setLeaderList(ArrayList<Leaders> leaderList) {
        this.leaderList = leaderList;
    }


    public static Dean getDean() {
        return dean;
    }

    public static void setDean(Dean dean) {
        Dean.dean = dean;
    }

    private Dean(String email, String fullname, String birthdate, String password, String phone,String id) {
        super(email, fullname, birthdate, password, phone,"1000","1000");
        this.leaderList=new ArrayList<Leaders>();
        this.SecretaryList=new ArrayList<Secretary>();
    }
    public static Dean getDean(String email, String fullname, String birthdate,String password, String phone,String id) {
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

    public void addSecretaryList(ArrayList<Secretary> leaderList) {
        for(Secretary l:leaderList){
            this.SecretaryList.add(l);
        }
    }
    public boolean removeSecretary(Secretary l){
        if(SecretaryList.contains(l) && l!=null){
            SecretaryList.remove(l);
            return true;
        }
        return false;
    }
    public  void addLeaderList(Leaders person){
        this.leaderList.add(person);
    }

    public  void addSecretayList(Secretary person){
        this.SecretaryList.add(person);
    }
    public Leaders createLeadersAccount(String email, String fullname, String birthdate, String password, String phone,String id){
        Leaders leader= new Leaders(email,fullname,birthdate,password,phone , id,this.getId());
        this.addLeaderList(leader);
        return leader;
    }

    public Secretary createSecretaryAccount(String email, String fullname, String birthdate, String password, String phone ,String id){
        Secretary sec = new Secretary(email,fullname,birthdate,password,phone,id,this.getId());
        this.addSecretayList(sec);
        return sec;
    }

    @Override
    public void accept(PersonVisitor pv) {

    }
}
