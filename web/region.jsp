<%-- 
    Document   : Region
    Created on : Mar 11, 2020, 1:09:13 PM
    Author     : amry4
--%>


<%@page import="controller.*"%>
<%@page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.*"%>
<%@page import="dao.*"%>
<%@page import="controller.DepartmentController" %>
<% GeneralDao<Region> gr = new GeneralDao<>();%>
<% IDao<Region> IRegion; %>
<% IRegion = new GeneralDao();%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/mainMenu.jsp" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Region Management </title>
    </head>
    <body>
        <div class="container">
            <div class="containercol px-md-5">
                <div class="container">
                    <div class="containercol px-md-5">
                        <!-- The Modal -->

                        <form action="${pageContext.servletContext.contextPath}/regionservlet?save" method="POST" id="savedata" >
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
                                                <input class="txtId form-control" id="txtId" type="Name" name="txtId" placeholder=" Id" aria-label="txtId" aria-describedby="addon-wrapping"  style="width: 100%">

                                            </div>
                                            <br>
                                            <div class="input-group flex-nowrap">
                                                <div class="input-group-prepend">
                                                    <span class="input-group-text" id="addon-wrapping">*</span>
                                                </div>
                                                <input id="txtName" type="Name" name="txtName" placeholder=" Name" aria-label="countryName" aria-describedby="addon-wrapping" class="form-control" style="width: 100%">

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

                        </form>
                    </div>
                </div>
            </div>
            <!--END MODAL 1-->

            <!-- The Modal -->
            <div class="modal" id="deleteModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="${pageContext.servletContext.contextPath}/regionservlet?delete" method="POST"  id="removeData" >
                            <!-- Modal Header -->
                            <div class="modal-header">
                                <h4 class="modal-title">Viewing Data</h4>
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>
                            <!-- Modal body -->
                            <div class="p-3 "style="width: 100%" style="align-content: center">
                                <div   >
                                    <div><h5 style="width: 100%" style="color: black" > Id Number : </h5> 
                                        <input class="isi hapusisi form-control" id="hapusisi" name="hapusisi" type="text" style="color: black" value="" style="border: none transparent;
                                               outline: none;" readonly />
                                        <br>
                                        <h5 style="width: 100%" style="color: black" > Region Name : </h5> 
                                        <input class="isi2 hapusisi2 form-control" id="hapusisi2" name="hapusisi2" type="text" style="color: black" value="" style="border: none transparent;
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

                                            <button onclick="deleteAlert(event)"  class="btn btn-danger deletebtn yesdelete" type="submit" value="Submit" >Delete</button>

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

            <table id="tableRegion" class="table table-hover" class="display" style="width: 100%" style="cursor: pointer;" >
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Action</th>
                    </tr> 
                </thead>
                <tbody>
                    <%
                        for (Region c : gr.manageData(new Region(), "regionName", "", "", false, true)) {
                    %>   <tr>
                        <td class="nr" ><%= c.getRegionId()%></td>
                        <td class="nr2" ><%= c.getRegionName()%></td>
                        <td><a href="#" data-toggle="tooltip" title="Edit Data">
                                <button id="updating" class="btn btn-primary updating confirm "type="button" data-toggle="modal" data-target="#Insert"><i class="fa fa-edit" ></i></button>
                            </a>
                            <a href="#" data-toggle="tooltip" title="Delete Data">
                                <button class="btn btn-danger confirm" type="button" data-toggle="modal" data-target="#deleteModal"><i class="fa fa-trash" ></i></button>
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
                        <th>Action</th>
                    </tr> 
                </tfoot>
            </table>

        </div>
        <form hidden="true" action="${pageContext.servletContext.contextPath}/regionservlet?update" method="post" id="updatedata"> <button hidden="true" class="btn btn-outline-danger " type="submit" ></button></form>
    </body>

    <script>
        $(document).ready(function () {
            var table = $('#tableRegion').DataTable({

            });
        });
        $(".saving").click(function () {
            $(".saveOrDelete").text("SAVE NEW DATA REGION");
            var textBox = document.getElementById("txtId"); //field
            var textBox2 = document.getElementById("txtName");
            textBox.value = "";
            textBox2.value = "";
            $("#txtId").prop("readonly", false);
        });
        $(".confirm").click(function () {
            var $row = $(this).closest("tr");    // Find the row
            var $text = $row.find(".nr").text(); // Find the text
            var $text2 = $row.find(".nr2").text(); //nr class
            $(".isi").text($text); // title
            $(".isi2").text($text2);
            var textBox = document.getElementById("txtId"); //field
            var textBox2 = document.getElementById("txtName");
            var tx = document.getElementById("hapusisi");
            var tx2 = document.getElementById("hapusisi2");
            textBox.value = $text;
            tx.value = $text;
            textBox2.value = $text2;
            tx2.value = $text2;
            $("#txtId").prop("readonly", true);
            $("#txtId").toggleClass('border-0');
            $("#hapusisi").prop("readonly", true);
            $(".updating").click(function () {
                $(".saveOrDelete").text("UPDATE DATA REGION");
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
//        function insertAlert(event) {
//            event.preventDefault();
//            $("#savedata").submit(swal({
//                title: "data has been save",
//                text: "successful!",
//                type: "success",
//                confirmButtonColor: "#34E076",
//                confirmButtonText: "Ok.",
//                closeOnConfirm: false
//            }
//            ).then(function (result) {
//                setTimeout(function () {
//                    var formz = document.getElementById("savedata");
//                    formz.submit();
//                }, 30);
//
//            }));
//        }
    </script>

</html>