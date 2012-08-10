<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    
    
<div>
<h2>User Details for captured profile</h2>
       
   <fieldset> 
   <table >
      <tr>
      <td>Full Name :</td>
         <td><c:out value="${user.fullName}"></c:out> 
            
         </td>
      </tr>
      <tr>
       <td>UserName :</td>
         <td><c:out value="${user.username}"></c:out> 
            
         </td>
      </tr>
   </table>
   <br>
  
</fieldset>


</div>

<div>

<a href="users?new"><span>New Profile</span></a>
</div>