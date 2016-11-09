/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicajavabanc;

/**
 *
 * @author Carlos Rodero, Esteve Cabrera, Mario Recamales
 */
public abstract class CompteBancari {
    protected String iban;
    protected double saldo;
    protected Client propietari;
    public double importe;
    
    public String getIban() {
        return iban;
    }
    public void setIban(String iban) {
        this.iban = iban;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    /**
     *
     * @param iban
     * @param saldo
     * @param propietari
     */
    public CompteBancari(String iban, double saldo, Client propietari) {
        this.iban = iban;
        this.saldo = saldo;
        this.propietari = propietari;
    }
    public double consultarSaldo(CompteBancari compte){
        return compte.saldo;
    }
    public boolean compteDescobert(CompteBancari compte,double importe){
        return(compte.saldo-importe<0);
    }
    public void ingressarDiners(CompteBancari compte,double importe){
        compte.saldo=compte.saldo+importe;
        
    }
}
