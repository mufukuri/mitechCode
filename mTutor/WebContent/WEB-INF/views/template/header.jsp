<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="security"
uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- Tray -->
	<div id="tray" class="box">

		<p class="f-left box">

			<!-- Switcher -->
			<span class="f-left" id="switcher">
				
			</span>
			<strong>mTutor</strong>

		</p>

		<p class="f-right">User: <strong><a href="#"><security:authentication property="principal.username" />
		</a></strong> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><a href="<c:url value="/j_spring_security_logout" />" > Logout</a></strong></p>

	</div> <!--  /tray -->

	<hr class="noscreen" />

	<!-- Menu -->
	<div id="menu" class="box">

		

		<ul class="box">
		<security:authorize access="hasRole('ROLE_ADMIN')">
			<li id="menu-active"><a href="users?list"><span>System Users</span></a></li> <!-- Active -->
			
			<li><a href="subjects?list"><span>Subjects</span></a></li>
			<li><a href="schools?list"><span>Schools</span></a></li>
			<li><a href="teachers?list"><span>Teachers</span></a></li>
			</security:authorize>
			<security:authorize access="hasRole('ROLE_TEACHER')">
			<li><a href="#"><span>Classes</span></a></li>
			<li><a href="#"><span>Quizzes</span></a></li>
			<li><a href="#"><span>Reports</span></a></li>
			</security:authorize>
			<li><a href="/password"><span>Change Password</span></a></li>
			
		</ul>

	</div> <!-- /header -->

	<hr class="noscreen" />