/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Carlos Rodero, Esteve Cabrera, Mario Recamales
 */
public class PracticaJavaBanc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*String nom;
        int pass;
        String nif;
        ArrayList<Client> clients= new ArrayList<>();
        Scanner lectura=new Scanner(System.in);
        int nResposta=1;      
        while(nResposta!=99){
            nResposta= lectura.nextInt();
            switch(nResposta){
                case 1:
                    System.out.println("Crea un client.Digues nom");
                    nom=lectura.next();
                    System.out.println("Posa el nif");
                    nif=lectura.next();
                    System.out.println("Posa una password");
                    pass=lectura.nextInt();
                    clients.add(new Particular(nom,pass,nif));
                case 2:
            }
        }*/
        int opcio;

        System.out.println("Benvinguda al Portal JavaBank\n\nEscull una opció:\n1.- Crear client\n2.- Entrar a l'aplicació");
        Scanner scan = new Scanner(System.in);

        while (1==1) {

            opcio = scan.nextInt();

            switch (opcio) {
                case 1:
                    //crearClient();
                    System.out.println("A");
                    break;
                case 2:
                    //entrarApp();
                    if(true){
                        System.out.println("Escull la operació que vulguis fer: " +
                                "\n1.- Traspàs")
                        ;
                        opcio = scan.nextInt();
                        switch (opcio){
                            case 1:

                                break;


                        }

                    }else{
                        System.out.println("Les dades introduïdes són incorrectes. Torna a introduir una opció:" +
                        "\n1.- Crear client\n2.- Entrar a l'aplicació");
                        break;
                    }

                    System.out.println("B");
                    break;
                default:
                    System.out.println("La opció escollida és incorrecte. Torna a introduir una opció.");

            }
        }



    }
    
}
