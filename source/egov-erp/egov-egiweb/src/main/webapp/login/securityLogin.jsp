<!DOCTYPE html>
<%
	String ipAddress= request.getRemoteAddr();
%>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<meta name="description" content="Neon Admin Panel" />
		<meta name="author" content="" />
		
		<title>eGov Urban Portal</title>
		<link rel="stylesheet" href="/egi/resources/global/css/bootstrap/bootstrap.css">
		<link rel="stylesheet" href="/egi/resources/global/css/font-icons/entypo/css/entypo.css">
		<link rel="stylesheet" href="/egi/resources/global/css/egov/custom.css">
		<link rel="stylesheet" href="/egi/resources/global/css/egov/header-custom.css">
		<script src="/egi/resources/global/js/jquery/jquery.js"></script>
		<!-- <c:url value='/resources/global/css/bootstrap/bootstrap.css' context='/egi'/>
		<c:url value='/resources/global/css/font-icons/entypo/css/entypo.css' context='/egi'/>
		<c:url value='/resources/global/css/egov/custom.css' context='/egi'/>
		<c:url value='/resources/global/css/egov/header-custom.css' context='/egi'/>
		<c:url value='/resources/global/js/jquery/jquery.js' context='/egi'/>
 -->
		
		
		<!--[if lt IE 9]><script src="resources/js/ie8-responsive-file-warning.js"></script><![endif]-->
		
		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
			<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
			<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
		<![endif]-->
		
		
	</head>
	<body class="page-body">
		
		<div class="page-container">
			
			<header class="navbar navbar-fixed-top"><!-- set fixed position by adding class "navbar-fixed-top" -->
				
				<nav class="navbar navbar-default navbar-custom navbar-fixed-top">
					<div class="container-fluid">
						<div class="navbar-header col-md-10 col-xs-10">
							<a class="navbar-brand" href="javascript:void(0);">
								<img src="/egi/resources/global/images/chennai_logo.jpg" height="60">
								<div>
									
									<span class="title2">Chennai Municipal Corporation</span>
								</div>
							</a>
						</div>
						
						<div class="nav-right-menu col-md-2 col-xs-2">
							<ul class="hr-menu text-right">
								<li class="ico-menu">
									<a href="javascript:void(0);">
										<img src="/egi/resources/global/images/logo@2x.png" title="Powered by eGovernments" height="20px">
									</a>
								</li>
								
							</ul>
						</div>
						
					</div>
				</nav>
				
			</header>
			
			<div class="main-content login-page">
				<div class="login-container ">
					<div class="login-content login-content-margin signup-section">
						<div class="login-header">
							<a href="signin.html" class="logo">
								<img src="/egi/resources/global/images/egov_logo_tr_h.png" alt="" height="37"/>
							</a>
						</div>
						<div class="login-toggle">
							<div class="row"> 
								<div class="col-md-12 col-xs-12">
									<div class="col-md-6 col-xs-6 sign-in sign sign-active arrow_box_left" data-sign="in">
										Sign In
									</div>
									<div class="col-md-6 col-xs-6 sign-up sign sign-notactive" data-sign="up">
										Sign Up
									</div>
								</div>
							</div>
						</div>
						<div class="login-body">
							<form method="post" role="form" id="signupform" class="display-hide">
								
								<div class="form-group">
									
									<div class="input-group">
										<div class="input-group-addon style-label">
											<i class="entypo-mobile theme-color style-color"></i>
										</div>
										
										<input type="text" class="form-control style-form" name="mobno" id="mobno" placeholder="Mobile number" autocomplete="off" />
										<span class="mandatory set-mandatory"></span>
									</div>
									<div class="text-right add-margin error-msg">Mobile number already exists</div>
								</div>
								
								<div class="form-group">
									<div class="row">
										<div class="col-md-6">
											<div class="input-group">
												<div class="input-group-addon style-label">
													<i class="entypo-key theme-color style-color"></i>
												</div>
												
												<input type="password" class="form-control style-form check-password" name="password" id="password" placeholder="Password" autocomplete="off" />
												<span class="mandatory set-mandatory"></span>
											</div>
										</div>
										<div class="col-md-6 margin-sm-top">
											<div class="input-group">
												<div class="input-group-addon style-label">
													<i class="entypo-key theme-color style-color"></i>
												</div>
												
												<input type="password" class="form-control style-form check-password" name="con-password" id="con-password" placeholder="Confirm password" autocomplete="off" />
												<span class="mandatory set-mandatory"></span>
											</div>
										</div>
										
									</div>
									<div class="text-right add-margin error-msg display-hide password-error">These passwords don't match. Try again?</div>
								</div>
								
								<div class="add-margin overflow-section">
								</div>
								
								<div class="form-group">
									
									<div class="input-group">
										<div class="input-group-addon style-label">
											<i class="entypo-user theme-color style-color"></i>
										</div>
										
										<input type="text" class="form-control style-form" name="name" id="name" placeholder="Full name" autocomplete="off" />
										<span class="mandatory set-mandatory"></span>
									</div>
									
								</div>
								
								<div class="form-group">
									
									<div class="input-group">
										<div class="input-group-addon style-label">
											<i class="entypo-mail theme-color style-color"></i>
										</div>
										
										<input type="text" class="form-control style-form" name="email" id="email" placeholder="Email" autocomplete="off" />
									</div>
									<div class="text-right add-margin error-msg">Email already exists</div>
								</div>
								
								<div class="form-group text-left">
									
									<div class="checkbox">
										<label>
											<input type="checkbox">Accept the 
											<span><a href="javascript:void(0);" data-toggle="modal" data-target="#myModal" data-backdrop="static">Terms Of Use</a></span>
										</label>
									</div>
									
								</div>
								
								<div class="form-group">
									<button type="submit" class="btn btn-primary btn-block btn-login">
										<i class="entypo-login"></i>
										Sign Up
									</button>
								</div>
								
							</form>
							<form method="post" role="form" id="signinform" action="${pageContext.request.contextPath}/j_security_check" autocomplete="off">
							<input type="hidden" id="ipAddress" name="ipAddress" value="<%=ipAddress%>"/>
							<input type="hidden" id="loginType" name="loginType" />
								<div class="form-group">
									
									<div class="input-group">
										<div class="input-group-addon style-label">
											<i class="entypo-user theme-color style-color"></i>
										</div>
										
										<input type="text" class="form-control style-form" name="j_username" id="j_username" placeholder="Username or Mobile number" autocomplete="off" required="required"/>
					<span class="mandatory set-mandatory"></span>
									</div>
									
								</div>
								<div class="form-group">
									
									<div class="input-group">
										<div class="input-group-addon style-label">
											<i class="entypo-key theme-color style-color"></i>
										</div>
										
										<input type="password" class="form-control style-form" name="j_password" id="j_password" placeholder="Password" autocomplete="off" required="required" />
								<span class="mandatory set-mandatory"></span>
									</div>
									
								</div>
								<div class="form-group">
									<button type="submit" class="btn btn-primary btn-block btn-login">
										<i class="entypo-login"></i>
										Sign In
									</button>
								</div>
								
								<div class="form-group">
									<div class="row">
										<div class="col-md-12 col-xs-12 text-right">
											<a href="recoverpassword.html">Forgot Password?</a>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
					
					<div class="login-content login-content-margin otp-section display-hide">
						<div class="login-header">
							<a href="signin.html" class="logo">
								<img src="/egi/resources/global/images/logo@2x.png" alt="" />
							</a>
							<h4 class="header-description">OTP Activation</h4>
						</div>
						<div class="login-body">
							<div class="">
								<div class="form-group text-left">
									Registration Successful. Enter your 5 digit activation code sent to your registered email or mobile to activate your account here.
								</div>
								<div class="form-group">
									<div class="input-group">
										<div class="input-group-addon">
											<i class="entypo-key theme-color"></i>
										</div>
										
										<input type="password" class="form-control " name="otp-check" id="otp-check" placeholder="Activation Code" autocomplete="off" />
									</div>
								</div>
								<div class="form-group text-right">
									<a href="homepagecitizen.html" class="btn btn-primary btn-login">
										Activate
									</a>
								</div>
								<div class="form-group text-left">
									Registration will get automatically deleted if you do not activate account within next 48 hours.
								</div>
							</div>
						</div>
					</div>
					
				</div>
				
				<footer class="main">
					
					Powered by <a href="http://eGovernments.org" target="_blank">eGovernments Foundation</a>
					
				</footer> 
				
			</div>
			
			
			
			
		</div>
		
		<!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="myModalLabel">Terms & Conditions</h4>
					</div>
					<div class="modal-body">
						<p>This website is designed, developed and maintained by eGovernments Foundation under the supervision of Corporation of Chennai, Government of Tamilnadu, India.</p>
						
						<p>Though all efforts have been made to ensure the accuracy and currency of the content on this website, the same should not be construed as a statement of law or used for any legal purposes. Incase of any ambiguity or doubts, users are advised to verify/check with the Department(s) and/or other source(s), and to obtain appropriate professional advice.</p>
						
						<p>Under no circumstances will this Department be liable for any expense, loss or damage including, without limitation, indirect or consequential loss or damage, or any expense, loss or damage whatsoever arising from use, or loss of use, of data, arising out of or in connection with the use of this website. These terms and conditions shall be governed by and construed in accordance with the Indian Laws. Any dispute arising under these terms and conditions shall be subject to the jurisdiction of the courts of India.</p>
						
						<p>The information posted on this website could include hypertext links or pointers to information created and maintained by non-Government/private organisations. Corporation of Chennai is providing these links and pointers solely for your information and convenience. When you select a link to an outside website, you are leaving the Corporation of Chennai website and are subject to the privacy and security policies of the owners/sponsors of the outside website. Corporation of Chennai, does not guarantee the availability of such linked pages at all times.</p>
						
						<p>Corporation of Chennai, cannot authorise the use of copyrighted materials contained in linked websites. Users are advised to request such authorisation from the owner of the linked website. Corporation of Chennai, does not guarantee that linked websites comply with Indian Government Web Guidelines.</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
		<link rel="stylesheet" href="/egi/resources/global/css/bootstrap/bootstrap-datepicker.css">
		
		<script src="/egi/resources/global/js/bootstrap/bootstrap.js"></script>
		
		<script src="/egi/resources/global/js/jquery/plugins/jquery.inputmask.bundle.min.js"></script>
		<script src="/egi/resources/global/js/bootstrap/bootstrap-datepicker.js"></script>
		<script src="/egi/resources/global/js/egov/custom.js"></script>
		<script src="/egi/resources/js/app/signin.js"></script>
		<!-- <c:url value='/resources/global/css/bootstrap/bootstrap-datepicker.css' context='/egi'/>
		<c:url value='/resources/global/js/bootstrap/bootstrap.js' context='/egi'/>
		<c:url value='/resources/global/js/jquery/plugins/jquery.inputmask.bundle.min.js' context='/egi'/>
		<c:url value='/resources/global/js/bootstrap/bootstrap-datepicker.js' context='/egi'/>
		<c:url value='/resources/global/js/egov/custom.js' context='/egi'/>
		<c:url value='/resources/global/../js/app/signin.js' context='/egi'/> -->
	</body>
</html>																																																							
