<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="test" uri="/WEB-INF/tags/topicDescriptor.tld"%>
<div>
<h2>View Concept</h2>
       
   <fieldset> 
   <table >
   <tr>
      <td>Concept Name:</td>
         <td><c:out value="${concept.conceptName}"></c:out> 
            
         </td>
      </tr>
      
      
      <tr>
      <td>Topic Sequence:</td>
         <td><c:out value="${concept.topicSequence}"></c:out> 
            
         </td>
      </tr>
      <tr>
         <td>Topic:</td>
         <td> <test:topicTag topicId="${concept.topicId}"></test:topicTag> 
            
         </td>
         
      </tr>
     
      
   </table>
   <br>
  

</fieldset>
</div>