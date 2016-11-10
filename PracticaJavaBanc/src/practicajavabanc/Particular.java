package practicajavabanc;
/**
 * Created by Esteve, Mario, Carlos on 09/11/2016.
 */
public class Particular extends Client {

    protected String nif;

    public Particular(String nom, int password, String nif) {
        super(nom, password);
        this.nif = nif;
    }
    public String getNif() {
        return nif;
    }
    public void setNif(String nif) {
        this.nif = nif;
    }
    @Override
    public String toString() {
        return super.toString() +", és un Particular{" +
                "amb NIF=" + nif +
                '}';
    }
    @Override
    public int compareTo(Client o){
        Particular aux = (Particular)o;
        return nif.compareTo(aux.nif);
    }
}
