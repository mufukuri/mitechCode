
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    
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
         <td><c:out value="${quiz.topicId}"></c:out> 
            
         </td>
      </tr>
      
       <tr>
         <th>Subject:</th>
         <td><c:out value="${quiz.subjectId}"></c:out> 
            
         </td>
      </tr>
   </table>
   <br>
  
</fieldset>
  



</div>                 
                        
<div>
<h2>View Quiz Question</h2>
 


   <fieldset> 
   <table>
    <tr>
         <th>Question:</th>
         <td><c:out value="${question.questionDetail}"></c:out> 
            
         </td>
      </tr>
   
   
    <tr>
         <th>Expected Answer:</th>
         <td><c:out value="${question.expectedAnswer}"></c:out> 
            
         </td>
      </tr>
   
   
    <tr>
         <th>Detailed Answer:</th>
         <td><c:out value="${question.detailedAnswer}"></c:out> 
            
         </td>
      </tr>
   
    <tr>
         <th>Points:</th>
         <td><c:out value="${question.points}"></c:out> 
            
         </td>
      </tr>
	 
	 <tr>
         <th> Difficulty:</th>
         <td><c:out value="${question.difficultyLevel}"></c:out> 
            
         </td>
      </tr>
	
   
    <tr>
         <th>Option A:</th>
         <td><c:out value="${question.optionA}"></c:out> 
            
         </td>
      </tr>
   
	<tr>
         <th>Option A Response:</th>
         <td><c:out value="${question.optionA_Response}"></c:out> 
            
         </td>
      </tr>
	
	
	<tr>
         <th>Option B:</th>
         <td><c:out value="${question.optionB}"></c:out> 
            
         </td>
      </tr>
	
	
	<tr>
         <th>Option B Response:</th>
         <td><c:out value="${question.optionB_Response}"></c:out> 
            
         </td>
      </tr>
	
  
   <tr>
         <th>Option C:</th>
         <td><c:out value="${question.optionC}"></c:out> 
            
         </td>
      </tr>
   
	<tr>
         <th>Option C Response:</th>
         <td><c:out value="${question.optionC_Response}"></c:out> 
            
         </td>
      </tr>
    <tr>
    
    <tr>
         <th>Option D:</th>
         <td><c:out value="${question.optionD}"></c:out> 
            
         </td>
      </tr>
    <tr>
    
    <tr>
         <th>Option D:</th>
         <td><c:out value="${question.optionD_Response}"></c:out> 
            
         </td>
      </tr>
    
	
	</table>
	<br>
	
	
	</fieldset>


</div>
<div>

<a href="questions"><span>Next Question</span></a>
<a href="quizDone"><span>Done</span></a>
</div>





