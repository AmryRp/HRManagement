<%-- 
    Document   : department
    Created on : Mar 12, 2020, 7:55:42 AM
    Author     : amry4
--%>
<%@page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.*"%>
<%@page import="dao.*"%>
<%@page import="controller.DepartmentController" %>
<% GeneralDao<Department> gdr = new GeneralDao<>();%>
<% GeneralDao<Location> gl = new GeneralDao<>();%>
<% GeneralDao<Employee> gE = new GeneralDao<>();%>
<% DepartmentController dct = new DepartmentController();  %>
<% IDao<Department> IDepartement; %>
<% IDepartement = new GeneralDao();%>

<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/mainMenu.jsp" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Department Management </title>
        

    </head>
    <body>
        <div class="container">
            <div class="containercol px-md-5">
                <div class="container">
                    <div class="containercol px-md-5">
                        <!-- The Modal -->
                        <form action="${pageContext.servletContext.contextPath}/departmentservlet?save" method="POST" id="savedata" name="savedata">

                            <div class="modal" id="Insert">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <!-- Modal Header -->
                                        <div class="modal-header">
                                            <h4 class="modal-title modalTitle saveOrDelete" id="saveOrDelete">Insert Data</h4>
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        </div>
                                        <!-- Modal body -->
                                        <div class="p-3 border bg-dark">

                                            <div class="input-group flex-nowrap">
                                                <div class="input-group-prepend">
                                                    <span class="input-group-text" id="addon-wrapping">*</span>
                                                </div>
                                                <input id="txtId" type="txtId" required name="txtId" placeholder=" Id" aria-label="departmentId" aria-describedby="addon-wrapping" class="form-control" style="width: 100%">

                                            </div>
                                            <br>
                                            <div class="input-group flex-nowrap">
                                                <div class="input-group-prepend">
                                                    <span class="input-group-text" id="addon-wrapping">*</span>
                                                </div>
                                                <input id="txtName" type="txtName" name="txtName" placeholder=" Name" aria-label="departmentName" aria-describedby="addon-wrapping" class="form-control" style="width: 100%">

                                            </div>
                                            <br>
                                            <div class="dropdown">
                                                <div class="input-group flex-nowrap" >
                                                    <div class="input-group-prepend">
                                                        <span class="input-group-text" id="addon-wrapping">*</span>
                                                    </div>
                                                    <input id="txtManager" name="txtManager" value="" type="txtManager" name="txtManager" placeholder=" Manager" aria-label="Manager" aria-describedby="addon-wrapping" readonly >
                                                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown">
                                                        Manager
                                                    </button>
                                                    <ul  class="dropdown-menu dr1" aria-labelledby="dropdownMenuButton">
                                                        <%
                                                            for (Employee E : gE.manageData(new Employee(), "lastName", "", "", false, true)) {
                                                        %> <li><a class='dropdown-item' href='#'><%= E.getEmployeeId()%> <%= E.getLastName()%></a></li>
                                                            <% }
                                                            %>
                                                    </ul>

                                                </div>
                                            </div>
                                            <br>
                                            <div class="dropdown">
                                                <div class="input-group flex-nowrap">
                                                    <div class="input-group-prepend">
                                                        <span class="input-group-text" id="addon-wrapping">*</span>
                                                    </div>
                                                    <input id="txtLocation" name="txtLocation" type="txtLocation" name="txtLocation" placeholder=" Location" aria-label="Location" aria-describedby="addon-wrapping" readonly >
                                                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" >
                                                        Location
                                                    </button>
                                                    <ul class="dropdown-menu dr2" aria-labelledby="dropdownMenuButton">
                                                        <%
                                                            for (Location r : gl.manageData(new Location(), "city", "", "", false, true)) {
                                                        %>  <li><a class='dropdown-item' href='#'><%= r.getLocationId()%> <%= r.getCity()%></a></li>
                                                            <% }
                                                            %>
                                                    </ul>

                                                </div>
                                            </div>

                                            <br>
                                            <!-- Modal footer -->
                                            <div class="modal-footer">
                                                <div class="container px-lg-5">
                                                    <div class="row mx-lg-n5">
                                                        <div class="col py-3 px-lg-5 "></div>
                                                        <div>
                                                            <button onclick="insertAlert(event)" class="btn btn-success" type="submit" name="btnSave" value="/save">Save</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!--END MODAL 1-->

            <!-- The Modal -->
            <div class="modal" id="deleteModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <%--<%=request.getContextPath()%>--%>
                        <!--//$//{pageContext.servletContext.contextPath}-->
                        <form action="${pageContext.servletContext.contextPath}/departmentservlet?delete" value="/delete" method="POST"  id="removeData" >
                            <!-- Modal Header -->
                            <div class="modal-header">
                                <h4 class="modal-title">Are you sure want to delete ?</h4>
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>
                            <!-- Modal body -->
                            <div class="p-3 "style="width: 100%" style="align-content: center">
                                <div   >
                                    <div><h5 style="width: 100%" style="color: black" > Id Number : </h5> 
                                        <input class="isi hapusisi form-control" id="hapusisi" name="hapusisi" type="text" style="color: black" value="" style="border: none transparent;
                                               outline: none;"  /> 
                                    </div>
                                </div>
                            </div>
                            <!-- Modal footer -->
                            <div class="modal-footer border bg-dark">
                                <div class="container px-lg-5">
                                    <div class="row mx-lg-n5">
                                        <div class="col py-3 px-lg-5 "></div>
                                        <div>

                                            <button onclick="deleteAlert(event)"  class="btn btn-danger deletebtn yesdelete" type="submit" value="Submit" >Yes</button>

                                        </div>
                                    </div>
                                </div>
                            </div>


                        </form>
                    </div>
                </div>

            </div>

            <!--END MODAL-->
            <br>
            <div class="container px-lg-5">
                <div class="row mx-lg-n5">
                    <div class="col py-3 px-lg-5 "></div>
                    <div>
                        <a href="#" data-toggle="tooltip" title="Insert Data">
                            <button class="btn btn-success saving " type="button" data-toggle="modal" data-target="#Insert"><i class="fa fa-save" ></i></button>
                        </a>
                    </div>
                </div>
            </div>

            <table id="tableDepartment" class="table  table-hover" class="display" style="width: 100%" style="cursor: pointer;" >
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Manager</th>
                        <th>Location</th>
                        <th>Action</th>
                    </tr> 
                </thead>
                <tbody>
                    <%
                        for (Department c : gdr.manageData(new Department(), "departmentName", "", "", false, true)) {
                    %>   <tr>
                        <td class="nr"><%= c.getDepartmentId()%></td>
                        <td class="nr2"><%= c.getDepartmentName()%></td>
                        <td class="nr3"><%= (c.getManagerId() == null) ? "" : c.getManagerId().getEmployeeId() + " " + c.getManagerId().getLastName()%></td>
                        <td class="nr4"><%= (c.getLocationId() == null) ? "" : c.getLocationId().getLocationId() + " " + c.getLocationId().getCity()%></td>
                        <td><a href="#" data-toggle="tooltip" title="Edit Data">
                                <button class="btn btn-primary confirm updating"type="button" data-toggle="modal" data-target="#Insert"><i class="fa fa-edit" ></i></button>
                            </a>
                            <a href="#" data-toggle="tooltip" title="Delete Data">
                                <button class="btn btn-danger confirm"type="button" data-toggle="modal" data-target="#deleteModal"><i class="fa fa-trash" ></i></button>
                            </a>      
                        </td>

                    </tr>
                    <% }
                    %>

                </tbody>
                <tfoot>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Manager</th>
                        <th>Location</th>
                        <th>Action</th>
                    </tr> 
                </tfoot>
            </table>

        </div>

    </body>

    <script>
        $(document).ready(function () {
        var table = $('#tableDepartment').DataTable({

        });
        });
        $(".saving").click(function () {
        $(".saveOrDelete").text("SAVE NEW DATA DEPARTMENT");
        var textBox = document.getElementById("txtId"); //field
        var textBox2 = document.getElementById("txtName");
        var textBox3 = document.getElementById("txtManager");
        var textBox4 = document.getElementById("txtLocation");
        textBox.value = "";
        textBox2.value = "";
        textBox3.value = "";
        textBox4.value = "";
        $("#txtId").prop("readonly", false);
        });
        $(".confirm").click(function () {
        var $row = $(this).closest("tr"); // Find the row
        var $text = $row.find(".nr").text(); // Find the text
        var $text2 = $row.find(".nr2").text(); //nr class
        var $text3 = $row.find(".nr3").text();
        var $text4 = $row.find(".nr4").text();
        $(".isi").text($text); // title
        $(".isi2").text($text2);
        var textBox = document.getElementById("txtId"); //field
        var textBox2 = document.getElementById("txtName");
        var textBox3 = document.getElementById("txtManager");
        var textBox4 = document.getElementById("txtLocation");
        var tx = document.getElementById("hapusisi");
        textBox.value = $text;
        tx.value = $text;
        textBox2.value = $text2;
        textBox3.value = $text3;
        textBox4.value = $text4;
        $("#txtId").prop("readonly", true);
        $("#txtId").toggleClass('border-0');
        $("#hapusisi").prop("readonly", true);
        $(".updating").click(function () {
        $(".saveOrDelete").text("UPDATE DATA DEPARTMENT");
        });
        });
        $(document).on('click', '.dr1 li a', function () {
        $('#editManager').val($(this).text());
        $('#txtManager').val($(this).text());
        });
        $(document).on('click', '.dr2 li a', function () {
        $('#editLocation').val($(this).text());
        $('#txtLocation').val($(this).text());
        });
        function deleteAlert(event) {
        event.preventDefault();
        $("#removeData").submit(swal({
        title: "data has been deleted",
                text: "successful!",
                type: "success",
                confirmButtonColor: "#34E076",
                confirmButtonText: "Ok.",
                closeOnConfirm: false
        }
        ).then(function (result) {
        setTimeout(function () {
        var formz = document.getElementById("removeData");
        formz.submit();
        }, 30);
        }));
        }
        function insertAlert(event) {
        event.preventDefault();
        
            $("#savedata").submit(swal({
        title: "data has been save",
                text: "successful!",
                type: "success",
                confirmButtonColor: "#34E076",
                confirmButtonText: "Ok.",
                closeOnConfirm: false
        }
        ).then(function (result) {
        setTimeout(function () {
        var formz = document.getElementById("savedata");
        formz.submit();
        }, 30);
        }));
        }
        
        
    </script>

</html>