<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.errorblock {
	color: #ff0000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 10px;
}
</style>
<div>
<c:if test="${not empty error}">
		<div class="errorblock">
			Your login attempt was not successful, try again.<br /> Caused :
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>
	</div>
<div>
   <h2>Sign in to mTutor</h2>
   
   <p>
    If you've been using mTutor from your phone,
    then that's amazing...we don't support IM yet.
   </p>
   
   <s:url var="authUrl" 
          value="/static/j_spring_security_check" /><!--<co id="co_securityCheckPath"/>-->
   <form method="post" class="signin" action="${authUrl}">
   
    <fieldset>
    <table cellspacing="0">
    <tr>
    <th><label for="username_or_email">Username</label></th>
    <td><input id="username_or_email" 
               name="j_username" 
               type="text" />  <!--<co id="co_usernameField"/>-->
      </td>
    </tr>
    <tr>
    <th><label for="password">Password</label></th>
      <td><input id="password" 
                 name="j_password" 
                 type="password" /> <!--<co id="co_passwordField"/>-->
          <small><a href="/account/resend_password">Forgot?</a></small>
      </td>
    </tr>
    <tr>
    <th></th>
    <td><input id="remember_me" 
        name="_spring_security_remember_me" 
        type="checkbox"/> <!--<co id="co_rememberMe"/>-->
        <label for="remember_me" 
               class="inline">Remember me</label></td>
    </tr>
    <tr>
    <th></th>
    <td><input name="commit" type="submit" value="Sign In" /></td>
    </tr>
    </table>
    </fieldset>
   </form>
   
   <script type="text/javascript">
    document.getElementById('username_or_email').focus();
   </script>
</div>