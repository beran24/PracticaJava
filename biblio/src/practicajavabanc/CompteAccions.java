package practicajavabanc;
import packclient.*;
import packcomptebancari.*;
/**
 * Interfície CompteAccions que descriu els següents mètodes que s'implementaran:
 * double getSaldo();
 * void ingressarDiners(double importe);
 */
public interface CompteAccions {
    double getSaldo();
    void ingressarDiners(double importe);
}
