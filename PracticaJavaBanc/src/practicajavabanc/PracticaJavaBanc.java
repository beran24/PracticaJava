import java.util.ArrayList;
import java.util.Scanner;
//package practicajavabanc;
/**
 * @author Carlos Rodero, Esteve Cabrera, Mario Recamales
 */
public class PracticaJavaBanc {

    public static void main(String[] args) {

        int opcio=0;
        int opcio2=0;

        while (true) {
            System.out.println("Benvinguda al Portal JavaBank\n\nEscull una opció:\n1.- Crear client\n" +
                    "2.- Entrar a l'aplicació\n3.- Activar ");
            Scanner scan = new Scanner(System.in);
            try{
                opcio = scan.nextInt();
            }catch(Exception e){
                System.out.println("Escull una de les opcions, siusplau");
            }
            switch (opcio) {
                case 1:
                    BancUtil.crearClient();
                    break;
                case 2:
                    if(BancUtil.entrarApp()){
                        opcio2=0;
                        while(opcio2!=9){
                            System.out.println("_______________________________________________");
                            BancUtil.ennumerarComptesClient();
                            System.out.println("Escull la operació que vulguis fer: \n1.- Crear compte bancari\n" +
                                    "2.- Fer un ingrés\n3.- Retirar efectiu\n4.- Consultar saldo\n5.- Fer un traspàs\n" +
                                    "6.- Sol·licitar targeta\n7.- Eliminar compte bancari\n8.- Comprovar interessos\n" +
                                    "9.- Enrere\n");
                            try{
                                opcio2 = scan.nextInt();
                            }catch(Exception e){
                                System.out.println("Escull una de les opcions, siusplau");
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
                /*case 3:
                    BancUtil.afegirClientComptes();
                    break;*/
                default:
                    System.out.println("La opció escollida és incorrecte. Torna a introduir una opció.\n");

            }
        }


    }

}