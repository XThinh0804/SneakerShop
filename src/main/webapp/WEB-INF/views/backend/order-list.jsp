<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- directive của JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<link href="${resource}/backend/css/simplePagination.css"
	rel="stylesheet" />
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
					data-target=".navbar-collapse"><i class="fa fa-bars"></i></a>
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
					<li><a href="#" class="waves-effect"><i
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
					<li><a href="404.html" class="waves-effect"><i
							class="fa fa-info-circle fa-fw" aria-hidden="true"></i><span
							class="hide-menu">Error 404</span></a></li>
				</ul>

			</div>
		</div>
		<!-- Left navbar-header end -->
		<!-- Page Content -->
		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row bg-title">
					<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
						<h4 class="page-title">Product</h4>
					</div>
					<div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
						<ol class="breadcrumb">
							<li><a href="${resource }/admin/home/view">Dashboard</a></li>
							<li class="active">Product</li>
						</ol>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /row -->
				<div class="row">
					<div class="col-12">
						<div class="card">

							<div class="card-body">
								<form action="${resource }/admin/order/list" method="get">
									<div class="row">
										<div class="col-12">
											<div class="card">
												<div class="card-body">
													<div class="table-responsive">

														<!-- Tìm kiếm -->
														<div class="row">
															<div class="col-md-2">
																<div class="form-group mb-4">
																	<select class="form-control" id="status" name="status">
																		<option value="2">Tất cả đơn hàng</option>
																		<option value="1">Đơn hàng đã giao</option>
																		<option value="0">Đơn hàng chưa giao</option>
																	</select>
																</div>
															</div>

															<div class="col-md-2">
																<input class="form-control" type="date" id="beginDate"
																	name="beginDate" />
															</div>
															<div class="col-md-2">
																<input class="form-control" type="date" id="endDate"
																	name="endDate" />
															</div>

															<div class="col-md-3">
																<input type="text" class="form-control" id="keyword"
																	name="keyword" placeholder="Search keyword" />
															</div>

															<div class="col-md-1">
																<button type="submit" id="btnSearch" name="btnSearch"
																	class="btn btn-primary">Search</button>
															</div>
															<div class="col-md-1">
																<input id="page" name="page" type="hidden"
																	class="form-control"
																	value="${saleOrderSearch.currentPage}" />
															</div>
														</div>
														<!-- Hết tìm kiếm -->

														<table id="zero_config"
															class="table table-striped table-bordered no-wrap">
															<thead>
																<tr align="center">
																	<th scope="col">No.</th>
																	<th scope="col">Code</th>
																	<th scope="col">Customer</th>
																	<th scope="col">Mobile</th>
																	<th scope="col">Address</th>
																	<th scope="col">Payment</th>
																	<th scope="col">Create by</th>
																	<!-- <th scope="col">Update by</th> -->
																	<th scope="col">Create date</th>
																	<th scope="col">Delivery date</th>
																	<th scope="col">Status</th>
																	<th scope="col">Edit</th>
																	<th scope="col">Delete</th>

																</tr>
															</thead>
															<tbody>
																<c:forEach var="saleOrder" items="${saleOrders}"
																	varStatus="loop">
																	<tr>
																		<th scope="row">${loop.index + 1 }</th>

																		<td align="center">${saleOrder.code }</td>
																		<td>${saleOrder.customer_name }</td>
																		<td align="center">${saleOrder.customer_mobile }</td>
																		<td>${saleOrder.customer_address }</td>
																		<td align="right">$<fmt:formatNumber
																				value="${saleOrder.total }" minFractionDigits="0"></fmt:formatNumber>
																		</td>
																		<td>${saleOrder.userCreateSaleOrder.username }</td>
																		<%-- <td>${saleOrder.updateBy }</td> --%>
																		<td><fmt:formatDate pattern="dd-MM-yyyy"
																				value="${saleOrder.createDate}" /></td>
																		<td><fmt:formatDate pattern="dd-MM-yyyy"
																				value="${saleOrder.updateDate}" /></td>

																		<td><c:choose>
																				<c:when test="${saleOrder.status }">
																		Đã giao hàng
																	</c:when>
																				<c:otherwise>Chưa giao hàng</c:otherwise>
																			</c:choose></td>

																		<td><a
																			href="${resource }/edit-product/${saleOrder.id }"
																			role="button" class="btn btn-primary">Edit</a>
																		<td><a
																			href="${resource }/delete-product/${saleOrder.id }"
																			role="button" class="btn btn-secondary"
																			style="background-color: red; color: #fff;">Delete</a>
																		</td>
																	</tr>
																</c:forEach>
															</tbody>
														</table>

														<div class="row">
															<div class="col-md-6">
																<div class="form-group mb-4">
																	<h3>
																		Total sales:$
																		<fmt:formatNumber value="${totalSales}"
																			minFractionDigits="0"></fmt:formatNumber>
																	</h3>
																</div>
															</div>

															<div class="col-md-6">
																<!-- Phan trang -->
																<div class="pagination float-right">
																	<div id="paging"></div>
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
						</div>
					</div>
				</div>

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
	<!-- pagination -->
	<script src="${resource}/backend/js/jquery.simplePagination.js"></script>
	<script type="text/javascript">
		$( document ).ready(function() {
			//Dat gia tri cua status ung voi dieu kien search truoc do
			$("#status").val(${saleOrderSearch.status});
			
			$("#paging").pagination({
				currentPage: ${saleOrderSearch.currentPage}, //Trang hien tai
				items: ${saleOrderSearch.totalItems}, //Tong so don hang (total sale orders)
				itemsOnPage: ${saleOrderSearch.sizeOfPage},
				cssStyle: 'light-theme',
				onPageClick: function(pageNumber, event) {
					$('#page').val(pageNumber);
					$('#btnSearch').trigger('click');
				},
			});
		});
	</script>
</body>
</html>
