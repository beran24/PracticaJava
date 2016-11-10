/**
 * @author Carlos Rodero, Esteve Cabrera, Mario Recamales
 */

import java.util.Date;


public class Vivenda extends CompteBancari {

    protected int tipusInteres;
    protected Date dataCaducitat;

    public Vivenda(String iban, double saldo, Client propietari) {
        super(iban, saldo, propietari);
        this.dataCaducitat = new Date();
        dataCaducitat=new Date(this.dataCaducitat.getTime()+ 92275200*1000);
    }

    public int getTipusInteres() {
        return tipusInteres;
    }

    public void setTipusInteres(int tipusInteres) {
        this.tipusInteres = tipusInteres;
    }

    public Date getDataCaducitat() {
        return dataCaducitat;
    }

    @Override
    public void ingressarDiners(double importe){
        saldo = saldo+importe+(importe*tipusInteres/100);
    }
}
