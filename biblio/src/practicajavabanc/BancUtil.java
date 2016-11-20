package practicajavabanc;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.io.*;
import packclient.*;
import packcomptebancari.*;
import static java.lang.StrictMath.abs;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author Esteve Cabrera,Carlos Rodero,Mario Recamales
 */
public final class BancUtil {
    /**
     * Classe Utility BancUtil. En aquesta classe implementarem la majoria de mètodes que farà servir un client del banc
     * amb els seus comptes bancaris i targetes.
     * Atributs de la classe BancUtil:
     *static boolean flag;
     * static double minDiners=10000;
     * static double minD;
     * static String iban;
     * static int posicioCompte;
     * static int opcio;
     * static int counter1,counter2;
     * static String nom;
     * static int pass;
     * static int edat;
     * static int passwordl;
     * static CompteBancari compteClient;
     * static CompteBancari compteClientDestinatari;
     * static Client client;
     * static String nif;
     * static ArrayList<Client> clients= new ArrayList<>();
     * static ArrayList<CompteBancari> comptesClient=new ArrayList<>();
     * static ArrayList<CompteBancari> comptes= new ArrayList<>();
     * static Scanner lectura=new Scanner(System.in);
     * private static ArrayList<Targeta> targetes= new ArrayList<>();
     */
    private static SimpleDateFormat data=new SimpleDateFormat("dd.MM.yyyy - hh:mm:ss");
    private static boolean flag;
    private static double minDiners=10000;
    private static double minD;
    private static String iban;
    private static int posicioCompte;
    private static int opcio;
    private static int counter1,counter2;
    private static String nom;
    private static int pass;
    private static int edat;
    private static int passwordl;
    private static CompteBancari compteClient;
    private static CompteBancari compteClientDestinatari;
    private static Client client;
    private static String nif;
    static ArrayList<Client> clients= new ArrayList<>();
    private static ArrayList<CompteBancari> comptesClient=new ArrayList<>();
    private static ArrayList<CompteBancari> comptes= new ArrayList<>();
    private static Scanner lectura=new Scanner(System.in);
    private static ArrayList<Targeta> targetes= new ArrayList<>();
    /**
     * Mètode existeixCompte. Aquest mètode rep per paràmetre l'ArrayList de comptes (de tipus CompteBancari) i el IBAN
     * del compte que sol·licitem al Client per comprobar que existeix.
     * @param comptes
     * @param iban
     * @return true si existeix el compte bancari dins l'ArrayList de comptes amb l'IBAN que li passem, o false
     * sino existeix.
     */
    public static boolean existeixCompte(ArrayList<CompteBancari> comptes,String iban){
        for(CompteBancari compte: comptes){
            if(compte.getIban().equals(iban)){
                return true;
            }
        }
        return false;
    }
    /**
     * Mètode existeixCompte. Aquest mètode rep per paràmetre l'ArrayList de comptes (de tipus CompteBancari),el IBAN
     * del compte que sol·licitem al Client, i el NIF/CIF del client, per comprobar que existeix el compte bancari amb
     * aquest IBAN i que correspon a un Client determinat, sigui Particular o Empresa.
     * @param comptes
     * @param iban
     * @param nif
     * @return true si el compte bancari existeix en l'ArrayList de comptes i correspon a un Particular o Empresa,
     * o false sino correspon a cap Client
     */
    public static boolean existeixCompte(ArrayList<CompteBancari> comptes,String iban,String nif){
        for(CompteBancari compte: comptes){
            if(compte.getIban().equals(iban)){
                if(compte.getPropietari().getClass().equals(Particular.class)){
                    if(((Particular)compte.getPropietari()).getNif().equals(nif)){
                        return true;
                    }
                }
                if(compte.getPropietari().getClass().equals(Empresa.class)){
                    if(((Empresa)compte.getPropietari()).getCif().equals(nif)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    /**
     * Mètode existeixClient. Aquest mètode rep per paràmetre l'ArrayList de clients (de tipus Client) i el NIF/CIF
     * del client, per comprobar que existeix el client amb el corresponent NIF o CIF.
     * @param clients
     * @param nif
     * @return true si el Client(Particular o Empresa) existeix dins de l'ArrayList de clients, o false sino existeix.
     */
    public static boolean existeixClient(ArrayList<Client> clients,String nif){
        for(Client persona: clients){
            if(persona.getClass().equals(Particular.class)){
                if(((Particular)persona).getNif().equals(nif)){
                    return true;
                }
            }
            if(persona.getClass().equals(Empresa.class)){
                if(((Empresa)persona).getCif().equals(nif)){
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Mètode posicioCompte. Aquest mètode rep per paràmetre l'ArrayList de comptes (de tipus CompteBancari) i el iban.
     * Ens permet saber en quina posició de l'ArrayList de CompteBancari està ubicat l'IBAN que li acabem de passar
     * (si aquest existeix)
     * @param comptes
     * @param iban
     * @return un "int" amb la posició del iban associat al compte bancari de l'ArrayList comptes. Retornarà 0
     * sino existeix.
     */
    public static int posicioCompte(ArrayList<CompteBancari> comptes,String iban){
        for(CompteBancari compte: comptes){
            if(compte.getIban().equals(iban)){
                return comptes.indexOf(compte);
            }
        }
        return 0;
    }
    /**
     * Mètode posicioClient. Aquest mètode rep per paràmetre l'ArrayList de clients (de tipus Client) i el nif/cif.
     * Ens permet saber en quina posició del'ArrayList de clients està ubicat el client que estem buscant, bé sigui amb
     * el NIF (Particular) o bé amb el CIF (Empresa), si existeix.
     * @param clients
     * @param nif
     * @return un "int" amb la posició del client associat amb el CIF/NIF que li passem, dins de l'ArrayList clients.
     * Retornarà 0 sino existeix.
     */
    public static int posicioClient(ArrayList<Client> clients,String nif){
        for(Client persona: clients){
            if(persona.getClass().equals(Particular.class)){
                if(((Particular)persona).getNif().equals(nif)){
                    return clients.indexOf(persona);
                }
            }
            if(persona.getClass().equals(Empresa.class)){
                if(((Empresa)persona).getCif().equals(nif)){
                    return clients.indexOf(persona);
                }
            }
        }
        return 0;
    }
    /**
     * Mètode crearClient. Ens permet la creació d'un nou Client dins l'ArrayList de clients tot demanant les dades a
     * l'usuari. Primer es demana escollir si el client és Particular o Empresa. A continuació, se li demanen les dades
     * corresponents al nom, edat i NIF (si és particular) o CIF (si és empresa). Comprovarà si el NIF/CIF ja existeix
     * amb el mètode existeixClient, i sino existeix li acabarà demamant una paraula de pas, i afegirà nom, edat,
     * NIF/CIF i paraula de pas dins de l'ArrayList. Si existeix, es confirma que el client ja existeix.
     */
    public static void crearClient() {
        System.out.println("1.- Client Particular\n2.- Client Empresa");
        opcio = 0;
        while (opcio != 1 && opcio != 2) {
            try{
                opcio = lectura.nextInt();
            }catch(Exception e){
                System.out.println("Ha d'escollir entre opció 1 o 2.\n");
            }
            if(opcio != 1 && opcio != 2){
                System.out.println("Ha d'escollir entre opció 1 o 2.\n");
            }
        }try{
            System.out.println("Creant nou client. Ha d'introduir les següents dades: \nIntrodueixi el seu nom: ");
            nom = lectura.next();
            System.out.println("Introdueixi l'edat: ");
            edat = lectura.nextInt();
            System.out.println("Introdueixi el NIF: ");
            nif = lectura.next();
            if (existeixClient(clients, nif)) {
                System.out.println("Aquest client ja està creat");
                return;
            }
            System.out.println("Introdueixi un número de pas");
            Console cnsl = System.console();
            char[] pwd = cnsl.readPassword();
            pass= Integer.parseInt(new String(pwd));
            //pass = lectura.nextInt();
            if (opcio == 1)
                clients.add(new Particular(nom, edat, pass, nif));
            if (opcio == 2)
                clients.add(new Empresa(nom, edat, pass, nif));
        }catch(Exception e){
            System.out.println("Ha introduit malament les dades");
            lectura.next();
            //e.printStackTrace();
        }
        
    }
    /**
     * Mètode entrarApp. Ens permet demanar les dades a l'usuari corresponents al seu NIF/CIF i al seu password.
     * Comprovarem amb la crida del mètode existeixClient que el NIF/CIF introduït correspo a un client, i si es així,
     * obtindrem la seva posició en l'ArrayList de clients mitjançant la crida del mètode posicioClient per tal
     * d'obtenir el password del client. D'aquesta manera, podem veure si el password que acaba d'introduir l'usuari és
     * el mateix que el que s'havia guardat en la seva posició de l'ArrayList clients.
     * Un cop s'ha realitzat amb èxit la comprovació, igualem la variable client amb les dades del client guardades
     * en l'ArrayList de clients per poder maniobrar amb més facilitat a partir d'ara en endavant en el menú de
     * l'Aplicació.
     * @return true si l'usuari ha pogut entrar en l'Aplicació, o false sino ha pogut entrar o bé no hi ha dades
     * de clients en l'ArrayList de clients.
     */
    public static boolean entrarApp(){
        if(!clients.isEmpty()){
            try{
                System.out.println("Entrar a l'aplicació.\nIntrodueixi el seu NIF/CIF: ");
                nif=lectura.next();
                System.out.println("Introdueixi el número de pas: ");
                Console cnsl = System.console();
                char[] pwd = cnsl.readPassword();
                passwordl= Integer.parseInt(new String(pwd));
                //passwordl=lectura.nextInt();
            }catch(Exception e){
                System.out.println("Has introduït malament les dades");
            }
            if(existeixClient(clients,nif)){
                if((clients.get(posicioClient(clients,nif)).getPassword())==(passwordl)){
                    client=clients.get(posicioClient(clients,nif));
                    System.out.println(client.getClass().getSimpleName());
                    //ennumerarComptesClient();
                    return true;
                }
            }
            return false;
        }else{
            System.out.println("No es pot entrar a l'Aplicació. En aquests moments no hi ha dades de clients");
            return false;
        }
    }
    /**
     * Mètode crearCompte. Ens permet crear un compte bancari de tipus Nòmina, Dipòsit, Pla de Pensions o Vivenda si és
     * un client Particular, o bé de tipus Nòmina o Dipòsit si és un client Empresa. Fem una marca per saber si estem
     * amb un client Particular o Empresa, d'aquesta manera només podrà crear els tipus de compte bancari que li
     * hem preguntat. Es genera aleshores un IBAN aleatori segons el tipus de compte que hagi escollit l'usuari.
     * Comprovarà si el compte ja existeix amb el mètode existeixCompte, i sino existeix l'afegeix en l'ArrayList
     * de comptes. En el cas del compte bancari Dipòsit, demanem a l'usuari la quantitat a dipositar (que ha de ser
     * superior a la variable minDiners = 10000).
     */
    public static void crearCompte(){
        if(client.getClass().equals(Particular.class)){
            System.out.println("1.- Nòmina\n2.- Dipòsit\n3.- Pla de pensions\n4.- Vivenda\n");
            flag=true;
        }
        if(client.getClass().equals(Empresa.class)){
            System.out.println("1.- Nòmina\n2.- Dipòsit\n");
            flag=false;
        }
        try{
            opcio=lectura.nextInt();
        }catch(Exception e){
            System.out.println("Torni a introduir la contrassenya");
        }
        switch(opcio){
            case 1:
                System.out.println("Generant el nou número IBAN d'aquest compte: ");
                Random randomGenerator = new Random();
                do {
                    int numero1 = abs(randomGenerator.nextInt(999-100))+100;
                    int numero2 = abs(randomGenerator.nextInt(999999999-100000000))+100000000;
                    iban = "ES2120130733" + numero1 + numero2;
                }while(existeixCompte(comptes,iban));
                System.out.println("El número de compte és: " +iban);
                //iban=lectura.next();
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
                System.out.println("Generant el nou número IBAN d'aquest compte: ");
                Random randomGenerator2 = new Random();
                do {
                    int numero1 = abs(randomGenerator2.nextInt(999-100))+100;
                    int numero2 = abs(randomGenerator2.nextInt(999999999-100000000))+100000000;
                    iban = "ES2120130733" + numero1 + numero2;
                }while(existeixCompte(comptes,iban));
                System.out.println("El número de compte és: " +iban);
                System.out.println("Digues la quantitat a dipositar. +10000");
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
                    System.out.println("El mínim de diners han de ser 10000 euros");
                }
                break;
            case 3:
                if(!flag){
                    System.out.println("Opció incorrecte");
                    break;
                }
                System.out.println("Generant el nou número IBAN d'aquest compte: ");
                Random randomGenerator3 = new Random();
                do {
                    int numero1 = abs(randomGenerator3.nextInt(999-100))+100;
                    int numero2 = abs(randomGenerator3.nextInt(999999999-100000000))+100000000;
                    iban = "ES2120130733" + numero1 + numero2;
                }while(existeixCompte(comptes,iban));
                System.out.println("El número de compte és: " +iban);
                if(!(existeixCompte(comptes,iban,((Particular)client).getNif()))){
                    comptes.add(new PlaPensions(iban,0,client));
                }else{
                    System.out.println("El compte bancari ja existeix");
                }
                break;
            case 4:
                if(!flag){
                    System.out.println("Opció incorrecte");
                    break;
                }
                System.out.println("Generant el nou número IBAN d'aquest compte: ");
                Random randomGenerator4 = new Random();
                do {
                    int numero1 = abs(randomGenerator4.nextInt(999-100))+100;
                    int numero2 = abs(randomGenerator4.nextInt(999999999-100000000))+100000000;
                    iban = "ES2120130733" + numero1 + numero2;
                }while(existeixCompte(comptes,iban));
                System.out.println("El número de compte és: " +iban);
                if(!(existeixCompte(comptes,iban,((Particular)client).getNif()))){
                    comptes.add(new Vivenda(iban,0,client));
                }else{
                    System.out.println("El compte bancari ja existeix");
                }
                break;
            default:
                System.out.println("Opció incorrecte");
                break;
        }
    }
    /**
     * Mètode ennumerarComptesClient. Ens permet accedir al ArrayList de comptes (de tipus CompteBancari) i si el compte
     * a comprovar és de la classe Particular i el client correspon a la classe Particular, aleshores comprovarem si
     * el nif del compte propietari és igual al del client mitjançant el mètode compareTo definit a Particular(permet
     * comparar el NIF dels objectes). Si és així, ens mostrarà per pantalla els comptes bancaris
     * associats al client. Si el compte a comprovar és de la classe Empresa també farà les mateixes comprovacions i
     * mostrarà per pantalla la mateixa informació, si el compte està associat al client.
     */
    public static void ennumerarComptesClient(){
        for(CompteBancari compte: comptes){
            if(compte.getPropietari().getClass().equals(Particular.class)&&client.getClass().equals(Particular.class)){
                if(((Particular)compte.getPropietari()).compareTo(client)==0){
                    System.out.println("Compte "+compte.getClass().getSimpleName()+" IBAN " + compte.getIban());
                }
            }
            if(compte.getPropietari().getClass().equals(Empresa.class)&&client.getClass().equals(Empresa.class)){
                if(((Empresa)compte.getPropietari()).compareTo(client)==0){
                    System.out.println("Compte "+compte.getClass().getSimpleName()+" IBAN " + compte.getIban());
                }
            }
        }
    }
    /**
     * Mètode triarCompteClient. Ens permet comprovar dins de l'ArrayList de comptes (de tipus CompteBancari) si
     * el compte és de la classe Particular i el client correspon a la classe Particular; si és així comprovarem si
     * el nif del compte propietari és igual al del client mitjançant el mètode compareTo definit a Particular (permet
     * comparar el NIF dels objectes). Un cop ha passat aquestes comprovacions, mostra per pantalla cadascun dels
     * comptes bancaris, amb un índex que és un comptador iniciat a 0, i es va sumant internament en aquest comptador +1
     * per cada compte bancari que apareix. A més a més, s'afegeix en una ArrayList comptesClient cadascun dels comptes
     * associats al client Particular. A continuació es demana per pantalla que s'introdueixi el compte a triar segons
     * el número d'índex que se li ha assignat al principi al compte bancari. Per últim, es crea la variable
     * compteClient que guardarà les dades de la posició consultada de l'ArrayList comptesClient.
     * Farà el procediment idèntic si es tracta d'un compte bancari d'un client Empresa.
     */
    public static boolean triarCompteClient(){
        counter1=0;
        comptesClient.clear();
        if(!comptes.isEmpty()){
            for(CompteBancari compte: comptes){
                if(compte.getPropietari().getClass().equals(Particular.class)&&client.getClass().equals(Particular.class)){
                    if(((Particular)compte.getPropietari()).compareTo(client)==0){
                        System.out.println(counter1+" Compte "+compte.getClass().getSimpleName()+" IBAN " + compte.getIban());
                        comptesClient.add(compte);
                        counter1++;
                    }
                }
                if(compte.getPropietari().getClass().equals(Empresa.class)&&client.getClass().equals(Empresa.class)){
                    if(((Empresa)compte.getPropietari()).compareTo(client)==0){
                        System.out.println(counter1+" Compte "+compte.getClass().getSimpleName()+" IBAN "+compte.getIban());
                        comptesClient.add(compte);
                        counter1++;
                    }
                }
            }
            try{
                posicioCompte=lectura.nextInt();
            }catch(Exception e){
                System.out.println("Indica un número de compte vàlid");
                return false;
            }
            if(posicioCompte>(comptesClient.size())-1){
                System.out.println("Indica un número de compte vàlid");
                return false;
            }else{
                compteClient=comptesClient.get(posicioCompte);
                return true;
            }
        }else{
            System.out.println("No has creat cap compte bancari.");
            return false;
        }
    }
    /**
     * Mètode triarCompteClient. Ens permet comprovar dins de l'ArrayList de comptes (de tipus CompteBancari) si el IBAN
     * que li passem com a paràmetre és igual amb algun IBAN dels comptes de l'ArrayList de comptes. Si es així, apareix
     * en pantalla junt amb un índex que hem creat com a comptador per tal que pugui escollir per pantalla fàcilment el
     * número de compte.
     * @param iban
     */
    public static void triarCompteClient(String iban){
        counter2=0;
        for(CompteBancari compte: comptes){
            if(compte.getIban().equals(iban)){
                compteClientDestinatari=comptes.get(counter2);
                System.out.println(counter2+" Compte "+compte.getClass().getSimpleName()+" IBAN "+ compte.getIban());
            }
            counter2++;
        }
    }
    /**
     * Mètode ferTraspas. Primer ens sol·licita el compte bancari del client que ha accedit a l'aplicació desde la qual
     * farem la transferència, cridant el mètode triarCompteClient. A continuació ens sol·licita el IBAN al qual volem
     * fer el traspàs. Per últim, ens sol·licita la quantitat de diners del traspàs. A partir d'aquí, cridarà al mètode
     * traspas de les classes Nomina i PlaPensions ja qu són les úniques que tenen implementades aquest mètode.
     */
    public static void ferTraspas(){

        System.out.print("Desde quin compte bancari vols fer el traspàs?\n");
        if(triarCompteClient()){
            if(compteClient.getClass().equals((Nomina.class))) {
                System.out.println("Posa l'IBAN del compte al qual vols fer el traspàs");
                iban = lectura.next();
                try {
                    triarCompteClient(iban);
                } catch (Exception e) {
                    System.out.println("L'IBAN no existeix");
                }
                System.out.println("Quants diners vols traspassar?");
                try {
                    minD = lectura.nextDouble();
                } catch (Exception e) {
                    System.out.print("Recorda que el número és amb decimals amb un punt\n");
                }
                try {
                    ((Nomina) compteClient).traspas(compteClientDestinatari, minD);
                }catch(Exception e){
                    System.out.print("El compte bancari no existeix\n");
                    lectura.next();
                }
            }else if(compteClient.getClass().equals(PlaPensions.class)){
                System.out.println("Posa l'IBAN del compte al qual vols fer el traspàs");
                iban = lectura.next();
                try {
                    triarCompteClient(iban);
                } catch (Exception e) {
                    System.out.println("L'IBAN no existeix");
                }
                System.out.println("Quants diners vols traspassar?");
                try {
                    minD = lectura.nextDouble();
                } catch (Exception e) {
                    System.out.print("Recorda que el número és amb decimals amb un punt\n");
                }
                try {
                    ((PlaPensions)compteClient).traspas(compteClientDestinatari, minD);
                }catch(Exception e){
                    System.out.print("El compte bancari no existeix\n");
                    lectura.next();
                }
                }else {
                System.out.println("Des d'aquest compte no es poden fer traspassos\n");
            }
        }else{
             System.out.println("No has triat el compte be\n");
        }
    }
    /**
     * Mètode ferIngres. Ens permet fer una consulta per pantalla per seleccionar en quin compte bancari farem l'ingrés.
     * Fa una crida al mètode triarCompteClient, i un cop hem seleccionat el compte del client, ens demana els diners
     * a ingressar. A continuació, es crida al mètode ingressarDiners, desde la variable compteClient, amb l'import
     * desitjat passat com a paràmetre.
     */
    public static void ferIngres(){
        System.out.print("Tria el compte on vols fer l'ingrés\n");
        if(triarCompteClient()){
            System.out.println("Quants diners vols ingressar?");
            try{
            minD=lectura.nextDouble();
            compteClient.ingressarDiners(minD);
            }catch(Exception e){
                System.out.print("Nos has posat una quantitat de diners valida");
            } 
        }else{
            System.out.print("No has seleccionat correctament el compte bancari\n");
        }
    }
    /**
     * Mètode ferConsultaSaldo. Ens permet consultar el saldo del compte bancari que apareix per pantalla. Es crida al
     * mètode triarCompteClient, i a continuació es mostra el saldo del compte del client tot cridant el mètode
     * consultarSaldo desde la variable compteClient.
     */
    public static void ferConsultaSaldo(){
        System.out.print("Tria el compte que vols consultar el saldo\n");
        if(triarCompteClient()){
            System.out.println("Saldo: "+String.format("%.2f", compteClient.consultarSaldo()));
        }else{
            System.out.print("No has seleccionat el compte be\n");
        }
    }
    /**
     * Mètode eliminarCompte. Ens permet eliminar el compte bancari que apareix per pantalla. Es crida al
     * mètode triarCompteClient, i a continuació s'elimina el compte bancari de l'ArrayList comptes coincident amb el
     * de la variable compteClient. Apareix un missatge per pantalla per indicar-nos que el compte ha estat eliminat.
     */
    public static void eliminarCompte(){
        System.out.print("Tria el compte que vols eliminar\n");
        if(triarCompteClient()){
            if(comptes.remove(compteClient)){
                System.out.print("El compte ha estat eliminat\n");
            }
        }else{
            System.out.print("No has seleccionat bé el compte bancari\n");
        }
    }
    /**
     *
     */
    public static void retirarEfectiu(){
        System.out.print("Tria el compte des d'on vols retirar diners\n");
        if(triarCompteClient()){
            System.out.println("Quants diners vols retirar");
            try{
            minD=lectura.nextDouble();
            }catch(Exception e){
                System.out.println("No as introduit una quantitat vàlida");
            }
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
                System.out.print("No es pot fer perquè et quedaries al descobert.\n");
            }
        }else{
            System.out.print("No has seleccionat bé el compte\n");
        }

    }
    public static void solicitarTargeta(){
        System.out.println("Tria el compte en el que vols associar la targeta:");
        if(triarCompteClient()){
            targetes.add(new Targeta(compteClient));
        }else{
            System.out.print("No has seleccionat bé el compte\n");
        }

    }
    public static void comprovarInteressos(){
        System.out.print("Tria el compte on vols mirar els interesos. Recorda que ha de ser un compte dipòsit\n");
        if(triarCompteClient()){
            
            if(compteClient.getClass().equals(Diposit.class)){
                ((Diposit)compteClient).comprovarInteressos(new Date());
            }else{
                System.out.print("No és un compte dipòsit\n");
            }

        }else{
            System.out.print("No has seleccionat bé el compte\n");
        }
    }
    public static void afegirClientComptes() {
        if (clients.isEmpty()) {
            clients.add(new Particular("Esteve", 29, 1234, "43559526X"));
            clients.add(new Particular("Mario", 20, 1234, "3455216Y"));
            clients.add(new Particular("Carlos", 31, 1234, "2324526P"));
            clients.add(new Empresa("Zara", 29, 1234, "23986456T"));
            if (comptes.isEmpty()) {
                comptes.add(new Diposit("ES1533331111430010090101", 50000, clients.get(0)));
                comptes.add(new Nomina("ES1533331111430010090105", 50000, clients.get(0)));
                comptes.add(new Nomina("ES6633331111480010090102", 25000, clients.get(1)));
                comptes.add(new PlaPensions("ES2333331111420010090103", 10000, clients.get(2)));
                comptes.add(new Nomina("ES7433331111470010090104", 99000, clients.get(3)));
            }
            if (targetes.isEmpty()) {
                targetes.add(new Targeta(comptes.get(0)));
                targetes.add(new Targeta(comptes.get(3)));
                targetes.add(new Targeta(comptes.get(1)));
                targetes.add(new Targeta(comptes.get(2)));
                
            }
        }
    }
    public static void mostrarTot(){
        
        for(Client cli: clients){
            System.out.println("Nom propietari: "+cli.getNom()+" Edad: "+cli.getEdat());
        }
        Collections.reverse(comptes);
        for(CompteBancari c: comptes){
            System.out.println("IBAN: "+c.getIban()+" Nom propietari: "+c.getPropietari().getNom()+" Saldo: "+c.getSaldo());
        }
        Collections.sort(targetes);
        for(Targeta t: targetes){
            System.out.println("Numero targeta: "+t.numeroTarjeta+" Nom propietari: "+t.getCompte().getPropietari().getNom()+" Data caducitat:"+data.format(t.dataCaducitat));
        }
    }
}