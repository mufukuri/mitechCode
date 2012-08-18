


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
 

<h2>Subjects</h2>
<table >
  <tr>
        <th>Subject Name</th>
       
    </tr>
<c:forEach items="${subjectList}" var="subject">
  
   <tr>
            <td>${subject.name}</td>
            <td><a href="<s:url value="/subjects/${subject.id}"/>">View Topics</a></td>
          
           
        </tr>
</c:forEach>


</table>
<br/>

<div>

<a href="subjects?new"><span>New Subject</span></a>
</div>