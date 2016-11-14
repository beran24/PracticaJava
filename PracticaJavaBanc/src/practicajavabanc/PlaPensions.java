//package practicajavabanc;
import java.util.Date;
/**
 * @author Carlos Rodero, Esteve Cabrera, Mario Recamales
 */
public class PlaPensions extends CompteBancari {
    /**
     * Classe PlaPensions, hereta de la classe CompteBancari. Override de mètode ingressarDiners.
     * Atributs de la classe PlaPensions:
     * protected int tipusInteres=2;
     * protected Date dataVenciment;
     */
    //Atributs
    protected int tipusInteres=2;
    protected Date dataVenciment;

    //Constructor
    /**
     * Constructor de la classe PlaPensions
     * @param iban
     * @param saldo
     * @param propietari
     */
    public PlaPensions(String iban, double saldo, Client propietari) {
        super(iban, saldo, propietari);
        this.dataVenciment= new Date();
    }
    //Métodes públics

    /**
     * Getter tipusInteres
     * @return el tipus d'interés del compte Pla de Pensions
     */
    public int getTipusInteres() {
        return tipusInteres;
    }

    /**
     * Setter tipusInteres. Estableix el tipus d'interés del compte Pla de Pensions
     * @param tipusInteres
     */
    public void setTipusInteres(int tipusInteres) {
        this.tipusInteres = tipusInteres;
    }

    /**
     * Getter dataVenciment.
     * @return la data de venciment del compte Pla de Pensions
     */
    public Date getDataVenciment() {
        return dataVenciment;
    }

    /**
     * Mètode ingressarDiners. Augmenta el saldo del compte PlaPensions en la quantitat indicada de l'ingrés,
     * i s'afegeixen els tipus d'interés especificats cada vegada que es faci un ingrés.
     * Amb Override perquè estem sobreescribint aquest mètode. Ara afegim al saldo el tipus d'interés que li pertoca.
     * @param importe
     */
    @Override
    public void ingressarDiners(double importe){
        saldo=saldo+importe+(importe*tipusInteres/100);
    }

    /**
     * Mètode treureDiners. Disminuïm el saldo del compte PlaPensions en la quantitat indicada.
     * Si en treure diners el saldo queda negatiu, així com si l'edat del titular del compte Pla de Pensions (propietari del
     * compte) és major de 65 anys, no ens permet fer la operació.
     * @param importe
     * @return true si hem pogut treure diners (importe) en el compte PlaPensions. Sino, retorna false.
     */
    public boolean treureDiners(double importe){
        if((saldo-importe>0)&&(propietari.edat > 65)){
            saldo=saldo-importe;
            return true;
        }
        else{
            if(propietari.edat < 65){
                System.out.println("No pots treure diners. La teva edat és inferior a 65 anys. Has de parlar amb el " +
                        "director de JavaBank.");
            }
            return false;
        }
            
    }
}
