/**
 * @author Carlos Rodero, Esteve Cabrera, Mario Recamales
 */

import java.util.Date;


public class Vivenda extends CompteBancari {

    protected int tipusInteres;
    protected Date dataCaducitat;

    public Vivenda(String iban, double saldo, Client propietari, Date dataCaducitat) {
        super(iban, saldo, propietari);
        this.dataCaducitat = dataCaducitat;
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
