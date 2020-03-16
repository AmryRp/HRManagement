/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;

/**
 *
 * @author amry4
 */
public class RegionServlet extends HttpServlet {
List<Region> ListRegion;
    IDao<Region> IRegion;

    Region ER = new Region();

    public RegionServlet() {
        IRegion = new GeneralDao();
       
    }
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
            response.sendRedirect(request.getContextPath() + "/region.jsp");
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
    
        switch (request.getQueryString()) {
            case "save":
                save(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
        }
        
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
    public boolean confirm(String id) {
        IRegion = new GeneralDao();
        return (IRegion.manageData(ER, "regionId", id, "", false, false) != null);
    }

    public void save(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          IRegion = new GeneralDao();
        String txtId = request.getParameter("txtId");
        String txtName = request.getParameter("txtName");
        System.out.println(txtId +" "+ txtName );
//save
        if (confirm(txtId)) {
            IRegion.manageData(new Region(new BigDecimal(txtId), txtName),"","",new BigDecimal("0"),true,false);
        } else {
             IRegion.manageData(new Region(new BigDecimal(txtId), txtName),"","",new BigDecimal("0"),true,false);
        }
    }

    public void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          IRegion = new GeneralDao();
        String deptId = request.getParameter("hapusisi");
        IRegion.manageData(ER,"","",new BigDecimal(deptId),true,true);
        PrintWriter out = response.getWriter();
        
       
    }
}
