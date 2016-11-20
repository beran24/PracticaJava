/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packcomptebancari;

import java.util.Date;
import practicajavabanc.*;
import packclient.Client;

/**
 *
 * @author Sandra
 */
public class PlaPensions extends CompteBancari implements TreureDinersAccions{
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
    
    @Override
    public boolean treureDiners(double importe){
        if((saldo-importe>0)&&(propietari.getEdat() > 65)){
            saldo=saldo-importe;
            return true;
        }
        else return false;
            
    }
    public boolean traspas ( CompteBancari rCompte,double importe){
        if(!(compteDescobert(importe))&&(propietari.getEdat()> 65)){
            rCompte.saldo=rCompte.saldo+importe;
            saldo=saldo-importe;
            return true;
        }else{
            if(propietari.getEdat() < 65) {
                System.out.println("No pots fer traspàs de diners. La teva edat és inferior a 65 anys. Has de parlar " +
                        "amb el director de JavaBank.");
            }else {
                System.out.println("No pots fer el traspàs. No hi ha suficients diners al compte");
            }
            return false;
        }
    }
}
