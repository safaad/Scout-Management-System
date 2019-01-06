package Model;
import java.util.ArrayList;

public class Dean extends Leaders{
    private ArrayList<Person> leaderList;
    private static Dean dean=null;

    public ArrayList<Person> getLeaderList() {
        return leaderList;
    }

    public void setLeaderList(ArrayList<Person> leaderList) {
        this.leaderList = leaderList;
    }


    public static Dean getDean() {
        return dean;
    }

    public static void setDean(Dean dean) {
        Dean.dean = dean;
    }

    private Dean(String email, String fullname, String birthdate, String password, String phone) {
        super(email, fullname, birthdate, password, phone,null);
        this.leaderList=new ArrayList<>();
    }

    private Dean(String email, String fullname, String birthdate, String password, String phone,String id) {
        super(email, fullname, birthdate, password, phone,id);
        this.leaderList=new ArrayList<>();

    }
    public static Dean getDean(String email, String fullname, String birthdate,String password, String phone ,String id) {
        if (dean == null) {
            dean = new Dean(email, fullname, birthdate, password, phone ,id);
        } else {
            System.out.println("already exists");

        }
        return dean;
    }
    public void addLeaderList(ArrayList<Person> leaderList) {
        for(Person l:leaderList){
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
    public Leaders createLeadersAccount(String email, String fullname, String birthdate, String password, String phone,String id){
        return new Leaders(email,fullname,birthdate,password,phone , id);
    }

    public Secretary createSecretaryAccount(String email, String fullname, String birthdate, String password, String phone){
        return new Secretary(email,fullname,birthdate,password,phone,getId());
    }

    @Override
    public void accept(PersonVisitor pv) {

    }
}
