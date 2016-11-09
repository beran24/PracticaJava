package practicajavabanc;
public abstract class Client implements Comparable<Client>{

    protected String nom;
    protected String adreça;
    protected int password;
    protected int edat;

    
    public Client(String nom, int password) {
        this.nom = nom;
        this.password = password;
    }
    public int getEdat() {
        return edat;
    }
    public void setEdat(int edat) {
        this.edat = edat;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getAdreça() {
        return adreça;
    }
    public void setAdreça(String adreça) {
        this.adreça = adreça;
    }
    public int getPassword() {
        return password;
    }
    public void setPassword(int password) {
        this.password = password;
    }
    public void canviPassword(int password, int passwordNou){
        if(password == this.password) {
            this.password = passwordNou;
        }else{
            System.out.println("T'has equivocat de password.");
        }
    }
    @Override
    public String toString() {
        return "Client{" +
                "nom='" + nom + '\'' +
                ", adreça='" + adreça + '\'' +
                '}';
    }
    @Override
    public int compareTo(Client o) {
        return nom.compareTo(o.nom);
    }
}
