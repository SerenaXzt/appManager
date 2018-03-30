<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<!-- Bootstrap -->
<link href="statics/gentelella-master/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Font Awesome -->
<link href="statics/gentelella-master/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<!-- NProgress -->
<link href="statics/gentelella-master/vendors/nprogress/nprogress.css" rel="stylesheet">
<!-- iCheck -->
<link href="statics/gentelella-master/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
<!-- bootstrap-wysiwyg -->
<link href="statics/gentelella-master/vendors/google-code-prettify/bin/prettify.min.css" rel="stylesheet">
<!-- Select2 -->
<link href="statics/gentelella-master/vendors/select2/dist/css/select2.min.css" rel="stylesheet">
<!-- Switchery -->
<link href="statics/gentelella-master/vendors/switchery/dist/switchery.min.css" rel="stylesheet">
<!-- starrr -->
<link href="statics/gentelella-master/vendors/starrr/dist/starrr.css" rel="stylesheet">

<!-- Custom Theme Style -->
<link href="statics/gentelella-master/build/css/custom.min.css" rel="stylesheet">
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
							<h2>${sessionScope.userSession.usercode }</h2>
						</div>
					</div>
					<!-- /menu profile quick info -->

					<br />

					<!-- sidebar menu -->
					<div id="sidebar-menu"
						class="main_menu_side hidden-print main_menu">
						<div class="menu_section">
							<h3>${sessionScope.userSession.username }</h3>
							<ul class="nav side-menu">
								<li><a><i class="fa fa-home"></i>App管理<span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="appsInfo">App审核</a></li>
									</ul></li>
								<li><a><i class="fa fa-edit"></i>用户管理<span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a id="userManager" href="${pageContext.request.contextPath }/userManager">用户管理</a></li>
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
							aria-expanded="false"> <img src="statics/images/img.jpg" alt="">${sessionScope.userSession.username }<span 
							class=" fa fa-angle-down"></span>
						</a>
							<ul class="dropdown-menu dropdown-usermenu pull-right">
								<li><a id="logOut" href="#"><i
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
				
			<!-- =============top=========================== -->