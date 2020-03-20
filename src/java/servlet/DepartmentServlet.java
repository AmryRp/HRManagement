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
import java.util.Arrays;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Department;
import model.Employee;
import model.Location;

/**
 *
 * @author amry4
 */
//@WebServlet("/DepartmentServlet")
public class DepartmentServlet extends HttpServlet {

    List<Department> ListDept;
    IDao<Department> IDepartement;

    List< Location> ListLocation;
    IDao<Location> ILocation;

    List< Employee> ListEmployee;
    IDao<Employee> IEmployee;

    Department ED = new Department();
    Location ER = new Location();

    public DepartmentServlet() {
        IDepartement = new GeneralDao();
        ILocation = new GeneralDao();
        IDepartement = new GeneralDao();

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
        String action = request.getServletPath();
//        String act = request.getParameterValues("btnSave")[0];
        String[] splitter = action.split("/DepartmentServlet");
//        String act = request.getp("");
        System.out.println(request.getQueryString());

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

    /**
     * delete function is used for deleting data from table
     *
     * @param id is string datatype converted to short for deleting data
     * @return to String for delete from object Department
     */
    public boolean confirm(String id) {
        IDepartement = new GeneralDao();
        return (IDepartement.manageData(ED, "departmentId", id, "", false, false) != null);
    }

    public void save(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String txtId = request.getParameter("txtId");
        String txtName = request.getParameter("txtName");
        String[] txtManager = request.getParameter("txtManager").split(" ");
        String[] txtLocation = request.getParameter("txtLocation").split(" ");
        System.out.println(txtId + " " + txtName + " " + Arrays.toString(txtManager) + " " + Arrays.toString(txtLocation));
//save
        PrintWriter out = response.getWriter();
        if (confirm(txtId)) {
            IDepartement.manageData(new Department(new Short(txtId), txtName, new Employee(new Integer(txtManager[0])),
                    new Location(new Short(txtLocation[0]))), "", "", new Short("0"), true, false);
             response.sendRedirect(request.getContextPath() + "/department.jsp");
//            }
        } else {
            out.println("<script src='Sweet_JS/sweetalert2.js'></script>");
            out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
            out.println("<script>");
            out.println("$(document).ready(function () {");
            out.println("swal ( 'Data has been saved' ,  ' ' ,  'success' ).then(function() {\n"
                    + "    window.location = 'department.jsp';\n"
                    + "});");
            out.println("});");
            out.println("</script>");
            IDepartement.manageData(new Department(new Short(txtId), txtName, new Employee(new Integer(txtManager[0])),
                    new Location(new Short(txtLocation[0]))), "", "", new Short("0"), true, false);
            RequestDispatcher rd = request.getRequestDispatcher("department.jsp");
            rd.include(request, response);
        }
    }

    public void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String deptId = request.getParameter("hapusisi");
        System.out.println(deptId);
        IDepartement.manageData(new Department(), "", "", new Short(deptId), true, true);
        PrintWriter out = response.getWriter();
    }

}
