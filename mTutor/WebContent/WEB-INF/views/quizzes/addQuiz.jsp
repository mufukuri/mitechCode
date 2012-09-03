
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <script type="text/javascript"
 
src="<c:url value="/resources/jquery/1.8/jquery-­1.8.0.min.js" />"></script>
</head>

 <c:url var="findSubjectsURL" value="/listSubjects" />
 <c:url var="findTopicsUrl" value="/listTopics" />
 <c:url var="findGradesUrl" value="/listGrades" />
 <c:url var="findConceptsUrl" value="/listConcepts" />
 
 
 <script type="text/javascript">
$(document).ready(function() { 
	$('#grades').change(
			function() {
				$.getJSON('${findTopicsUrl}', {
					academicLevelId : $(this).val(),
					ajax : 'true'
				}, function(data) {
					var html = '<option value="">--Select Topic--</option>';
					var len = data.length;
					for ( var i = 0; i < len; i++) {
						html += '<option value="' + data[i].id + '">'
								+ data[i].topicName + '</option>';
					}
					html += '</option>';

					$('#topics').html(html);
				});
			});
});
</script>
 
 
  <script type="text/javascript">
$(document).ready(function() { 
	$('#topics').change(
			function() {
				$.getJSON('${findConceptsUrl}', {
					topicId : $(this).val(),
					ajax : 'true'
				}, function(data) {
					var html = '<option value="">--Select Concept--</option>';
					var len = data.length;
					for ( var i = 0; i < len; i++) {
						html += '<option value="' + data[i].id + '">'
								+ data[i].conceptName + '</option>';
					}
					html += '</option>';

					$('#concepts').html(html);
				});
			});
});
</script>
 
 
 
<script type="text/javascript">
$(document).ready(
 
function() {
 
 
$.getJSON('${findSubjectsURL}', {
 
 
 
ajax : 'true'
 
 
}, function(data) {
 
 
 
var html = '<option value="">--Select Subject--</option>';
 
 
 
var len = data.length;
 
 
 
for ( var i = 0; i < len; i++) {
 
 
 
 
html += '<option value="' + data[i].id + '">'
 
 
 
 
 
 
+ data[i].name + '</option>';
 
 
 
}
 
 
 
html += '</option>';
                        //now that we have our options, give them to our select
 
 
 
$('#subjects').html(html);
});

});
</script>    



<!--Grades  -->


<script type="text/javascript">
$(document).ready(function() { 
	$('#subjects').change(
			function() {
				$.getJSON('${findGradesUrl}', {
					subjectId : $(this).val(),
					ajax : 'true'
				}, function(data) {
					var html = '<option value="">--Select Grade--</option>';
					var len = data.length;
					for ( var i = 0; i < len; i++) {
						html += '<option value="' + data[i].id + '">'
								+ data[i].levelName + '</option>';
					}
					html += '</option>';

					$('#grades').html(html);
				});
			});
});
</script>



                 
                        
<div>
<h2>Create Quiz</h2>
<form:form id="createQuiz" method="POST" modelAttribute="quiz">   


  
   <fieldset> 
   <table>
   
   <tr>
  <th><form:label path="quizType">Quiz Type:</form:label></th>
         <td> <form:select path="quizType">
        
         <form:options items="${quizTypes}"/>
         </form:select><br/>
             <form:errors path="quizType" cssClass="errors" />
         </td>
   
   
   </tr>
   
    <tr>

<th><form:label path="subjectId">Subject:</form:label></th>
	<td>
	<form:select id="subjects" path="subjectId">
	</form:select> 
	 <form:errors path="subjectId" cssClass="errors" />
	 </td>
	 
	

	</tr>
   <tr>

<th><form:label path="academicLevelId">Grade:</form:label></th>
	<td>
	<form:select id="grades" path="academicLevelId">
	</form:select> 
	 <form:errors path="academicLevelId" cssClass="errors" />
	 </td>
	 
	

	</tr>
  
   
	
	<tr>
<th><form:label path="topicId">Topic:</form:label></th>
	<td>
	<form:select id="topics" path="topicId">
	</form:select> 
	 <form:errors path="topicId" cssClass="errors" />
	 </td>
	 
	

	</tr>

<tr>
<th><form:label path="conceptId">Concept:</form:label></th>
	<td>
	<form:select id="concepts" path="conceptId">
	</form:select> 
	 <form:errors path="conceptId" cssClass="errors" />
	 </td>
	 
	

	</tr>


	
	
	
	</table>
	<br>
	<button name="cancel" type="submit">Cancel</button>
	<button type="submit">Next</button>
	</fieldset>
</form:form>

</div>






