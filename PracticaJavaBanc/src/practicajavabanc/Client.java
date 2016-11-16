//package practicajavabanc;
/**
 * @author Carlos Rodero, Esteve Cabrera, Mario Recamales
 */
public abstract class Client implements Comparable<Client>  {
    /**
     *Classe abstracta Client. En aquesta classe redefinim mètodes de la classe Object, com ToString i
     * implementem la interfície Comparable per definir el mètode compareTo.
     * Atributs de la classe Client:
     * protected String nom;
     * protected String adresa;
     * protected int edat;
     * protected int password;
     */
    //Atributs
    protected String nom;
    protected String adresa;
    protected int edat;
    protected int password;

    //Constructor
    /**
     * Constructor de la classe Client.
     * @param nom rep el nom del client
     * @param edat rep l'edat del client
     * @param password rep la password del client
     */
    public Client(String nom, int edat, int password) {
        this.nom = nom;
        this.edat = edat;
        this.password = password;
    }

    //Mètodes públics
    /**
     *Getter nom
     * @return nom del client
     */
    public String getNom() {
        return nom;
    }

    /**
     *Getter adreça
     * @return adreça del client
     */
    public String getAdresa() {
        return adresa;
    }

    /**
     *Setter adresa. Estableix adreça del client
     * @param adresa
     */
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    /**
     * Getter edat
     * @return edat del client
     */
    public int getEdat() {
        return edat;
    }

    /**
     * Getter Password.
     * @return password del client
     */
    public int getPassword() {
        return password;
    }

    /**
     * Mètode canviPassword. Li passem el password que ha entrat per consola i el passwordNou, i si el password
     * que ha entrat coincideix amb el seu password, fa un canvi a passwordNou. Sino, apareix missatge en pantalla
     * indicant que s'ha equivocat de password.
     * @param password
     * @param passwordNou
     */
    public void canviPassword(int password, int passwordNou){
        if(password == this.password) {
            this.password = passwordNou;
        }else{
            System.out.println("T'has equivocat de password.");
        }
    }

    /**
     * Override del mètode toString de la classe Object.
     * @return un nou String indicant el nom, adreça i edat del client.
     */
    @Override
    public String toString() {
        return "Client: " +
                "nom='" + nom + '\'' +
                ", adreça='" + adresa + '\'' +
                ", edat='" + edat + '\'' +
                ' ';
    }

    /**
     * Override del mètode compareTo. Ens permet comparar els noms dels clients
     * @param o
     * @return si els noms dels clients són iguals (return 0) o són diferents (return diferent de 0)
     */
    @Override
    public int compareTo(Client o) {
        return nom.compareTo(o.nom);
    }



}