/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packcomptebancari;
import practicajavabanc.*;
import packclient.*;

import java.util.Date;

/**
 *
 * @author Sandra
 */
public class Diposit extends CompteBancari implements TreureDinersAccions{
    protected int tipusInteres=1;
    public double minDiners=10000.00;
    protected Date dataAvui;
    protected Date dataUltimaVerificacio;

    public double getMinDiners() {
        return minDiners;
    }
    
    public Diposit(String iban, double saldo, Client propietari) {
        super(iban, saldo, propietari);
        this.dataUltimaVerificacio=new Date();
    }
    public void comprovarInteressos(Date dataAvui){
        saldo=saldo+((saldo*tipusInteres/100)*(dataAvui.getTime()-dataUltimaVerificacio.getTime())/60000);
        System.out.println("Els interesos desde la ultima verificació son: "+String.format("%.2f",(saldo*tipusInteres/100)*(dataAvui.getTime()-dataUltimaVerificacio.getTime())/60000));
        this.dataUltimaVerificacio=new Date();
    }
    @Override
    public boolean treureDiners(double importe){
        if(saldo-importe>0){
            saldo=saldo-importe;
            return true;
        }
        else return false;
            
    }

    @Override
    public void ingressarDiners(double importe) {
        saldo=saldo+importe;
    }
    
    
}
