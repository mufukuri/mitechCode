
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
     <script type="text/javascript"
 
src="<c:url value="/resources/jquery/1.8/jquery-­1.8.0.min.js" />"></script>
    
    
<div>
 <c:url var="findDifficultyTypes" value="/listDifficultyTypes" />
 
 
 
 <script type="text/javascript">
$(document).ready(
 
function() {
 
 
$.getJSON('${findDifficultyTypes}', {
 
 
 
ajax : 'true'
 
 
}, function(data) {
 
 
 
var html = '<option value="">--Select Difficulty Type--</option>';
 
 
 
var len = data.length;
 
 
 
for ( var i = 0; i < len; i++) {
 
 
 
 
html += '<option value="' + data + '">'
 
 
 
 
 
 
+ data + '</option>';
 
 
 
}
 
 
 
html += '</option>';
                        //now that we have our options, give them to our select
 
 
 
$('#types').html(html);
});

});
</script>    

 
 
 
<h2>Quiz Details</h2>
       
  <fieldset> 
  <form:form modelAttribute="quiz">
   <table >
       <tr>
         <th><form:label path="quizNumber">Quiz Number:</form:label></th>
         <td><c:out value="${quiz.quizNumber}"></c:out> 
            
         </td>
      </tr>
       
      <tr>
         <th><form:label path="quizType">Quiz Type:</form:label></th>
         <td><c:out value="${quiz.quizType}"></c:out> 
            
         </td>
      </tr>
      <tr>
         <th><form:label path="topicId">Topic:</form:label></th>
         <td><c:out value="${quiz.topicId}"></c:out> 
            
         </td>
      </tr>
      
       <tr>
         <th><form:label path="subjectId">Subject:</form:label></th>
         <td><c:out value="${quiz.subjectId}"></c:out> 
            
         </td>
      </tr>
   </table>
   <br>
  </form:form>
</fieldset>
  

 

</div>                 
                        
<div>
<h2>Create Quiz Question</h2>
<form:form id="createQuestion" method="POST" modelAttribute="quizQuestion">   


   <fieldset> 
   <table>
   
   <tr>
  <th><form:label path="questionDetail">Question:</form:label></th>
         <td> <form:textarea path="questionDetail" size="120" />
        
   
             <form:errors path="questionDetail" cssClass="errors" />
         </td>
   
   
   </tr>
   
 
    
	 <tr>
  <th><form:label path="expectedAnswer">Expected Answer:</form:label></th>
         <td> <form:input path="expectedAnswer" size="50"/>
        
    
             <form:errors path="expectedAnswer" cssClass="errors" />
         </td>
   
   
   </tr>
	
	<tr>
  <th><form:label path="detailedAnswer">Detailed Answer:</form:label></th>
         <td> <form:textarea path="detailedAnswer" size="120"/>
        
    
             <form:errors path="detailedAnswer" cssClass="errors" />
         </td>
   
   
   </tr>
   
   <tr>
  <th><form:label path="points">Points:</form:label></th>
         <td> <form:input path="points" size="50"/>
        
    
             <form:errors path="points" cssClass="errors" />
         </td>
   
   
   </tr>
   
   
	<tr>
  <th><form:label path="difficultyLevel">Difficulty Level:</form:label></th>
         <td> <form:select path="difficultyLevel">
        
         <form:options items="${types}"/>
         </form:select><br/>
             <form:errors path="difficultyLevel" cssClass="errors" />
         </td>
   
   
   </tr>
	 
	 
	  <%-- <tr>

<th><form:label path="difficultyLevel">Difficulty Type:</form:label></th>
	<td>
	<form:select id="types" path="difficultyLevel">
	</form:select> 
	 <form:errors path="difficultyLevel" cssClass="errors" />
	 </td>
	 
	

	</tr> --%>
   <tr>
	
	
	<tr>
  <th><form:label path="optionA">Option A:</form:label></th>
         <td> <form:input path="optionA" size="50"/>
        
    
             <form:errors path="optionA" cssClass="errors" />
         </td>
   
   
   </tr>
	 <tr>
  <th><form:label path="optionA_Response">Option A Response:</form:label></th>
         <td> <form:textarea path="optionA_Response" size="120" />
        
   
             <form:errors path="optionA_Response" cssClass="errors" />
         </td>
   
   
   </tr>
	<tr>
  <th><form:label path="optionB">Option B:</form:label></th>
         <td> <form:input path="optionB" size="50"/>
        
    
             <form:errors path="optionB" cssClass="errors" />
         </td>
   
   
   </tr>
   
    <tr>
  <th><form:label path="optionB_Response">Option B Response:</form:label></th>
         <td> <form:textarea path="optionB_Response" size="120" />
        
   
             <form:errors path="optionB_Response" cssClass="errors" />
         </td>
   
   
   </tr>
   
   
	<tr>
  <th><form:label path="optionC">Option C:</form:label></th>
         <td> <form:input path="optionC" size="50"/>
        
    
             <form:errors path="optionC" cssClass="errors" />
         </td>
   
   
   </tr>
    <tr>
  <th><form:label path="optionC_Response">Option C Response:</form:label></th>
         <td> <form:textarea path="optionC_Response" size="120" />
        
   
             <form:errors path="optionC_Response" cssClass="errors" />
         </td>
   
   
   </tr>
   
   <tr>
  <th><form:label path="optionD">Option D:</form:label></th>
         <td> <form:input path="optionD" size="50"/>
        
    
             <form:errors path="optionD" cssClass="errors" />
         </td>
   
   
   </tr>
    <tr>
  <th><form:label path="optionD_Response">Option D Response:</form:label></th>
         <td> <form:textarea path="optionD_Response" size="120" />
        
   
             <form:errors path="optionD_Response" cssClass="errors" />
         </td>
   
   
   </tr>
	
	</table>
	<br>
	<button type="submit">Save Question</button>
	
	</fieldset>
</form:form>
 
</div>






