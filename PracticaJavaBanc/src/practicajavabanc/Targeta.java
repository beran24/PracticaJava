package practicajavabanc;
/**
 * Created by mario 9/11/16.
 */
import java.util.Date;

public class Targeta {
    private double numeroTarjeta;
    private Date dataCaducitat;
    private int cvc;
    private int pin;

    //CompteBancari compte = new CompteBancari(iban, Client, saldoinicial);

    public Targeta (double numeroTarjeta, int pin, Date dataCaducitat, int cvc ){
        
        this.numeroTarjeta=numeroTarjeta;
        this.dataCaducitat=dataCaducitat;
        this.cvc=cvc;
    }
    public double getNumT(){
        return numeroTarjeta;
    }
    public Date getDataC(){
        return dataCaducitat;
    }
    public int getCvc(){
        return cvc;
    }
    public int getPin(){
        return pin;
    }
    public void setNumT(double numeroTarjeta){
        this.numeroTarjeta = numeroTarjeta;
    }
    public void setdDataC(Date dataCaducitat){
        this.dataCaducitat = dataCaducitat;
    }
    public void setCvc(int cvc){
        this.cvc = cvc;
    }
    public void setPin(int pin){
        this.pin = pin;
    }
}
