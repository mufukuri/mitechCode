<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div>
<h2>Create Subject</h2>
<sf:form method="POST" modelAttribute="subject">         
   <fieldset> 
   <table>
      <tr>
         <th><sf:label path="name">Name:</sf:label></th>
         <td><sf:input path="name" size="30" /><br/>
             <sf:errors path="name" cssClass="errors" />
         </td>
      </tr>
     
     
     
   </table>
   <br>
   <input name="commit" type="submit" 
                    value="Create Subject." />
                    <input name="cancel" type="submit" 
                    value="Cancel" />  
</fieldset>
</sf:form>

</div>