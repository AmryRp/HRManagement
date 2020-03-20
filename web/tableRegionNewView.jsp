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
<% GeneralDao<Region> gr = new GeneralDao<>();%>
<% IDao<Region> IRegion; %>
<% IRegion = new GeneralDao();%>
<!DOCTYPE html>
<html style="height: auto;" class=""><head>
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
                        <a href="index3.html" class="nav-link">Home</a>
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
            <aside class="main-sidebar sidebar-dark-primary elevation-4">
                <!-- Brand Logo -->
                <a href="/index3.html" class="brand-link">
                    <img src="dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
                    <span class="brand-text font-weight-light">AdminLTE 3</span>
                </a>

                <!-- Sidebar -->
                <div class="sidebar">
                    <nav class="mt-2">
                        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">

                            <li class="nav-item has-treeview">
                                <a href="#" class="nav-link">
                                    <i class="nav-icon fas fa-edit"></i>
                                    <p>
                                        Forms
                                        <i class="fas fa-angle-left right"></i>
                                    </p>
                                </a>
                                <ul class="nav nav-treeview" style="display: none;">
                                    <li class="nav-item">
                                        <a href="../forms/general.html" class="nav-link">
                                            <i class="far fa-circle nav-icon"></i>
                                            <p>General Elements</p>
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="../forms/advanced.html" class="nav-link">
                                            <i class="far fa-circle nav-icon"></i>
                                            <p>Advanced Elements</p>
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="../forms/editors.html" class="nav-link">
                                            <i class="far fa-circle nav-icon"></i>
                                            <p>Editors</p>
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="../forms/validation.html" class="nav-link">
                                            <i class="far fa-circle nav-icon"></i>
                                            <p>Validation</p>
                                        </a>
                                    </li>
                                </ul>
                            </li>
                            <li class="nav-item has-treeview">
                                <a href="#" class="nav-link active">
                                    <i class="nav-icon fas fa-table"></i>
                                    <p>
                                        Tables
                                        <i class="fas fa-angle-left right"></i>
                                    </p>
                                </a>
                                <ul class="nav nav-treeview" style="display: none;">

                                    <li class="nav-item">
                                        <a href="../tables/data.html" class="nav-link active">
                                            <i class="far fa-circle nav-icon"></i>
                                            <p>DataTables</p>
                                        </a>
                                    </li>

                                    <li class="nav-item">
                                        <a href="../tables/data.html" class="nav-link active">
                                            <i class="far fa-circle nav-icon"></i>
                                            <p>DataTables</p>
                                        </a>
                                    </li><li class="nav-item">
                                        <a href="../tables/data.html" class="nav-link active">
                                            <i class="far fa-circle nav-icon"></i>
                                            <p>DataTables</p>
                                        </a>
                                    </li></ul>
                            </li>

                        </ul>
                    </nav>
                    <!-- /.sidebar-menu -->
                </div>
                <!-- /.sidebar -->
            </aside>

            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper" style="min-height: 806px;">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <div class="container-fluid">
                        <div class="row mb-2">
                            <div class="col-sm-6">
                                <h1>DataTables</h1>
                            </div>
                            <div class="col-sm-6">
                                <ol class="breadcrumb float-sm-right">
                                    <li class="breadcrumb-item"><a href="#">Home</a></li>
                                    <li class="breadcrumb-item active">DataTables</li>
                                </ol>
                            </div>
                        </div>
                    </div><!-- /.container-fluid -->
                </section>

                <!-- Main content -->
                <section class="content">
                    <div class="row">
                        <div class="col-12">
                            <div class="card">
                                <div class="card-header">
                                    <h3 class="card-title">DataTable with minimal features &amp; hover style</h3>
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
                                                                                    <th class="no-sort" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" >Action</th>
                                                                                </tr>
                                                                            </thead>
                                                                            <tbody>
                                                                                <%
                                                                                    for (Region c : gr.manageData(new Region(), "regionName", "", "", false, true)) {
                                                                                %>   <tr role="row" class="odd">
                                                                                    <td class="nr sorting_1"tabindex="0" ><%= c.getRegionId()%></td>
                                                                                    <td class="nr2 sorting_1"tabindex="0" ><%= c.getRegionName()%></td>
                                                                                    <td><a href="#" data-toggle="tooltip" title="Edit Data">
                                                                                            <i class="fa fa-edit updating confirm"style="color: blue; align-content: center" ></i>
                                                                                        </a>
                                                                                        <a href="#" data-toggle="tooltip" title="Delete Data">
                                                                                            <i class="fa fa-trash confirm" style="color: red; align-content: center" ></i>
                                                                                        </a>      
                                                                                    </td>

                                                                                </tr>
                                                                                <% }
                                                                                %></tbody>
                                                                            <tfoot>
                                                                                <tr>
                                                                                    <th rowspan="1" colspan="1">Id</th>
                                                                                    <th rowspan="1" colspan="1">Name</th>
                                                                                    <th rowspan="1" colspan="1">Action</th>
                                                                            </tfoot>
                                                                        </table>
                                                                    </div>
                                                                </div>
                                                                <div class="row">
                                                                    <div class="col-sm-12 col-md-7">
                                                                        <div class="dataTables_paginate paging_simple_numbers" id="example2_paginate">
                                                                            <ul class="pagination">
                                                                                <li class="paginate_button page-item previous disabled" id="example2_previous">
                                                                                    <a href="#" aria-controls="example2" data-dt-idx="0" tabindex="0" class="page-link">Previous</a>
                                                                                </li>
                                                                                <li class="paginate_button page-item active">
                                                                                    <a href="#" aria-controls="example2" data-dt-idx="1" tabindex="0" class="page-link">1</a>
                                                                                </li>
                                                                                <li class="paginate_button page-item next disabled" id="example2_next">
                                                                                    <a href="#" aria-controls="example2" data-dt-idx="2" tabindex="0" class="page-link">Next</a>
                                                                                </li>
                                                                            </ul>
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
            <footer class="main-footer">
                <div class="float-right d-none d-sm-block">
                    <b>Version</b> 3.0.3-pre
                </div>
                <strong>Copyright © 2014-2019 <a href="http://adminlte.io">AdminLTE.io</a>.</strong> All rights
                reserved.
            </footer>

            <!-- Control Sidebar -->
            <aside class="control-sidebar control-sidebar-dark" style="display: block;">
                <!-- Control sidebar content goes here -->
                <div class="p-3 control-sidebar-content"><h5>Options</h5><hr class="mb-2"><div class="mb-1"><input type="checkbox" value="1" class="mr-1"><span>Logout</span></div></div></aside>
            <!-- /.control-sidebar -->
            <div id="sidebar-overlay"></div>

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
        </script>
    </body>
</html>

