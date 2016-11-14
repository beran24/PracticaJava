//package practicajavabanc;
/**
 * @author Carlos Rodero, Esteve Cabrera, Mario Recamales
 */
public abstract class CompteBancari implements CompteAccions {
    /**
     * Classe abstracta CompteBancari. Implementa la interfície CompteAccions
     * Atributs de la classe CompteBancari:
     * protected String iban;
     * protected double saldo;
     * protected Client propietari;
     * protected double importe;
     */
    //Atributs
    protected String iban;
    protected double saldo;
    protected Client propietari;
    protected double importe;

    //Constructor
    /**
     * Constructor de la classe CompteBancari
     * @param iban
     * @param saldo
     * @param propietari
     **/
    public CompteBancari(String iban, double saldo, Client propietari) {
        this.iban = iban;
        this.saldo = saldo;
        this.propietari = propietari;
    }
    //Mètodes públics

    /**
     * Getter iban.
     * @return el iban del compte bancari.
     */
    public String getIban() {
        return iban;
    }

    /**
     * Getter Saldo.
     * Amb Override perquè serà sobreescrit en classes que ho heretin
     * @return saldo del compte bancari
     */
    @Override
    public double getSaldo() {
        return saldo;
    }

    /**
     * Mètode consultarSaldo. Ens permet consultar el saldo del compte bancari
     * @return saldo del compte bancari
     */
    public double consultarSaldo(){
        return saldo;
    }

    /**
     * Mètode compteDescobert. Permet saber si el compte bancari es quedarà en saldo negatiu en fer una operació.
     * @param importe
     * @return true si el compte bancari es queda en negatiu, i false si es queda en positiu
     */
    public boolean compteDescobert(double importe){
        return(saldo-importe<0);
    }

    /**
     * Mètode ingressarDiners. Augmenta el saldo del compte bancari en la quantitat indicada de l'ingrés.
     * Amb Override perquè serà sobreescrit en classes que ho heretin.
     * @param importe
     */
    @Override
    public void ingressarDiners(double importe){
        saldo=saldo+importe;  
    }
}
