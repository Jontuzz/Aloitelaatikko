/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serveletit;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Tietovarastopakkaus.*;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author s1601378
 */
@WebServlet(name = "lisaaAloite", urlPatterns = {"/lisaaAloite"})
public class lisaaAloite extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    //Määritellään viittaus Tietovarasto-luokkaan
    private Tietovarasto tietovarasto = new Tietovarasto();
    private Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        String kayttajaID = request.getParameter("kayttajaID");
        String aloitenimi = request.getParameter("aloitenimi");
        String aloitekuvaus = request.getParameter("aloitekuvaus");
        
        String luontipaivays = sdf.format(date);
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet lisaaAloite</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("Käyttäjän ID:" + kayttajaID + "<br />");
            out.println("Aloitenimi: " + aloitenimi + "<br />");
            out.println("Aloitekuvaus: " + aloitekuvaus + "<br />");
            out.println("Aloitteen päivämäärä: " + luontipaivays + "<br />");
            
            
            //Luodaan Aloite olio
            Aloite aloite = new Aloite(0, aloitenimi, aloitekuvaus, luontipaivays, Integer.parseInt(kayttajaID));
            
            if (tietovarasto.lisaaAloite(aloite)) {
                // Lisäys onnistui
                out.println("<h2>Aloitteen lisäys onnistui</h2>");
            } else {
                // Lisäys epäonnistui
                out.println("<h2>Aloitteen lisäys epäonnistui</h2>");
            }
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
