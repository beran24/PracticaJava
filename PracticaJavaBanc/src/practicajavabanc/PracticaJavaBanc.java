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
 * @author Carlos Rodero, Esteve Cabrera, Mario Recamales
 */
public class PracticaJavaBanc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nom;
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
        }
    }
    
}
