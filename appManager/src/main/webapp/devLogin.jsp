<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath(); 
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%> 
<!DOCTYPE html>
<html lang="en">
  <head>
  <base href=" <%=basePath%>">
  <script type="text/javascript" src="statics/jquery/jquery-1.12.4.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Gentellela Alela! | </title>

    <!-- Bootstrap -->
    <link href="statics/gentelella-master/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="statics/gentelella-master/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="statics/gentelella-master/vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- Animate.css -->
    <link href="https://colorlib.com/polygon/gentelella/css/animate.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="statics/gentelella-master/build/css/custom.min.css" rel="stylesheet">
  </head>

   <body class="login">
    <div>
      <a class="hiddenanchor" id="signup"></a>
      <a class="hiddenanchor" id="signin"></a>

      <div class="login_wrapper">
        <div class="animate form login_form">
          <section class="login_content">
            <form id="logIn" action="${pageContext.request.contextPath }/devLogin" method="post">
              <h1>开发者登录</h1>
              <div>
                <input type="text" name="userCode" class="form-control" placeholder="Username" required="" />
              </div>
              <div>
                <input type="password" name="userPassword" class="form-control" placeholder="Password" required="" />
              </div>
              <span style="color:red">${requestScope.error }</span>
               <div class="form-group">
			      <button type="submit" class="btn btn-primary" id="devlogin">登录</button>
			      <button type="reset" class="btn btn-danger">重置</button>
			  </div>
            </form>
          </section>
        </div>
      </div>
    </div>
  </body>
</html>