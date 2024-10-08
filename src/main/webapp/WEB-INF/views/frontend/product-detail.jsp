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
<link rel="icon" type="image/png" sizes="16x16"
	href="https://i.pinimg.com/236x/56/d9/0d/56d90d66b6ed70bcd57cf711012338ec.jpg" />
<!-- Favicon -->
<link href="${resource}/frontend/img/favicon.ico" rel="icon">

<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap"
	rel="stylesheet">

<!-- Font Awesome -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet">

<!-- Libraries Stylesheet -->
<link
	href="${resource}/frontend/lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet">

<!-- Customized Bootstrap Stylesheet -->
<link href="${resource}/frontend/css/style.css" rel="stylesheet">
</head>

<body>
	<!-- Topbar Start -->
	<div class="container-fluid">
		<div class="row bg-secondary py-2 px-xl-5">
			<div class="col-lg-6 d-none d-lg-block">
				<div class="d-inline-flex align-items-center">
					<a class="text-dark" href="">FAQs</a> <span class="text-muted px-2">|</span>
					<a class="text-dark" href="">Help</a> <span class="text-muted px-2">|</span>
					<a class="text-dark" href="">Support</a>
				</div>
			</div>
			<div class="col-lg-6 text-center text-lg-right">
				<div class="d-inline-flex align-items-center">
					<a class="text-dark px-2" href=""> <i class="fab fa-facebook-f"></i>
					</a> <a class="text-dark px-2" href=""> <i class="fab fa-twitter"></i>
					</a> <a class="text-dark px-2" href=""> <i
						class="fab fa-linkedin-in"></i>
					</a> <a class="text-dark px-2" href=""> <i class="fab fa-instagram"></i>
					</a> <a class="text-dark pl-2" href=""> <i class="fab fa-youtube"></i>
					</a>
				</div>
			</div>
		</div>
		<div class="row align-items-center py-3 px-xl-5">
			<div class="col-lg-3 d-none d-lg-block">
				<a href="" class="text-decoration-none">
					<h1 class="m-0 display-5 font-weight-semi-bold">
						<span class="text-primary font-weight-bold border px-3 mr-1">Sneaker</span>Shop
					</h1>
				</a>
			</div>
			<div class="col-lg-6 col-6 text-left">
				<form action="">
					<div class="input-group">
						<input type="text" class="form-control"
							placeholder="Search for products">
						<div class="input-group-append">
							<span class="input-group-text bg-transparent text-primary">
								<i class="fa fa-search"></i>
							</span>
						</div>
					</div>
				</form>
			</div>
			<div class="col-lg-3 col-6 text-right">
				<a href="" class="btn border"> <i
					class="fas fa-heart text-primary"></i> <span class="badge">0</span>
				</a> <a href="${resource}/cart-view" class="btn border"> <i
					class="fas fa-shopping-cart text-primary"></i> <span class="badge"
					id="totalCartProducts">${totalCartProducts}</span>
				</a>
			</div>
		</div>
	</div>
	<!-- Topbar End -->


	<!-- Navbar Start -->
	<div class="container-fluid">
		<div class="row border-top px-xl-5">
			<div class="col-lg-3 d-none d-lg-block">
				<a
					class="btn shadow-none d-flex align-items-center justify-content-between bg-primary text-white w-100"
					data-toggle="collapse" href="#navbar-vertical"
					style="height: 65px; margin-top: -1px; padding: 0 30px;">
					<h6 class="m-0">Categories</h6> <i
					class="fa fa-angle-down text-dark"></i>
				</a>
				<nav
					class="collapse position-absolute navbar navbar-vertical navbar-light align-items-start p-0 border border-top-0 border-bottom-0 bg-light"
					id="navbar-vertical" style="width: calc(100% - 30px); z-index: 1;">
					<div class="navbar-nav w-100 overflow-hidden" style="height: 410px">
						<div class="nav-item dropdown">
							<c:forEach var="category" items="${categories}">
								<a href="" class="nav-item nav-link">${category.name}</a>
							</c:forEach>
						</div>
				</nav>
			</div>
			<div class="col-lg-9">
				<nav
					class="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0">
					<a href="${resource}/index"
						class="text-decoration-none d-block d-lg-none">
						<h1 class="m-0 display-5 font-weight-semi-bold">
							<span class="text-primary font-weight-bold border px-3 mr-1">Sneaker</span>Shop
						</h1>
					</a>
					<button type="button" class="navbar-toggler" data-toggle="collapse"
						data-target="#navbarCollapse">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse justify-content-between"
						id="navbarCollapse">
						<div class="navbar-nav mr-auto py-0">
							<a href="${resource}/index" class="nav-item nav-link">Home</a> <a
								href="${resource}/shop" class="nav-item nav-link">Shop</a> <a
								href="${resource}/contact" class="nav-item nav-link">Contact</a>
						</div>
						<div class="navbar-nav ml-auto py-0">
							<a href="" class="nav-item nav-link">Đăng nhập</a> <a href=""
								class="nav-item nav-link">Đăng ký</a>
						</div>
					</div>
				</nav>
			</div>
		</div>
	</div>
	<!-- Navbar End -->


	<!-- Page Header Start -->
	<div class="container-fluid bg-secondary mb-5">
		<div
			class="d-flex flex-column align-items-center justify-content-center"
			style="min-height: 300px">
			<h1 class="font-weight-semi-bold text-uppercase mb-3">CHI TIẾT
				SẢN PHẨM</h1>
			<div class="d-inline-flex">
				<p class="m-0">
					<a href="${resource}/index">Home</a>
				</p>
			</div>
		</div>
	</div>
	<!-- Page Header End -->


	<!-- Shop Detail Start -->
	<div class="container-fluid py-5">
		<form class="form-inline" action="${resource}/product-detail"
			method="POST">
			<div class="row px-xl-5">
				<div class="col-lg-5 pb-5">
					<div id="product-carousel" class="carousel slide"
						data-ride="carousel">
						<div class="carousel-inner border">
							<div class="carousel-item active">
								<img class="w-100 h-100"
									src="${classpath}/UploadFiles/${product.avatar}" alt="Image">
							</div>
							<c:forEach items="${productImages}" var="productImage">
								<div class="carousel-item">
									<img class="w-100 h-100"
										src="${classpath}/UploadFiles/${productImage.path}"
										alt="Image">
								</div>
							</c:forEach>
						</div>
						<a class="carousel-control-prev" href="#product-carousel"
							data-slide="prev"> <i
							class="fa fa-2x fa-angle-left text-dark"></i>
						</a> <a class="carousel-control-next" href="#product-carousel"
							data-slide="next"> <i
							class="fa fa-2x fa-angle-right text-dark"></i>
						</a>
					</div>
				</div>

				<div class="col-lg-7 pb-5">
					<h3 class="font-weight-semi-bold">${product.name}</h3>
					<p class="mb-4">${product.brand}</p>
					<div class="d-flex mb-3">
						<div class="text-primary mr-2">
							<small class="fas fa-star"></small> <small class="fas fa-star"></small>
							<small class="fas fa-star"></small> <small
								class="fas fa-star-half-alt"></small> <small class="far fa-star"></small>
						</div>
						<small class="pt-1">(50 Reviews)</small>
					</div>
					<h3 class="font-weight-semi-bold mb-4">$ ${product.price}</h3>
					<p class="mb-4">${product.shortDescription}</p>
					<div class="d-flex mb-3">
						<p class="text-dark font-weight-medium mb-0 mr-3">Sizes:</p>
						<form>
							<c:forEach var="attribute" items="${attributes}">
								<div class="custom-control custom-radio custom-control-inline">
									<input type="radio" class="custom-control-input"
										id="${attribute.id}" name="size" value="${attribute.size}">
									<label class="custom-control-label" for="${attribute.id}">${attribute.size}</label>
								</div>
							</c:forEach>
						</form>
					</div>
					<div class="d-flex align-items-center mb-4 pt-2">
						<div class="input-group quantity mr-3" style="width: 130px;">
							<div class="quantity__plus mb-10">
								<input style="width: 140px; height: 33px;" type="number"
									name="quantity" id="quantity" value="1">
							</div>
						</div>
						<button class="btn btn-primary px-3" type="button"
							onclick="addToCart(${product.id }, '${product.name }')">
							<i class="fa fa-shopping-cart mr-1"></i> Add To Cart
						</button>
					</div>
					<div class="d-flex pt-2">
						<p class="text-dark font-weight-medium mb-0 mr-2">Share on:</p>
						<div class="d-inline-flex">
							<a class="text-dark px-2" href=""> <i
								class="fab fa-facebook-f"></i>
							</a> <a class="text-dark px-2" href=""> <i class="fab fa-twitter"></i>
							</a> <a class="text-dark px-2" href=""> <i
								class="fab fa-linkedin-in"></i>
							</a> <a class="text-dark px-2" href=""> <i
								class="fab fa-pinterest"></i>
							</a>
						</div>
					</div>
				</div>
			</div>
		</form>
		<div class="row px-xl-5">
			<div class="col">
				<div
					class="nav nav-tabs justify-content-center border-secondary mb-4">
					<a class="nav-item nav-link active" data-toggle="tab"
						href="#tab-pane-1">Description</a> <a class="nav-item nav-link"
						data-toggle="tab" href="#tab-pane-2">Information</a> <a
						class="nav-item nav-link" data-toggle="tab" href="#tab-pane-3">Reviews
						(0)</a>
				</div>
				<div class="tab-content">
					<div class="tab-pane fade show active" id="tab-pane-1">
						<h4 class="mb-3">Product Description</h4>
						<p>Eos no lorem eirmod diam diam, eos elitr et gubergren diam
							sea. Consetetur vero aliquyam invidunt duo dolores et duo sit.
							Vero diam ea vero et dolore rebum, dolor rebum eirmod consetetur
							invidunt sed sed et, lorem duo et eos elitr, sadipscing kasd
							ipsum rebum diam. Dolore diam stet rebum sed tempor kasd eirmod.
							Takimata kasd ipsum accusam sadipscing, eos dolores sit no ut
							diam consetetur duo justo est, sit sanctus diam tempor aliquyam
							eirmod nonumy rebum dolor accusam, ipsum kasd eos consetetur at
							sit rebum, diam kasd invidunt tempor lorem, ipsum lorem elitr
							sanctus eirmod takimata dolor ea invidunt.</p>
						<p>Dolore magna est eirmod sanctus dolor, amet diam et eirmod
							et ipsum. Amet dolore tempor consetetur sed lorem dolor sit lorem
							tempor. Gubergren amet amet labore sadipscing clita clita diam
							clita. Sea amet et sed ipsum lorem elitr et, amet et labore
							voluptua sit rebum. Ea erat sed et diam takimata sed justo. Magna
							takimata justo et amet magna et.</p>
					</div>
					<div class="tab-pane fade" id="tab-pane-2">
						<h4 class="mb-3">Additional Information</h4>
						<p>Eos no lorem eirmod diam diam, eos elitr et gubergren diam
							sea. Consetetur vero aliquyam invidunt duo dolores et duo sit.
							Vero diam ea vero et dolore rebum, dolor rebum eirmod consetetur
							invidunt sed sed et, lorem duo et eos elitr, sadipscing kasd
							ipsum rebum diam. Dolore diam stet rebum sed tempor kasd eirmod.
							Takimata kasd ipsum accusam sadipscing, eos dolores sit no ut
							diam consetetur duo justo est, sit sanctus diam tempor aliquyam
							eirmod nonumy rebum dolor accusam, ipsum kasd eos consetetur at
							sit rebum, diam kasd invidunt tempor lorem, ipsum lorem elitr
							sanctus eirmod takimata dolor ea invidunt.</p>
						<div class="row">
							<div class="col-md-6">
								<ul class="list-group list-group-flush">
									<li class="list-group-item px-0">Sit erat duo lorem duo ea
										consetetur, et eirmod takimata.</li>
									<li class="list-group-item px-0">Amet kasd gubergren sit
										sanctus et lorem eos sadipscing at.</li>
									<li class="list-group-item px-0">Duo amet accusam eirmod
										nonumy stet et et stet eirmod.</li>
									<li class="list-group-item px-0">Takimata ea clita labore
										amet ipsum erat justo voluptua. Nonumy.</li>
								</ul>
							</div>
							<div class="col-md-6">
								<ul class="list-group list-group-flush">
									<li class="list-group-item px-0">Sit erat duo lorem duo ea
										consetetur, et eirmod takimata.</li>
									<li class="list-group-item px-0">Amet kasd gubergren sit
										sanctus et lorem eos sadipscing at.</li>
									<li class="list-group-item px-0">Duo amet accusam eirmod
										nonumy stet et et stet eirmod.</li>
									<li class="list-group-item px-0">Takimata ea clita labore
										amet ipsum erat justo voluptua. Nonumy.</li>
								</ul>
							</div>
						</div>
					</div>
					<div class="tab-pane fade" id="tab-pane-3">
						<div class="row">
							<div class="col-md-6">
								<h4 class="mb-4">1 review for "Colorful Stylish Shirt"</h4>
								<div class="media mb-4">
									<img src="img/user.jpg" alt="Image" class="img-fluid mr-3 mt-1"
										style="width: 45px;">
									<div class="media-body">
										<h6>
											John Doe<small> - <i>01 Jan 2045</i></small>
										</h6>
										<div class="text-primary mb-2">
											<i class="fas fa-star"></i> <i class="fas fa-star"></i> <i
												class="fas fa-star"></i> <i class="fas fa-star-half-alt"></i>
											<i class="far fa-star"></i>
										</div>
										<p>Diam amet duo labore stet elitr ea clita ipsum, tempor
											labore accusam ipsum et no at. Kasd diam tempor rebum magna
											dolores sed sed eirmod ipsum.</p>
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<h4 class="mb-4">Leave a review</h4>
								<small>Your email address will not be published.
									Required fields are marked *</small>
								<div class="d-flex my-3">
									<p class="mb-0 mr-2">Your Rating * :</p>
									<div class="text-primary">
										<i class="far fa-star"></i> <i class="far fa-star"></i> <i
											class="far fa-star"></i> <i class="far fa-star"></i> <i
											class="far fa-star"></i>
									</div>
								</div>
								<form>
									<div class="form-group">
										<label for="message">Your Review *</label>
										<textarea id="message" cols="30" rows="5" class="form-control"></textarea>
									</div>
									<div class="form-group">
										<label for="name">Your Name *</label> <input type="text"
											class="form-control" id="name">
									</div>
									<div class="form-group">
										<label for="email">Your Email *</label> <input type="email"
											class="form-control" id="email">
									</div>
									<div class="form-group mb-0">
										<input type="submit" value="Leave Your Review"
											class="btn btn-primary px-3">
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Shop Detail End -->

	<!-- Footer Start -->
	<div class="container-fluid bg-secondary text-dark mt-5 pt-5">
		<div class="row px-xl-5 pt-5">
			<div class="col-lg-4 col-md-12 mb-5 pr-3 pr-xl-5">
				<a href="${resource}/index" class="text-decoration-none">
					<h1 class="mb-4 display-5 font-weight-semi-bold">
						<span
							class="text-primary font-weight-bold border border-white px-3 mr-1">Sneaker</span>Shop
					</h1>
				</a>
				<p>Khám phá thế giới giày đầy sắc màu và phong cách tại Sneaker
					Shop! Từ giày thời trang đến giày thể thao, chúng tôi có tất cả
					những gì bạn cần để hoàn thiện phong cách của mình.</p>
				<p class="mb-2">
					<i class="fa fa-map-marker-alt text-primary mr-3"></i>Chương Mỹ,Hà
					Nội
				</p>
				<p class="mb-2">
					<i class="fa fa-envelope text-primary mr-3"></i>thinha4k54cma@gmail.com
				</p>
				<p class="mb-0">
					<i class="fa fa-phone-alt text-primary mr-3"></i>+84 984 955 623
				</p>
			</div>
			<div class="col-lg-8 col-md-12">
				<div class="row">
					<div class="col-md-4 mb-5">
						<h5 class="font-weight-bold text-dark mb-4">Quick Links</h5>
						<div class="d-flex flex-column justify-content-start">
							<a class="text-dark mb-2" href="index.html"><i
								class="fa fa-angle-right mr-2"></i>Home</a> <a
								class="text-dark mb-2" href="shop.html"><i
								class="fa fa-angle-right mr-2"></i>Our Shop</a> <a
								class="text-dark mb-2" href="detail.html"><i
								class="fa fa-angle-right mr-2"></i>Shop Detail</a> <a
								class="text-dark mb-2" href="cart.html"><i
								class="fa fa-angle-right mr-2"></i>Shopping Cart</a> <a
								class="text-dark mb-2" href="checkout.html"><i
								class="fa fa-angle-right mr-2"></i>Checkout</a> <a class="text-dark"
								href="contact.html"><i class="fa fa-angle-right mr-2"></i>Contact
								Us</a>
						</div>
					</div>
					<div class="col-md-4 mb-5">
						<h5 class="font-weight-bold text-dark mb-4">Quick Links</h5>
						<div class="d-flex flex-column justify-content-start">
							<a class="text-dark mb-2" href="index.html"><i
								class="fa fa-angle-right mr-2"></i>Home</a> <a
								class="text-dark mb-2" href="shop.html"><i
								class="fa fa-angle-right mr-2"></i>Our Shop</a> <a
								class="text-dark mb-2" href="detail.html"><i
								class="fa fa-angle-right mr-2"></i>Shop Detail</a> <a
								class="text-dark mb-2" href="cart.html"><i
								class="fa fa-angle-right mr-2"></i>Shopping Cart</a> <a
								class="text-dark mb-2" href="checkout.html"><i
								class="fa fa-angle-right mr-2"></i>Checkout</a> <a class="text-dark"
								href="contact.html"><i class="fa fa-angle-right mr-2"></i>Contact
								Us</a>
						</div>
					</div>
					<div class="col-md-4 mb-5">
						<h5 class="font-weight-bold text-dark mb-4">Newsletter</h5>
						<form action="">
							<div class="form-group">
								<input type="text" class="form-control border-0 py-4"
									placeholder="Your Name" required="required" />
							</div>
							<div class="form-group">
								<input type="email" class="form-control border-0 py-4"
									placeholder="Your Email" required="required" />
							</div>
							<div>
								<button class="btn btn-primary btn-block border-0 py-3"
									type="submit">Subscribe Now</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="row border-top border-light mx-xl-5 py-4">
			<div class="col-md-6 px-xl-0">
				<p class="mb-md-0 text-center text-md-left text-dark">
					&copy; <a class="text-dark font-weight-semi-bold" href="#">sneakershop.com</a>.
					All Rights Reserved.

					<!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
					Designed by <a class="text-dark font-weight-semi-bold"
						href="https://htmlcodex.com">HTML Codex</a>
				</p>
			</div>
			<div class="col-md-6 px-xl-0 text-center text-md-right">
				<img class="img-fluid" src="img/payments.png" alt="">
			</div>
		</div>
	</div>
	<!-- Footer End -->


	<!-- Back to Top -->
	<a href="#" class="btn btn-primary back-to-top"><i
		class="fa fa-angle-double-up"></i></a>


	<!-- JavaScript Libraries -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
	<script src="lib/easing/easing.min.js"></script>
	<script src="lib/owlcarousel/owl.carousel.min.js"></script>

	<!-- Contact Javascript File -->
	<script src="mail/jqBootstrapValidation.min.js"></script>
	<script src="mail/contact.js"></script>

	<!-- Template Javascript -->
	<script src="js/main.js"></script>
	<!-- Add to cart -->
	<script type="text/javascript">
	function getSelectedRadioValue() {
	    const radios = document.querySelectorAll('input[name="size"]');
	    let selectedValue = '';
	    radios.forEach((radio) => {
	        if (radio.checked) {
	            selectedValue = radio.value;
	        }
	    });
	    return selectedValue;
	}
	const selectedValue = getSelectedRadioValue();
		addToCart = function(_productId, _productName) {		
			//alert("Thêm "  + _quantity + " sản phẩm '" + _productName + "' vào giỏ hàng ");
			let data = {
				id: _productId, //lay theo id
				name: _productName,
				quantity: jQuery("#quantity").val(),
				size: selectedValue
			};
				
			//$ === jQuery
			jQuery.ajax({
				url : "/add-to-cart",
				type : "POST",
				contentType: "application/json",
				data : JSON.stringify(data),
				dataType : "json", //Kieu du lieu tra ve tu controller la json
				
				success : function(jsonResult) {
					alert(jsonResult.code + ": " + jsonResult.message);
					let totalProducts = jsonResult.totalCartProducts;
					$("#totalCartProducts").html(totalProducts);
				},
				
				error : function(jqXhr, textStatus, errorMessage) {
					alert(jsonResult.code + ': Đã có lỗi xay ra...!')
				},
			});
		}
	</script>
</body>

</html>