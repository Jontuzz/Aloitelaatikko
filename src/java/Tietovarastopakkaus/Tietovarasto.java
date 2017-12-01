/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tietovarastopakkaus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author s1601378
 */
public class Tietovarasto {

    //Yhteysmuuttujat
    private String ajuri;
    private String url;
    private String kayttajatunnus;
    private String salasana;

    public Tietovarasto(String ajuri, String url, String kayttajatunnus, String salasana) {
        this.ajuri = ajuri;
        this.url = url;
        this.kayttajatunnus = kayttajatunnus;
        this.salasana = salasana;
    }

    public Tietovarasto() {
        this("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/aloitelaatikko", "root", "");
    }

    public boolean lisaaKayttaja(Kayttaja kayttaja) {

        Connection yhteys = null;
        PreparedStatement lisayslause = null;

        try {
            // Otetaan yhteys tietokantaan
            yhteys = Yhteydenhallinta.avaaYhteys(ajuri, url, kayttajatunnus, salasana);
            //jos yhteyttä ei saada, niin palautetaan false
            if (yhteys == null) {
                return false;
            }
            // Määritellään lisäystä varten SQL-lauseet
            String lisaaKayttajaSQL = "INSERT INTO kayttajat (etunimi, sukunimi, email, kayttajatunnus, salasana, puhelin, luontipaivays) VALUES(?, ?, ?, ?, ?, ?, ?)";
            
            lisayslause = yhteys.prepareStatement(lisaaKayttajaSQL);
            
            // Valmistellaan SQL-lause tietokantapalvelinta varten
//            lisayslause.setInt(1, kayttaja.getKayttajaID());
            lisayslause.setString(1, kayttaja.getEtunimi());
            lisayslause.setString(2, kayttaja.getSukunimi());
            lisayslause.setString(3, kayttaja.getEmail());
            lisayslause.setString(4, kayttaja.getKayttajaTunnus());
            lisayslause.setString(5, kayttaja.getSalasana());
            lisayslause.setString(6, kayttaja.getPuhelin());
            lisayslause.setString(7, kayttaja.getLuontiPaivays());
            
            //Suoritetaan palvelimella SQL-lause
            return lisayslause.executeUpdate() > 0;
            
        } catch (SQLException ex) {
            //Jos tuli virhe, niin hypätään tänne
            ex.printStackTrace();
            return false;

        } finally {
            // Suljetaan yhteys tietokantaan
            Yhteydenhallinta.suljeLause(lisayslause);
            Yhteydenhallinta.suljeYhteys(yhteys);
        }
    }
    
    public boolean lisaaAloite(Aloite aloite) {
        
        Connection yhteys = null;
        PreparedStatement lisayslause = null;
        
        try {
            yhteys = Yhteydenhallinta.avaaYhteys(ajuri, url, kayttajatunnus, salasana);
            if (yhteys == null) {
                return false;
            }
            //Määritetään aloitteen lisäystä varten SQL-lause
            String lisaaAloiteSQL = "INSERT INTO aloitteet (aloitenimi, aloitekuvaus, pvm, kayttajaID) VALUES(?, ?, ?, ?)";
            
            lisayslause = yhteys.prepareStatement(lisaaAloiteSQL);
            
            lisayslause.setString(1, aloite.getAloitenimi());
            lisayslause.setString(2, aloite.getAloitekuvaus());
            lisayslause.setString(3, aloite.getPvm());
            lisayslause.setInt(4, aloite.getKayttajaID());
            
            return lisayslause.executeUpdate() > 0;
        } catch (SQLException ex) {
            //Jos tuli virhe, niin hypätään tänne
            ex.printStackTrace();
            return false;

        } finally {
            // Suljetaan yhteys tietokantaan
            Yhteydenhallinta.suljeLause(lisayslause);
            Yhteydenhallinta.suljeYhteys(yhteys);
        }
    }
    
    public List<Aloite> haeKaikkiAloitteet() {
        // Luodaan aloitteet niminen lista
        List<Aloite> aloitteet = new ArrayList<Aloite>();
        // Määritellään tietokannan käsittelyyn tarvittavat oliomuuttujat
        Connection yhteys = null;
        PreparedStatement hakulause = null;
        ResultSet tulosjoukko = null;
        
        try {
            //Avataan tietokantayhteys
            yhteys = Yhteydenhallinta.avaaYhteys(ajuri, url, kayttajatunnus, salasana);
            // Tarkistetaan onko yhteys tietokantaan olemassa
            if (yhteys != null) {
                // Määritellään SQL-lause, jolla haetaan kaikki aloitteet
                String haeKaikkiSql = "SELECT * FROM aloitteet";
                // Suoritetaan tietokantahaku
                hakulause = yhteys.prepareStatement(haeKaikkiSql);
                // Talletetaan kaikki aloitteet oliomuuttujaan tulosjoukko
                tulosjoukko = hakulause.executeQuery();
                // Lisätään aloitteet listaan
                while (tulosjoukko.next()) {
                    int aloiteID = tulosjoukko.getInt("aloiteID");
                    String aloitenimi = tulosjoukko.getString("aloitenimi");
                    String aloitekuvaus = tulosjoukko.getString("aloitekuvaus");
                    String pvm = tulosjoukko.getString("pvm");
                    int kayttajaID = tulosjoukko.getInt("kayttajaID");
                    // Lisätään listaan
                    aloitteet.add(new Aloite(aloiteID, aloitenimi, aloitekuvaus, pvm, kayttajaID));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Yhteydenhallinta.suljeTulosjoukko(tulosjoukko);
            Yhteydenhallinta.suljeLause(hakulause);
            Yhteydenhallinta.suljeYhteys(yhteys);
        }
        // Palautetaan aloitteet kutsuvalle ohjelmalle
        // Aloitteet on talletettu listarakenteeseen
        return aloitteet;
    }
    
    public boolean lisaaToimenpide(Toimenpide toimenpide) {
        Connection yhteys = null;
        PreparedStatement lisayslause = null;
        
        try {
            // Otetaan yhteys tietokantaan
            yhteys = Yhteydenhallinta.avaaYhteys(ajuri, url, kayttajatunnus, salasana);
            if (yhteys == null) {
                return false;
            }
            //Määritetään toimenpiteen lisäystä varten SQL-lause
            String lisaaAloiteSQL = "INSERT INTO toimenpiteet VALUES(?, ?, ?, ?, ?)";
            
            lisayslause = yhteys.prepareStatement(lisaaAloiteSQL);
            
            lisayslause.setInt(1, toimenpide.getToimenpideID());
            lisayslause.setString(2, toimenpide.getKuvaus());
            lisayslause.setString(3, toimenpide.getPvm());
            lisayslause.setInt(4, toimenpide.getKayttajaID());
            lisayslause.setInt(5, toimenpide.getAloiteID());
            
            return lisayslause.executeUpdate() > 0;
        } catch (SQLException ex) {
            //Jos tuli virhe, niin hypätään tänne
            ex.printStackTrace();
            return false;

        } finally {
            // Suljetaan yhteys tietokantaan
            Yhteydenhallinta.suljeLause(lisayslause);
            Yhteydenhallinta.suljeYhteys(yhteys);
        }
    }
}
