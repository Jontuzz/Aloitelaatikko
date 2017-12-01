<%-- 
    Document   : lisaaAloite
    Created on : Nov 14, 2017, 2:20:51 PM
    Author     : s1601378
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Uusi aloite</title>
    </head>
    <body>
        <h1>Luo uusi aloite!</h1>
        
        <form name="lisaaAloite" action="../../Aloitelaatikko/lisaaAloite" method="post">
            <input type="text" name="kayttajaID" placeholder="kayttajaID"/><br /><br />
            <input type="text" name="aloitenimi" placeholder="Aloitteen nimi"/><br /><br />
            <textarea name="aloitekuvaus" placeholder="Aloitteen kuvaus" rows="7" cols="70" /></textarea> <br /><br />
        
            <input type="reset" value="Tyhjennä" name="tyhjenna" />
            <input type="submit" value="Talleta aloite" name="luoAloite" />
        </form>
        
        
    </body>
</html>
