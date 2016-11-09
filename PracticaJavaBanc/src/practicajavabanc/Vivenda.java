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
public class Vivenda extends CompteBancari {
    protected int tipusInteres;
    protected Date dataCaducitat;
    public Vivenda(String iban, double saldo, Client propietari) {
        super(iban, saldo, propietari);
    }
    
    
}
