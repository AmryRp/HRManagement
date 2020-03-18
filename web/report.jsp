<%-- 
    Document   : report
    Created on : Mar 17, 2020, 10:30:22 PM
    Author     : amry4
--%>
<%@page import="org.hibernate.engine.jdbc.connections.spi.ConnectionProvider"%>
<%@page import="tool.HibernateUtil"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@ page contentType="application/pdf"%>
<%@ page trimDirectiveWhitespaces="true"%>

<%@ page import="net.sf.jasperreports.engine.*"%>
<%@ page import="java.io.File"%>
<%@ page import="java.io.FileInputStream"%>
<%@ page import="java.io.FileNotFoundException"%>
<%@ page import="java.io.InputStream"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.SQLException"%>


<%

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Connection c = null;
//        String[] filename = Report.split(".jrxml");
//    String htmlpath = ("C:\\Users\\amry4\\OneDrive\\Dokumen\\NetBeansProjects\\HRWeb" + filename[0] + ".html ");
    try {
//        Class.forName("com.mysql.jdbc.Driver");
        c = sessionFactory.getSessionFactoryOptions().getServiceRegistry().
                getService(ConnectionProvider.class).getConnection();
        String jrxmlFile = session.getServletContext().getRealPath("/WEB-INF/regionReport.jrxml");
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

%>