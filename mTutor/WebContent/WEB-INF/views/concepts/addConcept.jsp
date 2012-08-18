
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div>
<h2>Create Concept</h2>
<sf:form method="POST" modelAttribute="concept">   

   <fieldset> 
   <table>
   
   
      <tr>
         <th><sf:label path="conceptName">Concept Name:</sf:label></th>
         <td><sf:input path="conceptName" size="30" /><br/>
             <sf:errors path="conceptName" cssClass="errors" />
         </td>
      </tr>
     <tr>
     <th><sf:label path="topicSequence">Topic Sequence</sf:label></th>
     <td><sf:input path="topicSequence" size="30" /><br/>
             <sf:errors path="topicSequence" cssClass="errors" />
         </td>
     </tr>
     <tr>
         <th><sf:label path="topicId">Topic:</sf:label></th>
         <td><sf:input path="topicId" size="30" /><br/>
             <sf:errors path="topicId" cssClass="errors" />
         </td>
      </tr>
     
   </table>
   <br>
    <input name="commit" type="submit" 
                    value="Create topic." />
	  <input name="commit" type="submit" 
                    value="Cancel" />  
</fieldset>
</sf:form>
 
</div>






