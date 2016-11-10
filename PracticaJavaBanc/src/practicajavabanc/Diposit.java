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
public class Diposit extends CompteBancari {
    protected int tipusInteres=1;
    public double minDiners=10000.00;
    protected Date dataAvui;
    protected Date dataUltimaVerificacio;
    
    public Diposit(String iban, double saldo, Client propietari) {
        super(iban, saldo, propietari);
        this.dataUltimaVerificacio=new Date();
    }
    public void comprovarInteressos(Date dataAvui){
        this.dataAvui=new Date();
        saldo=saldo+((saldo*tipusInteres/100)*(dataAvui.getTime()-dataUltimaVerificacio.getTime())/60000);
        System.out.println("Els interesos desde la ultima verificació son: "+(saldo*tipusInteres/100)+(dataAvui.getTime()-dataUltimaVerificacio.getTime())/60000);
        this.dataUltimaVerificacio=new Date();
    }
    
    
}
