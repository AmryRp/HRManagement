package servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import dao.GeneralDao;
import dao.IDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import model.Useraccount;
import tool.BCrypt;

/**
 *
 * @author amry4
 */
public class LoginServlet extends HttpServlet {

    List<Useraccount> ListAccount;
    IDao<Useraccount> IAccount;
    Useraccount ua = new Useraccount();

    public LoginServlet() {
        super();
        IAccount = new GeneralDao();
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
        String username = request.getParameter("Username");
        String password = request.getParameter("Password");
        PrintWriter out = response.getWriter();
        if (getPassword(username).equals("failed")) {
            out.println("<script src='Sweet_JS/sweetalert2.js'></script>");
            out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
            out.println("<script>");
            out.println("$(document).ready(function () {");
            out.println("swal ( 'incorrect id !' ,  ' ' ,  'error' ).then(function() {\n"
                    + "    window.location = 'login.jsp';\n"
                    + "});");
            out.println("$  });");
            out.println("</script>");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.include(request, response);
        } else {
            ListAccount = IAccount.manageData(new Useraccount(), "username", username, new BigDecimal("0"), false, false);
            if ((BCrypt.checkpw(password, ListAccount.get(0).getPassword()))
                    && (username.equals(ListAccount.get(0).getUsername()))) {
                response.sendRedirect(request.getContextPath() + "/mainMenu.jsp");
            } else {
                out.println("<script src='Sweet_JS/sweetalert2.js'></script>");
                out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                out.println("<script>");
                out.println("$(document).ready(function(){");
                out.println("swal ( 'incorrect password !' ,  ' ' ,  'error' );");
                out.println("});");
                out.println("</script>");
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.include(request, response);
            }
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

    public String getPassword(String username) {
        IAccount = new GeneralDao();
        return (IAccount.manageData(new Useraccount(), "username", username, new BigDecimal("0"), false, false) != null) ? "sukses" : "failed";
    }
}
