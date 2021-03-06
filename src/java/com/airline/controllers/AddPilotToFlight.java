/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.controllers;

import com.airline.models.Pilot;
import com.airline.models.PilotRank;
import com.airline.service.FlightService;
import com.airline.service.PilotService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dlpuertaj
 */
@WebServlet(name = "AddPilotToFlight", urlPatterns = {"/addPilotToFlight"})
public class AddPilotToFlight extends HttpServlet {

    
    @EJB
    PilotService ps;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddPilotToFlight</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Pilot to flight added!</h1>");
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
        
//        String pId = request.getParameter("pId");
//        String fId = request.getParameter("fId");
//        
//        fs.addPilotToFlight(pId, fId);
//        
//        processRequest(request, response);
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
        /* En el video crean un nuevo servlet llamado CreatePilotAndAddToFlight
         * Yo he decidido hacerlo aquí.*/
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        Integer license = Integer.parseInt(request.getParameter("license"));
        String rank = request.getParameter("pilot_rank");
        
        
        Pilot p = new Pilot();
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setPilotLicense(license);
        p.setPilotRank(PilotRank.valueOf(rank));
        
        String flightId = request.getParameter("fId");
        
        ps.addNewPilotToFlight(p, flightId);
        
        response.sendRedirect("Flights");
        
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
