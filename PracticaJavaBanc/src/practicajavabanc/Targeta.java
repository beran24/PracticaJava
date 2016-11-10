/**
 * @author Carlos Rodero, Esteve Cabrera, Mario Recamales
 */
import java.util.Date;


public class Targeta {
    protected double numeroTarjeta;
    protected Date dataCaducitat;
    protected int cvc;
    protected int pin;
    protected CompteBancari compte;


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

}
