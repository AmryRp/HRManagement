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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;

/**
 *
 * @author amry4
 */
public class EmployeeServlet extends HttpServlet {

    List<Department> ListDept;
    IDao<Department> IDepartement;

    List<Job> ListJob;
    IDao<Job> IJob;

    List< Employee> ListEmployee;
    IDao<Employee> IEmployee;

    Department ED = new Department();
    Location ER = new Location();
    Employee EJ = new Employee();

    public EmployeeServlet() {
        IDepartement = new GeneralDao();
        IJob = new GeneralDao();
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
//            response.sendRedirect(request.getContextPath() + "/employee.jsp");
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

    /**
     * delete function is used for deleting data from table
     *
     * @param id is string datatype converted to short for deleting data
     * @return to String for delete from object Department
     */
    public boolean confirm(String id) {
        IEmployee = new GeneralDao();
        return (IEmployee.manageData(EJ, "employeeId", id, "", false, false) != null);
    }

    public Date toDate(String date) throws ParseException {
        DateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date Dates = originalFormat.parse(date);
        java.sql.Date sqlDate = new java.sql.Date(Dates.getTime());

//        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
//        DateFormat targetFormat = new SimpleDateFormat("MM/dd/yy");
//        java.util.Date Dates2 = sdf.parse(date);
//        java.sql.Date sqlDate = new java.sql.Date(Dates.getTime());
//        String formattedDate = targetFormat.format(date);
        return sqlDate;
    }

    public void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String employeeId = request.getParameter("employeeId");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String hireDate = request.getParameter("hireDate");
        String[] job = request.getParameter("job").split(" ");
        String salary = request.getParameter("salary");
        String commission = request.getParameter("commission");
        String[] managerId = request.getParameter("manager").split(" ");
        String[] departmentId = request.getParameter("department").split(" ");
        try {
            IEmployee.manageData(new Employee(new Integer(employeeId), firstName, lastName, email,
                    phoneNumber, toDate(hireDate), (new Job(job[0])), new BigDecimal(salary),
                    new BigDecimal(commission), (new Employee(new Integer(managerId[0]))),
                    (new Department(new Short(departmentId[0])))), "", "", 0, true, false);

        } catch (ParseException ex) {
            Logger.getLogger(EmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect(request.getContextPath() + "/employee.jsp");
    }

    public void save(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        IEmployee = new GeneralDao();
        IJob = new GeneralDao();
        IDepartement = new GeneralDao<>();
        String employeeId = request.getParameter("employeeId");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String hireDate = request.getParameter("hireDate");
        String[] job = request.getParameter("job").split(" ");
        String salary = request.getParameter("salary");
        String commission = request.getParameter("commission");
        String[] managerId = request.getParameter("manager").split(" ");
        String[] departmentId = request.getParameter("department").split(" ");
        try {
            System.out.println(employeeId + " " + firstName + " " + toDate(hireDate) + " " + lastName + " " + email + " " + phoneNumber + " " + hireDate + " "
                    + Arrays.toString(job) + " " + salary + " " + commission + " " + Arrays.toString(managerId) + " " + Arrays.toString(departmentId));
        } catch (ParseException ex) {
            Logger.getLogger(EmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
//save  
        PrintWriter out = response.getWriter();
        if (confirm(employeeId)) {
//            out.println(" <script src='Sweet_JS/sweetalert2.all.min.js'></script>");
//            out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
//            out.println("<script>");
//            out.println("$(document).ready(function () {");
//            out.println("swal({\n"
//                    + "        title: \"Warning\",\n"
//                    + "        text: \"this Region data Exist want to Update ?\",\n"
//                    + "        type: \"warning\",\n"
//                    + "        showCancelButton: true,\n"
//                    + "        confirmButtonColor: '#DD6B55',\n"
//                    + "        confirmButtonText: 'Yes, I am sure!',\n"
//                    + "        cancelButtonText: \"No, cancel it!\",\n"
//                    + "    }).then(function() {\n"
//                    + "      $(this).trigger('submit');\n"
//                    + "        swal({\n"
//                    + "            title: 'Success!', \n"
//                    + "            text: 'Data Updated', \n"
//                    + "            type: 'success'\n"
//                    + "        }, function() {\n"
//                    + "            $(this).trigger('submit');");
//            out.println("        }).then(function() { var formz = document.getElementById(\"savedata\");\n"
//                    + "                    formz.submit();\n");
//
//            out.println("window.location = 'employee.jsp';\n"
//                    + "});\n"
//                    + "    },function(dismiss) {\n"
//                    + "        if(dismiss == 'cancel') {\n"
//                    + "            swal(\"Cancelled\", \"Invoice not created!\", \"error\").then(function() {\n"
//                    + "    window.location = 'employee.jsp';\n"
//                    + "});\n"
//                    + "        }\n"
//                    + "    });"
//                    + "});");
//            out.println("</script>");

            update(request, response);
            RequestDispatcher rd = request.getRequestDispatcher("employee.jsp");
            rd.include(request, response);
        } else {
            try {
                IEmployee.manageData(new Employee(new Integer(employeeId), firstName, lastName, email,
                        phoneNumber, toDate(hireDate), (new Job(job[0])), new BigDecimal(salary),
                        new BigDecimal(commission), (new Employee(new Integer(managerId[0]))),
                        (new Department(new Short(departmentId[0])))), "", "", 0, true, false);

            } catch (ParseException ex) {
                Logger.getLogger(EmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String empId = request.getParameter("hapusisi");
        System.out.println(empId);
        IEmployee.manageData(new Employee(), "", "", new Integer(empId), true, true);
        PrintWriter out = response.getWriter();
    }

}
