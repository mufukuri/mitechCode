<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
 

<h2>Schools</h2>
<table >
  <tr>
        <th>Name</th>
        <th>Address</th>
        <th>Town</th>
         <th>Province</th>
    </tr>
<c:forEach items="${schoolList}" var="school">
  
   <tr>
            <td>${school.schoolName}</td>
            <td>${school.address}</td>
            <td>${school.city}</td>
             <td>${school.province}</td>
        </tr>
</c:forEach>



</table>

<br/>
<div>
<a href="schools?new"><span>New School</span></a>
</div>