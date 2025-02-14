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
                        <h1 class="mt-4">Manage Products</h1>
                        <ol class="breadcrumb mb-4">
                           <li class="breadcrumb-item"><a href="/admin">Dashboard</a></li>
                           <li class="breadcrumb-item active">Products</li>
                        </ol>
                        <div class="container mt-5">
                           <div class="row">
                              <div class="col-md-6 mb-3 mx-auto">
                                 <div class="card" style="width: 100%;">
                                    <div class="card-header">
                                       <h2>Product Details</h2>
                                    </div>
                                    <ul class="list-group list-group-flush">
                                       <li class="list-group-item">
                                          <img src="/images/product/${product.image}" alt="abc" srcset=""
                                             style="max-width: 250px;">
                                       </li>
                                       <li class="list-group-item">
                                          <div class="row">
                                             <div class="col-6 font-weight-bold">ID:</div>
                                             <div class="col">${product.id}</div>
                                          </div>
                                       </li>
                                       <li class="list-group-item">
                                          <div class="row">
                                             <div class="col-6 font-weight-bold">Name:</div>
                                             <div class="col">${product.name}</div>
                                          </div>
                                       </li>
                                       <li class="list-group-item">
                                          <div class="row">
                                             <div class="col-6 font-weight-bold">Price:</div>
                                             <div class="col">${product.price}</div>
                                          </div>
                                       </li>
                                       <li class="list-group-item">
                                          <div class="row">
                                             <div class="col-6 font-weight-bold">Detail Description:</div>
                                             <div class="col">${product.detailDesc}</div>
                                          </div>
                                       </li>
                                       <li class="list-group-item">
                                          <div class="row">
                                             <div class="col-6 font-weight-bold">Short Description:</div>
                                             <div class="col">${product.shortDesc}</div>
                                          </div>
                                       </li>
                                       <li class="list-group-item">
                                          <div class="row">
                                             <div class="col-6 font-weight-bold">Quantity:</div>
                                             <div class="col">${product.quantity}</div>
                                          </div>
                                       </li>
                                       <li class="list-group-item">
                                          <div class="row">
                                             <div class="col-6 font-weight-bold">Sold:</div>
                                             <div class="col">${product.sold}</div>
                                          </div>
                                       </li>
                                       <li class="list-group-item">
                                          <div class="row">
                                             <div class="col-6 font-weight-bold">Factory:</div>
                                             <div class="col">${product.factory}</div>
                                          </div>
                                       </li>
                                       <li class="list-group-item">
                                          <div class="row">
                                             <div class="col-6 font-weight-bold">Target:</div>
                                             <div class="col">${product.target}</div>
                                          </div>
                                       </li>
                                    </ul>

                                 </div>
                                 <a href="/admin/product" class="btn btn-primary mt-3 float-end">Back</a>
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