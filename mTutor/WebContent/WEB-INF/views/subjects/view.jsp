<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
<h2>View Subject</h2>
       
   <fieldset> 
   <table >
      <tr>
         <th><sf:label path="fullName">Full name:</sf:label></th>
         <td><c:out value="${subject.name}"></c:out> 
            
         </td>
      </tr>
      
   </table>
   <br>
  
</fieldset>


</div>