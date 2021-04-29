<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
                    </div> -->
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
                    </div> -->
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
				<div class="row">
					<div class="col-xl-12">
						<div class="hero-cap text-center">
							<h2>Member List</h2>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--================Cart Area =================-->
	<section class="cart_area section_padding">
		<div class="container">
			<div class="cart_inner">
				<div class="table-responsive">
					<table class="table">
						<thead>
							<tr>
								<th scope="col">memberId</th>
								<th scope="col">userName</th>
								<th scope="col">password</th>
								<th scope="col">answer</th>
							</tr>
						</thead>
						<tbody>
							<tr>

							</tr>
							<tr>

							</tr>
							
							
						</tbody>
					</table>
					<div class="checkout_btn_inner float-right">
						<a class="btn_1" href="#">Update Member</a> <a
							class="btn_1 checkout_btn_1" href="#">Delete Member</a>
							<a
							class="btn_1 checkout_btn_1" href="${url }superManager">Manage Manager</a>
					</div>
				</div>
			</div>
	</section>
	<!--================End Cart Area =================--> </main>
	>
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

	<!-- Scrollup, nice-select, sticky -->
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