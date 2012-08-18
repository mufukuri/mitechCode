


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
 

<h2>Topics</h2>
<table >
  <tr>
        <th>Topic Name</th>
        <th>Description</th>
         <th>Upgrade Level</th>
          <th>Subject</th>
           <th>Grade</th>
    </tr>
<c:forEach items="${topicList}" var="topic">
  
   <tr>
            <td>${topic.topicName}</td>
       <td>${topic.description}</td>
       <td>${topic.toUpgrade}</td>
        <td>${topic.subjectId}</td>
        <td>${topic.academicLevelId}</td>
     <td><a href="<s:url value="/topics/${topic.id}"/>">View Concepts</a></td>
          
           
        </tr>
</c:forEach>


</table>
<br/>

<div>

<a href="topics?new"><span>New Topic</span></a>
</div>