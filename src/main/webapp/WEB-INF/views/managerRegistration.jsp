<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	response.setHeader("Expires", "0"); // Proxies.
%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<c:url value="/" var="url" />
<!doctype html>
<html lang="zxx">
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Watch shop | eCommers</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="manifest" href="site.webmanifest">
<link rel="shortcut icon" type="image/x-icon"
	href="${path}/resources/assets/img/favicon.ico">

<!-- CSS here -->
<link rel="stylesheet"
	href="${path}/resources/assets/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${path}/resources/assets/css/owl.carousel.min.css">
<link rel="stylesheet" href="${path}/resources/assets/css/flaticon.css">
<link rel="stylesheet" href="${path}/resources/assets/css/slicknav.css">
<link rel="stylesheet"
	href="${path}/resources/assets/css/animate.min.css">
<link rel="stylesheet"
	href="${path}/resources/assets/css/magnific-popup.css">
<link rel="stylesheet"
	href="${path}/resources/assets/css/fontawesome-all.min.css">
<link rel="stylesheet"
	href="${path}/resources/assets/css/themify-icons.css">
<link rel="stylesheet" href="${path}/resources/assets/css/slick.css">
<link rel="stylesheet"
	href="${path}/resources/assets/css/nice-select.css">
<link rel="stylesheet" href="${path}/resources/assets/css/style.css">

<c:if test="${!empty msg }">
	<script type="text/javascript">
		alert("${msg}");
	</script>
</c:if>

<script type="text/javascript">
	function checkform() {
		if (document.frm.memberId.value == "" ) {
			document.frm.memberId.focus();
			alert("아이디를 입력해주세요");
			return false;
		}
		else if(document.frm.userName.value == "" ) {
			document.frm.userName.focus();
			alert("이름을 입력해주세요");
			return false;
		}
		else if (document.frm.pw.value == "" ) {
			document.frm.pw.focus();
			alert("비밀번호를 입력해주세요");
			return false;
		}
		else if (document.frm.answer.value == "" ) {
			document.frm.answer.focus();
			alert("답변을 입력해주세요");
			return false;
		}
	}
