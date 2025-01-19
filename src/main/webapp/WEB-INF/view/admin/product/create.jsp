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
            <script>
               $(document).ready(() => {
                  const avatarFile = $("#avatarFile");
                  avatarFile.change(function (e) {
                     const imgURL = URL.createObjectURL(e.target.files[0]);
                     console.log(imgURL);

                     $("#avatarPreview").attr("src", imgURL);
                     $("#avatarPreview").css({ "display": "block" });
                  })
               })
            </script>
         </head>

         <body class="sb-nav-fixed">
            <jsp:include page="../layout/header.jsp" />
            <div id="layoutSidenav">
               <jsp:include page="../layout/sidebar.jsp" />
               <div id="layoutSidenav_content">
                  <main>
                     <div class="container-fluid px-4">
                        <h1 class="mt-4">Manage Product</h1>
                        <ol class="breadcrumb mb-4">
                           <li class="breadcrumb-item"><a href="/admin">Dashboard</a></li>
                           <li class="breadcrumb-item active">Products</li>
                        </ol>
                        <div class="container mt-5">

                           <div class="row">
                              <div class="col-md-6 mb-3 mx-auto">
                                 <h2>Create a product</h2>
                                 <hr />
                                 <form:form action="/admin/product/create" method="post" modelAttribute="newProduct"
                                    enctype="multipart/form-data" class="row">
                                    <div class="mb-3 col-md-6 col-12">
                                       <c:set var="nameError">
                                          <form:errors path="name" cssClass="invalid-feedback" />
                                       </c:set>
                                       <form:label class="form-label" path="name">Name</form:label>
                                       <form:input class="form-control ${not empty nameError ? 'is-invalid' : ''}"
                                          path="name" type="text" />
                                       ${nameError}
                                    </div>

                                    <div class="mb-3 col-12 col-md-6">
                                       <c:set var="priceError">
                                          <form:errors path="price" cssClass="invalid-feedback" />
                                       </c:set>
                                       <form:label class="form-label" path="price">Price</form:label>
                                       <form:input class="form-control ${not empty priceError ? 'is-invalid' : ''}"
                                          path="price" type="number" />
                                       ${priceError}
                                    </div>

                                    <div class="mb-3 col-md-6 col-12">
                                       <c:set var="detailDescError">
                                          <form:errors path="detailDesc" cssClass="invalid-feedback" />
                                       </c:set>
                                       <form:label class="form-label" path="detailDesc">Detail Description</form:label>
                                       <form:textarea
                                          class="form-control  ${not empty detailDescError ? 'is-invalid' : ''}"
                                          path="detailDesc" type="text" style="height: 100px;" />
                                       ${detailDescError}
                                    </div>

                                    <div class="mb-3 col-md-6 col-12">
                                       <c:set var="shortDescError">
                                          <form:errors path="shortDesc" cssClass="invalid-feedback" />
                                       </c:set>
                                       <form:label class="form-label" path="shortDesc">Short
                                          Description</form:label>
                                       <form:input class="form-control  ${not empty shortDescError ? 'is-invalid' : ''}"
                                          path="shortDesc" type="text-area" />
                                       ${shortDescError}
                                    </div>

                                    <div class="mb-3  col-12 col-md-6">
                                       <c:set var="quantityError">
                                          <form:errors path="quantity" cssClass="invalid-feedback" />
                                       </c:set>
                                       <form:label class="form-label" path="quantity">Quantity</form:label>
                                       <form:input class="form-control  ${not empty quantityError ? 'is-invalid' : ''}"
                                          path="quantity" type="number" />
                                       ${quantityError}
                                    </div>

                                    <div class="mb-3 col-12 col-md-6">
                                       <label class="form-label" path="factory">Factory</label>
                                       <form:select class="form-select" path="factory">
                                          <form:option value="APPLE">Apple (Macbook)</form:option>
                                          <form:option value="LENOVO">Lenovo</form:option>
                                          <form:option value="ASUS">Asus</form:option>
                                          <form:option value="HP">HP</form:option>
                                          <form:option value="ACER">Acer</form:option>
                                          <form:option value="MSI">MSI</form:option>
                                          <form:option value="DELL">Dell</form:option>
                                          <form:option value="MICROSOFT">Microsoft</form:option>
                                          <form:option value="SONY VAIO">Sony VAIO</form:option>
                                       </form:select>
                                    </div>

                                    <div class="mb-3 col-12 col-md-6">
                                       <label class="form-label" path="target">Target</label>
                                       <form:select class="form-select" path="target">
                                          <form:option value="office">Office</form:option>
                                          <form:option value="gaming">Gaming</form:option>
                                          <form:option value="other">Other</form:option>
                                       </form:select>
                                    </div>

                                    <div class="mb-3 col-12 col-md-6">
                                       <label for="avatarFile" class="form-label">Image</label>
                                       <input class="form-control" type="file" id="avatarFile"
                                          accept=".png, .jpg, .jpeg" name="imageFile" />
                                    </div>

                                    <div class="mb-3 col-12">
                                       <img src="" alt="Avatar preview" id="avatarPreview"
                                          style="display: none; max-width: 250px;">
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