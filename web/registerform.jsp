<%-- 
    Document   : registerform
    Created on : Mar 19, 2020, 11:03:14 AM
    Author     : amry4
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Form</title>
        <style>
            table {
                font-family: 'Varela Round', sans-serif;
                border: 2px solid ;
                width: 100%;
            }
            td, th {
                border: 1px  #000000 ;
                text-align: center;
                padding: 7px;
            }
            .table-hover tbody tr:hover td, .table-hover tbody tr:hover th {
                background-color: #FFFFFF;
            }
            thead
            {
                background-color: #405d27;
            }
            tr:nth-child(odd) {
                background-color: #82b74b;

                border: 0.8px #000000;
            }
            tr:nth-child(even) {
                background-color: #c1946a;

                border: 0.8px #000000;
            }
            .dropdown-menu {         
                max-height: 200px;
                overflow-y: auto;
            }
            input {
                position: relative;
                color: black;
            }

            input:before {
                position: absolute;
                content: attr(data-date);
                color: black;
            }

            input::-webkit-datetime-edit, input::-webkit-inner-spin-button, input::-webkit-clear-button {
                display: none;
            }

            input::-webkit-calendar-picker-indicator {
                position: absolute;
                top: 3px;
                right: 0;
                color: black;
                opacity: 1;
            }
            body {
                font-family: 'Varela Round', sans-serif;
            }
            .modal-login {
                color: #636363;
                width: 350px;
            }
            .modal-login .modal-content {
                padding: 20px;
                border-radius: 5px;
                border: none;
            }
            .modal-login .modal-header {
                border-bottom: none;
                position: relative;
                justify-content: center;
            }
            .modal-login h4 {
                text-align: center;
                font-size: 26px;
            }
            .modal-login  .form-group {
                position: relative;
            }
            .modal-login i {
                position: absolute;
                left: 13px;
                top: 11px;
                font-size: 18px;
            }
            .modal-login .form-control {
                padding-left: 40px;
            }
            .modal-login .form-control:focus {
                border-color: #00ce81;
            }
            .modal-login .form-control, .modal-login .btn {
                min-height: 40px;
                border-radius: 3px; 
            }
            .modal-login .hint-text {
                text-align: center;
                padding-top: 10px;
            }
            .modal-login .close {
                position: absolute;
                top: -5px;
                right: -5px;
            }
            .modal-login .btn {
                background: #00ce81;
                border: none;
                line-height: normal;
            }
            .modal-login .btn:hover, .modal-login .btn:focus {
                background: #00bf78;
            }
            .modal-login .modal-footer {
                background: #ecf0f1;
                border-color: #dee4e7;
                text-align: center;
                margin: 0 -20px -20px;
                border-radius: 5px;
                font-size: 13px;
                justify-content: center;
            }
            .modal-login .modal-footer a {
                color: #999;
            }
            .trigger-btn {
                display: inline-block;
                margin: 100px auto;
            }
        </style>
    </head>
    <body>
        <h1>Register Form</h1>
        <form action="${pageContext.servletContext.contextPath}/registervalidation?register" method="POST">
            <div class="container">
                <div class="field">
                    <input maxlength="64" type="Email" id="inputEmail" name="inputEmail" class="inputEmail" required>
                    <input minlength="8"  type="Password" id="inputPassword" name="inputPassword" class="inputPassword" required>
                </div>
                <br>
                <div class="actions">
                    <input class="registerbtn btn btn-success " value="Register" id="registerbtn" type="submit" >
                </div>
            </div>
        </form>

    </body>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js"></script>
    <!-- Jquery v.3.2.1 from ajax for Sweet Alert  -->
    <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
    <!-- Jquery v.3.2.1 from ajax for Bootstrap  -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <!-- poper v.1.11.0 from cdnjs for Bootstrap animation  -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
    <!-- bootstrap.min v.4.0.0 from maxcdn for Bootstrap   -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
    <!-- Jquery v.3.3.0 from code.jquery for datatable  -->
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
    <!-- datatables.min v.3.3.0 from ajax for table design   -->
    <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"></script>
    <script src="https://cdn.datatables.net/fixedheader/3.1.6/js/dataTables.fixedHeader.min.js"></script>
    <script src="https://cdn.datatables.net/responsive/2.2.3/js/dataTables.responsive.min.js"></script>
    <script src="https://cdn.datatables.net/responsive/2.2.3/js/responsive.bootstrap.min.js"></script>
    <script src="https://cdn.datatables.net/buttons/1.6.1/js/buttons.colVis.min.js"></script>
    <script src="https://cdn.datatables.net/buttons/1.6.1/js/dataTables.buttons.min.js">
        $(document).ready(function () {
            $('.field input').keyup(function () {

                var empty = false;
                $('.field input').each(function () {
                    if ($(this).val().length == 0) {
                        empty = true;
                    }
                });

                if (empty) {
                    $('.actions input').attr('disabled', 'disabled');
                } else {
                    $('.actions input').attr('disabled', false);
                }
            });
        });
    </script>
</html>