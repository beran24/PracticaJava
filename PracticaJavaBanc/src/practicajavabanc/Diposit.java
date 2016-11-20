//package practicajavabanc;

import java.util.Date;
/**
 * @author Carlos Rodero, Esteve Cabrera, Mario Recamales
 */
public class Diposit extends CompteBancari implements TreureDinersAccions{
    /**
     * Classe Diposit, hereta de la classe CompteBancari. Implementa la interfície TreureDinersAccions.
     * Atributs de la classe PlaPensions:
     * protected int tipusInteres;
     * public double minDiners;
     * protected Date dataAvui;
     * protected Date dataUltimaVerificacio;
     */
    //Atributs
    protected int tipusInteres=1;
    public double minDiners=10000.00;
    protected Date dataAvui;
    protected Date dataUltimaVerificacio;
    //Constructor

    /**
     * Constructor de la classe Diposit
     * @param iban rep el IBAN del Diposit
     * @param saldo rep el saldo del Diposit
     * @param propietari rep l'objecte Client
     * dataUltimaVerificacio és una nova data
     */
    public Diposit(String iban, double saldo, Client propietari) {
        super(iban, saldo, propietari);
        this.dataUltimaVerificacio=new Date();
    }

    //Mètodes públics

    /**
     * Getter tipusInteres
     * @return el tipus d'interés del compte Dipòsit
     */
    public int getTipusInteres() {
        return tipusInteres;
    }

    /**
     * Setter tipusInteres. Estableix el tipus d'interés del compte Dipòsit
     * @param tipusInteres
     */
    public void setTipusInteres(int tipusInteres) {
        this.tipusInteres = tipusInteres;
    }
    /**
     * Getter MinDiners.
     * @return el mínim de diners que acceptarà el compte Dipòsit
     */
    public double getMinDiners() {
        return minDiners;
    }

    /**
     * Mètode comprovarInteressos. Aquest mètode permet guardar la data en la que accedim, i d'aquesta manera
     * ens permet calcular els interessos que s'han generat desde la darrera data en que hem accedit al mètode.
     * Cada 60 segons (60.000 ms) augmenta per 1 unitat els interessos.
     * Per exemple, si passen 120 segons augmenten *2 els interessos
     * Per pantalla se'ns mostrarà aquesta informació i s'afegiran al saldo del compte Diposit
     * @param dataAvui
     */
    public void comprovarInteressos(Date dataAvui){
        this.dataAvui=new Date();
        saldo=saldo+((saldo*tipusInteres/100)*(dataAvui.getTime()-dataUltimaVerificacio.getTime())/60000);
        System.out.println("Els interesos desde la ultima verificació son: "+(saldo*tipusInteres/100)+(dataAvui.getTime()-dataUltimaVerificacio.getTime())/60000);
        this.dataUltimaVerificacio=new Date();
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
     * Mètode treureDiners. Disminuïm el saldo del compte Dipòsit en la quantitat indicada.
     * Si en treure diners el saldo queda negatiu no ens permet fer la operació.
     * @param importe
     * @return true si hem pogut treure diners (importe) en el compte Dipòsit. Sino, retorna false.
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
