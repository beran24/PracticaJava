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
    public void ingressarDiners(CompteBancari compte,double importe){
        compte.saldo=compte.saldo+(importe*tipusInteres/100);
    }
    public boolean treureDiners(PlaPensions compte,double importe){
        if(compte.saldo-importe>0){
            compte.saldo=compte.saldo-importe;
            return true;
        }
        else return false;
            
    }
    
    
}
