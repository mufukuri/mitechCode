<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="phoneUrl" value="/resources/images/cellphone.jpg"/>
<form action="/mTutor/sim/process">
<div>Mobile : <input type="text" id="id" name="Id" value="${txt.id}"></div>
<br/>
<div style="width: 428px; height: 500px; background-image: url('${phoneUrl}');">
       <div style="background-color: white; position: relative; width: 191px; height: 305px; left: 148px; top: 95px; padding-left: 1px">
               <div style="width: 190px;font-size: 11px"><b>${txt.htmlMessage}</b></div>
               <textarea style="height: 25px; width: 181px; position: absolute; top: 245px; left: 2px" id="Message"  name="Message" ></textarea>
               <button value="Send" style="position: absolute; top: 280px; left: 0px; width: 191px;">Send</button>
       </div>
</div>
<br/>
<div>Length :${msgLength}</div>
<input type="hidden" id="SessionState" name="SessionState" value="${txt.sessionState}">
<input type="hidden" id="CustomerState" name="CustomerState" value="${txt.customerState}">

</form>