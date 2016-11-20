

package packclient;
import practicajavabanc.*;
import packcomptebancari.*;
public abstract class Client implements Comparable<Client>  {

    protected String nom;
    protected String adreça;
    protected int edat;
    protected int password;

    public Client(String nom, int edat, int password) {
        this.nom = nom;
        this.edat = edat;
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public String getAdreça() {
        return adreça;
    }

    public void setAdreça(String adreça) {
        this.adreça = adreça;
    }

    public int getEdat() {
        return edat;
    }

    public int getPassword() {
        return password;
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
        return "Client: " +
                "nom='" + nom + '\'' +
                ", adreça='" + adreça + '\'' +
                ", edat='" + edat + '\'' +
                ' ';
    }

    @Override
    public int compareTo(Client o) {
        return nom.compareTo(o.nom);
    }



}