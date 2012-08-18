


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
 
 <script language="javascript">
//<!--        
function deletePerson(url){
    var confirmed = confirm('<fmt:message key="person.form.confirmDelete"/>');

    if (confirmed) {
        var request = new XMLHttpRequest();
        request.open('DELETE', url, true);
        request.onreadystatechange = function () { window.location.reload(true); };
        request.send(null);
    }
}
// -->
</script>

<h2>Topics</h2>
<table >
  <tr>
        <th>Concept</th>
        <th>Sequence Number</th>
         <th>Topic</th>
         
    </tr>
<c:forEach items="${conceptList}" var="concept">
  
   <tr>
            <td>${concept.conceptName}</td>
       <td>${concept.topicSequence}</td>
       <td>${concept.topicId}</td>
       <td><c:url var="deleteUrl" value="/concept/delete.jsp">
            <c:param name="id" value="${concept.id}" />
        </c:url>
        
        <a href="javascript:deletePerson('<c:out value="${deleteUrl}"/>')">remove</a> 
        </td>
     
  
          
           
        </tr>
</c:forEach>


</table>
<br/>

<div>

<a href="concepts?new"><span>New Concept</span></a>
</div>