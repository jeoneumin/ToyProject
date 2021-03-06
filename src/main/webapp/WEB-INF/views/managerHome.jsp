<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	response.setHeader("Expires", "0"); // Proxies.
%>
<c:if test="${empty member }">
	<c:redirect url="${url }login"/>
</c:if>
<c:set var="path" value="${pageContext.request.contextPath}" />
<%-- 내일 처음 실행시 ${path }와 같게 value를 설정하고 다시 실행해보기 --%>
<c:url var="url" value="/" />
<!-- pagingNavi에 필요한 변수 설정 -->
<c:set var="scope" value="${scope}" />
<c:set var="total" value="${total}" />
<c:set var="pageNum" value="${pageNum}" />
<c:set var="pre" value="false" />
<c:set var="next" value="false" />


<!-- 총 페이지 갯수 -->
<c:choose>
	<c:when test="${(total%scope) ne 0 }">
		<fmt:parseNumber var="lastPage" integerOnly="true"
			value="${(total/scope) + 1 }" />
	</c:when>
	<c:otherwise>
		<fmt:parseNumber var="lastPage" integerOnly="true"
			value="${total/scope }" />
	</c:otherwise>
</c:choose>

<!-- 페이지 표시 범위 설정 -->
<fmt:parseNumber var="pageNumSets" integerOnly="true"
	value="${pageNum/scope }" />
<c:if test="${pageNum%scope == 0 }">
	<fmt:parseNumber integerOnly="true" var="startNum"
		value="${pageNum-(scope-1) }" />
	<fmt:parseNumber integerOnly="true" var="endNum" value="${pageNum}" />
</c:if>
<c:if test="${pageNum%scope != 0 }">
	<fmt:parseNumber integerOnly="true" var="startNum"
		value="${(pageNumSets*scope)+1 }" />
	<fmt:parseNumber integerOnly="true" var="endNum" value="${(pageNumSets*scope)+scope }" />
</c:if>

<!-- [pre],[next] 필요 여부 -->
<c:if test="${startNum>scope }">
	<c:set var="pre" value="true" />
</c:if>

<c:if test="${endNum < lastPage }">
	<c:set var="next" value="true" />
