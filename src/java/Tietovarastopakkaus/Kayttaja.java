/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tietovarastopakkaus;


public class Kayttaja {
    
    private int kayttajaID;
    private String etunimi;
    private String sukunimi;
    private String email;
    private String kayttajaTunnus;
    private String salasana;
    //private String syntymaAika;    
    private String puhelin;
    private String luontiPaivays;

    public Kayttaja(int kayttajaID, String etunimi, String sukunimi, String email, String kayttajaTunnus, String salasana, String puhelin, String luontiPaivays) {
        this.kayttajaID = kayttajaID;
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.email = email;
        this.kayttajaTunnus = kayttajaTunnus;
        this.salasana = salasana;
        //this.syntymaAika = syntymaAika;
        this.puhelin = puhelin;
        this.luontiPaivays = luontiPaivays;
    }

    public int getKayttajaID() {
        return kayttajaID;
    }

    public String getEtunimi() {
        return etunimi;
    }

    public String getSukunimi() {
        return sukunimi;
    }

    public String getEmail() {
        return email;
    }

    public String getKayttajaTunnus() {
        return kayttajaTunnus;
    }

    public String getSalasana() {
        return salasana;
    }

    public String getPuhelin() {
        return puhelin;
    }

    public String getLuontiPaivays() {
        return luontiPaivays;
    }
}
