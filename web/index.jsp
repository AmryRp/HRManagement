<%-- 
    Document   : index
    Created on : Mar 20, 2020, 9:33:56 AM
    Author     : amry4
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% String name = (String) session.getAttribute("userLogon");%>
        <%
            try {
                if (request.getSession() == null) {
                    response.sendRedirect(request.getContextPath() + "/login.jsp");
                } else {
        %>
        <h5>WELCOME <%= name%></h5>
        <%
            if (session.getAttribute("userLogon").equals("")) {
                response.sendRedirect(request.getContextPath() + "/login.jsp");
        %>

        <%
        } else {
        %>
        <a href="${pageContext.servletContext.contextPath}/loginservlet?out">
            <b>
                <button href="${pageContext.servletContext.contextPath}/loginservlet?out" class="btn btn-outline-danger " type="submit" >Logout</button>
            </b>
        </a>
        <%
                    }
                }
            } catch (Exception e) {

            }
        %>
    </body>
</html>
