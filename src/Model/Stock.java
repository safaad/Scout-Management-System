package Model;

public class Stock {
    private String itid,iname,quantity;

    public Stock(String itid, String iname, String quantity) {
        this.itid = itid;
        this.iname = iname;
        this.quantity = quantity;
    }

    public String getItid() {
        return itid;
    }

    public void setItid(String itid) {
        this.itid = itid;
    }

    public String getIname() {
        return iname;
    }

    public void setIname(String iname) {
        this.iname = iname;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
