/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import com.sun.security.ntlm.Server;
import dao.GeneralDao;
import dao.IDao;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Useraccount;
import tool.BCrypt;

/**
 *
 * @author amry4
 */
public class RegisterValidation extends HttpServlet {

    List<Useraccount> ListAccount;
    IDao<Useraccount> IAccount;
    Useraccount ua = new Useraccount();
    private String emailSender = "Bootcamp34mii@gmail.com";
    private String passwordSender = "Bootcamp34";

    public RegisterValidation() {
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
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet RegisterValidation</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet RegisterValidation at " + request.getContextPath() + "</h1>");
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
        switch (request.getQueryString()) {
            case "activation":
                activation(request, response);
                break;
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
        switch (request.getQueryString()) {
            case "register":
                register(request, response);
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

    public void register(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        //ambil dari form registrasi
        String email = request.getParameter("inputEmail");
        String pass = BCrypt.hashpw(request.getParameter("inputPassword"), BCrypt.gensalt());
        //kirim ke form email
        session.setAttribute("registEmail", email);
        session.setAttribute("registPass", pass);
        Random rdNumber = new Random();
        int numberToday = rdNumber.nextInt(1000);
        String aktifasi = "http://localhost:8084/HRWeb/loginservlet?activation";
        System.out.println(email + " " + pass + " " + numberToday);
        String htmlFile = "C:\\Users\\amry4\\OneDrive\\Dokumen\\NetBeansProjects\\HRWeb\\web\\header.html";
        send(emailSender, passwordSender, email, "#HRM" + numberToday + " Your Account Activation for HR management",htmlFile );
        //beri alert email sukses dikirmkan ke email pendaftar
        response.sendRedirect(request.getContextPath() + "/login.jsp");

    }

    public void activation(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        //ambil dari html yang dikirim ke email. 
        String email = (String) session.getAttribute("registEmail");
        String pass = (String) session.getAttribute("registPass");
        session.setAttribute("activateEmail", email);
        session.setAttribute("activatePass", pass);
        System.out.println(email);
        System.out.println(pass);

        save(email, pass, request, response);

    }

    public void save(String id, String pass, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        IAccount = new GeneralDao();
        IAccount.manageData(new Useraccount(id, pass), "", "", "", true, false);
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }

    public static void send(String from, String password, String to, String sub, String htmlfile) {
        //Get properties object    
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        //get Session   
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });
        //compose message    
        try {
            Multipart multipart = new MimeMultipart("alternative");
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            Address address = new InternetAddress(from);
            message.setFrom(address);
            message.setSubject(sub);

//            MimeBodyPart htmlpath = new MimeBodyPart();
////            message.Body = File.ReadAllText(Server.MapPath("~/activation.html"));
//            String htmlContent = "";
//            htmlpath.setContent(htmlContent, "text/html");
//            MimeBodyPart textpath = new MimeBodyPart();
//            textpath.setText(msg);
//            multipart.addBodyPart(textpath);
//            multipart.addBodyPart(htmlpath);
//            message.setContent(multipart);
            //send message  
            message.setDataHandler(new DataHandler(new FileDataSource(htmlfile)));
            Transport.send(message);
            System.out.println("message sent successfully");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}
