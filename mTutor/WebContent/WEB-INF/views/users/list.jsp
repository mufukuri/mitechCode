<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
 

<h2>User Profiles</h2>
<div>
<table >
  <tr>
        <th>User Name</th>
        <th>Full Name</th>
        <th>Email</th>
         <th>Role</th>
    </tr>
<c:forEach items="${userList}" var="user">
  
   <tr>
            <td>${user.username}</td>
            <td>${user.fullName}</td>
            <td>${user.email}</td>
             <td>${user.role}</td>
        </tr>
</c:forEach>

</table>
</div>
<br/>
<div>
<a href="users?new"><span>New Profile</span></a>
</div>