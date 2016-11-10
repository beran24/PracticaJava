/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicajavabanc;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Esteve Cabrera,Carlos Rodero,Mario Recamales
 */
public final class BancUtil {
        int opcio;
        String nom;
        int pass;
        int edat;
        String nif;
        ArrayList<Client> clients= new ArrayList<>();
        ArrayList<Particular> particulars= new ArrayList<>();
        ArrayList<CompteBancari> comptes= new ArrayList<>();
        Scanner lectura=new Scanner(System.in);
    public static boolean existeixCompte(ArrayList<CompteBancari> comptes,String iban){
        for(CompteBancari compte: comptes){
            if(compte.iban.equals(iban)){
                return true;
            } 
        }
        return false;
    }
    public static boolean existeixCompte(ArrayList<CompteBancari> comptes,String iban,String nif){
        for(CompteBancari compte: comptes){
            if(compte.iban.equals(iban)){
               if(compte.propietari.getClass().equals(Particular.class)){
                    if(((Particular)compte.propietari).nif.equals(nif)){
                        return true;
                    }
               }
               if(compte.propietari.getClass().equals(Empresa.class)){
                    if(((Empresa)compte.propietari).cif.equals(nif)){
                        return true;
                    }
               }
               
            } 
        }
        return false;
    }
    public static boolean existeixClient(ArrayList<Client> clients,String nif){
        for(Client persona: clients){
            if(persona.getClass().equals(Particular.class)){
                if(((Particular)persona).nif.equals(nif)){
                    return true;
                } 
            }
            if(persona.getClass().equals(Empresa.class)){
                if(((Empresa)persona).cif.equals(nif)){
                    return true;
                } 
            } 
        }
        return false;
    }
    public static int posicioCompte(ArrayList<CompteBancari> comptes,String iban){
        for(CompteBancari compte: comptes){
            if(compte.iban.equals(iban)){
                return comptes.indexOf(compte);
            } 
        }
        return 0;
    }
    public static int posicioClient(ArrayList<Client> clients,String nif){
        for(Client persona: clients){
            if(persona.getClass().equals(Particular.class)){
                if(((Particular)persona).nif.equals(nif)){
                    return clients.indexOf(persona);
                } 
            }
            if(persona.getClass().equals(Empresa.class)){
                if(((Empresa)persona).cif.equals(nif)){
                    return clients.indexOf(persona);
                } 
            }
        }
        return 0;
    }
    public void crearClient(){
        System.out.println("1.- Client Particular\n2.- Client Empresa");
        while(opcio!=1&&opcio!=2){
        opcio=lectura.nextInt();
        }
        System.out.println("Creacio un client.\nDigues nom");
        nom=lectura.next();
        System.out.println("Creacio un client.\nDigues edat");
        edat=lectura.nextInt();
        System.out.println("Creacio un client.\nPosa el nif");
        nif=lectura.next();
        System.out.println("Creacio un client.\nPosa una password");
        pass=lectura.nextInt();
        if(existeixClient(clients,nif)){
            System.out.println("Aquest client ja esta creat");
        }else{
            if(opcio==1)
                clients.add(new Particular(nom,edat,pass,nif));
            if(opcio==2)
                clients.add(new Empresa(nom,edat,pass,nif));
        }
        
    }
}
