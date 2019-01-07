package Model;

public class Item {

    private String id;
    private String name;
    private String quntity;


    public Item(String id ,String name,String quntity){
        this.id=id;
        this.name=name;
        this.quntity=quntity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuntity() {
        return quntity;
    }

    public void setQuntity(String quntity) {
        this.quntity = quntity;
    }


}
