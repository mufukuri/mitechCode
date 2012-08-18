<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
<h2>View Topic</h2>
       
   <fieldset> 
   <table >
   <tr>
      <td>Topic Name:</td>
         <td><c:out value="${topic.topicName}"></c:out> 
            
         </td>
      </tr>
      
      
      <tr>
      <td>Description:</td>
         <td><c:out value="${topic.description}"></c:out> 
            
         </td>
      </tr>
      <tr>
         <td>To up Grade::</td>
         <td><c:out value="${topic.toUpgrade}"></c:out> 
            
         </td>
         
      </tr>
      <tr>
         <td>Grade::</td>
         <td><c:out value="${topic.academicLevelId}"></c:out> 
            
         </td>
         
      </tr>
      
   </table>
   <br>
  <%-- <h2>Concepts</h2>
<table >
  <tr>
        <th>Concept Name</th>
        <th>Topic Sequence</th>
        
    </tr>
<c:forEach items="${conceptList}" var="concept">
  
   <tr>
            <td>${concept.conceptName}</td>
       <td>${concept.description}</td>
       
     <td><a href="<s:url value="/topics/${concept.id}"/>">View Concept</a></td>
          
           
        </tr>
</c:forEach>


</table>
</fieldset>

</div>


<div>

<a href="topics?concept"><span>New Concept</span></a>
</div> --%>