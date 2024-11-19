<%@ page contentType="text/html" pageEncoding="UTF-8" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

         <!DOCTYPE html>
         <html lang="en">

         <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Document</title>

            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
               integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
               crossorigin="anonymous">

            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
               integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
               crossorigin="anonymous"></script>

            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

            <!-- <link rel="stylesheet" href="/css/demo.css"> -->

         </head>

         <body>
            <div class="container mt-5">
               <div class="row">
                  <div class="col-md-6 mb-3 mx-auto">
                     <div class="card" style="width: 100%;">
                        <div class="card-header">
                           <h2>User Details</h2>
                        </div>
                        <ul class="list-group list-group-flush">
                           <li class="list-group-item">
                             <div class="row">
                               <div class="col-6 font-weight-bold">ID:</div>
                               <div class="col">${user.id}</div>
                             </div>
                           </li>
                           <li class="list-group-item">
                             <div class="row">
                               <div class="col-6 font-weight-bold">Email:</div>
                               <div class="col">${user.email}</div>
                             </div>
                           </li>
                           <li class="list-group-item">
                             <div class="row">
                               <div class="col-6 font-weight-bold">Full Name:</div>
                               <div class="col">${user.fullName}</div>
                             </div>
                           </li>
                           <li class="list-group-item">
                             <div class="row">
                               <div class="col-6 font-weight-bold">Address:</div>
                               <div class="col">${user.address}</div>
                             </div>
                           </li>
                           <li class="list-group-item">
                             <div class="row">
                               <div class="col-6 font-weight-bold">Phone:</div>
                               <div class="col">${user.phone}</div>
                             </div>
                           </li>
                         </ul>
                         
                     </div>
                     <a href="/admin/user" class="btn btn-primary mt-3 float-end">Back</a>
                  </div>
               </div>
         </body>

         </html>