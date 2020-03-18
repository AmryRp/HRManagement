/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import org.hibernate.SessionFactory;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import tool.HibernateUtil;

/**
 *
 * @author amry4
 */
public class ReportServlet extends HttpServlet {

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
            response.sendRedirect(request.getContextPath() + "/mainMenu.jsp");
            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ReportServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ReportServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
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
        System.out.println(request.getQueryString());
        try {
            switch (request.getQueryString()) {
                case "region":
                    reportfix("/WEB-INF/regionReport.jrxml", request, response);
                    break;
                case "country":
                    reportfix("/WEB-INF/countryReport.jrxml", request, response);
                    break;
                case "location":
                    reportfix("/WEB-INF/locationReport.jrxml", request, response);
                    break;
                case "department":
                    reportfix("/WEB-INF/departmentReport.jrxml", request, response);
                    break;
                case "employee":
                    reportfix("/WEB-INF/employeeReport.jrxml", request, response);
                    break;
                case "job":
                    reportfix("/WEB-INF/jobReport.jrxml", request, response);
                    break;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReportServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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

//    public void showReport(String Report, HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException, SQLException {
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        Connection c = null;
//        String[] filename = Report.split(".jrxml");
//        String htmlpath = ("C:\\Users\\amry4\\OneDrive\\Dokumen\\NetBeansProjects\\HRWeb" + filename[0] + ".html ");
//        try {
//            System.out.println("sudah");
//            c = sessionFactory.getSessionFactoryOptions().getServiceRegistry().
//                    getService(ConnectionProvider.class).getConnection();
//            JasperPrint countryPrint = JasperFillManager.fillReport(
//                    getClass().getClassLoader().getResourceAsStream(Report), null, c);
//            JasperExportManager.exportReportToHtmlFile(countryPrint, htmlpath);
//            String destFile = "region.pdf";
//            JasperExportManager.exportReportToPdfFile(countryPrint, destFile);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        processRequest(request, response);
//    }
    public void reportfix(String Report, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Connection c = null;
//        String[] filename = Report.split(".jrxml");
//    String htmlpath = ("C:\\Users\\amry4\\OneDrive\\Dokumen\\NetBeansProjects\\HRWeb" + filename[0] + ".html ");
        try {

//        Class.forName("com.mysql.jdbc.Driver");
            c = sessionFactory.getSessionFactoryOptions().getServiceRegistry().
                    getService(ConnectionProvider.class).getConnection();
            HttpSession session = request.getSession();
            String jrxmlFile = session.getServletContext().getRealPath(Report);
            InputStream input = new FileInputStream(new File(jrxmlFile));
            JasperReport jr = JasperCompileManager.compileReport(input);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, c);
            JasperExportManager.exportReportToPdfStream(jp, response.getOutputStream());
            response.getOutputStream().flush();
            response.getOutputStream().close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        processRequest(request, response);
    }
}