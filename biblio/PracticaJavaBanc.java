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
        
        int opcio=0;
        int opcio2=0;

        while (true) {
            System.out.println("Benvinguda al Portal JavaBank\n\nEscull una opció:\n1.- Crear client\n2.- Entrar a l'aplicació\n3.-Activar clients inicials amb comptes");
            Scanner scan = new Scanner(System.in);
            try{
            opcio = scan.nextInt();
            }catch(Exception e){
                System.out.println("Posa un numero siusplau");
            }
            switch (opcio) {
                case 1:
                    BancUtil.crearClient();
                    break;
                case 3:
                    BancUtil.afegirClientComptes();
                    break;
                case 2:
                    if(BancUtil.entrarApp()){
                        opcio2=0;
                        while(opcio2!=9){
                            System.out.println("_______________________________________________");
                            BancUtil.ennumerarComptesClient();
                            System.out.println("Escull la operació que vulguis fer: \n1.- Crear compte\n2.- Fer ingres\n3.- Retirar efectiu\n4.- Consulta saldo\n5.- Fer traspas\n6.- Solicitar targeta\n7.- Eliminar Compte\n8.- Comprovar interesos\n9.- Enrere\n");
                            try{
                            opcio2 = scan.nextInt();
                            }catch(Exception e){
                                System.out.println("No es una opcio, torna a triar");
                            }
                            switch (opcio2){
                                case 1:
                                    BancUtil.crearCompte();
                                    break;
                                case 2:
                                    BancUtil.ferIngres();
                                    break;
                                case 3:
                                    BancUtil.retirarEfectiu();
                                    break;
                                case 4:
                                    BancUtil.ferConsultaSaldo();
                                    break;
                                case 5:
                                    BancUtil.ferTraspas();
                                    break;   
                                case 6:
                                    BancUtil.solicitarTargeta();
                                    break;
                                case 7:
                                    BancUtil.eliminarCompte();
                                    break;
                                case 8:
                                    BancUtil.comprovarInteressos();
                                    break;    
                                case 9:
                                    opcio2=9;
                                    break;
                                default:
                                    System.out.println("La opció escollida és incorrecte. Torna a introduir una opció.\n");
                            }
                        }
                    }else{
                        System.out.println("Les dades introduïdes són incorrectes\n");
                        break;
                    }
                    break;
                default:
                    System.out.println("La opció escollida és incorrecte. Torna a introduir una opció.\n");

            }
        }


    }
    
}
