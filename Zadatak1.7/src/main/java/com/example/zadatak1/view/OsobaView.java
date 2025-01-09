package com.example.zadatak1.view;

public class OsobaView {
    public String setPoruka;
    private String ulazniTekst;
    private static String poruka;

    public OsobaView(String ulazniTekst, String prouka){
        setUlazniTekst(ulazniTekst);
        setPoruka(poruka);
    }

    public OsobaView(){

    }

    public String getUlazniTekst(){
        return ulazniTekst;
    }

    public void setUlazniTekst(String ulazniTekst){
        this.ulazniTekst = ulazniTekst;
    }

    public static String getPoruka(){
        return poruka;
    }

    public static void setPoruka(String novaPoruka){
        poruka = novaPoruka;
    }
}
