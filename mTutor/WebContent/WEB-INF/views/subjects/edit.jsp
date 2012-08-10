<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div>
<h2>Create Subject</h2>
<sf:form method="POST" modelAttribute="user">         
   <fieldset> 
   <table>
      <tr>
         <th><sf:label path="name">Name:</sf:label></th>
         <td><sf:input path="name" size="15" /><br/>
             <sf:errors path="name" cssClass="error" />
         </td>
      </tr>
     
     
     
   </table>
   <br>
   <input name="commit" type="submit" 
                    value="Create Subject." />
</fieldset>
</sf:form>

</div>