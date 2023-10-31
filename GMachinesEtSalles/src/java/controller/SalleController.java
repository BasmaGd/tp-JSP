/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Salle;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.SalleService;
import services.MachineService;

/**
 *
 * @author DELL
 */
@WebServlet(name = "SalleController", urlPatterns = {"/SalleController"})
public class SalleController extends HttpServlet {

    SalleService ss = new SalleService();
   

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
  if (request.getParameter("op") != null) {
            if (request.getParameter("op").equals("delete")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Salle salleToDelete = ss.findById(id);
                System.out.println(id);
                
                System.out.println(ss.findById(id));
                System.out.println("=========================================");
              
                    ss.delete(ss.findById(id));
                
            } else if (request.getParameter("op").equals("update")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String code = request.getParameter("code");
                Salle salleToUpdate = ss.findById(id);
                if (salleToUpdate != null) {
                    salleToUpdate.setCode(code);
                    ss.update(salleToUpdate);
                }
            }
        } else {
            String code = request.getParameter("code");
            Salle newSalle = new Salle();
            newSalle.setCode(code);
            ss.create(newSalle);
        }
        response.sendRedirect("salle.jsp");

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
         System.out.println("get");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "SalleController";
    }// </editor-fold>

}
