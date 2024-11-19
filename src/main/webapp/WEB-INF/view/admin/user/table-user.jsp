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
               <div class="d-flex justify-content-between">
                  <h3 class="mb-0">Table User</h3>
                  <a class="btn btn-primary" href="/admin/user/create" role="button">Create User</a>
               </div>
               <hr />

               <table class="table table-bordered table-hover align-middle text-center">
                  <thead>
                     <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Email</th>
                        <th scope="col">Full Name</th>
                        <th scope="col">Action</th>
                     </tr>
                  </thead>

                  <tbody>
                     <c:forEach var="user" items="${users}">
                        <tr>
                           <th scope="row">${user.id}</th>
                           <td>${user.email}</td>
                           <td>${user.fullName}</td>
                           <td class="text-center">
                              <a href="/admin/user/${user.id}" class="btn btn-success">View</a>
                              <a href="/admin/user/update/${user.id}" class="btn btn-warning mx-3">Update</a>
                              <a class="btn btn-danger" href="/admin/user/delete/${user.id}">Delete</a>
                           </td>
                        </tr>
                     </c:forEach>
                  </tbody>
               </table>
            </div>

         </body>

         </html>