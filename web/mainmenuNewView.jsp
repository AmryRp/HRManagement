<%-- 
    Document   : mainmenuNewView
    Created on : Mar 21, 2020, 10:14:03 AM
    Author     : amry4
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="height: auto;" class="">
    <head>
        <jsp:include page="/script.jsp" />
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Region</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
        <!-- DataTables -->
        <link rel="stylesheet" href="plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
        <link rel="stylesheet" href="plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="dist/css/adminlte.min.css">
        <!-- Google Font: Source Sans Pro -->
        <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
    </head>
    <body class="sidebar-mini sidebar-collapse control-sidebar-slide-open" data-gr-c-s-loaded="true" style="height: auto;">
        <div class="wrapper">
            
            <!-- Navbar -->
            <nav class="main-header navbar navbar-expand navbar-white navbar-light">
                <!-- Left navbar links -->
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
                    </li>
                    <li class="nav-item d-none d-sm-inline-block">
                        <a href="mainmenuNewView.jsp" class="nav-link">Home</a>
                    </li>
                    <li class="nav-item d-none d-sm-inline-block">
                        <a href="#" class="nav-link">Contact</a>
                    </li>
                </ul>

                <!-- SEARCH FORM -->
                <form class="form-inline ml-3">
                    <div class="input-group input-group-sm">
                        <input class="form-control form-control-navbar" type="search" placeholder="Search" aria-label="Search">
                        <div class="input-group-append">
                            <button class="btn btn-navbar" type="submit">
                                <i class="fas fa-search"></i>
                            </button>
                        </div>
                    </div>
                </form>

                <!-- Right navbar links -->
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" data-widget="control-sidebar" data-slide="false" href="#" role="button">
                            <i class="fas fa-th-large"></i>
                        </a>
                    </li>
                </ul>
            </nav>
            <!-- /.navbar -->

            <!-- Main Sidebar Container -->

        </div>
        

        <!-- ./wrapper -->

        <!-- jQuery -->
        <script src="plugins/jquery/jquery.min.js"></script>
        <!-- Bootstrap 4 -->
        <script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
        <!-- DataTables -->
        <script src="plugins/datatables/jquery.dataTables.min.js"></script>
        <script src="plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
        <script src="plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
        <script src="plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
        <!-- AdminLTE App -->
        <script src="dist/js/adminlte.min.js"></script>
        <!-- AdminLTE for demo purposes -->
        <script src="dist/js/demo.js"></script>
        <!-- page script -->
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
                                                            {"orderable": false, "targets": 2}
                                                        ]

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
        </script>
    </body>
</html>
