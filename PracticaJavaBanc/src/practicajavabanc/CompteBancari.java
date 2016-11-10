/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Carlos Rodero, Esteve Cabrera, Mario Recamales
 */
public abstract class CompteBancari implements CompteAccions {
    protected String iban;
    protected double saldo;
    protected Client propietari;
    protected double importe;
    
    public String getIban() {
        return iban;
    }
    public void setIban(String iban) {
        this.iban = iban;
    }

    @Override
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

    public boolean compteDescobert(double importe){
        return(saldo-importe<0);
    }

    @Override
    public void ingressarDiners(double importe){
        saldo=saldo+importe;  
    }
}
