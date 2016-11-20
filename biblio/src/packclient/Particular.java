package packclient;
/**
 * @author Carlos Rodero, Esteve Cabrera, Mario Recamales
 */
public class Particular extends Client {
    /**
     * Classe Particular, hereta de la classe Client. Redefinició del mètode toString i compareTo.
     * Atributs de la classe Particular:
     * protected String nif
     */
    //Atributs
    protected String nif;

    /**
     * Constructor de la classe Particular.
     * @param nom rep el nom del particular
     * @param edat rep l'edat del particular
     * @param password rep la password del particular
     * @param nif rep el nif del particular
     */
    //Constructor
    public Particular(String nom, int edat, int password, String nif) {
        super(nom, edat, password);
        this.nif = nif;
    }
    //Mètodes públics

    /**
     * Getter nif
     * @return nif del particular
     */
    public String getNif() {
        return nif;
    }

    /**
     * Override del mètode toString de la classe Object.
     * @return un nou String indicant el nom, adreça, edat, que és un particular i el seu NIF.
     */
    @Override
    public String toString() {
        return super.toString() +", és un Particular{" +
                "amb NIF=" + nif +
                '}';
    }

    /**
     * Override del mètode compareTo. Ens permet comparar els nifs dels particulars
     * @param o rep un objecte Client
     * @return si els nifs dels particulars són iguals (return 0) o són diferents (return diferent de 0)
     */
    @Override
    public int compareTo(Client o){
        Particular aux = (Particular)o;
        return nif.compareTo(aux.nif);
    }
}
