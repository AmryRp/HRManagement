<%-- 
    Document   : registerform
    Created on : Mar 19, 2020, 11:03:14 AM
    Author     : amry4
--%>
<%@page import="servlet.RegisterValidation"%>
<%@page import="net.tanesha.recaptcha.ReCaptchaResponse"%>
<%@page import="net.tanesha.recaptcha.ReCaptchaImpl"%>
<%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Register</title>
        <link href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://www.google.com/recaptcha/api.js" async defer></script>

        <style type="text/css">
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
        <div id="myModal" class="container ">
            <div class="modal-dialog modal-login">
                <div class="modal-content">
                    <div class="modal-header">				
                        <h4 class="modal-title">Register Form</h4>
                        <!--<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>-->
                    </div>
                    <div class="modal-body">
                        <form action="registerValidation?register" method="post">
                            <div class="form-group">
                                <i class="fa fa-user"></i>
                                <input maxlength="64" type="Email" id="inputEmail" name="inputEmail" class="inputEmail form-control" required>
                            </div>
                            <div class="form-group">
                                <i class="fa fa-lock"></i>
                                <input minlength="8"  type="Password" id="inputPassword" name="inputPassword" class="inputPassword form-control" required>				
                            </div>
                            <p style="color:red;">${errorString}</p>
                            <div class="form-group">
                                <% String SiteKey = RegisterValidation.SITE_KEY;
                                %>
                                <div class="g-recaptcha"
                                     data-sitekey=<%= SiteKey%>></div>
                            </div>
                            <div class="form-group">
                                <input class="registerbtn btn btn-success btn-block btn-lb" value="Submit" id="registerbtn form-control" type="submit" >
                            </div>
                        </form>				

                    </div>
                    <div class="modal-footer">

                        <a href="forgotpassword.jsp">Forgot Password?</a>
                        <a href="login.jsp" style="color: brown"> <i class="fa fa-chevron-left"></i> </a> 

                    </div>
                </div>
            </div>
        </div>    
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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js"></script>
    <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'>

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
