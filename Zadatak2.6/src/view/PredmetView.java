package view;

public class PredmetView {
    private String ulazniTekst;
    private static String poruka;

    public PredmetView(String ulazniTekst, String poruka){
        setPoruka(poruka);
        setUlazniTekst(ulazniTekst);
    }

    public String getUlazniTekst(){
        return  ulazniTekst;
    }

    public void setUlazniTekst(String ulazniTekst){
        this.ulazniTekst=ulazniTekst;
    }

    public static String getPoruka(){
        return poruka;
    }

    public void setPoruka(String poruka){
        this.poruka=poruka;
    }
}
