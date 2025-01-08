package view;

public class OsobaView {
    private String ulazniTekst;
    private String poruka;

    public OsobaView(String ulazniTekst, String poruka){
        setUlazniTeskt(ulazniTekst);
        setPoruka(poruka);
    }

    public OsobaView() {

    }

    public void setUlazniTeskt(String ulazniTekst){
this.ulazniTekst = ulazniTekst;

    }

    public void setPoruka(String poruka){
        this.poruka = poruka;

        
    }

    public String getUlazniTekst() {
        return ulazniTekst;
    }

    public String getPoruka() {
        return poruka;
    }
}

