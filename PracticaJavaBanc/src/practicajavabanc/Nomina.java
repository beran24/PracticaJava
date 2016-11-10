/**
 * Created by mario on 9/11/16.
 */
public class Nomina extends CompteBancari implements TreureDinersAccions {
    protected int tipusInteres=2;

    public Nomina(String iban, double saldo, Client propietari) {
        super(iban, saldo, propietari);
        
    }
    public int getTipusInteres() {
        return tipusInteres;
    }
    public void setTipusInteres(int tipusInteres) {
        this.tipusInteres = tipusInteres;
    }
    public boolean traspas ( CompteBancari rCompte,double importe){
        if(!(compteDescobert(importe))){
            rCompte.saldo=rCompte.saldo+importe;
            saldo=saldo-importe;
            return true;
        }else{
            System.out.println("No pots fer el traspas. No hi ha suficients diners al compte");
            return false;
        }
    }
    @Override
    public void ingressarDiners(double importe){
        saldo=saldo+importe+(importe*tipusInteres/100);  
    }

    @Override
    public boolean treureDiners(double importe){
        if(saldo-importe>0){
            saldo=saldo-importe;
            return true;
        }
        else return false;
            
    }
}
