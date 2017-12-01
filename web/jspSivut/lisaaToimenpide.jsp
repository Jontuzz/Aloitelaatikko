<%-- 
    Document   : lisaaToimenpide
    Created on : Nov 21, 2017, 3:08:54 PM
    Author     : s1601378
--%>
<%@page import="Tietovarastopakkaus.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Toimenpiteen kirjaus</title>
    </head>
    <body>
        <%
            Tietovarasto tietovarasto = new Tietovarasto();
        %>
        <h1>Toimenpiteen kirjaus!</h1>
        <% request.setCharacterEncoding("UTF-8"); 
        // Otetaan aloiteID ja aloitekuvaus talteen muuttujiin
        String aloiteID = request.getParameter("aloiteID");
        String aloitekuvaus = request.getParameter("aloitekuvaus");
        %>
        
        <p>Aloitteen kuvaus: <%=aloitekuvaus %></p>
        
        <form action="../../Aloitelaatikko/lisaaToimenpide" method="POST">
            
            Toimenpide: <br />
            <textarea name="kuvaus" rows="4" cols="30"></textarea><br />
            
            Toimenpiteen kirjasi: <br />
            <input type="text" name="kayttajaID" size="5"><br /><br />
            
            <button type="submit" value="submit">Tallenna toimenpide</button>
            <button type="reset" value="Tyhjennä">Tyhjennä kentät</button>
            
            <input type="hidden" name="aloiteID" value='<%=aloiteID %>'>
            
        </form>
        
    </body>
</html>
