package practicajavabanc;
/**
 * Created by mario on 9/11/16.
 */
public class Nomina extends CompteBancari {
    protected int tipusInteres;

    public Nomina(String iban, double saldo, Client propietari) {
        super(iban, saldo, propietari);
        
    }
    public int getTipusInteres() {
        return tipusInteres;
    }
    public void setTipusInteres(int tipusInteres) {
        this.tipusInteres = tipusInteres;
    }

    public boolean traspas (CompteBancari tCompte, CompteBancari rCompte,double importe){
        if(!(tCompte.compteDescobert(tCompte, importe))){
            rCompte.saldo=rCompte.saldo+importe;
            tCompte.saldo=tCompte.saldo-importe;
            return true;
        }else{
            System.out.println("No pots fer el traspas. No hi ha suficients diners al compte");
            return false;
        }
    }
    @Override
    public void ingressarDiners(CompteBancari compte,double importe){
        compte.saldo=compte.saldo+importe+(importe*tipusInteres/100);  
    }
    public boolean treureDiners(Nomina compte,double importe){
        if(compte.saldo-importe>0){
            compte.saldo=compte.saldo-importe;
            return true;
        }
        else return false;
            
    }
}
