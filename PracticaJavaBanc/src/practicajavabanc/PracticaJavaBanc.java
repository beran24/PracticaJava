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
        
        int opcio;
        int opcio2;

        while (true) {
            System.out.println("Benvinguda al Portal JavaBank\n\nEscull una opció:\n1.- Crear client\n2.- Entrar a l'aplicació");
            Scanner scan = new Scanner(System.in);
            opcio = scan.nextInt();

            switch (opcio) {
                case 1:
                    BancUtil.crearClient();
                    System.out.println("Chivato creacio");
                    break;
                case 2:
                    if(BancUtil.entrarApp()){
                        System.out.println("Escull la operació que vulguis fer: " +"\n1.- Traspàs\n2.- Crear compte\n9.- Enrere");
                        opcio2 = scan.nextInt();
                        while(opcio2!=9){
                            switch (opcio2){
                                case 1:
                                    System.out.println("Traspas");
                                    break;
                                case 2:
                                    BancUtil.crearCompte();
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    break;
                                case 5:
                                    break;   
                                case 6:
                                    break;
                                case 9:
                                    opcio2=9;
                                    break;
                            }
                        }

                    }else{
                        System.out.println("Les dades introduïdes són incorrectes.");
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
