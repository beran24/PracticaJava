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
    static  int passwordl;
    static CompteBancari compteClient;
    static CompteBancari compteClientDestinatari;
    static Client client;
    static String nif;
    static ArrayList<Client> clients= new ArrayList<>();
    static ArrayList<CompteBancari> comptesClient=new ArrayList<>();
    static ArrayList<CompteBancari> comptes= new ArrayList<>();
    static Scanner lectura=new Scanner(System.in);
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
        System.out.println("1.- Client Particular\n2.- Client Empresa");
        opcio = 0;
        while (opcio != 1 && opcio != 2) {
            opcio = lectura.nextInt();
        }
        System.out.println("Creacio un client.\nDigues nom");
        nom = lectura.next();
        System.out.println("Creacio un client.\nDigues edat");
        edat = lectura.nextInt();
        System.out.println("Creacio un client.\nPosa el nif");
        nif = lectura.next();
        if (existeixClient(clients, nif)) {
            System.out.println("Aquest client ja esta creat");
            return;
        }
        System.out.println("Creacio un client.\nPosa una password");
        pass = lectura.nextInt();
        if (opcio == 1)
            clients.add(new Particular(nom, edat, pass, nif));
        if (opcio == 2)
            clients.add(new Empresa(nom, edat, pass, nif));
    }
    public static boolean entrarApp(){
        System.out.println("Entrar App.Posa el nif/cif");
        nif=lectura.next();
        System.out.println("Posa la password");
        passwordl=lectura.nextInt();
        if(existeixClient(clients,nif)){
            if((clients.get(posicioClient(clients,nif)).password)==(passwordl)){
                client=clients.get(posicioClient(clients,nif));
                ennumerarComptesClient();
                return true;
            }
        }
        return false;
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
        opcio=lectura.nextInt();
        switch(opcio){
            case 1:
                System.out.println("Posa el iban");
                iban=lectura.next();
                if(flag){
                    if(!(existeixCompte(comptes,iban,((Particular)client).nif))){
                        comptes.add(new Nomina(iban,0,client));
                    }else{
                        System.out.println("El compte bancari ja existeix");
                    }
                }
                if(!flag){
                    if(!(existeixCompte(comptes,iban,((Empresa)client).cif))){
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
                minD=lectura.nextDouble();
                if(minD>minDiners){
                    if(flag){
                        if(!(existeixCompte(comptes,iban,((Particular)client).nif))){
                            comptes.add(new Diposit(iban,minD,client));
                        }else{
                            System.out.println("El compte bancari ja existeix");
                        }
                    }
                    if(!flag){
                        if(!(existeixCompte(comptes,iban,((Empresa)client).cif))){
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
            posicioCompte=lectura.nextInt();
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
        triarCompteClient();
        if(compteClient.getClass().equals(Nomina.class)){
            System.out.println("A quina compte vols fer el traspas");
            iban=lectura.next();
            triarCompteClient(iban);
            System.out.println("Quants diners vols traspassar");
            minD=lectura.nextDouble();
            ((Nomina)compteClient).traspas(compteClientDestinatari, minD);
        }else{
            System.out.println("Desde aquesta compte no es poden fer traspassos");
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
            System.out.println("Saldo: "+compteClient.consultarSaldo());
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
}
