/**
 * @author Carlos Rodero, Esteve Cabrera, Mario Recamales
 */
public class Particular extends Client {

    protected String nif;

    public Particular(String nom, int edat, int password, String nif) {
        super(nom, edat, password);
        this.nif = nif;
    }

    public String getNif() {
        return nif;
    }


    @Override
    public String toString() {
        return super.toString() +", és un Particular " +
                "amb NIF=" + nif +
                ' ';
    }

    @Override
    public int compareTo(Client o){
        Particular aux = (Particular)o;
        return nif.compareTo(aux.nif);
    }
}
