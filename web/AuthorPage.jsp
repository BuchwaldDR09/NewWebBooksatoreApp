<%-- 
    Document   : AuthorPage
    Created on : Feb 6, 2016, 12:22:10 PM
    Author     : Buchw_000
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.5/slate/bootstrap.min.css">
        <title>Daniel's BookStore</title>
    </head>
    <body>

        
        
        <div class="jumbotron">
            <h1 style="text-align: center">
                <u style="color: #0099ff"<b>Daniel's Bookstore: Authors</b>
            </h1>
        </div>
         
        <style>
            .nav-pills{
                display: flex;
                justify-content: center;
            }
        </style>
        
        
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
                <ul class="nav nav-pills">
                    <li><a href="Home.jsp">Home</a></li>
                </ul>
            </div>
          </div>
        </nav>
        
        <div class="row">
            <div class ="container">
                <div class="panel panel-default">
                
                
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th><u>Author Name</u></th>
                            <th><u>Author ID</u></th>
                            <th><u>Time/Date Stamp</u></th>   
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>${firstAuthorName}</td>
                            <td>${firstAuthorID}</td>
                            <td>${firstTimeStamp}</td>
                        </tr>
                        <tr>
                            <td>${secondAuthorName}</td>
                            <td>${secondAuthorID}</td>
                            <td>${secondTimeStamp}</td>
                        </tr>
                        <tr>
                            <td>${thirdAuthorName}</td>
                            <td>${thirdAuthorID}</td>
                            <td>${thirdTimeStamp}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
        
        
    </body>
</html>
