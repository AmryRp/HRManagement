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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.*;
import org.hibernate.Session;

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
//            response.sendRedirect(request.getContextPath() + "/region.jsp");
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
//        HttpSession session = request.getSession();
//        try (PrintWriter out = response.getWriter()){
//            
//        } 

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
                saveOrUpdate(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "update":
                update(request, response);
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

    public void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        IRegion = new GeneralDao();
         HttpSession session = request.getSession();
        String id = (String) session.getAttribute("updateIdReg");
        String name = (String) session.getAttribute("updateNameReg");
        System.out.println(id + name);
        IRegion.manageData(new Region(new BigDecimal(id), name), "", "", new BigDecimal("0"), true, false);
        response.sendRedirect(request.getContextPath() + "/region.jsp");
    }

    public void save(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        IRegion = new GeneralDao();
        String txtId = request.getParameter("txtId");
        String txtName = request.getParameter("txtName");
        System.out.println(txtId + " " + txtName);
        IRegion.manageData(new Region(new BigDecimal(txtId), txtName), "", "", new BigDecimal("0"), true, false);
    }

    public void saveOrUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        IRegion = new GeneralDao();
        String txtId = request.getParameter("txtId");
        String txtName = request.getParameter("txtName");
        HttpSession session = request.getSession();
        session.setAttribute("updateIdReg", txtId);
        session.setAttribute("updateNameReg", txtName);
        if (confirm(txtId)) {
            out.println("<script src='Sweet_JS/sweetalert2.all.min.js'></script>");
            out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
            out.println("<script>");
            out.println("$(document).ready(function () {");
            out.println("swal({\n"
                    + "        title: \"Warning\",\n"
                    + "        text: \"this Region data Exist want to Update ?\",\n"
                    + "        type: \"warning\",\n"
                    + "        showCancelButton: true,\n"
                    + "        confirmButtonColor: '#DD6B55',\n"
                    + "        confirmButtonText: 'Yes, I am sure!',\n"
                    + "        cancelButtonText: \"No, cancel it!\",\n"
                    + "    }).then(function() {\n"
                    + "      $(this).trigger('submit');\n"
                    + "        swal({\n"
                    + "            title: 'Success!', \n"
                    + "            text: 'Data Updated', \n"
                    + "            type: 'success'\n"
                    + "        }, function() {\n"
                    + "            $(this).trigger('submit');");
            out.println("        }).then(function() {  ");
            out.println("var formz = document.getElementById(\"updatedata\");\n"
                    + "                formz.submit();"
                    + "});\n"
                    + "    },function(dismiss) {\n"
                    + "        if(dismiss == 'cancel') {\n"
                    + "            swal(\"Cancelled\", \"not updated\", \"error\").then(function() {\n"
                    + "    window.location = 'region.jsp';\n"
                    + "});\n"
                    + "        }\n"
                    + "    });"
                    + "});");
            out.println("</script>");

            RequestDispatcher rd = request.getRequestDispatcher("region.jsp");
            rd.include(request, response);

        } else {
            out.println("<script src='Sweet_JS/sweetalert2.js'></script>");
            out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
            out.println("<script>");
            out.println("$(document).ready(function () {");
            out.println("swal ( 'Data has been saved' ,  ' ' ,  'success' ).then(function() {\n"
                    + "    window.location = 'region.jsp';\n"
                    + "});");
            out.println("});");
            out.println("</script>");
            RequestDispatcher rd = request.getRequestDispatcher("region.jsp");
            rd.include(request, response);
            save(request, response);
        }
    }

    public void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        IRegion = new GeneralDao();
        String deptId = request.getParameter("hapusisi");
        IRegion.manageData(ER, "", "", new BigDecimal(deptId), true, true);
        response.sendRedirect(request.getContextPath() + "/region.jsp");
//        PrintWriter out = response.getWriter();
//        out.println("<script src='Sweet_JS/sweetalert2.js'></script>");
//        out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
//        out.println("<script>");
//        out.println("$(document).ready(function () {");
//        out.println("swal ( 'Data has been deleted' ,  ' ' ,  'success' ).then(function() {\n"
//                + "    window.location = 'region.jsp';\n"
//                + "});");
//        out.println("});");
//        out.println("</script>");
//        RequestDispatcher rd = request.getRequestDispatcher("region.jsp");
//        rd.include(request, response);
    }

    public List getData() {
        ListRegion = IRegion.manageData(new Region(), "regionName", "", "", false, true);
        return ListRegion;
    }

}
