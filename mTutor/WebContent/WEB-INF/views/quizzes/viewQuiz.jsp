
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib prefix="test" uri="/WEB-INF/tags/topicDescriptor.tld"%>
    <%@taglib prefix="subject" uri="/WEB-INF/tags/subjectDescriptor.tld"%>
    <div>

<h2>Quiz Details</h2>
       
   <fieldset> 
   <table >
      <tr>
         <th>Quiz Number:</th>
         <td><c:out value="${quiz.quizNumber}"></c:out> 
            
         </td>
      </tr>
      
      <tr>
         <th>Quiz Type:</th>
         <td><c:out value="${quiz.quizType}"></c:out> 
            
         </td>
      </tr>
      <tr>
         <th>Topic:</th>
         <td>
         <test:topicTag topicId="${quiz.topicId}"></test:topicTag>
         <%-- <c:out value="${quiz.topicId}"></c:out>  --%>
            
         </td>
      </tr>
      
       <tr>
         <th>Subject:</th>
         <td>
        <%--  <td><c:out value="${quiz.subjectId}"></c:out> --%> 
            <subject:subjectTag subjectId="${quiz.subjectId}"></subject:subjectTag>
         </td>
      </tr>
   </table>
   <br>
  
</fieldset>
  



</div>        
                        




