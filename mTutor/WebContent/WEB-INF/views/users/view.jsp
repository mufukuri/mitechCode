<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div>
<h2>Create mTutor Profile</h2>
<sf:form method="POST" modelAttribute="user" action="add" commandName="user"
         enctype="multipart/form-data">         
   <fieldset> 
   <table cellspacing="0">
      <tr>
         <th><sf:label path="fullName">Full name:</sf:label></th>
         <td><sf:input path="fullName" size="15" /><br/>
             <sf:errors path="fullName" cssClass="error" />
         </td>
      </tr>
      <tr>
         <th><sf:label path="username">Username:</sf:label></th>
         <td><sf:input path="username" size="15" maxlength="15" />
              <small id="username_msg">No spaces, please.</small><br/>
             <sf:errors path="username" cssClass="error" />

            </td>
      </tr>
      <tr>
         <th><sf:label path="password">Password:</sf:label></th>
         <td><sf:password path="password" size="30" 
                            showPassword="true"/> 
             <small>6 characters or more (be tricky!)</small><br/>
             <sf:errors path="password" cssClass="error" />
            </td>
      </tr>

      <tr>
         <th><sf:label path="email">Email Address:</sf:label></th>

         <td><sf:input path="email" size="30"/> 
             <small>In case you forget something</small><br/>
             <sf:errors path="email" cssClass="error" />
            </td>
      </tr>
      <!--<start id="image_field"/>--> 
      
      <!--<end id="image_field"/>--> 
      <tr>
       <th><sf:label path="role">User Role:</sf:label></th>
       <td>
      <sf:select path="role">
      <sf:option value="NONE" label="--- Select ---"></sf:option>
      <sf:option value="ROLE_ADMIN" label="Admin"></sf:option>
       <sf:option value="ROLE_TEACHER" label="Teacher"></sf:option>
      
      </sf:select>
      </td>
      </tr>
     
     
   </table>
   <br>
   <input name="commit" type="submit" 
                    value="Create account." />
</fieldset>
</sf:form>

</div>