/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicajavabanc;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.io.*;

/**
 *
 * @author Esteve Cabrera,Carlos Rodero,Mario Recamales
 */
public final class BancUtil {
    static boolean flag;
    static double minDiners=10000;
    static double minD;
    static String iban;
    static int posicioCompte;
    static int opcio;
    static int counter1,counter2;
    static String nom;
    static int pass;
    static int edat;
    static int passwordl;
    static CompteBancari compteClient;
    static CompteBancari compteClientDestinatari;
    static Client client;
    static String nif;
    static ArrayList<Client> clients= new ArrayList<>();
    static ArrayList<CompteBancari> comptesClient=new ArrayList<>();
    static ArrayList<CompteBancari> comptes= new ArrayList<>();
    static Scanner lectura=new Scanner(System.in);
    /**
     * Aquesta funcio comprova si el compte existeix o no
     * @param comptes
     * @param iban
     * @return boolean
     */
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
    public static void crearClient() {
        System.out.println("1.- Client Particular\n2.- Client Empresa\n");
        opcio = 0;
        while (opcio != 1 && opcio != 2) {
            try{
            opcio = lectura.nextInt();
            }catch(Exception e){
                System.out.println("Opcio 1 o 2 solament.\n");
            }
            if(opcio != 1 && opcio != 2){
                System.out.println("Opcio 1 o 2 solament.\n");
            }
        }try{
        System.out.println("Creacio un client.\nDigues nom");
        nom = lectura.next();
        System.out.println("Digues edat");
        edat = lectura.nextInt();
        System.out.println("Posa el nif");
        nif = lectura.next();
        if (existeixClient(clients, nif)) {
            System.out.println("Aquest client ja esta creat");
            return;
        }
        System.out.println("Posa una password");
        Console cnsl = System.console();
        char[] pwd = cnsl.readPassword();
        pass= Integer.parseInt(new String(pwd));
        //pass = lectura.nextInt();
        }catch(Exception e){
            System.out.println("Has introduit malament les dades");
            e.printStackTrace();
        }
        if (opcio == 1)
            clients.add(new Particular(nom, edat, pass, nif));
        if (opcio == 2)
            clients.add(new Empresa(nom, edat, pass, nif));
    }
    public static boolean entrarApp(){
        if(!clients.isEmpty()){
            try{
            System.out.println("Entrar App.Posa el nif/cif");
            nif=lectura.next();
            System.out.println("Posa la password");
            Console cnsl = System.console();
            char[] pwd = cnsl.readPassword();
            passwordl= Integer.parseInt(new String(pwd));
            //passwordl=lectura.nextInt();
            }catch(Exception e){
                System.out.println("Has introduit malament les dades");
            }
            if(existeixClient(clients,nif)){
                if((clients.get(posicioClient(clients,nif)).password)==(passwordl)){
                    client=clients.get(posicioClient(clients,nif));
                    System.out.println(client.getClass().getSimpleName());
                    //ennumerarComptesClient();
                    return true;
                }
            }
            return false;
        }else{
            System.out.println("No hi ha clients en la Base de dades");
            return false;
        }
    }
    public static void crearCompte(){
        if(client.getClass().equals(Particular.class)){
            System.out.println("1.- Nomina\n2.- Diposit\n3.- Pla de pensions\n4.- Vivenda\n");
            flag=true;
        }
        if(client.getClass().equals(Empresa.class)){
            System.out.println("1.- Nomina\n2.- Diposit\n");
            flag=false;
        }
        try{
        opcio=lectura.nextInt();
        }catch(Exception e){
            System.out.println("Posa la contrasenya be");
        }
        switch(opcio){
            case 1:
                System.out.println("Posa el iban");
                iban=lectura.next();
                if(flag){
                    if(!(existeixCompte(comptes,iban))){
                        comptes.add(new Nomina(iban,0,client));
                    }else{
                        System.out.println("El compte bancari ja existeix");
                    }
                }
                if(!flag){
                    if(!(existeixCompte(comptes,iban))){
                        comptes.add(new Nomina(iban,0,client));
                    }else{
                        System.out.println("El compte bancari ja existeix");
                    }
                        
                }
                break;
            case 2:
                System.out.println("Posa el iban");
                iban=lectura.next();
                System.out.println("Posa la quantitat a dipositar");
                try{
                minD=lectura.nextDouble();
                }catch(Exception e){
                    System.out.println("Has de posar la quantitat de diners amb decimals");
                }
                if(minD>minDiners){
                    if(flag){
                        if(!(existeixCompte(comptes,iban))){
                            comptes.add(new Diposit(iban,minD,client));
                        }else{
                            System.out.println("El compte bancari ja existeix");
                        }
                    }
                    if(!flag){
                        if(!(existeixCompte(comptes,iban))){
                            comptes.add(new Diposit(iban,minD,client));
                        }else{
                            System.out.println("El compte bancari ja existeix");
                        }

                    } 
                }else{
                    System.out.println("El minim de diners han de ser 10000 euros");
                }
                break;
            case 3:
                System.out.println("Posa el iban");
                iban=lectura.next();
                if(!(existeixCompte(comptes,iban,((Particular)client).nif))){
                    comptes.add(new PlaPensions(iban,0,client));
                }else{
                    System.out.println("El compte bancari ja existeix");
                }
                break;
            case 4:
                System.out.println("Posa el iban");
                iban=lectura.next();
                if(!(existeixCompte(comptes,iban,((Particular)client).nif))){
                    comptes.add(new Vivenda(iban,0,client));
                }else{
                    System.out.println("El compte bancari ja existeix");
                }
        }
    }
    public static void ennumerarComptesClient(){
        for(CompteBancari compte: comptes){
            if(compte.propietari.getClass().equals(Particular.class)&&client.getClass().equals(Particular.class)){
                if(((Particular)compte.propietari).compareTo(client)==0){
                System.out.println("Compte "+compte.getClass().getSimpleName()+" IBAN " + compte.getIban());
                }
            }
            if(compte.propietari.getClass().equals(Empresa.class)&&client.getClass().equals(Empresa.class)){
                if(((Empresa)compte.propietari).compareTo(client)==0){
                    System.out.println("Compte "+compte.getClass().getSimpleName()+" IBAN " + compte.getIban());
                }
            }       
        }
    }
    public static void triarCompteClient(){
        counter1=0;
        comptesClient.clear();
        if(!comptes.isEmpty()){
            for(CompteBancari compte: comptes){
                if(compte.propietari.getClass().equals(Particular.class)&&client.getClass().equals(Particular.class)){
                    if(((Particular)compte.propietari).compareTo(client)==0){
                    System.out.println(counter1+" Compte "+compte.getClass().getSimpleName()+" IBAN " + compte.getIban());
                    comptesClient.add(compte);
                    counter1++;
                    }
                }
                if(compte.propietari.getClass().equals(Empresa.class)&&client.getClass().equals(Empresa.class)){
                    if(((Empresa)compte.propietari).compareTo(client)==0){
                    System.out.println(counter1+" Compte "+compte.getClass().getSimpleName()+" IBAN "+compte.getIban());
                    comptesClient.add(compte);
                    counter1++;
                    }
                }
            }
            try{
            posicioCompte=lectura.nextInt();
            }catch(Exception e){
                System.out.println("Posa un numero de compte valid");
            }
            compteClient=comptesClient.get(posicioCompte);
        }else{
            System.out.println("No tens cap compte encara. Crean un");
        }
    }
    public static void triarCompteClient(String iban){
        counter2=0;
        for(CompteBancari compte: comptes){
            if(compte.iban.equals(iban)){
                compteClientDestinatari=comptes.get(counter2);
                System.out.println(counter2+" Compte "+compte.getClass().getSimpleName()+" IBAN "+ compte.getIban());
            }
            counter2++;
        }
    }
    public static void ferTraspas(){
        
        System.out.print("Desde quina compte vols fer el traspas\n");
        try{
        triarCompteClient();
        }catch(Exception e){
            System.out.print("Has de triar la compte correcta\n");
        }
        if(compteClient.getClass().equals(Nomina.class)){
            System.out.println("Posa l'IBAN del compte al qual vols fer el traspas");
            iban=lectura.next();
            try{
            triarCompteClient(iban);
            }catch(Exception e){
                System.out.println("L'IBAN no existeix");
            }
            System.out.println("Quants diners vols traspassar");
            try{
            minD=lectura.nextDouble();
            }catch(Exception e){
                System.out.print("Recorda que el numero es amb decimals amb un punt\n");
            }
            ((Nomina)compteClient).traspas(compteClientDestinatari, minD);
        }else{
            System.out.println("Desde aquesta compte no es poden fer traspassos\n");
        }    
        
        
    }
    public static void ferIngres(){
        System.out.print("Tria el compte on vols fer l'ingres\n");
        try{
            triarCompteClient();
            System.out.println("Quants diners vols ingressar");
            minD=lectura.nextDouble();
            compteClient.ingressarDiners(minD);
        }catch(Exception e){
            System.out.print("No has seleccionat el compte be\n");
        }
    }
    public static void ferConsultaSaldo(){
        System.out.print("Tria el compte que vols consultar el saldo\n");
        try{
            triarCompteClient();
            System.out.println("Saldo: "+String.format("%.2f", compteClient.consultarSaldo()));
        }catch(Exception e){
            System.out.print("No has seleccionat el compte be\n");
        }
    }
    public static void eliminarCompte(){
        System.out.print("Tria el compte que vols eliminar\n");
        try{
            triarCompteClient();
            if(comptes.remove(compteClient)){
                System.out.print("El compte ha sigut eliminat\n");
        }
        }catch(Exception e){
            System.out.print("No has seleccionat el compte be\n"); 
        }
        
    }
    public static void retirarEfectiu(){
        System.out.print("Tria el compte que vols eliminar\n");
        try{
            triarCompteClient();
            System.out.print("Quan vols retirar\n");
            minD=lectura.nextInt();
            if(!compteClient.compteDescobert(minD)){
                if(compteClient.getClass().equals(Nomina.class)){
                    ((Nomina)compteClient).treureDiners(minD);
                }
                else if(compteClient.getClass().equals(Diposit.class)){
                    ((Diposit)compteClient).treureDiners(minD);
                }
                else if(compteClient.getClass().equals(PlaPensions.class)){
                    ((PlaPensions)compteClient).treureDiners(minD);
                }else{
                    System.out.print("Un compte vivenda no pot retirar diners\n"); 
                }
            }else{
                System.out.print("No es pot fer perque et quedaries amb descobert.PAGA EL COLEGIO MARIO\n"); 
            }
        
        }catch(Exception e){
            System.out.print("No has seleccionat el compte be\n"); 
        }
        
    }
    public static void solicitarTargeta(){
        
    }
    public static void comprovarInteressos(){
        System.out.print("Tria el compte que vols mirar els interesos.Recorda que ha de ser un compte diposit\n");
        try{
            triarCompteClient();
            if(compteClient.getClass().equals(Diposit.class)){
                ((Diposit)compteClient).comprovarInteressos(new Date());
            }else{
                System.out.print("No es un compte diposit\n");
            }
            
        }catch(Exception e){
            System.out.print("No has seleccionat el compte be\n"); 
        }
    }
}
