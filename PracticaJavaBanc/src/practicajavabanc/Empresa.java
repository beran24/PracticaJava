/**
 * @author Carlos Rodero, Esteve Cabrera, Mario Recamales
 */
public class Empresa extends Client {

    protected String cif;

    public Empresa(String nom, int edat, int password, String cif) {
        super(nom, edat, password);
        this.cif = cif;
    }

    public String getCif() {
        return cif;
    }


    @Override
    public String toString() {
        return super.toString() + ", és una Empresa " +
                "amb CIF=" + cif +
                ' ';
    }

    @Override
    public int compareTo(Client o){
        Empresa aux = (Empresa) o;
        return cif.compareTo(aux.cif);
    }

}
