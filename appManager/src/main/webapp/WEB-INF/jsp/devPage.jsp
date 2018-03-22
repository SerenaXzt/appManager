<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href=" <%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Bootstrap -->
<link
	href="statics/gentelella-master/vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link
	href="statics/gentelella-master/vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<!-- NProgress -->
<link href="statics/gentelella-master/vendors/nprogress/nprogress.css"
	rel="stylesheet">
<!-- Animate.css -->
<link href="https://colorlib.com/polygon/gentelella/css/animate.min.css"
	rel="stylesheet">

<!-- Custom Theme Style -->
<link href="statics/gentelella-master/build/css/custom.min.css"
	rel="stylesheet">
</head>
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<div class="col-md-3 left_col">
				<div class="left_col scroll-view">
					<div class="navbar nav_title" style="border: 0;">
						<a href="index.html" class="site_title"><i class="fa fa-paw"></i>
							<span>App Manager</span></a>
					</div>

					<div class="clearfix"></div>

					<!-- menu profile quick info -->
					<div class="profile">
						<div class="profile_pic">
							<img src="statics/images/img.jpg" alt="..."
								class="img-circle profile_img">
						</div>
						<div class="profile_info">
							<span>Welcome,</span>
							<h2>${sessionScope.userSession.devcode }</h2>
						</div>
					</div>
					<!-- /menu profile quick info -->

					<br />

					<!-- sidebar menu -->
					<div id="sidebar-menu"
						class="main_menu_side hidden-print main_menu">
						<div class="menu_section">
							<h3>${sessionScope.userSession.devname }</h3>
							<ul class="nav side-menu">
								<li><a><i class="fa fa-home"></i>App账户管理<span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="index.html">Dashboard</a></li>
										<li><a href="index2.html">Dashboard2</a></li>
										<li><a href="index3.html">Dashboard3</a></li>
									</ul></li>
								<li><a><i class="fa fa-edit"></i>App应用管理<span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="appsInfo">App维护</a></li>
									</ul></li>
						</div>
						<div class="menu_section">



							<ul class="nav child_menu">
								<li><a href="page_403.html">403 Error</a></li>
								<li><a href="page_404.html">404 Error</a></li>
								<li><a href="page_500.html">500 Error</a></li>
								<li><a href="plain_page.html">Plain Page</a></li>
								<li><a href="login.html">Login Page</a></li>
								<li><a href="pricing_tables.html">Pricing Tables</a></li>
							</ul>
							</li>

							<ul class="nav child_menu">
								<li><a href="#level1_1">Level One</a>
								<li><a>Level One<span class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li class="sub_menu"><a href="level2.html">Level Two</a>
										</li>
										<li><a href="#level2_1">Level Two</a></li>
										<li><a href="#level2_2">Level Two</a></li>
									</ul></li>
								<li><a href="#level1_2">Level One</a></li>
							</ul>
							</li>

							</ul>
						</div>

					</div>
					<!-- /sidebar menu -->

					<!-- /menu footer buttons -->
					<div class="sidebar-footer hidden-small">
						<a data-toggle="tooltip" data-placement="top" title="Settings">
							<span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
						</a> <a data-toggle="tooltip" data-placement="top" title="FullScreen">
							<span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
						</a> <a data-toggle="tooltip" data-placement="top" title="Lock"> <span
							class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
						</a> <a data-toggle="tooltip" data-placement="top" title="Logout">
							<span class="glyphicon glyphicon-off" aria-hidden="true"></span>
						</a>
					</div>
					<!-- /menu footer buttons -->
				</div>
			</div>

			<!-- top navigation -->
			<div class="top_nav">
				<div class="nav_menu">
					<nav>
					<div class="nav toggle">
						<a id="menu_toggle"><i class="fa fa-bars"></i></a>
					</div>

					<ul class="nav navbar-nav navbar-right">
						<li class=""><a href="javascript:;"
							class="user-profile dropdown-toggle" data-toggle="dropdown"
							aria-expanded="false"> <img src="statics/images/img.jpg" alt="">${sessionScope.userSession.devname }<span 
							class=" fa fa-angle-down"></span>
						</a>
							<ul class="dropdown-menu dropdown-usermenu pull-right">
								<li><a href="login.html"><i
										class="fa fa-sign-out pull-right"></i> Log Out</a></li>
							</ul></li>

					</ul>
					</nav>
				</div>
			</div>
			<!-- /top navigation -->

			<!-- page content -->
			<div class="right_col" role="main">
				<!-- top tiles -->
				<!-- /top tiles -->



      </div>
    </div>
     
				<div class="row">

					<!-- Start to do list -->

				</div>

			</div>
			<!-- end of weather widget -->

			<!-- /page content -->

			<!-- footer content -->
			<footer>
			<div class="pull-right">
				Gentelella - Bootstrap Admin Template by <a
					href="https://colorlib.com">Colorlib</a>
			</div>
			<div class="clearfix"></div>
			</footer>
			<!-- /footer content -->
		</div>
	</div>

	<!-- jQuery -->
	<script src="statics/gentelella-master/vendors/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="statics/gentelella-master/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- FastClick -->
	<script src="statics/gentelella-master/vendors/fastclick/lib/fastclick.js"></script>
	<!-- NProgress -->
	<script src="statics/gentelella-master/vendors/nprogress/nprogress.js"></script>
	<!-- Chart.js -->
	<script src="statics/gentelella-master/vendors/Chart.js/dist/Chart.min.js"></script>
	<!-- gauge.js -->
	<script src="statics/gentelella-master/vendors/gauge.js/dist/gauge.min.js"></script>
	<!-- bootstrap-progressbar -->
	<script
		src="statics/gentelella-master/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
	<!-- iCheck -->
	<script src="statics/gentelella-master/vendors/iCheck/icheck.min.js"></script>
	<!-- Skycons -->
	<script src="statics/gentelella-master/vendors/skycons/skycons.js"></script>
	<!-- Flot -->
	<script src="statics/gentelella-master/vendors/Flot/jquery.flot.js"></script>
	<script src="statics/gentelella-master/vendors/Flot/jquery.flot.pie.js"></script>
	<script src="statics/gentelella-master/vendors/Flot/jquery.flot.time.js"></script>
	<script src="statics/gentelella-master/vendors/Flot/jquery.flot.stack.js"></script>
	<script src="statics/gentelella-master/vendors/Flot/jquery.flot.resize.js"></script>
	<!-- Flot plugins -->
	<script src="statics/gentelella-master/vendors/flot.orderbars/js/jquery.flot.orderBars.js"></script>
	<script src="statics/gentelella-master/vendors/flot-spline/js/jquery.flot.spline.min.js"></script>
	<script src="statics/gentelella-master/vendors/flot.curvedlines/curvedLines.js"></script>
	<!-- DateJS -->
	<script src="statics/gentelella-master/vendors/DateJS/build/date.js"></script>
	<!-- JQVMap -->
	<script src="statics/gentelella-master/vendors/jqvmap/dist/jquery.vmap.js"></script>
	<script src="statics/gentelella-master/vendors/jqvmap/dist/maps/jquery.vmap.world.js"></script>
	<script src="statics/gentelella-master/vendors/jqvmap/examples/js/jquery.vmap.sampledata.js"></script>
	<!-- bootstrap-daterangepicker -->
	<script src="js/moment/moment.min.js"></script>
	<script src="js/datepicker/daterangepicker.js"></script>

	<!-- Custom Theme Scripts -->
	<script src="statics/gentelella-master/build/js/custom.min.js"></script>
</body>
</html>