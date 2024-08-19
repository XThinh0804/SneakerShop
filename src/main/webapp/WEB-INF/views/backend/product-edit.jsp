<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- directive của JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html dir="ltr" lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="keywords"
	content="wrappixel, admin dashboard, html css dashboard, web dashboard, bootstrap 4 admin, bootstrap 4, css3 dashboard, bootstrap 4 dashboard, severny admin bootstrap 4 dashboard, frontend, responsive bootstrap 4 admin template, pixel  design, pixel  dashboard bootstrap 4 dashboard template" />
<meta name="description"
	content="Pixel Admin is powerful and clean admin dashboard template, inpired from Bootstrap Framework" />
<meta name="robots" content="noindex,nofollow" />
<title>Sneaker Shop</title>
<link rel="canonical"
	href="https://www.wrappixel.com/templates/pixel-admin-lite/" />
<!-- Favicon icon -->
<link rel="icon" type="image/png" sizes="16x16"
	href="https://i.pinimg.com/236x/56/d9/0d/56d90d66b6ed70bcd57cf711012338ec.jpg" />
<!-- Bootstrap Core CSS -->
<link href="${resource}/backend/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<!-- Menu CSS -->
<link
	href="${resource}/backend/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.css"
	rel="stylesheet" />
<!-- animation CSS -->
<link href="${resource}/backend/css/animate.css" rel="stylesheet" />
<!-- Custom CSS -->
<link href="${resource}/backend/css/style.css" rel="stylesheet" />
<!-- color CSS -->
<link href="${resource}/backend/css/colors/blue-dark.css" id="theme"
	rel="stylesheet" />
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
	<!-- Preloader -->
	<div class="preloader">
		<div class="cssload-speeding-wheel"></div>
	</div>
	<div id="wrapper">
		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top m-b-0">
			<div class="navbar-header">
				<a class="navbar-toggle hidden-sm hidden-md hidden-lg"
					href="javascript:void(0)" data-toggle="collapse"
					data-target=".navbar-collapse"><i
					class="fa fa-bars"></i></a>
				<div class="top-left-part">
					<a class="logo" href="${resource }/admin/home/view"><b><img
							src="${resource}/backend/plugins/images/pixeladmin-logo.png"
							alt="home" /></b><span class="hidden-xs"><img
							src="${resource}/backend/plugins/images/pixeladmin-text.png"
							alt="home" /></span></a>
				</div>
				<ul class="nav navbar-top-links navbar-left m-l-20 hidden-xs">
					<li>
						<form role="search" class="app-search hidden-xs">
							<input type="text" placeholder="Search..." class="form-control" />
							<a href=""><i class="fa fa-search"></i></a>
						</form>
					</li>
				</ul>
				<ul class="nav navbar-top-links navbar-right pull-right">
					<li><a class="profile-pic" href="#"> <img
							src="${resource}/backend/plugins/images/users/varun.jpg"
							alt="user-img" width="36" class="img-circle" /><b
							class="hidden-xs">Admin</b>
					</a></li>
				</ul>
			</div>
			<!-- /.navbar-header -->
			<!-- /.navbar-top-links -->
			<!-- /.navbar-static-side -->
		</nav>
		<!-- Left navbar-header -->
		<div class="navbar-default sidebar" role="navigation">
			<div class="sidebar-nav navbar-collapse slimscrollsidebar">
				<ul class="nav" id="side-menu">
					<li style="padding: 10px 0 0"><a
						href="${resource }/admin/home/view" class="waves-effect"><i
							class="fa fa-clock-o fa-fw" aria-hidden="true"></i><span
							class="hide-menu">Dashboard</span></a></li>
					<li><a href="${resource }/admin/home/profile" class="waves-effect"><i
							class="fa fa-user fa-fw" aria-hidden="true"></i><span
							class="hide-menu">Profile</span></a></li>
					<li><a href="${resource }/admin/category/list"
						class="waves-effect" aria-expanded="false"><i
							class="fa fa-table fa-fw" aria-hidden="true"></i><span
							class="hide-menu">Category</span></a></li>
					<li><a href="${resource }/admin/product/list"
						class="waves-effect" aria-expanded="false"><i
							class="fa fa-table fa-fw" aria-hidden="true"></i><span
							class="hide-menu">Product</span></a></li>
					<li><a href="${resource }/admin/attribute/list"
						class="waves-effect" aria-expanded="false"> <i
							class="fa fa-table fa-fw" aria-hidden="true"></i> <span
							class="hide-menu">Attribute</span></a></li>
					<li><a href="${resource }/admin/user/list"
						class="waves-effect" aria-expanded="false"><i
							class="fa fa-table fa-fw" aria-hidden="true"></i><span
							class="hide-menu">Users</span></a></li>
					<li><a href="${resource }/admin/role/list"
						class="waves-effect" aria-expanded="false"><i
							class="fa fa-table fa-fw" aria-hidden="true"></i><span
							class="hide-menu">Roles</span></a></li>
					<li><a href="${resource }/admin/order/list"
						class="waves-effect" aria-expanded="false"><i
							class="fa fa-table fa-fw" aria-hidden="true"></i><span
							class="hide-menu">Orders</span></a></li>
					<li><a href="${resource }/admin/contact/list"
						class="waves-effect" aria-expanded="false"><i
							class="fa fa-table fa-fw" aria-hidden="true"></i><span
							class="hide-menu">Customer contact</span></a></li>
					<li><a href="fontawesome.html" class="waves-effect"><i
							class="fa fa-font fa-fw" aria-hidden="true"></i><span
							class="hide-menu">Icons</span></a></li>
					<li><a href="map-google.html" class="waves-effect"><i
							class="fa fa-globe fa-fw" aria-hidden="true"></i><span
							class="hide-menu">Google Map</span></a></li>
					<li><a href="blank.html" class="waves-effect"><i
							class="fa fa-columns fa-fw" aria-hidden="true"></i><span
							class="hide-menu">Blank Page</span></a></li>
				</ul>

			</div>
		</div>
		<!-- Left navbar-header end -->
		<!-- Page Content -->
		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row bg-title">
					<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
						<h4 class="page-title">Category</h4>
					</div>
					<div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
						<ol class="breadcrumb">
							<li><a href="#">Dashboard</a></li>
							<li class="active">Category</li>
						</ol>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<div class="row">
					<div class="col-12">
						<div class="card">
							<div class="card-body">
								<sf:form class="form"
									action="${resource }/admin/product/edit-save" method="post"
									modelAttribute="product" enctype="multipart/form-data">

									<div class="form-body">

										<sf:hidden path="id" />
										<!-- id > 0 -> Edit -->

										<div class="row">
											<div class="col-md-6">
												<div class="form-group mb-4">
													<label for="category">Select category</label>
													<sf:select path="category.id" class="form-control"
														id="category">
														<sf:options items="${categories }" itemValue="id"
															itemLabel="name"></sf:options>
													</sf:select>
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group mb-4">
													<label for="name">Product name</label>
													<sf:input path="name" type="text" class="form-control"
														id="name" name="name" placeholder="product name"></sf:input>
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-4">
												<div class="form-group mb-4">
													<label for="brand">Brand</label>
													<sf:input path="brand" type="text" class="form-control"
														id="brand" name="brand" placeholder="product brand"></sf:input>
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group mb-4">
													<label for="price">Price</label>
													<sf:input path="price" type="number" autocomplete="off"
														id="price" name="price" class="form-control"
														placeholder="price"></sf:input>
												</div>
											</div>

											<div class="col-md-4">
												<div class="form-group mb-4">
													<label for="salePrice">Sale price</label>
													<sf:input path="salePrice" type="number" autocomplete="off"
														id="salePrice" name="salePrice" class="form-control"
														placeholder="Sale price"></sf:input>
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-6">
												<div class="form-group mb-4">
													<label for="create">Create by</label>
													<sf:select path="userCreateProduct.id" class="form-control"
														id="createBy">
														<sf:options items="${users }" itemValue="id"
															itemLabel="username"></sf:options>
													</sf:select>
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group mb-4">
													<label for="update">Update by</label>
													<sf:select path="userUpdateProduct.id" class="form-control"
														id="updateBy">
														<sf:options items="${users }" itemValue="id"
															itemLabel="username"></sf:options>
													</sf:select>
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-6">
												<div class="form-group mb-4">
													<label for="createdate">Create date</label>

													<sf:input path="createDate" class="form-control"
														type="date" id="createDate" name="createDate"></sf:input>
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group mb-4">
													<label for="updatedate">Update date</label>

													<sf:input path="updateDate" class="form-control"
														type="date" id="updateDate" name="updateDate"></sf:input>
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-12">
												<div class="form-group mb-4">
													<label for="description">Description</label>
													<sf:textarea path="shortDescription" id="shortDescription"
														name="shortDescription" class="form-control" rows="3"
														placeholder="Short desription..."></sf:textarea>
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-12">
												<div class="form-group mb-4">
													<label for="detailDescription">Detail description</label>
													<sf:textarea path="detailDescription"
														id="detailDescription" name="detailDescription"
														class="form-control" rows="3"
														placeholder="detail desription..."></sf:textarea>
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-2">
												<div class="form-group mb-4">
													<label for="isHot">&nbsp;&nbsp;&nbsp;&nbsp;</label>
													<sf:checkbox path="isHot" class="form-check-input"
														id="isHot" name="isHot"></sf:checkbox>
													<label for="isHot">Is a hot product?</label>

												</div>
											</div>

											<div class="col-md-10">
												<div class="form-group mb-4">
													<label for="isHot">&nbsp;&nbsp;&nbsp;&nbsp;</label>
													<sf:checkbox path="status" class="form-check-input"
														id="status" name="status"></sf:checkbox>
													<label for="status">Active</label>

												</div>
											</div>

										</div>

										<div class="row">
											<div class="col-md-12">
												<div class="form-group mb-4">
													<label for="avatarFile">Choose product Avatar</label> <input
														id="avatarFile" name="avatarFile" type="file"
														class="form-control-file" multiple="multiple">
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-12">
												<div class="form-group mb-4">
													<label for="image">Choose product Image</label> <input
														id="imageFiles" name="imageFiles" type="file"
														class="form-control-file" multiple="multiple">
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-12">
												<div class="form-group mb-4">
													<label for="image">Choose product Image</label> <input
														id="imageFiles" name="imageFiles" type="file"
														class="form-control-file" multiple="multiple">
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-12">
												<div class="form-group mb-4">
													<label for="image">Choose product Image</label> <input
														id="imageFiles" name="imageFiles" type="file"
														class="form-control-file" multiple="multiple">
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-12">
												<div class="form-group mb-4">
													<label for="image">Choose product Image</label> <input
														id="imageFiles" name="imageFiles" type="file"
														class="form-control-file" multiple="multiple">
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-12">
												<div class="form-group mb-4">
													<a href="${resource }/admin/product/list"
														class="btn btn-secondary active" role="button"
														aria-pressed="true"
														style="background-color: #516673; color: #fff;"> Back
														to list </a>
													<button type="submit" class="btn btn-primary"
														style="background-color: #85b4d0;">Save edit
														product</button>
												</div>
											</div>
										</div>

									</div>
								</sf:form>
							</div>
						</div>
					</div>

				</div>
				<!-- /.row -->
			</div>
			<!-- /.container-fluid -->
			<footer class="footer text-center">
				2020 &copy; Pixel Admin brought to you by <a
					href="https://www.wrappixel.com/">wrappixel.com</a>
			</footer>
		</div>
		<!-- /#page-wrapper -->
	</div>
	<!-- /#wrapper -->
	<!-- jQuery -->
	<script
		src="${resource}/backend/plugins/bower_components/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="${resource}/backend/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- Menu Plugin JavaScript -->
	<script
		src="${resource}/backend/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.js"></script>
	<!--slimscroll JavaScript -->
	<script src="${resource}/backend/js/jquery.slimscroll.js"></script>
	<!--Wave Effects -->
	<script src="${resource}/backend/js/waves.js"></script>
	<!-- Custom Theme JavaScript -->
	<script src="${resource}/backend/js/custom.min.js"></script>
</body>
</html>
