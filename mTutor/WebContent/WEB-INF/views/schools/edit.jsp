<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div>
<h2>Add School</h2>
<sf:form method="POST" modelAttribute="school">         
   <fieldset> 
   <table>
      <tr>
         <th><sf:label path="schoolName">School Name:</sf:label></th>
         <td><sf:input path="schoolName" size="80" /><br/>
             <sf:errors path="schoolName" cssClass="error" />
         </td>
      </tr>
      <tr>
         <th><sf:label path="address">Address:</sf:label></th>
         <td>
         <sf:textarea path="address" size="100" maxlength="120"/>
       
             
             <sf:errors path="address" cssClass="error" />

            </td>
      </tr>
      <tr>
         <th><sf:label path="city">City/Town:</sf:label></th>
         <td><sf:input path="city" size="30"/> 
             
             <sf:errors path="city" cssClass="error" />
            </td>
      </tr>

     
      <!--<start id="image_field"/>--> 
      
      <!--<end id="image_field"/>--> 
      <tr>
       <th><sf:label path="province">Province:</sf:label></th>
       <td>
      <sf:select path="province">
      <sf:option value="NONE" label="--- Select ---"></sf:option>
      <sf:option value="Harare" label="Harare"></sf:option>
     
      
      </sf:select>
      </td>
      </tr>
     
     
   </table>
   <br>
   <input name="commit" type="submit" 
                    value="Create School." />
</fieldset>
</sf:form>

</div>