//package practicajavabanc;
/**
 * @author Carlos Rodero, Esteve Cabrera, Mario Recamales
 */
public class Empresa extends Client {
    /**
     * Classe Empresa, hereta de la classe Client. Redefinició del mètode toString i compareTo.
     * Atributs de la classe Empresa:
     * protected String cif
     */
    //Atributs
    protected String cif;

    /**
     * Constructor de la classe Empresa
     * @param nom
     * @param edat
     * @param password
     * @param cif
     */
    //Constructor
     public Empresa(String nom, int edat, int password, String cif) {
        super(nom, edat, password);
        this.cif = cif;
    }
    //Métodes públics
    /**
     * Getter cif
     * @return cif de l'empresa
     */
    public String getCif() {
        return cif;
    }

    /**
     * Override del mètode toString de la classe Object.
     * @return un nou String indicant el nom, adreça, edat, que és una empresa i el seu CIF.
     */
    @Override
    public String toString() {
        return super.toString() + ", és una Empresa{" +
                "amb CIF=" + cif +
                '}';
    }

    /**
     * Override del mètode compareTo. Ens permet comparar els cifs de les emkpreses
     * @param o
     * @return si els cifs de les empreses són iguals (return 0) o són diferents (return diferent de 0)
     */
    @Override
    public int compareTo(Client o){
        Empresa aux = (Empresa) o;
        return cif.compareTo(aux.cif);
    }

}