</c:if>


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
								<li><a href="#"><span class="flaticon-user"></span></a></li>
								<li><a href="#"><span
										class="flaticon-shopping-cart"></span></a></li>
							</ul>
						</div>

						<c:if test="${member }==null">
							<c:redirect url="${url }/login"></c:redirect>
						</c:if>

						<c:if test="${!empty member }">
							<div class="header-right">
								<li>${member.memberId },Hello</li>
								<li><a href="<c:url value="/logout"/>" style="color: black">[Logout]</a></li>
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
								<th scope="col">choice</th>
								<th scope="col">memberId</th>
								<th scope="col">userName</th>
								<th scope="col">password</th>
								<th scope="col">answer</th>
								<th scope="col">manageValue</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${!empty memberList }">
								<c:set var="memberListItem" value="${memberList }" />
								<c:forEach var="item" items="${memberListItem }" begin="0"
									end="${fn:length(memberList) }" step="1" varStatus="status">
									<tr>
										<td><input type="checkbox" name="user_CheckBox"></td>
										<td>${item.memberId }</td>
										<td>${item.userName }</td>
										<td>${item.pw }</td>
										<td>${item.answer }</td>
										<td>${item.manageValue }</td>
									</tr>
								</c:forEach>
							</c:if>
							<c:if test="${empty memberList }">
								<tr>

								</tr>
								<tr>

								</tr>
							</c:if>

						</tbody>
					</table>
					<div
						style="text-align: center; margin-top: 20px; margin-bottom: 20px;">
						<c:if test="${pre eq 'true'}">
							<a href="${url }managerHomeProc?pageNum=${startNum-1}"
								style="color: black">[pre]</a>
						</c:if>
						<c:forEach var="num" begin="${startNum }" end="${endNum }"
							step="1">
							<c:if test="${num <= lastPage }">
								<c:if test="${num == pageNum }">
									<strong><a href="${url }managerHomeProc?pageNum=${num}" style="color: black">${num }</a></strong>
								</c:if>
								<c:if test="${num != pageNum }">
								<a href="${url }managerHomeProc?pageNum=${num}" style="color: black">${num }</a>
								</c:if>
							</c:if>
						</c:forEach>
						<c:if test="${next eq 'true'}">
							<a href="${url }managerHomeProc?pageNum=${endNum+1}"
								style="color: black">[next]</a>
						</c:if>
					</div>

					<div class="checkout_btn_inner float-right" id="btngroup">
						<button class="btn_1" id="updateBtn" onclick="inputChange();">Update Member</button> <button
							class="btn_1 checkout_btn_1" id="deleteBtn" onclick="sendMemberIdArr();">Delete Member</button> <button
							class="btn_1 checkout_btn_1" onclick="location.href='${url }superManagerProc';" >Manage
							Manager</button>
					</div>
					<div id="print"></div>
				 </div>
			</div>
	</section>
	<!--================End Cart Area =================--> </main>

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

	<!-- jquery CDN -->
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	
	<script
		src="${path}/resources/assets/js/vendor/modernizr-3.5.0.min.js"></script>
	<!-- Jquery, Popper, Bootstrap -->
	<script src="${path}/resources/assets/js/vendor/jquery-1.12.4.min.js"></script>
	<script src="${path}/resources/assets/js/popper.min.js"></script>
	<script src="${path}/resources/assets/js/bootstrap.min.js"></script>
	<!-- Jquery Mobile Menu -->
	<script src="${path}/resources/assets/js/jquery.slicknav.min.js"></script>

	<!-- Jquery Slick , Owl-Carousel Plugins -->
	<script src="${path}/resources/assets/js/owl.carousel.min.js"></script>
	<script src="${path}/resources/assets/js/slick.min.js"></script>

	<!-- One Page, Animated-HeadLin -->
	<script src="${path}/resources/assets/js/wow.min.js"></script>
	<script src="${path}/resources/assets/js/animated.headline.js"></script>

	<!-- Scrollup, nice-select, sticky -->
	<script src="${path}/resources/assets/js/jquery.scrollUp.min.js"></script>
	<script src="${path}/resources/assets/js/jquery.nice-select.min.js"></script>
	<script src="${path}/resources/assets/js/jquery.sticky.js"></script>
	<script src="${path}/resources/assets/js/jquery.magnific-popup.js"></script>

	<!-- contact js -->
	<script src="${path}/resources/assets/js/contact.js"></script>
	<script src="${path}/resources/assets/js/jquery.form.js"></script>
	<script src="${path}/resources/assets/js/jquery.validate.min.js"></script>
	<script src="${path}/resources/assets/js/mail-script.js"></script>
	<script src="${path}/resources/assets/js/jquery.ajaxchimp.min.js"></script>

	<!-- Jquery Plugins, main Jquery -->
	<script src="${path}/resources/assets/js/plugins.js"></script>
	<script src="${path}/resources/assets/js/main.js"></script>
	
	<!-- 사용자정의함수 -->
	<!-- <script>
	$("#updateBtn").click(function(){
		var rowData = new Array();
		var tdArr = new Array();
		var checkbox = $("input[name=user_CheckBox]:checked");
		
		checkbox.each(function(i) {
			var tr = checkbox.parent().parent().eq(i);
			var td = tr.children();
			
			rowData.push(tr.text());
			
			var no = td.eq(1).text()+", ";
			var userid = td.eq(2).text()+", ";
			var name = td.eq(3).text()+", ";
			var email = td.eq(4).text()+", ";
			
			tdArr.push(no);
			tdArr.push(userid);
			tdArr.push(name);
			tdArr.push(email);
		});
	
		$("#ex_Result1").html(" * 체크된 Row의 모든 데이터 = "+rowData);
		$("#ex_Result2").html(tdArr);
	});
	</script> -->
	
	<script>
		var inputChange = function() {
			var checkbox = $("input[name=user_CheckBox]:checked");
			
			checkbox.each(function(i) {
				var tr = $(checkbox.parent().parent().eq(i));
				var td = tr.children();
				
				var username = td.eq(2).text();
				var password = td.eq(3).text();
				var answer = td.eq(4).text();
			
				td.eq(2).html("<input type='text' name='userName' value='"+username+"'/>");
				td.eq(3).html("<input type='text' name='pw' value='"+password+"'/>");
				td.eq(4).html("<input type='text' name='answer' value='"+answer+"'/>");
				
			});
			
			var btn = $("#btngroup").children();
			btn.eq(0).replaceWith("<button class='btn_1 checkout_btn_1'onclick='updatesubmit();' >submit</button>");
			btn.eq(1).replaceWith("<button class='btn_1 checkout_btn_1' onclick='cancle();'>cancle</button>");
			btn.eq(2).remove();
		};
		
		
		
		/* $("#updateBtn").on("click",inputChange); */
	</script>
	
	<!-- <script>
	$("#deleteBtn").click(function(){
		var path = "${path}/memberDeleteProc";
		var memberIdArr = new Array();
		var checkbox = $("input[name=user_CheckBox]:checked");
		
		checkbox.each(function(i) {
			var tr = checkbox.parent().parent().eq(i);
			var td = tr.children();
			
			var memberId = td.eq(1).text();
			
			
			memberIdArr.push(memberId);
		});
		
		sendMemberIdArr(path,memberIdArr);
		
	});
	</script> -->
	
	<!-- <script >
		var updatesubmit = function(){
			var userNameArr = new Array();
			var pwArr = new Array();
			var answerArr = new Array();
			$("input[name=userName]").each(function(){
				userNameArr.push($)
			});
		};
		
		var cancle = function(){
			window.location.href=${url}+"managerHomeProc";
		};
	</script> -->
		
	<!-- <script>
	function sendMemberIdArr(path,arrData){
		var form = document.createElement('form');
		form.setAttribute('method','post');
		form.setAttribute('action',path);
		document.charset = "utf-8";
		
		var memberIdArr = document.createElement('input');
		memberIdArr.setAttribute('type','hidden');
		memberIdArr.setAttribute('name', 'memberIdArr');
		memberIdArr.setAttribute('value',arrData);
		form.appendChild(memberIdArr);
		
		document.body.appendChild(form);
		form.submit();
	}
	</script> -->
	
	<script>
	function sendMemberIdArr(){
		var memberIdArr = new Array();
		var checkbox = $("input[name=user_CheckBox]:checked");
		
	
		//아이디 뽑아냄
		checkbox.each(function(i){
			var tr = $(checkbox.parent().parent().eq(i));
			var td = tr.children();
			
			/* data2 = td.eq(1).text(); */
			var data2 =	td.eq(1).text();
			
			memberIdArr.push(data2);
		});
		console.log(memberIdArr[0]);
		console.log(memberIdArr.length);
		
		//ajax로 비동기 처리
		 $.ajax({
            url: "memberDeleteProc",
            type: "POST",
            data: { "id" : memberIdArr },
            success: function(data){
            	console.log(data);
                if (data == "success"){
                	console.log("success2");
                	location.href="managerHomeProc";
                	alert("memberDelete Success");
                
                } else{
                	console.log("fail");
                	alert("memberDelete Fail");
                }
            },
            error: function(){
                alert("fail");
            }
        }); 
	}
	</script>
	
	<!-- <script type="text/javascript">
		function test(){
			var checkbox = $("input[name=user_checkbox]:checked");
			
			$("input[name=user_checkbox]:checked").each(function(){
				var test = $(this).val();
				console.log(test);
			});
			
			
		}
	</script>
	 -->
	

</body>
</html>