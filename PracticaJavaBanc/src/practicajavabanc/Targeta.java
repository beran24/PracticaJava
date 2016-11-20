//package practicajavabanc;
/**
 * @author Carlos Rodero, Esteve Cabrera, Mario Recamales
 */
import static java.lang.Math.abs;
import java.util.Date;
import java.util.Random;

public class Targeta implements Comparable<Targeta>{
    /**
     * Classe Targeta. En aquesta classe implementem la interfície Comparable per definir el mètode compareTo.
     * Atributs de la classe Targeta:
     * protected long numeroTarjeta;
     * protected Date dataCaducitat;
     * protected int cvc;
     * protected int pin;
     * protected CompteBancari compte;
     */
    //Atributs
    protected long numeroTarjeta;
    protected Date dataCaducitat;
    protected int cvc;
    protected int pin;
    protected CompteBancari compte;

    //Constructor
    /**
     * Constructor de la classe Targeta
     * @param compte rep un objecte CompteBancari.
     * Definim quin és el número de la targeta, el pin i el cvc (codi de seguretat) amb un número aleatori.
     * Definim la dataCaducitat de la targeta.
     */
    public Targeta(CompteBancari compte ){
        Random randomGenerator = new Random();
        this.numeroTarjeta=(((randomGenerator.nextInt(8)+1)*1000)+abs(randomGenerator.nextLong())%999)*10000*10000*10000+(abs(randomGenerator.nextLong())%(10000*10000));
        dataCaducitat=new Date();
        dataCaducitat= new Date(dataCaducitat.getTime()+ (31536*1000*1000));
        this.pin=((randomGenerator.nextInt(8)+1)*1000)+((randomGenerator.nextInt(9))*100)+((randomGenerator.nextInt(9))*10)+(randomGenerator.nextInt(9));
        this.cvc=((randomGenerator.nextInt(8)+1)*100)+((randomGenerator.nextInt(9))*10)+(randomGenerator.nextInt(9));
        this.compte=compte;
    }
    //Mètodes públics
    /**
     *Getter NumT
     * @return el número de la targeta
     */
    public double getNumT(){
        return numeroTarjeta;
    }
    /**
     *Getter DataC
     * @return la data de caducitat de la targeta
     */
    public Date getDataC(){
        return dataCaducitat;
    }
    /**
     *Getter NumCvc
     * @return el número de seguretat (cvc) de la targeta
     */
    public int getCvc(){
        return cvc;
    }
    /**
     *Getter Pin
     * @return el pin de la targeta
     */
    public int getPin(){
        return pin;
    }
    /**
     *Getter NumT
     * @return el número de la targeta
     */

    /**
     * Override del mètode compareTo. Ens permet comparar les dates de caducitat de les targetes
     * @param o rep un objecte Tarjeta
     * @return si les dates de caducitat de les targetes són iguals (return 0) o són diferents (return diferent de 0)
     */
    @Override
    public int compareTo(Targeta o) {
        return dataCaducitat.compareTo(o.dataCaducitat);
    }
}