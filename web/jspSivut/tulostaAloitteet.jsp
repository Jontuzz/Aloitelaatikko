<%-- 
    Document   : tulostaAloitteet
    Created on : Nov 24, 2017, 1:50:20 PM
    Author     : s1601378
--%>
<%@page import="Tietovarastopakkaus.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Aloitteiden tulostus</title>
    </head>
    <body>
        <%
          Tietovarasto tietovarasto = new Tietovarasto();
        %>
        <h1>Kaikki aloitteet</h1>
        
        <table border="1">
            <thead>
                <tr>
                    <th>Aloitetunnus</th>
                    <th>Nimi</th>
                    <th>Kuvaus</th>
                    <th>pvm</th>
                    <th>Tekijätunnus</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (Aloite aloite : tietovarasto.haeKaikkiAloitteet()) {                         
                %>
                <tr>
                    <td><%= aloite.getAloiteID() %></td>
                    <!-- Lähetetään aloitteen lisäksi aloiteID ja
                    aloitekuvaus servletille -->
                    <td><a href='lisaaToimenpide.jsp?aloiteID=<%=aloite.getAloiteID() %>&aloitekuvaus=<%= aloite.getAloitekuvaus() %>'><%=aloite.getAloitenimi() %></a></td>
                    <td><%= aloite.getAloitekuvaus() %></td>
                    <td><%= aloite.getPvm()%></td>
                    <td><%= aloite.getKayttajaID() %></td>
                </tr>
                <% } %>
            </tbody>
        </table>
        
    </body>
</html>
