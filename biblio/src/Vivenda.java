//package practicajavabanc;
/**
 * @author Carlos Rodero, Esteve Cabrera, Mario Recamales
 */
import java.util.Date;


public class Vivenda extends CompteBancari {
    /**
     * Classe Vivenda, hereta de la classe CompteBancari. Override de mètode ingressarDiners.
     * Atributs de la classe Nomina:
     * protected int tipusInteres;
     * protected Date dataCaducitat;
     */

    //Atributs
    protected int tipusInteres=3;
    protected Date dataCaducitat;

    //Constructor
    /**
     * Constructor de la classe Vivenda
     * @param iban rep IBAN de Vivenda
     * @param saldo rep saldo de Vivenda
     * @param propietari rep objecte Client
     * dataCaducitat retorna una nova data de caducitat, que és la que quan es crea el compte vivenda més 3 anys.
     *
     */
    public Vivenda(String iban, double saldo, Client propietari) {
        super(iban, saldo, propietari);
        this.dataCaducitat = new Date();
        dataCaducitat=new Date(this.dataCaducitat.getTime()+ 92275200*1000);
    }
    //Mètodes públics

    /**
     * Getter tipusInterés.
     * @return el tipus d'interés del compte Vivenda
     */
    public int getTipusInteres() {
        return tipusInteres;
    }

    /**
     * Setter tipusInterés. Estableix el tipus d'interés del compte Vivenda.
     * @param tipusInteres
     */
    public void setTipusInteres(int tipusInteres) {
        this.tipusInteres = tipusInteres;
    }

    /**
     * Getter dataCaducitat.
     * @return la data de caducitat de la vivenda
     */
    public Date getDataCaducitat() {
        return dataCaducitat;
    }

    /**
     * Mètode ingressarDiners. Augmenta el saldo del compte Vivenda en la quantitat indicada de l'ingrés, i s'afegeixen
     * els tipus d'interés especificats cada vegada que es faci un ingrés.
     * Amb Override perquè estem sobreescribint aquest mètode. Ara afegim al saldo el tipus d'interés que li pertoca.
     * @param importe
     */
    @Override
    public void ingressarDiners(double importe){
        saldo = saldo+importe+(importe*tipusInteres/100);
    }
}
