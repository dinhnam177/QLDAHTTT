package domain;
import java.util.Date;
public class Donate {
    protected String card;
    protected String status;
    protected Date dateIn ;
    protected Date dateOut;

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public java.sql.Timestamp getdateIn(){
        this.dateIn = new Date();
        java.sql.Timestamp sqlTimeIn = new java.sql.Timestamp(dateIn.getTime());
        return sqlTimeIn;
    }
    public java.sql.Timestamp getdateOut(){
        this.dateOut = new Date();
        java.sql.Timestamp sqlTimeOut = new java.sql.Timestamp(dateOut.getTime());
        return sqlTimeOut;
    }
}
