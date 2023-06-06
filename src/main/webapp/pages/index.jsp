<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Reports App</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
</head>
<body>

	<div class="container">
		<h3 class="pb-3 pt-2">
			<b><u>Report Application</u></b>
			</h1>


			<form:form action="search" modelAttribute="search" method="post">

				<table>

					<tr>
						<td>Plan Names:</td>
						<td><form:select path="planName">
								<form:option value="">-select-</form:option>
								<form:options items="${names}" />

							</form:select></td>

						<td>Plan Status:</td>
						<td><form:select path="planStatus">
								<form:option value="">-select-</form:option>
								<form:options items="${status}" />

							</form:select></td>


						<td>Gender:</td>
						<td><form:select path="gender">
								<form:option value="">-select-</form:option>
								<form:option value="male">Male</form:option>
								<form:option value="fe-male">Fe-Male</form:option>
							</form:select></td>
					</tr>

					<tr>
						<td>Start Date:</td>
						<td><form:input type="date" path="planStartDate" /></td>

						<td>End Date:</td>
						<td><form:input type="date" path="planEndDate" /></td>
					</tr>
					<tr>
					</tr>

					<tr>
						<td><a href="/" class="btn btn-secondary">Reset</a></td>
						<td><input type="submit" value="Search"
							class="btn btn-primary" /></td>
					</tr>

				</table>


			</form:form>

			<hr />

			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>ID</th>
						<th>Holder Name</th>
						<th>Gender</th>
						<th>Plan Name</th>
						<th>Plan Status</th>
						<th>Start Date</th>
						<th>End Date</th>
						<th>Amount</th>

					</tr>

				</thead>
				<tbody>
					<c:forEach items="${plans}" var="plan" varStatus="index">
						<tr>
							<td>${index.count}</td>
							<td>${plan.citizenName}</td>
							<td>${plan.gender}</td>
							<td>${plan.planName}</td>
							<td>${plan.planStatus}</td>
							<td>${plan.planStartDate}</td>
							<td>${plan.planEndDate}</td>
							<td>${plan.benifitAmount}</td>

						</tr>

					</c:forEach>

					<c:if test="${empty plans}">
						<tr>
							<td colspan="8" align="center">No Record Found</td>
						</tr>
					</c:if>

				</tbody>

			</table>

			<hr />

			Export : <a href="excel">Excel</a> <a href="pdf">Pdf</a>
	</div>



	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>
</body>
</html>