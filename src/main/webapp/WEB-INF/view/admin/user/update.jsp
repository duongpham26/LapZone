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
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
            <!-- <script>
               $(document).ready(() => {
                  const avatarFile = $("#avatarFile");
                  avatarFile.change(function (e) {
                     const imgURL = URL.createObjectURL(e.target.files[0]);
                     console.log(imgURL);
                     
                     $("#avatarPreview").attr("src", imgURL);
                     $("#avatarPreview").css({ "display": "block" });
                  })
               }) -->
            </script>
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
                                 <h2>Update a user</h2>
                                 <hr />
                                 <form:form action="/admin/user/update" method="post" modelAttribute="updateUser"
                                    class="row">
                                    <div class="mb-3 d-none">
                                       <form:label class="form-label" path="id">Id</form:label>
                                       <form:input class="form-control" path="id" />
                                    </div>

                                    <div class="mb-3 col-12">
                                       <form:label class="form-label" path="email">Email</form:label>
                                       <form:input class="form-control" path="email" type="email" readonly="true" />
                                    </div>

                                    <div class="mb-3 col-md-6 col-12">
                                       <c:set var="fullNameError">
                                          <form:errors path="fullName" cssClass="invalid-feedback" />
                                       </c:set>
                                       <form:label class="form-label" path="fullName">Full Name</form:label>
                                       <form:input class="form-control ${not empty fullNameError ? 'is-invalid' : ''}"
                                          path="fullName" />
                                       ${fullNameError}
                                    </div>

                                    <div class="mb-3 col-md-6 col-12">
                                       <form:label class="form-label" path="phone">Phone</form:label>
                                       <form:input class="form-control" path="phone" />
                                    </div>

                                    <div class="mb-3 col-md-6 col-12">
                                       <form:label class="form-label" path="address">Address</form:label>
                                       <form:input class="form-control" path="address" />
                                    </div>

                                    <div class="mb-3 col-12 col-md-6">
                                       <label class="form-label">Role</label>
                                       <form:select class="form-select" path="role.name">
                                          <form:option value="ADMIN">ADMIN</form:option>
                                          <form:option value="USER">USER</form:option>
                                       </form:select>
                                    </div>

                                    <!-- <div class="mb-3 col-12 col-md-6">
                                       <label for="avatarFile" class="form-label">Avatar</label>
                                       <input class="form-control" type="file" id="avatarFile" accept=".png, .jpg, .jpeg" name="imageFile"/>
                                    </div>

                                    <div class="mb-3 col-12">
                                       <img src="" alt="Avatar preview" id="avatarPreview" style="display: none; max-width: 250px;">
                                    </div> -->

                                    <div class="mt-3">
                                       <button type="submit" class="btn btn-warning ">Update</button>
                                       <a class="btn btn-success mx-3" href="/admin/user">Exit</a>
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