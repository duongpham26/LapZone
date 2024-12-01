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

                           <div class="row">
                              <div class="col-md-6 mb-3 mx-auto">
                                 <h2>Create a user</h2>
                                 <hr />
                                 <form:form action="/admin/user/create" method="post" modelAttribute="newUser" class="row">
                                    <div class="mb-3 col-md-6 col-12">
                                       <form:label class="form-label" path="email">Email</form:label>
                                       <form:input class="form-control" path="email" type="email" />
                                    </div>
            
                                    <div class="mb-3 col-12 col-md-6">
                                       <form:label class="form-label" path="password">Password</form:label>
                                       <form:input class="form-control" path="password" type="password" />
                                    </div>
                                   
                                    <div class="mb-3 col-md-6 col-12">
                                       <form:label class="form-label" path="fullName">Full Name</form:label>
                                       <form:input class="form-control" path="fullName" />
                                    </div>
            
                                    <div class="mb-3 col-md-6 col-12">
                                       <form:label class="form-label" path="phone">Phone</form:label>
                                       <form:input class="form-control" path="phone" />
                                    </div>
            
                                    <div class="mb-3 col-12">
                                       <form:label class="form-label" path="address">Address</form:label>
                                       <form:input class="form-control" path="address" accept=".png, .jpg, jpeg" />
                                    </div>

                                    <div class="mb-3 col-12 col-md-6">
                                       <label class="form-label" path="role">Role</label>
                                       <select class="form-select">
                                          <option value="ADMIN">Admin</option>
                                          <option value="USER">User</option>
                                        </select>
                                    </div>

                                    <div class="mb-3 col-12 col-md-6">
                                       <label for="formFile" class="form-label">Avatar</label>
                                       <input class="form-control" type="file" id="formFile" />
                                    </div>

                                    <div class="mb-3 col-12">
                                       <img src="" alt="Avatar preview" id="avatarPreview" style="display: none; max-width: 250px;">
                                    </div>
      
                                    <div class="mb-3 col-12">
                                       <button type="submit" class="btn btn-primary mt-3">Submit</button>
                                    </div>
            
                                 </form:form>
                              </div>
                           </div>
            
                        </div>
                     </div>
                  </main>
                  <jsp:include page="../layout/footer.jsp" />
               </div>
            </div>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
               crossorigin="anonymous"></script>
            <script src="/js/scripts.js"></script>
         </body>
         </html>