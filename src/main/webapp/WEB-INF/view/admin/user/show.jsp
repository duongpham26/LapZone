<%@ page contentType="text/html" pageEncoding="UTF-8" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
         <!DOCTYPE html>
         <html lang="en">

         <head>
            <meta charset="utf-8" />
            <meta http-equiv="X-UA-Compatible" content="IE=edge" />
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
            <meta name="description" content="" />
            <meta name="author" content="" />
            <title>Dashboard - SB Admin</title>
            <link href="/css/styles.css" rel="stylesheet" />
            <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
         </head>

         <body class="sb-nav-fixed">
            <jsp:include page="../layout/header.jsp" />
            <div id="layoutSidenav">
               <jsp:include page="../layout/sidebar.jsp" />
               <div id="layoutSidenav_content">
                  <main>
                     <div class="container-fluid px-4">
                        <h1 class="mt-4">Manage Users</h1>
                        <ol class="breadcrumb mb-4">
                           <li class="breadcrumb-item"><a href="/admin">Dashboard</a></li>
                           <li class="breadcrumb-item active">Users</li>
                        </ol>
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
                                          <a href="/admin/user/update/${user.id}"
                                             class="btn btn-warning mx-3">Update</a>
                                          <a class="btn btn-danger" href="/admin/user/delete/${user.id}">Delete</a>
                                       </td>
                                    </tr>
                                 </c:forEach>
                              </tbody>
                           </table>
                        </div>
                     </div>
                  </main>
                  <jsp:include page="../layout/footer.jsp" />
               </div>
            </div>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
               crossorigin="anonymous"></script>
            <script src="js/scripts.js"></script>
         </body>
         </html>