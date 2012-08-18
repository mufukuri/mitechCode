
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div>
<h2>Create Topic</h2>
<sf:form commandName="topic">   
<input type="hidden" name="_flowExecutionKey" 
	      value="${flowExecutionKey}"/>      
   <fieldset> 
   <table>
   <tr>
  <th><sf:label path="academicLevelId">Grade:</sf:label></th>
         <td> <sf:select path="academicLevelId">
   
         <sf:options items="${grades}"/>
         </sf:select><br/>
             <sf:errors path="academicLevelId" cssClass="errors" />
         </td>
   
   
   </tr>
   
  <tr>
  <th><sf:label path="subjectId">Subject:</sf:label></th>
         <td> <sf:select path="subjectId">
        
         <sf:options items="${subjects}"/>
         </sf:select><br/>
             <sf:errors path="subjectId" cssClass="errors" />
         </td>
   
   
   </tr>
   
   
  <%--  <tr>
  <th><sf:label path="topicType">Type:</sf:label></th>
         <td> <sf:select path="topicType">
         
         <sf:options items="${topicTypes}"/>
         </sf:select><br/>
             <sf:errors path="topicType" cssClass="errors" />
         </td>
   
   
   </tr> --%>
   
   
      <tr>
         <th><sf:label path="topicName">Name:</sf:label></th>
         <td><sf:input path="topicName" size="30" /><br/>
             <sf:errors path="topicName" cssClass="errors" />
         </td>
      </tr>
     <tr>
     <th><sf:label path="description">Description</sf:label></th>
     <td><sf:input path="description" size="30" /><br/>
             <sf:errors path="description" cssClass="errors" />
         </td>
     </tr>
     <tr>
         <th><sf:label path="toUpgrade">Upgrade Level:</sf:label></th>
         <td><sf:input path="toUpgrade" size="30" /><br/>
             <sf:errors path="toUpgrade" cssClass="errors" />
         </td>
      </tr>
     
   </table>
   <br>
   <input type="submit" class="button" 
	      name="_eventId_createTopic" value="Create Topic"/>
	  <input type="submit" class="button" 
	      name="_eventId_cancel" value="Cancel"/>    
</fieldset>
</sf:form>

</div>