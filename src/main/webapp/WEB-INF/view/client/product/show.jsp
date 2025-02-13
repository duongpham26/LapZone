<%@ page contentType="text/html" pageEncoding="UTF-8" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
         <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <!-- format number-->>
            <!DOCTYPE html>
            <html lang="en">

            <head>
               <meta charset="utf-8">
               <title>Home - LaptopZone</title>
               <meta content="width=device-width, initial-scale=1.0" name="viewport">
               <meta content="" name="keywords">
               <meta content="" name="description">

               <!-- Google Web Fonts -->
               <link rel="preconnect" href="https://fonts.googleapis.com">
               <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
               <link
                  href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Raleway:wght@600;800&display=swap"
                  rel="stylesheet">

               <!-- Icon Font Stylesheet -->
               <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" />
               <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
                  rel="stylesheet">

               <!-- Libraries Stylesheet -->
               <link href="/client/lib/lightbox/css/lightbox.min.css" rel="stylesheet">
               <link href="/client/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">


               <!-- Customized Bootstrap Stylesheet -->
               <link href="/client/css/bootstrap.min.css" rel="stylesheet">

               <!-- Template Stylesheet -->
               <link href="/client/css/style.css" rel="stylesheet">
            </head>

            <body>

               <!-- Spinner Start -->
               <div id="spinner"
                  class="show w-100 vh-100 bg-white position-fixed translate-middle top-50 start-50  d-flex align-items-center justify-content-center">
                  <div class="spinner-grow text-primary" role="status"></div>
               </div>
               <!-- Spinner End -->


               <!-- Navbar start -->
               <!-- header -->
               <jsp:include page="../layout/header.jsp" />
               <!-- Navbar End -->

               <!-- Fruits Shop Start-->
               <div class="container-fluid fruite py-5">
                  <div class="container py-5">
                     <nav aria-label="breadcrumb">
                        <ol class="breadcrumb mb-4">
                           <li class="breadcrumb-item"><a href="/admin">Dashboard</a></li>
                           <li class="breadcrumb-item active">Products</li>
                        </ol>
                     </nav>


                     <div class="row g-4 ">
                        <div class="col-12 col-md-4">
                           <div class="row g-4">
                              <div class="col-12">
                                 <div class="mb-2"><b>Factory</b></div>
                                 <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="checkbox" id="factory-1" value="APPLE">
                                    <label class="form-check-label" for="factory-1">Apple</label>
                                 </div>
                                 <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="checkbox" id="factory-2" value="LENOVO">
                                    <label class="form-check-label" for="factory-2">Lenovo</label>
                                 </div>
                                 <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="checkbox" id="factory-3" value="ASUS">
                                    <label class="form-check-label" for="factory-3">Asus</label>
                                 </div>
                                 <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="checkbox" id="factory-4" value="HP">
                                    <label class="form-check-label" for="factory-4">HP</label>
                                 </div>
                                 <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="checkbox" id="factory-5" value="ACER">
                                    <label class="form-check-label" for="factory-5">Acer</label>
                                 </div>
                                 <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="checkbox" id="factory-6" value="MSI">
                                    <label class="form-check-label" for="factory-6">MSI</label>
                                 </div>
                                 <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="checkbox" id="factory-7" value="DELL">
                                    <label class="form-check-label" for="factory-7">Dell</label>
                                 </div>
                                 <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="checkbox" id="factory-8" value="MICROSOFT">
                                    <label class="form-check-label" for="factory-8">Microsoft</label>
                                 </div>
                                 <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="checkbox" id="factory-9" value="SONY">
                                    <label class="form-check-label" for="factory-9">Sony VAIO</label>
                                 </div>
                              </div>
                              <div class="col-12">
                                 <div class="mb-2"><b>Target</b></div>
                                 <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="checkbox" id="target-1" value="office">
                                    <label class="form-check-label" for="target-1">Office</label>
                                 </div>
                                 <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="checkbox" id="target-2" value="gaming">
                                    <label class="form-check-label" for="target-2">Gaming</label>
                                 </div>
                                 <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="checkbox" id="target-3" value="other">
                                    <label class="form-check-label" for="target-3">Other</label>
                                 </div>
                              </div>
                              <div class="col-12">
                                 <div class="mb-2"><b>Price</b></div>
                                 <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="checkbox" id="price-1" value="price-1">
                                    <label class="form-check-label" for="price-1">Under 10 million</label>
                                 </div>
                                 <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="checkbox" id="price-2" value="price-2">
                                    <label class="form-check-label" for="price-2">From 10 to 15 million</label>
                                 </div>
                                 <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="checkbox" id="price-3" value="price-3">
                                    <label class="form-check-label" for="price-3">From 15 to 20 million</label>
                                 </div>
                                 <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="checkbox" id="price-4" value="price-4">
                                    <label class="form-check-label" for="price-4">Over 20 million</label>
                                 </div>
                              </div>

                              <div class="col-12">
                                 <div class="mb-2"><b>Sort</b></div>
                                 <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="checkbox" id="sort-1" value="sort-1">
                                    <label class="form-check-label" for="sort-1">Price ascending</label>
                                 </div>
                                 <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="checkbox" id="sort-2" value="sort-2">
                                    <label class="form-check-label" for="sort-2">Price descending</label>
                                 </div>
                                 <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="checkbox" id="sort-3" value="sort-3">
                                    <label class="form-check-label" for="sort-3">Not sort</label>
                                 </div>
                              </div>
                           </div>
                           <button class="btn border-secondary rounded-pill px-4 py-3 text-primary text-uppercase mt-4"
                              type="submit">Filter product</button>
                        </div>

                        <div class="col-12 col-md-8">
                           <div class="row g-4">
                              <c:forEach var="product" items="${products}">
                                 <div class="col-12 col-md-4">
                                    <div class="rounded position-relative fruite-item border">
                                       <div class="fruite-img">
                                          <img src="/images/product/${product.image}" class="img-fluid w-90 rounded-top"
                                             alt="">
                                       </div>
                                       <div class="text-white bg-secondary px-3 py-1 rounded position-absolute"
                                          style="top: 10px; left: 10px;">${product.factory}
                                       </div>
                                       <div class="p-4 rounded-bottom">
                                          <p style="font-size: 15px; font-weight: bold; text-align: center;"
                                             class="mb-2">
                                             <a href="/product/${product.id}">${product.name}</a>
                                          </p>
                                          <p style="font-size: 13px; text-align: center;">${product.shortDesc}</p>
                                          <div class="flex-lg-wrap">
                                             <p class="text-dark fs-5 fw-bold mb-3"
                                                style="font-size: 15px; text-align: center; width: 100%;">
                                                <fmt:formatNumber type="number" value="${product.price}" /> VND
                                             </p>
                                             <form action="/add-product-to-cart/${product.id}" method="post">
                                                <div>
                                                   <input type="hidden" name="${_csrf.parameterName}"
                                                      value="${_csrf.token}" />
                                                </div>
                                                <button href="#"
                                                   class="mx-auto btn border border-secondary rounded-pill px-3 text-primary mt-1 d-flex align-items-center">
                                                   <i class="fa fa-shopping-bag me-2 text-primary"></i>
                                                   Add to cart</button>
                                             </form>
                                          </div>
                                       </div>
                                    </div>
                                 </div>
                              </c:forEach>
                           </div>
                           <nav aria-label="Page navigation example">
                              <ul class="pagination justify-content-center flex-row d-flex mt-4">
                                 <li class="page-item ${1 eq currentPage ? 'disabled' : ''}">
                                    <a class=" page-link" href="/products?page=${currentPage - 1}"
                                       aria-label="Previous">
                                       <span aria-hidden="true">&laquo;</span>
                                    </a>
                                 </li>

                                 <c:forEach begin="0" end="${(totalPages eq 0) ? 0 : totalPages - 1}" varStatus="loop">
                                    <li class="page-item">
                                       <a class="page-link ${(loop.index + 1) eq currentPage ? 'active' : ''}"
                                          href="/products?page=${loop.index + 1}">
                                          ${loop.index +1}
                                       </a>
                                    </li>
                                 </c:forEach>

                                 <li class="page-item ${totalPages eq currentPage ? 'disabled' : ''}">
                                    <a class="page-link" href="/products?page=${currentPage + 1}" aria-label="Next">
                                       <span aria-hidden="true">&raquo;</span>
                                    </a>
                                 </li>
                              </ul>
                           </nav>
                        </div>
                     </div>
                  </div>
               </div>
               <!-- Fruits Shop End-->


               <!-- Footer Start -->
               <jsp:include page="../layout/footer.jsp" />
               <!-- Footer End -->

               <!-- Copyright Start -->
               <div class="container-fluid copyright bg-dark py-4">
                  <div class="container">
                     <div class="row">
                        <div class="col-md-6 text-center text-md-start mb-3 mb-md-0">
                           <span class="text-light"><a href="#"><i class="fas fa-copyright text-light me-2"></i>Your
                                 Site Name</a>, All
                              right
                              reserved.</span>
                        </div>
                        <div class="col-md-6 my-auto text-center text-md-end text-white">
                           <!--/*** This template is free as long as you keep the below author’s credit link/attribution link/backlink. ***/-->
                           <!--/*** If you'd like to use the template without the below author’s credit link/attribution link/backlink, ***/-->
                           <!--/*** you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". ***/-->
                           Designed By <a class="border-bottom" href="https://htmlcodex.com">HTML Codex</a>
                           Distributed By <a class="border-bottom" href="https://themewagon.com">ThemeWagon</a>
                        </div>
                     </div>
                  </div>
               </div>
               <!-- Copyright End -->



               <!-- Back to Top -->
               <a href="#" class="btn btn-primary border-3 border-primary rounded-circle back-to-top"><i
                     class="fa fa-arrow-up"></i></a>


               <!-- JavaScript Libraries -->
               <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
               <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
               <script src="/client/lib/easing/easing.min.js"></script>
               <script src="/client/lib/waypoints/waypoints.min.js"></script>
               <script src="/client/lib/lightbox/js/lightbox.min.js"></script>
               <script src="/client/lib/owlcarousel/owl.carousel.min.js"></script>

               <!-- Template Javascript -->
               <script src="/client/js/main.js"></script>
            </body>

            </html>