<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!-- directive của JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sneaker Shop</title>
    <link
      rel="icon"
      type="image/png"
      sizes="16x16"
      href="https://i.pinimg.com/236x/56/d9/0d/56d90d66b6ed70bcd57cf711012338ec.jpg"
    />
    <!-- Favicon -->
    <link href="${resource}/frontend/img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet"> 

    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="${resource}/frontend/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
	<link href="${resource}/backend/css/simplePagination.css" rel="stylesheet" />
    <!-- Customized Bootstrap Stylesheet -->
    <link href="${resource}/frontend/css/style.css" rel="stylesheet">
</head>

<body>
    <!-- Topbar Start -->
    <div class="container-fluid">
        <div class="row bg-secondary py-2 px-xl-5">
            <div class="col-lg-6 d-none d-lg-block">
                <div class="d-inline-flex align-items-center">
                    <a class="text-dark" href="">FAQs</a>
                    <span class="text-muted px-2">|</span>
                    <a class="text-dark" href="">Help</a>
                    <span class="text-muted px-2">|</span>
                    <a class="text-dark" href="">Support</a>
                </div>
            </div>
            <div class="col-lg-6 text-center text-lg-right">
                <div class="d-inline-flex align-items-center">
                    <a class="text-dark px-2" href="">
                        <i class="fab fa-facebook-f"></i>
                    </a>
                    <a class="text-dark px-2" href="">
                        <i class="fab fa-twitter"></i>
                    </a>
                    <a class="text-dark px-2" href="">
                        <i class="fab fa-linkedin-in"></i>
                    </a>
                    <a class="text-dark px-2" href="">
                        <i class="fab fa-instagram"></i>
                    </a>
                    <a class="text-dark pl-2" href="">
                        <i class="fab fa-youtube"></i>
                    </a>
                </div>
            </div>
        </div>
        <div class="row align-items-center py-3 px-xl-5">
            <div class="col-lg-3 d-none d-lg-block">
                <a href="" class="text-decoration-none">
                    <h1 class="m-0 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border px-3 mr-1">Sneaker</span>Shop</h1>
                </a>
            </div>
            <div class="col-lg-6 col-6 text-left">
                <form action="">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Search for products">
                        <div class="input-group-append">
                            <span class="input-group-text bg-transparent text-primary">
                                <i class="fa fa-search"></i>
                            </span>
                        </div>
                    </div>
                </form>
            </div>
            <div class="col-lg-3 col-6 text-right">
                <a href="" class="btn border">
                    <i class="fas fa-heart text-primary"></i>
                    <span class="badge">0</span>
                </a>
                <a href="" class="btn border">
                    <i class="fas fa-shopping-cart text-primary"></i>
                    <span class="badge" id="totalCartProducts">${totalCartProducts}</span>
                </a>
            </div>
        </div>
    </div>
    <!-- Topbar End -->


    <!-- Navbar Start -->
    <div class="container-fluid">
        <div class="row border-top px-xl-5">
            <div class="col-lg-3 d-none d-lg-block">
                <a class="btn shadow-none d-flex align-items-center justify-content-between bg-primary text-white w-100" data-toggle="collapse" href="#navbar-vertical" style="height: 65px; margin-top: -1px; padding: 0 30px;">
                    <h6 class="m-0">Categories</h6>
                    <i class="fa fa-angle-down text-dark"></i>
                </a>
                <nav class="collapse position-absolute navbar navbar-vertical navbar-light align-items-start p-0 border border-top-0 border-bottom-0 bg-light" id="navbar-vertical" style="width: calc(100% - 30px); z-index: 1;">
                    <div class="navbar-nav w-100 overflow-hidden" style="height: 410px">
                        <div class="nav-item dropdown">
                            <c:forEach var="category" items="${categories}">
                        		<a href="" class="nav-item nav-link">${category.name}</a>
                        	</c:forEach>
                    </div>
                </nav>
            </div>
            <div class="col-lg-9">
                <nav class="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0">
                    <a href="${resource}/index" class="text-decoration-none d-block d-lg-none">
                        <h1 class="m-0 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border px-3 mr-1">Sneaker</span>Shop</h1>
                    </a>
                    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                        <div class="navbar-nav mr-auto py-0">
                            <a href="${resource}/index" class="nav-item nav-link">Home</a>
                            <a href="${resource}/shop" class="nav-item nav-link active">Shop</a>
                            <a href="${resource}/contact" class="nav-item nav-link">Contact</a>
                        </div>
                        <div class="navbar-nav ml-auto py-0">
                            <a href="" class="nav-item nav-link">Đăng nhập</a>
                            <a href="" class="nav-item nav-link">Đăng ký</a>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
    </div>
    <!-- Navbar End -->


    <!-- Page Header Start -->
    <div class="container-fluid bg-secondary mb-5">
        <div class="d-flex flex-column align-items-center justify-content-center" style="min-height: 300px">
            <h1 class="font-weight-semi-bold text-uppercase mb-3">Shopping Cart</h1>
            <div class="d-inline-flex">
                <p class="m-0"><a href="">Home</a></p>
                <p class="m-0 px-2">-</p>
                <p class="m-0">Shopping Cart</p>
            </div>
        </div>
    </div>
    <!-- Page Header End -->


    <!-- Cart Start -->
    <c:choose>
	<c:when test="${totalCartProducts > 0}">
	<form method="get">
    <div class="container-fluid pt-5">
    <h3 align="center" class="page-title text-truncate text-dark font-weight-medium mb-1">
			<span id="placeOrderSuccess"> Your cart: ${message }</span>
			</h3>
        <div class="row">
            <div class="col-lg-8 table-responsive mb-5" style="margin: auto;">
                <table class="table table-bordered text-center mb-0">
                    <thead class="bg-secondary text-dark">
                        <tr>
                            <th scope="col" class="text-center">No.</th>
							<th scope="col" class="text-center">Image</th>
                            <th scope="col" class="text-center">Product</th>
                            <th scope="col" class="text-center">Size</th>
                            <th scope="col" class="text-center">Quantity</th>
							<th scope="col" class="text-center">Price</th>
							<th scope="col" class="text-center">Total</th>
							<th scope="col" class="text-center">Actions</th>
                        </tr>
                    </thead>
                    <tbody class="align-middle">
                    <c:forEach var="cartProduct" items="${cart.cartProducts }" varStatus="loop">
                        <tr>
                        	<th scope="row">${loop.index + 1 }</th>
                            <td class="align-middle"><img src="${classpath}/UploadFiles/${cartProduct.avatar}" alt="" style="width: 50px;"></td>
                            <td>${cartProduct.name }</td>
                            <td>${cartProduct.size }</td>
                            <td align="center">
							<button type="button" onclick="updateProductQuantity(${cartProduct.id }, -1)" value="-">-</button> 
							<strong><span id="productQuantity_${cartProduct.id }">${cartProduct.quantity }</span></strong>
							<button type="button" onclick="updateProductQuantity(${cartProduct.id }, 1)" value="+">+</button>
							</td>
                            <td class="align-middle"><span>$</span><fmt:formatNumber value="${cartProduct.price}" minFractionDigits="0" /></td>
                            <td class="align-middle">
                            <span>$</span>
                            <span id = "totalPrice_${cartProduct.id }">
							<fmt:formatNumber value="${cartProduct.price * cartProduct.quantity }" minFractionDigits="0"/>
							</span>
                            </td>
                            <td class="align-middle">
                            <a href="${classpath }/product-detail/${cartProduct.id }" role="button" class="btn btn-secondary">Edit</a>
                            <a href="${classpath }/product-cart-delete/${cartProduct.id }" role="button" class="btn btn-secondary">Delete</a>
                            </td>
                        </tr>
                       </c:forEach>
                    </tbody>
                </table>
            </div>
            </div>
            <div class="row">
            <div class="col-lg-4">
                <div class="card border-secondary mb-5">
                    <div class="card-footer border-secondary bg-transparent">
                        <div class="d-flex justify-content-between mt-2">
                            <h5 class="font-weight-bold">Total</h5>
                            <h5 class="font-weight-bold">
                            <span>$</span>
                            <strong><span id="totalCartPriceId">
                            <fmt:formatNumber value="${totalCartPrice}" minFractionDigits="0"></fmt:formatNumber>
							</span></strong>
                            </h5>
                        </div>
                    </div>
                </div>
            </div>
            </div>
    </div>
    </form>
    				<div class="page-breadcrumb" style="margin:auto;">
								<div class="row"></div>
								<div class="row">
									<div class="main__products-title">
										<h1 style="margin-left: 200px">Thông tin khách hàng</h1>
									</div>
								</div>
								<form action="${classpath }/cart-view" method="get">
									<div class="row">

										<div class="col-12">
											<div class="card">
												<div class="card-body">
													<div class="form-body">
														<div class="row">

															<div class="col-md-12">
																<div class="form-group mb-4">
																	<label for="name">Customer name (*)</label> <input
																		type="text" class="form-control" id="txtName"
																		name="txtName" placeholder="your name"
																		value="${loginedUser.name }" />
																</div>
															</div>
														</div>

														<div class="row">

															<div class="col-md-12">
																<div class="form-group mb-4">
																	<label for="mobile">Customer mobile (*)</label> <input
																		type="text" class="form-control" id="txtMobile"
																		name="txtMobile" placeholder="your phone number"
																		value="${loginedUser.mobile }" />
																</div>
															</div>
														</div>

														<div class="row">

															<div class="col-md-12">
																<div class="form-group mb-4">
																	<label for="phone">Customer email</label> <input
																		type="email" class="form-control" id="txtEmail"
																		name="txtEmail" placeholder="your email"
																		value="${loginedUser.email }" />
																</div>
															</div>
														</div>

														<div class="row">

															<div class="col-md-12">
																<div class="form-group mb-4">
																	<label for="phone">Customer address</label> <input
																		type="text" class="form-control" id="txtAddress"
																		name="txtAddress" placeholder="your address"
																		value="${loginedUser.address }" />
																</div>
															</div>
														</div>
														<div class="row">
															<div class="col-md-12">
																<div class="form-group mb-4">
																	<a href="${classpath }/index"
																		class="btn btn-primary active" role="button"
																		aria-pressed="true"> Back to shop </a>
																	<button class="btn btn-primary" onclick="_placeOrder()">
																	Place orders</button>

																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>

									</div>
								</form>
							</div>
    </c:when>
    </c:choose>
    <!-- Cart End -->


    <!-- Footer Start -->
    <div class="container-fluid bg-secondary text-dark mt-5 pt-5">
        <div class="row px-xl-5 pt-5">
            <div class="col-lg-4 col-md-12 mb-5 pr-3 pr-xl-5">
                <a href="${resource}/index" class="text-decoration-none">
                    <h1 class="mb-4 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border border-white px-3 mr-1">Sneaker</span>Shop</h1>
                </a>
                <p>Khám phá thế giới giày đầy sắc màu và phong cách tại Sneaker Shop! Từ giày thời trang đến giày thể thao, chúng tôi có tất cả những gì bạn cần để hoàn thiện phong cách của mình.</p>
                <p class="mb-2"><i class="fa fa-map-marker-alt text-primary mr-3"></i>Chương Mỹ,Hà Nội</p>
                <p class="mb-2"><i class="fa fa-envelope text-primary mr-3"></i>thinha4k54cma@gmail.com</p>
                <p class="mb-0"><i class="fa fa-phone-alt text-primary mr-3"></i>+84 984 955 623</p>
            </div>
            <div class="col-lg-8 col-md-12">
                <div class="row">
                    <div class="col-md-4 mb-5">
                        <h5 class="font-weight-bold text-dark mb-4">Quick Links</h5>
                        <div class="d-flex flex-column justify-content-start">
                            <a class="text-dark mb-2" href="${resource}/index"><i class="fa fa-angle-right mr-2"></i>Home</a>
                            <a class="text-dark mb-2" href="${resource}/shop"><i class="fa fa-angle-right mr-2"></i>Our Shop</a>
                            <a class="text-dark mb-2" href="detail.html"><i class="fa fa-angle-right mr-2"></i>Shop Detail</a>
                            <a class="text-dark mb-2" href="cart.html"><i class="fa fa-angle-right mr-2"></i>Shopping Cart</a>
                            <a class="text-dark mb-2" href="checkout.html"><i class="fa fa-angle-right mr-2"></i>Checkout</a>
                            <a class="text-dark" href="contact.html"><i class="fa fa-angle-right mr-2"></i>Contact Us</a>
                        </div>
                    </div>
                    <div class="col-md-4 mb-5">
                        <h5 class="font-weight-bold text-dark mb-4">Quick Links</h5>
                        <div class="d-flex flex-column justify-content-start">
                            <a class="text-dark mb-2" href="index.html"><i class="fa fa-angle-right mr-2"></i>Home</a>
                            <a class="text-dark mb-2" href="shop.html"><i class="fa fa-angle-right mr-2"></i>Our Shop</a>
                            <a class="text-dark mb-2" href="detail.html"><i class="fa fa-angle-right mr-2"></i>Shop Detail</a>
                            <a class="text-dark mb-2" href="cart.html"><i class="fa fa-angle-right mr-2"></i>Shopping Cart</a>
                            <a class="text-dark mb-2" href="checkout.html"><i class="fa fa-angle-right mr-2"></i>Checkout</a>
                            <a class="text-dark" href="contact.html"><i class="fa fa-angle-right mr-2"></i>Contact Us</a>
                        </div>
                    </div>
                    <div class="col-md-4 mb-5">
                        <h5 class="font-weight-bold text-dark mb-4">Newsletter</h5>
                        <form action="">
                            <div class="form-group">
                                <input type="text" class="form-control border-0 py-4" placeholder="Your Name" required="required" />
                            </div>
                            <div class="form-group">
                                <input type="email" class="form-control border-0 py-4" placeholder="Your Email"
                                    required="required" />
                            </div>
                            <div>
                                <button class="btn btn-primary btn-block border-0 py-3" type="submit">Subscribe Now</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="row border-top border-light mx-xl-5 py-4">
            <div class="col-md-6 px-xl-0">
                <p class="mb-md-0 text-center text-md-left text-dark">
                    &copy; <a class="text-dark font-weight-semi-bold" href="#">sneakershop.com</a>. All Rights Reserved. 
					
					<!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
					Designed by <a class="text-dark font-weight-semi-bold" href="https://htmlcodex.com">HTML Codex</a>
                </p>
            </div>
            <div class="col-md-6 px-xl-0 text-center text-md-right">
                <img class="img-fluid" src="img/payments.png" alt="">
            </div>
        </div>
    </div>
    <!-- Footer End -->


    <!-- Back to Top -->
    <a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>


    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>

    <!-- Contact Javascript File -->
    <script src="mail/jqBootstrapValidation.min.js"></script>
    <script src="mail/contact.js"></script>

    <!-- Template Javascript -->
    <script src="js/main.js"></script>
    <script type="text/javascript">
		updateProductQuantity = function(_productId, _quantity) {
			let data = {
				id : _productId, //lay theo id
				quantity : _quantity
			};

			//$ === jQuery
			jQuery.ajax({
				url : "/update-product-quantity",
				type : "POST",
				contentType : "application/json",
				data : JSON.stringify(data),
				dataType : "json", //Kieu du lieu tra ve tu controller la json

				success : function(jsonResult) {
					let totalProducts = jsonResult.totalCartProducts; 
					//Viet lai so luong sau khi bam nut -, +
					$("#productQuantity_" + jsonResult.productId).html(jsonResult.newQuantity); 
					$("#totalCartPriceId").html(jsonResult.totalCartPrice); 
					$("#totalPrice_" + jsonResult.productId).html(jsonResult.totalPrice);
					$("#totalCartProducts").html(jsonResult.totalCartProducts);
				},

				error : function(jqXhr, textStatus, errorMessage) {
					alert("An error occur");
				}
			});
		}
	</script>

	<script type="text/javascript">
		function _placeOrder() {
			//javascript object
			let data = {				
				name : jQuery("#txtName").val(),
				email : jQuery("#txtEmail").val(), //Get by Id
				mobile : jQuery("#txtMobile").val(),
				address : jQuery("#txtAddress").val(),
			};
			
			//$ === jQuery
			jQuery.ajax({
				url : "/place-order",
				type : "POST",
				contentType: "application/json",
				data : JSON.stringify(data),
				dataType : "json", //Kieu du lieu tra ve tu controller la json
				
				success : function(jsonResult) {
					alert(jsonResult.code + ": " + jsonResult.message);
					//$("#placeOrderSuccess").html(jsonResult.message);
				},
				
				error : function(jqXhr, textStatus, errorMessage) {
					alert("An error occur");
				}
			});
		}
	</script>
</body>

</html>