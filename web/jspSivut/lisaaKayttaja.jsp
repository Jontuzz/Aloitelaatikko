<%-- 
    Document   : lisaaTekija
    Created on : Oct 31, 2017, 2:52:44 PM
    Author     : s1601378
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Käyttäjän lisääminen</title>
    </head>
    <body>
        <h1>Uuden käyttäjän lisäys</h1>
        <form name="lisäys" action="../../Aloitelaatikko/lisaaKayttaja" method="post">
            <input type="text" name="etunimi" placeholder="Etunimi" /><br />
            <input type="text" name="sukunimi" placeholder="Sukunimi" /><br />
            <input type="email" name="email" placeholder="Email" /><br />
            <input type="text" name="kayttajatunnus" placeholder="Käyttäjätunnus" /><br />
            <input type="password" name="salasana" placeholder="Salasana" /><br />
            <input type="text" name="puhelin" placeholder="Puhelinnumero" /><br />
            <!-- <input type="date" name="luontipaivays"><br> -->
            
            <input type="reset" value="Tyhjennä" name="reset"/>
            <input type="submit" value="Talleta" name="talleta" />
        </form>
    </body>
</html>
