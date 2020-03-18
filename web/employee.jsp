<%-- 
    Document   : employee
    Created on : Mar 11, 2020, 11:32:29 PM
    Author     : amry4
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.*"%>
<%@page import="dao.GeneralDao"%>
<%@page import="controller.DepartmentController" %>
<% GeneralDao<Department> gdr = new GeneralDao<>();%>
<% GeneralDao<Job> gj = new GeneralDao<>();%>
<% GeneralDao<Employee> gE = new GeneralDao<>();%>

<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/mainMenu.jsp" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Employee Management </title>


    </head>
    <body>
        <br>
        <br>
        <div class="container"  style="width: 100%">
            <div class="container px-lg-5">
                <div class="row mx-lg-n5">
                    <div class="col py-3 px-lg-5 "></div>
                    <div>
                        <a href="#" data-toggle="tooltip" title="Insert Data">
                            <button id="saving" class="btn btn-success saving " type="button" data-toggle="modal" data-target="#Insert"><i class="fa fa-save" ></i></button>
                        </a>
                    </div>
                </div>
            </div>

            <table id="tableEmployee" class="table table-hover display nowrap" style="width: 100%; text-align: center"  >
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Phone Number</th>
                        <th>Hire Date</th>
                        <th>Job Title</th>
                        <th>Salary</th>
                        <th>Commission</th>
                        <th>Manager</th>
                        <th>Department</th>
                        <th>Action</th>
                    </tr> 
                </thead>
                <tbody>
                    <%
                        for (Employee c : gE.manageData(new Employee(), "lastName", "", "", false, true)) {
                    %>   <tr>
                        <td class="nr"><%= c.getEmployeeId()%></td>
                        <td class="nr2"><%= c.getFirstName()%></td>
                        <td class="nr3"><%= c.getLastName()%></td>
                        <td class="nr4"><%= (c.getEmail() == null) ? "" : c.getEmail()%></td>
                        <td class="nr5"><%= (c.getPhoneNumber() == null) ? "" : c.getPhoneNumber()%></td>
                        <% SimpleDateFormat hire = new SimpleDateFormat("YYYY-MM-dd");%>
                        <td class="nr6"><%= (c.getHireDate() == null) ? "" : hire.format(c.getHireDate())%></td>
                        <td class="nr7"><%= (c.getJobId() == null) ? "" : c.getJobId().getJobId() + " " + c.getJobId().getJobTitle()%></td>
                        <td class="nr8"><%= (c.getSalary() == null) ? "" : c.getSalary()%></td>
                        <td class="nr9"><%= (c.getCommissionPct() == null) ? "" : c.getCommissionPct()%></td>
                        <td class="nr10"><%= (c.getManagerId() == null) ? "" : c.getManagerId().getEmployeeId() + " " + c.getManagerId().getLastName()%></td>
                        <td class="nr11"><%= (c.getDepartmentId() == null) ? "" : c.getDepartmentId().getDepartmentId() + " " + c.getDepartmentId().getDepartmentName()%></td>
                        <td><a href="#" data-toggle="tooltip" title="Edit Data">
                                <button id="updating" class="btn btn-primary confirm updating"type="button" data-toggle="modal" data-target="#Insert"><i class="fa fa-edit" ></i></button>
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
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Phone Number</th>
                        <th>Hire Date</th>
                        <th>Job Title</th>
                        <th>Salary</th>
                        <th>Commission</th>
                        <th>Manager</th>
                        <th>Department</th>
                        <th>Action</th>
                    </tr> 
                </tfoot>
            </table>

            <div class="container">
                <div class="containercol px-md-5">
                    <!-- The Modal -->
                    <form action="${pageContext.servletContext.contextPath}/employeeservlet?save" method="POST" id="savedata" >
                        <!--<form action="${pageContext.servletContext.contextPath}/employeeservlet?update" method="POST" id="updatedata" >-->
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
                                            <input id="employeeId" class="employeeId" type="Name" name="employeeId" placeholder=" Id" aria-label="employeeId" aria-describedby="addon-wrapping" class="form-control" style="width: 100%">
                                        </div>
                                        <br>
                                        <div class="input-group flex-nowrap">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text" id="addon-wrapping">*</span>
                                            </div>
                                            <input id="firstName" type="Name" name="firstName" placeholder=" First Name" aria-label="firstName" aria-describedby="addon-wrapping" class="form-control" style="width: 100%">
                                        </div>
                                        <br>
                                        <div class="input-group flex-nowrap">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text" id="addon-wrapping">*</span>
                                            </div>
                                            <input id="lastName" type="Name" name="lastName" placeholder=" Last Name" aria-label="lastName" aria-describedby="addon-wrapping" class="form-control" style="width: 100%">
                                        </div>
                                        <br>
                                        <div class="input-group flex-nowrap">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text" id="addon-wrapping">*</span>
                                            </div>
                                            <input id="email" type="email" name="email" placeholder=" Email" aria-label=" @email" aria-describedby="addon-wrapping" class="form-control" style="width: 100%"/>
                                        </div>
                                        <br>
                                        <div class="input-group flex-nowrap">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text" id="addon-wrapping">*</span>
                                            </div>

                                            <input id="phoneNumber" type="tel" value=""  name="phoneNumber" placeholder="1234566789" aria-label="phoneNumber" 
                                                   aria-describedby="addon-wrapping" class="form-control" style="width: 100%" />

                                        </div>
                                        <br>
                                        <div class="input-group flex-nowrap">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text" id="addon-wrapping">*</span>
                                            </div>
                                            <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.3/moment.min.js" ></script>
                                            <input id="hireDate" type="Date" pattern="(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](19|20)\d\d" 
                                                   name="hireDate" aria-label="hireDate" data-date="" data-date-format="MM/DD/YY" value=""
                                                   aria-describedby="addon-wrapping" class="form-control" style="width: 100%"/>
                                        </div>
                                        <br>
                                        <div class="dropdown">
                                            <div class="input-group flex-nowrap" >
                                                <div class="input-group-prepend">
                                                    <span class="input-group-text" id="addon-wrapping">*</span>
                                                </div>
                                                <input id="job" name="job" value="" type="Name" name="job" placeholder=" Job" aria-label="job" aria-describedby="addon-wrapping" readonly >
                                                <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown">
                                                    Job
                                                </button>
                                                <ul  class="dropdown-menu dr1" aria-labelledby="dropdownMenuButton">
                                                    <%
                                                        for (Job E : gj.manageData(new Job(), "jobTitle", "", "", false, true)) {
                                                    %> <li><a class='dropdown-item' href='#'><%= E.getJobId()%> <%= E.getJobTitle()%></a></li>
                                                        <% }
                                                        %>
                                                </ul>

                                            </div>
                                        </div>
                                        <br>
                                        <div class="input-group flex-nowrap">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text" id="addon-wrapping">*</span>
                                            </div>
                                            <input id="salary" type="Number" name="salary" placeholder=" Salary" aria-label="salary" aria-describedby="addon-wrapping" class="form-control" style="width: 100%">

                                        </div>
                                        <br>
                                        <div class="input-group flex-nowrap">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text" id="addon-wrapping">*</span>
                                            </div>
                                            <input id="commission" type="Name" min="0" max="0.9" name="commission" placeholder=" commission" aria-label="commision" aria-describedby="addon-wrapping" class="form-control" style="width: 100%"/>
                                            <input id="comissionChooser" type="range" min="0" max="0.9" step="0.1" value="0.0" name="comissionChooser" oninput="commission.value = comissionChooser.value"/>

                                        </div>
                                        <br>
                                        <div class="dropdown">
                                            <div class="input-group flex-nowrap" >
                                                <div class="input-group-prepend">
                                                    <span class="input-group-text" id="addon-wrapping">*</span>
                                                </div>
                                                <input id="manager" name="manager" value="" type="Name" placeholder=" Manager" aria-label="Manager" aria-describedby="addon-wrapping" readonly >
                                                <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown">
                                                    Manager
                                                </button>
                                                <ul  class="dropdown-menu dr2" aria-labelledby="dropdownMenuButton">
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
                                                <input id="department" name="department" type="Name" placeholder=" Department" aria-label="department" aria-describedby="addon-wrapping" readonly >
                                                <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" >
                                                    Department
                                                </button>
                                                <ul class="dropdown-menu dr3" aria-labelledby="dropdownMenuButton">
                                                    <%
                                                        for (Department r : gdr.manageData(new Department(), "departmentName", "", "", false, true)) {
                                                    %>  <li><a class='dropdown-item' href='#'><%= r.getDepartmentId()%> <%= r.getDepartmentName()%></a></li>
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
                                                        <button onclick="insertAlert(event)" class="btn btn-success" type="submit" value="Submit">Save</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--</form>-->
                    </form>
                </div>
            </div>


            <!--END MODAL 1-->

            <!-- The Modal -->
            <div class="modal" id="deleteModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="${pageContext.servletContext.contextPath}/employeeservlet?delete" method="POST"  id="removeData" >
                            <!-- Modal Header -->
                            <div class="modal-header">
                                <h4 class="modal-title">Delete ?</h4>
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>
                            <!-- Modal body -->
                            <div class="p-3 "style="width: 100%" style="align-content: center">
                                <div   >
                                    <div><h5 style="width: 100%" style="color: black" > Are you sure want to delete id Number : </h5> 
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


        </div>
    </body>

    <script>
        $(document).ready(function () {
            var table = $('#tableEmployee').DataTable({
            });
        });
    </script>

    <script>
        $("#hireDate").on("change", function () {
            this.setAttribute(
                    "data-date",
                    moment(this.value, "YYYY-MM-DD")
                    .format(this.getAttribute("data-date-format"))
                    );
        }).trigger("change");

        $(".saving").click(function () {
            $(".saveOrDelete").text("SAVE NEW DATA EMPLOYEE");
            var textBox = document.getElementById("employeeId");
            var textBox2 = document.getElementById("firstName");
            var textBox3 = document.getElementById("lastName");
            var textBox4 = document.getElementById("email");
            var textBox5 = document.getElementById("phoneNumber");
            var textBox6 = document.getElementById("hireDate");
            var textBox7 = document.getElementById("job");
            var textBox8 = document.getElementById("salary");
            var textBox9 = document.getElementById("commission");
            var textBox10 = document.getElementById("manager");
            var textBox11 = document.getElementById("department");
            textBox.value = "";
            textBox2.value = "";
            textBox3.value = "";
            textBox4.value = "";
            textBox5.value = "";
            textBox6.value = "";
            textBox7.value = "";
            textBox8.value = "";
            textBox9.value = "";
            textBox10.value = "";
            textBox11.value = "";
            $("#employeeId").prop("readonly", false);
        });
        $(".confirm").click(function () {
            var $row = $(this).closest("tr");    // Find the row
            var $text = $row.find(".nr").text(); // Find the text
            var $text2 = $row.find(".nr2").text();
            var $text3 = $row.find(".nr3").text();
            var $text4 = $row.find(".nr4").text();
            var $text5 = $row.find(".nr5").text();
            var $text6 = $row.find(".nr6").text();
            var $text7 = $row.find(".nr7").text();
            var $text8 = $row.find(".nr8").text();
            var $text9 = $row.find(".nr9").text();
            var $text10 = $row.find(".nr10").text();
            var $text11 = $row.find(".nr11").text();
            $(".isi").text($text);
            $(".isi2").text($text2);
            var textBox = document.getElementById("employeeId");
            var textBox2 = document.getElementById("firstName");
            var textBox3 = document.getElementById("lastName");
            var textBox4 = document.getElementById("email");
            var textBox5 = document.getElementById("phoneNumber");
            var textBox6 = document.getElementById("hireDate");
            var textBox7 = document.getElementById("job");
            var textBox8 = document.getElementById("salary");
            var textBox9 = document.getElementById("commission");
            var textBox10 = document.getElementById("manager");
            var textBox11 = document.getElementById("department");
            var tx = document.getElementById("hapusisi");
            tx.value = $text;
            textBox.value = $text;
            textBox2.value = $text2;
            textBox3.value = $text3;
            textBox4.value = $text4;
            textBox5.value = $text5;
            textBox6.value = $text6;
            textBox7.value = $text7;
            textBox8.value = $text8;
            textBox9.value = $text9;
            textBox10.value = $text10;
            textBox11.value = $text11;
            $("#employeeId").prop("readonly", true);
            $("#employeeId").toggleClass('border-0');
            $("#hapusisi").prop("readonly", true);
            $(".updating").click(function () {
                $(".saveOrDelete").text("UPDATE DATA EMPLOYEE");
            });
        });
        $(document).on('click', '.dr1 li a', function () {
            $('#job').val($(this).text());
        });

        $(document).on('click', '.dr2 li a', function () {
            $('#manager').val($(this).text());
        });

        $(document).on('click', '.dr3 li a', function () {
            $('#department').val($(this).text());
        });
        function deleteAlert(event) {
            event.preventDefault();
            $("#removeData").submit(swal({
                title: "sure want to delete ?",
                text: "successful!",
                type: "success",
                showCancelButton: true,
                confirmButtonColor: "#34E076",
                confirmButtonText: 'Yes, delete it!',
                cancelButtonText: 'No, keep it'
            }
            ).then(function (result) {
                setTimeout(function () {
                    var formz = document.getElementById("removeData");
                    formz.submit();
                }, 30);
            }));
        }
//        $(document).ready(function () {
//        $("form").on('submit', function (e) {
//        $(".employeeId").each(function () {
//        e.preventDefault();
//                var input = $(this);
//                if (input.val() == "") {
//                swal(input.attr("name") + " Cannot be blank");
//                return false;
//        } 
//                else if (input.val() == "3" ) //BELOM BISA
//	{       
//                swal(input.attr("name") + "is already exist ");
//                return false;
//        }
//                else{
//                event.preventDefault();
//                $("#savedata").submit(swal({
//                     title: "data has been save",
//                     text: "successful!",
//                     type: "success",
//                     confirmButtonColor: "#34E076",
//                     confirmButtonText: "Ok.",
//                     closeOnConfirm: false
//        }
//        ).then(function (result) {
//        setTimeout(function () {
//        var formz = document.getElementById("savedata");
//                formz.submit();
//        }, 30);
//        }));
//        }
//
//        })
//        });
//        });

    </script>

</html>
