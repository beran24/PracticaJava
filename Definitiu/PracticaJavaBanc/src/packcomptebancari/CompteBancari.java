/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packcomptebancari;
import practicajavabanc.*;
import packclient.*;

/**
 *
 * @author Carlos Rodero, Esteve Cabrera, Mario Recamales
 */
public abstract class CompteBancari implements CompteAccions,Comparable<CompteBancari> {
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

    public Client getPropietari() {
        return propietari;
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
    
    public double consultarSaldo(){
        return saldo;
    }
    public boolean compteDescobert(double importe){
        return(saldo-importe<0);
    }
    @Override
    public abstract void ingressarDiners(double importe);

    @Override
    public int compareTo(CompteBancari o) {
        return Double.valueOf(saldo).compareTo(o.saldo);
    }
    
}
