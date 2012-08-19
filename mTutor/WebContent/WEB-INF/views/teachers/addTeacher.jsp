
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div>
<h2>Add Teacher</h2>
<sf:form method="POST" modelAttribute="teacher">   

   <fieldset> 
   <table>
   <tr>
  <th><sf:label path="firstName">First Name:</sf:label></th>
         <td> <sf:input path="firstName" size="30" /><br/>
             <sf:errors path="firstName" cssClass="errors" />
         </td>
   
   
   </tr>
   
    <tr>
  <th><sf:label path="surname">Surname:</sf:label></th>
         <td> <sf:input path="surname" size="30" /><br/>
             <sf:errors path="surname" cssClass="errors" />
         </td>
   
   
   </tr>
   
   <tr>
  <th><sf:label path="gender">Gender:</sf:label></th>
         <td> <sf:radiobutton path="gender" value="Male" label="Male"/>
         <sf:radiobutton path="gender" value="Female" label="Female"/>
             <sf:errors path="gender" cssClass="errors" />
         </td>
   
   
   </tr>
   
   
   <tr>
  <th><sf:label path="nationalId">National ID:</sf:label></th>
         <td> <sf:input path="nationalId" size="30" /><br/>
             <sf:errors path="nationalId" cssClass="errors" />
         </td>
   
   
   </tr>
   
   <tr>
  <th><sf:label path="employmentNumber">Employment Number:</sf:label></th>
         <td> <sf:input path="employmentNumber" size="30" /><br/>
             <sf:errors path="employmentNumber" cssClass="errors" />
         </td>
   
   
   </tr>
   
   <tr>
    <th><label>Login Id:</label></th>
         <td> <input type="text" size="30" name="loginId" id="loginId" /><br/>
             <span style="color: red">${loginIdError}</span>
         </td>
   
   
   </tr>
   
   
   
   
   
   
  <tr>
  <th><sf:label path="schoolId">School:</sf:label></th>
         <td> <sf:select path="schoolId">
        
         <sf:options items="${schools}"/>
         </sf:select><br/>
             <sf:errors path="schoolId" cssClass="errors" />
         </td>
   
   
   </tr>
   
   
  
     
   </table>
   <br>
    <input name="commit" type="submit" 
                    value="Create Teacher" />
	
</fieldset>
</sf:form>
 
</div>






