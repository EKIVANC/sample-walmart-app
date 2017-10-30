<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Static content -->
<link rel="stylesheet" href="/resources/css/style.css">
<script type="text/javascript" src="/resources/js/app.js"></script>

<title>Spring Boot</title>
</head>
<body>
	<jsp:include page="../views/header.jspx" />

	<%-- <c:if test="${not empty errorMessage}">
		<h4>
			<b>Something bad happened, Please Try Again Later, </b> <b>here is the detail:</b> <br /> <b style="color: red; font-weight: bold;">${errorMessage}</b>
		</h4>
	</c:if> --%>

	<div style="clear: both"></div>
	<div style="width: 100%;">
		<div style="float: left; width: 50%; margin: auto; text-align: center">
			<h3>${bookDetail.name}</h3>
			<img alt="BookImage" src="${bookDetail.largeImage}" />
		</div>

		<div style="float: left; margin-top:150px">
			<div class="divTable">
				<div class="divTableHead">
						<div class="divTableRow4Header">
							<div class="divTableCell4Header">Product Details</div>
						</div>
				</div>
			
				<div class="divTableBody">
					<div class="divTableRow">
						<div class="divTableCell">
							Price: $${bookDetail.salePrice}
							<c:if test="${not empty bookDetail.msrp}">
						 -- List Price $${bookDetail.msrp}
						</c:if>
						</div>
					</div>
					<div class="divTableRow">
						<div class="divTableCell">ISBN: ${bookDetail.isbn}</div>
					</div>
					<div class="divTableRow">
						<div class="divTableCell">Available in stock:
							${bookDetail.stock}</div>
					</div>
					<div class="divTableRow">
						<div class="divTableCell">Standard Ship Rate:
							$${bookDetail.standardShipRate}</div>
					</div>

					<c:if test="${bookDetail.freeShippingOver50Dollars}">
						<div class="divTableRow">
							<div class="divTableCell">Free Shipping Over 50 Dolars!!</div>
						</div>
					</c:if>
					
					<c:if test="${bookDetail.shipToStore}">
						<div class="divTableRow">
							<div class="divTableCell">Ship to Store Free!</div>
						</div>
					</c:if>

					<div class="divTableRow">
						<div class="divTableCell">
							<button id="btnAdd2cart" disabled="true">Add to Cart</button>
						</div>
					</div>
				</div>
			</div>



		</div>
	</div>
	<div style="clear: both"></div>

	<div class="tab">
		<button class="tablinks" onclick="openTab(event, 'product_desc')"
			id="defaultOpen">Product Description</button>
		<button class="tablinks" onclick="openTab(event, 'reviews')">Reviews</button>
	</div>

	<div id="product_desc" class="tabcontent">
		<h3>Description:</h3>
		<p> 
			<c:out value="${bookDetail.longDescription}" escapeXml="false" />
		</p>
	</div>

	<div id="reviews" class="tabcontent">
		<h3>Customer Feedbacks:</h3>
		<p>${customerReview.reviews.count}</p>
		<c:if test="${not empty errorMessage}">
			<h4>
				<b style="color: green; font-weight: bold;">Walmart Review Service is not working!</b>
				<b style="color: green; font-weight: bold;">And it did not work for the whole weeked :/ </b>
				<b style="color: green; font-weight: bold;">It is not your candidate mistake :) </b> 
				<b>here is the detail:</b> <br /> <b style="color: red; font-weight: bold;">${errorMessage}</b>
			</h4>
		</c:if>
	</div>


	<script>
		function openTab(evt, pname) {
			var i, tabcontent, tablinks;
			tabcontent = document.getElementsByClassName("tabcontent");
			for (i = 0; i < tabcontent.length; i++) {
				tabcontent[i].style.display = "none";
			}
			tablinks = document.getElementsByClassName("tablinks");
			for (i = 0; i < tablinks.length; i++) {
				tablinks[i].className = tablinks[i].className.replace(
						" active", "");
			}
			document.getElementById(pname).style.display = "block";
			evt.currentTarget.className += " active";
		}

		// Get the element with id="defaultOpen" and click on it
		document.getElementById("defaultOpen").click();
	</script>

	<jsp:include page="../views/footer.jspx" />
</body>
</html>