<%-- 
    Document   : tableTemplate
    Created on : Mar 20, 2020, 9:48:00 AM
    Author     : amry4
--%>

<%@page import="controller.*"%>
<%@page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.*"%>
<%@page import="dao.*"%>
<%@page import="controller.DepartmentController" %>
<% GeneralDao<Country> gc = new GeneralDao<>();%>
<% GeneralDao<Region> gr = new GeneralDao<>();%>
<% IDao<Country> ICountry; %>
<% ICountry = new GeneralDao();%>
<!DOCTYPE html>
<html style="height: auto;" class="">
    <head>
        <jsp:include page="/script.jsp" />
        <jsp:include page="/mainmenuNavbar.jsp" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Country</title>
    </head>
    <body class="sidebar-mini sidebar-collapse control-sidebar-slide-open" data-gr-c-s-loaded="true" style="height: auto;">
        <div class="containercol px-md-5">
            <div class="container">
                <div class="containercol px-md-5">
                    <!-- The Modal -->
                    <form action="${pageContext.servletContext.contextPath}/countryservlet?save" method="POST" id="savedata" >
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
                                        <div class='field'>
                                            <div class="input-group flex-nowrap">
                                                <div class="input-group-prepend">
                                                    <span class="input-group-text" id="addon-wrapping">*</span>
                                                </div>
                                                <input required="required" id="txtId" type="txtId" name="txtId" placeholder=" Id" aria-label="countryId" aria-describedby="addon-wrapping" class="form-control" style="width: 100%">

                                            </div>
                                            <br>
                                            <div class="input-group flex-nowrap">
                                                <div class="input-group-prepend">
                                                    <span class="input-group-text" id="addon-wrapping">*</span>
                                                </div>
                                                <input id="txtName" type="txtName" name="txtName" placeholder=" Name" aria-label="countryName" aria-describedby="addon-wrapping" class="form-control" style="width: 100%">

                                            </div>
                                            <br>
                                            <div class="dropdown">
                                                <div class="input-group flex-nowrap" >
                                                    <div class="input-group-prepend">
                                                        <span class="input-group-text" id="addon-wrapping">*</span>
                                                    </div>
                                                    <input id="txtRegion" name="txtRegion" value="" type="txtRegion" placeholder=" Region" aria-label="Region" aria-describedby="addon-wrapping" readonly >
                                                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown">
                                                        Region
                                                    </button>
                                                    <ul  class="dropdown-menu dr1" aria-labelledby="dropdownMenuButton">
                                                        <%
                                                            for (Region E : gr.manageData(new Region(), "regionName", "", "", false, true)) {
                                                        %> <li><a class='dropdown-item' href='#'><%= E.getRegionId()%> <%= E.getRegionName()%></a></li>
                                                            <% }
                                                            %>
                                                    </ul>
                                                </div>
                                            </div>
                                            <br>
                                        </div>
                                        <!-- Modal footer -->
                                        <div class="modal-footer">
                                            <div class="container px-lg-5">
                                                <div class="row mx-lg-n5">
                                                    <div class="col py-3 px-lg-5 "></div>
                                                    <div class='actions'>
                                                        <input onclick="insertAlert(event)" class="btn btn-success" type="submit" value="Save" disabled="disabled">

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
                    <form action="${pageContext.servletContext.contextPath}/countryservlet?delete" method="POST"  id="removeData" >
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
                                           outline: none;" readonly /> 
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
        <!--MODAL-->
        <!-- Content Wrapper. Contains page content -->
        <div class="content-wrapper" >
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <div class="container-fluid">

                </div><!-- /.container-fluid -->
            </section>
            <div class="wrapper"><div class="containercol px-md-5">
                    <!-- Main content -->
                    <section class="content">
                        <div class="row">
                            <div class="col-12">
                                <div class="card">
                                    <div class="card-header">
                                        <h3 class="card-title">DataTable with minimal features &amp; hover style</h3>
                                        <div class="container px-lg-5">
                                            <div class="row mx-lg-n5">
                                                <div class="col py-3 px-lg-5 "></div>
                                                <div>
                                                    <a style="padding-left: 65px" href="#" data-toggle="tooltip" title="Insert Data">
                                                        <i class="saving fa fa-save" style="font-size:36px;color:green; align-content: center" type="button" data-toggle="modal" data-target="#Insert"></i>
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- /.card-header -->
                                    <div class="card-body">
                                        <div id="example2_wrapper" class="dataTables_wrapper dt-bootstrap4">
                                            <div class="row">
                                                <div class="col-sm-12 col-md-6"></div>
                                                <div class="col-sm-12 col-md-6"></div>

                                            </div><div class="row">
                                                <div class="col-sm-12">
                                                    <div id="example2_wrapper" class="dataTables_wrapper dt-bootstrap4">
                                                        <div class="row"><div class="col-sm-12 col-md-6">
                                                            </div><div class="col-sm-12 col-md-6"></div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-sm-12">
                                                                <div id="example2_wrapper" class="dataTables_wrapper dt-bootstrap4">
                                                                    <div class="row">
                                                                        <div class="col-sm-12 col-md-6"></div>
                                                                        <div class="col-sm-12 col-md-6"></div>
                                                                    </div>
                                                                    <div class="row">
                                                                        <div class="col-sm-12">
                                                                            <table id="example2" class="table table-bordered table-hover dataTable dtr-inline" role="grid" aria-describedby="example2_info">
                                                                                <thead>
                                                                                    <tr role="row">
                                                                                        <th class="sorting_asc" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-label="Rendering engine: activate to sort column descending" aria-sort="ascending">Id</th>
                                                                                        <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-label="Browser: activate to sort column ascending">Name</th>
                                                                                        <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-label="Browser: activate to sort column ascending">Region</th>
                                                                                        <th class="no-sort" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" >Action</th>
                                                                                    </tr>
                                                                                </thead>
                                                                                <tbody>
                                                                                    <%
                                                                                        for (Country c : gc.manageData(new Country(), "countryName", "", "", false, true)) {
                                                                                    %>    <tr role="row" class="odd">
                                                                                        <td class="nr sorting_1"tabindex="0" ><%= c.getCountryId()%></td>
                                                                                        <td class="nr2 sorting_1"tabindex="0" ><%= c.getCountryName()%></td>
                                                                                        <td class="nr3 sorting_1"tabindex="0" ><%= (c.getRegionId() == null) ? "" : c.getRegionId().getRegionId() + " " + c.getRegionId().getRegionName()%></td>
                                                                                        <td style="vertical-align: middle; text-align: center;" >
                                                                                            <a style="vertical-align: middle; display: inline-block;
                                                                                               margin: 0 20px 0 0;" href="#" data-toggle="tooltip" title="Edit Data">
                                                                                                <i class="fa fa-edit updating confirm"style="font-size:36px;color:#0066cc; align-content: center" id="updating" type="button" data-toggle="modal" data-target="#Insert"></i>
                                                                                            </a>

                                                                                            <a style="vertical-align: middle;display: inline-block;
                                                                                               margin: 0 20px 0 0;" href="#" data-toggle="tooltip" title="Delete Data">
                                                                                                <i class="fa fa-trash confirm" style="font-size:36px;color:red; align-content: center" type="button" data-toggle="modal" data-target="#deleteModal"></i>
                                                                                            </a>   
                                                                                        </td>
                                                                                    </tr>
                                                                                    <% }
                                                                                    %></tbody>
                                                                                <tfoot>
                                                                                    <tr>
                                                                                        <th rowspan="1" colspan="1">Id</th>
                                                                                        <th rowspan="1" colspan="1">Name</th>
                                                                                        <th rowspan="1" colspan="1">Region</th>
                                                                                        <th rowspan="1" colspan="1">Action</th>
                                                                                </tfoot>
                                                                            </table>
                                                                        </div>
                                                                    </div>

                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- /.card-body -->
                                </div>
                            </div>
                            <!-- /.col -->
                        </div>
                        <!-- /.row -->
                    </section>
                    <!-- /.content -->
                </div>
                <!-- /.content-wrapper -->
            </div>
            <!-- Main content -->
        </div>
        <footer class="main-footer">
            <div class="float-right d-none d-sm-block">
                <b>Version</b> 3.0.3-pre
            </div>
            <strong>Copyright © 2014-2019 <a href="http://adminlte.io">AdminLTE.io</a>.</strong> All rights
            reserved.
        </footer>                                                                       

    </body>
    <script>
        $(function () {
            $('#example2').DataTable({
                "paging": true,
                "lengthChange": false,
                "searching": false,
                "ordering": true,
                "info": true,
                "autoWidth": false,
                "responsive": true,
                "columnDefs": [
                    {"orderable": false, "targets": 3}
                ]

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
            var $row = $(this).closest("tr");    // Find the row
            var $text = $row.find(".nr").text(); // Find the text
            var $text2 = $row.find(".nr2").text(); //nr class
            var $text3 = $row.find(".nr3").text();
            $(".isi").text($text); // title
            $(".isi2").text($text2);
            var textBox = document.getElementById("txtId"); //field
            var textBox2 = document.getElementById("txtName");
            var textBox3 = document.getElementById("txtRegion");
            var tx = document.getElementById("hapusisi");
            textBox.value = $text;
            tx.value = $text;
            textBox2.value = $text2;
            textBox3.value = $text3;
            $(".updating").click(function () {
                $("#txtId").prop("readonly", true);
                $("#txtId").toggleClass('border-0');

                $("#hapusisi").prop("readonly", true);
                $(".saveOrDelete").text("UPDATE DATA DEPARTMENT");
            });
        });

        $(document).on('click', '.dr1 li a', function () {
            $('#editManager').val($(this).text());
            $('#txtRegion').val($(this).text());
        });
        function deleteAlert(event) {
            event.preventDefault();
            $("#removeData").submit(swal({
                title: "sure want to delete ?",
                text: "",
                type: "question",
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
    </script>
</html>

