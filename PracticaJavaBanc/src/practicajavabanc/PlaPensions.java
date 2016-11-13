/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicajavabanc;
import java.util.Date;

/**
 *
 * @author Sandra
 */
public class PlaPensions extends CompteBancari {
    protected int tipusInteres=2;
    protected Date dataVenciment;
    public PlaPensions(String iban, double saldo, Client propietari) {
        super(iban, saldo, propietari);
        this.dataVenciment= new Date();
    }
    @Override
    public void ingressarDiners(double importe){
        saldo=saldo+(importe*tipusInteres/100);
    }
    
    public boolean treureDiners(double importe){
        if((saldo-importe>0)&&(propietari.edat > 65)){
            saldo=saldo-importe;
            return true;
        }
        else return false;
            
    }
}