</script>
</head>
<body>
	<header>
		<!-- Header Start -->
		<div class="header-area">
			<div class="main-header header-sticky">
				<div class="container-fluid">
					<div class="menu-wrapper">
						<!-- Logo 
                        <div class="logo">
                            <a href="index.html"><img src="${path}/resources/assets/img/logo/logo.png" alt=""></a>
                        </div>-->
						<!-- Main-menu 
                        <div class="main-menu d-none d-lg-block">
                            <nav>                                                
                                <ul id="navigation">  
                                    <li><a href="index.html">Home</a></li>
                                    <li><a href="shop.html">shop</a></li>
                                    <li><a href="about.html">about</a></li>
                                    <li class="hot"><a href="#">Latest</a>
                                        <ul class="submenu">
                                            <li><a href="shop.html"> Product list</a></li>
                                            <li><a href="product_details.html"> Product Details</a></li>
                                        </ul>
                                    </li>
                                    <li><a href="blog.html">Blog</a>
                                        <ul class="submenu">
                                            <li><a href="blog.html">Blog</a></li>
                                            <li><a href="blog-details.html">Blog Details</a></li>
                                        </ul>
                                    </li>
                                    <li><a href="#">Pages</a>
                                        <ul class="submenu">
                                            <li><a href="login.html">Login</a></li>
                                            <li><a href="cart.html">Cart</a></li>
                                            <li><a href="elements.html">Element</a></li>
                                            <li><a href="confirmation.html">Confirmation</a></li>
                                            <li><a href="checkout.html">Product Checkout</a></li>
                                        </ul>
                                    </li>
                                    <li><a href="contact.html">Contact</a></li>
                                </ul>
                            </nav>
                        </div>-->
						<!-- Header Right -->
						<div class="header-right">
							<ul>
								<li>
									<div class="nav-search search-switch">
										<span class="flaticon-search"></span>
									</div>
								</li>
								<li><a href="login.html"><span class="flaticon-user"></span></a></li>
								<li><a href="cart.html"><span
										class="flaticon-shopping-cart"></span></a></li>
							</ul>
						</div>
						
						<c:if test="${member }==null">
							<c:redirect url="${url }/login"></c:redirect>
						</c:if>

						<c:if test="${!empty member }">
							<div class="header-right">
									<li>${member.memberId },Hello</li>
									<li><a href="<c:url value="/logout"/>" style="color:black">[Logout]</a></li>
							</div>
						</c:if>
					</div>
					<!-- Mobile Menu -->
					<div class="col-12">
						<div class="mobile_menu d-block d-lg-none"></div>
					</div>
				</div>
			</div>
		</div>
		<!-- Header End -->
	</header>
	<main> <!-- Hero Area Start-->
	<div class="slider-area ">
		<div class="single-slider slider-height2 d-flex align-items-center">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-xl-12">
						<div class="hero-cap text-center">
							<h2>Manager Registration</h2>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Hero Area End--> <!--================registration_part Area =================-->
	<section class="login_part section_padding ">
		<div class="container">



			<div class="login_part_form">
				<div class="login_part_form_iner">
					<h3>
						<br> Please fill your info up
					</h3>
					<form class="row contact_form" action="${url }managerRegistProc"
						method="post" novalidate="novalidate" name="frm" onsubmit="return checkform()">
						<div class="col-md-12 form-group p_star">
							<input type="text" class="form-control" id="memberId"
								name="memberId" value="" placeholder="memberID">
						</div>
						<div class="col-md-12 form-group p_star">
							<input type="text" class="form-control" id="userName"
								name="userName" value="" placeholder="userName">
						</div>
						<div class="col-md-12 form-group p_star">
							<input type="password" class="form-control" id="pw" name="pw"
								value="" placeholder="pw">
						</div>
						<div class="col-md-12 form-group p_star">
							<input type="text" class="form-control" id="answer" name="answer"
								value="" placeholder="answer">
						</div>
						<div class="col-md-12 form-group">
							<button type="submit" value="submit" class="btn_3">
								Registraion</button>
							<a href="${url }superManagerProc" class="btn_3">Cancle</a> <a
								class="registraion_cancle" href="#">���</a>
						</div>
					</form>
				</div>
			</div>



		</div>
	</section>
	<!--================login_part end =================--> </main>
	<!--? Search model Begin -->
	<div class="search-model-box">
		<div class="h-100 d-flex align-items-center justify-content-center">
			<div class="search-close-btn">+</div>
			<form class="search-model-form">
				<input type="text" id="search-input"
					placeholder="Searching key.....">
			</form>
		</div>
	</div>
	<!-- Search model end -->

	<!-- JS here -->

	<script
		src="./${path}/resources/assets/js/vendor/modernizr-3.5.0.min.js"></script>
	<!-- Jquery, Popper, Bootstrap -->
	<script src="./${path}/resources/assets/js/vendor/jquery-1.12.4.min.js"></script>
	<script src="./${path}/resources/assets/js/popper.min.js"></script>
	<script src="./${path}/resources/assets/js/bootstrap.min.js"></script>
	<!-- Jquery Mobile Menu -->
	<script src="./${path}/resources/assets/js/jquery.slicknav.min.js"></script>

	<!-- Jquery Slick , Owl-Carousel Plugins -->
	<script src="./${path}/resources/assets/js/owl.carousel.min.js"></script>
	<script src="./${path}/resources/assets/js/slick.min.js"></script>

	<!-- One Page, Animated-HeadLin -->
	<script src="./${path}/resources/assets/js/wow.min.js"></script>
	<script src="./${path}/resources/assets/js/animated.headline.js"></script>

	<!-- Scroll up, nice-select, sticky -->
	<script src="./${path}/resources/assets/js/jquery.scrollUp.min.js"></script>
	<script src="./${path}/resources/assets/js/jquery.nice-select.min.js"></script>
	<script src="./${path}/resources/assets/js/jquery.sticky.js"></script>
	<script src="./${path}/resources/assets/js/jquery.magnific-popup.js"></script>

	<!-- contact js -->
	<script src="./${path}/resources/assets/js/contact.js"></script>
	<script src="./${path}/resources/assets/js/jquery.form.js"></script>
	<script src="./${path}/resources/assets/js/jquery.validate.min.js"></script>
	<script src="./${path}/resources/assets/js/mail-script.js"></script>
	<script src="./${path}/resources/assets/js/jquery.ajaxchimp.min.js"></script>

	<!-- Jquery Plugins, main Jquery -->
	<script src="./${path}/resources/assets/js/plugins.js"></script>
	<script src="./${path}/resources/assets/js/main.js"></script>

</body>

</html>