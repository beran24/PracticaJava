package practicajavabanc;
/**
 * Created by mario 9/11/16.
 */
import static java.lang.Math.abs;
import java.util.Date;
import java.util.Random;


public class Targeta {
    protected long numeroTarjeta;
    protected Date dataCaducitat;
    protected int cvc;
    protected int pin;
    protected CompteBancari compte;

    public Targeta(CompteBancari compte ){
        Random randomGenerator = new Random();
        this.numeroTarjeta=(((randomGenerator.nextInt(8)+1)*1000)+abs(randomGenerator.nextLong())%999)*10000*10000*10000+(abs(randomGenerator.nextLong())%(10000*10000));
        dataCaducitat=new Date();
        dataCaducitat= new Date(dataCaducitat.getTime()+ (31536*1000*1000));
        this.pin=((randomGenerator.nextInt(8)+1)*1000)+((randomGenerator.nextInt(9))*100)+((randomGenerator.nextInt(9))*10)+(randomGenerator.nextInt(9));
        this.cvc=((randomGenerator.nextInt(8)+1)*100)+((randomGenerator.nextInt(9))*10)+(randomGenerator.nextInt(9));
        this.compte=compte;
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
