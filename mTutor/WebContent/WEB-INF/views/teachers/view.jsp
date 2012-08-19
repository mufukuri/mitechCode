<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<h2>View Teacher</h2>

	<fieldset>
		<legend>Teacher Details</legend>
		<table>
			<tr>
				<td><span class="label">First Name:</span></td>
				<td><c:out value="${teacher.firstName}"></c:out></td>

				<td><span class="label">Surname:</span></td>
				<td><c:out value="${teacher.surname}"></c:out></td>
			</tr>
			<tr>
				<td><span class="label">Gender:</span></td>
				<td><c:out value="${teacher.gender}"></c:out></td>

				<td><span class="label">Employment Number:</span></td>
				<td><c:out value="${teacher.employmentNumber}"></c:out></td>
			</tr>
			<tr>
			
				<td><span class="label">Login Id:</span></td>
				<td><c:out value="${user.username}"></c:out></td>
				
				<td><span class="label">National Id:</span></td>
				<td><c:out value="${teacher.nationalId}"></c:out></td>
			</tr>
			<tr>
				
				<td><span class="label">School:</span></td>
				<td><c:out value="${school.schoolName}"></c:out></td>
				
				<td></td>
				<td></td>
				
			</tr>
		</table>
		<br>

	</fieldset>

	<fieldset>
		<legend>Classes</legend>

		<table>
			<tr>
				<th>Class Name</th>
				<th>Academic Level</th>
				<th>Join Code</th>

			</tr>
			<c:forEach items="${classList}" var="schoolClass">

				<tr>
					<td>${schoolClass.className}</td>
					<td>${schoolClass.academicLevelId}</td>
					<td>${schoolClass.joinCode}</td>
				</tr>
			</c:forEach>


		</table>

	</fieldset>


</div>