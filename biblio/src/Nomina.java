//package practicajavabanc;
/**
 * @author Carlos Rodero, Esteve Cabrera, Mario Recamales
 */
public class Nomina extends CompteBancari implements TreureDinersAccions {
    /**
     * Classe Nomina, hereta de la classe CompteBancari. Implementa la interfície TreureDinersAccions.
     * Override de mètode ingressarDiners.
     * Atributs de la classe Nomina:
     * protected int tipusInteres;
     */
    //Atributs
    protected int tipusInteres=0;

    //Constructor
    /**
     * Constructor de la classe Nomina
     * @param iban rep el IBAN de la Nomina
     * @param saldo rep el saldo de la Nomina
     * @param propietari rep l'objecte Client
     */
    public Nomina(String iban, double saldo, Client propietari) {
        super(iban, saldo, propietari);
    }
    //Mètodes públics

    /**
     * Getter tipusInterés.
     * @return el tipus d'interés del compte Nomina
     */
    public int getTipusInteres() {
        return tipusInteres;
    }

    /**
     * Setter tipusInterés. Estableix el tipus d'interés del compte Nomina.
     * @param tipusInteres
     */
    public void setTipusInteres(int tipusInteres) {
        this.tipusInteres = tipusInteres;
    }

    /**
     * Mètode trapas. Permet fer un traspàs de diners establert (importe) entre el compte bancari que crida aquest
     * mètode i un compte bancari receptor.
     * Primer comprova que el compte bancari que realitza el traspàs no es quedi al descobert (compteDescobert).
     * Si és així, el compte bancari receptor augmenta el seu saldo amb l'import de la transferència,
     * i el compte bancari d'on hem realitzat la transferència li restem al seu saldo aquest mateix import.
     * Si no es pot fer, mostra en pantalla un missatge conforme no hi ha suficients diners al compte.
     * @param rCompte
     * @param importe
     * @return true si s'ha pogut fer la transferència entre els dos comptes bancaris, i retorna false si no s'ha fer.
     */
    public boolean traspas ( CompteBancari rCompte,double importe){
        if(!(compteDescobert(importe))){
            rCompte.saldo=rCompte.saldo+importe;
            saldo=saldo-importe;
            return true;
        }else{
            System.out.println("No pots fer el traspàs. No hi ha suficients diners al compte");
            return false;
        }
    }

    /**
     * Mètode ingressarDiners. Augmenta el saldo del compte Nomina en la quantitat indicada de l'ingrés.
     * Amb Override perquè estem sobreescribint aquest mètode.
     * @param importe
     */
    @Override
    public void ingressarDiners(double importe){
        saldo=saldo+importe;
    }

    /**
     * Mètode treureDiners. Disminuïm el saldo del compte Nòmina en la quantitat indicada.
     * Si en treure diners el saldo queda negatiu no ens permet fer la operació.
     * @param importe
     * @return true si hem pogut treure diners (importe) en el compte Nomina. Sino, retorna false.
     */
    @Override
    public boolean treureDiners(double importe){
        if(saldo-importe>0){
            saldo=saldo-importe;
            return true;
        }
        else return false;
    }
}
