<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<c:url var="faviconUrl" value="/resources/images/icons/favicon.ico"/>

<%-- CSS --%>
<c:url var="resetCssUrl" value="/resources/css/reset.css"/>
<c:url var="mainCssUrl" value="/resources/css/main.css"/>
<c:url var="twoColCssUrl" value="/resources/css/2col.css"/>
<c:url var="oneColCssUrl" value="/resources/css/1col.css"/>
<c:url var="styleCssUrl" value="/resources/css/style.css"/>
<c:url var="mystyleCssUrl" value="/resources/css/mystyle.css"/>

<%-- JavaScript --%>
<c:url var="switcherJsUrl" value="/resources/js/switcher.js"/>
<c:url var="jqueryJsUrl" value="/resources/js/jquery.js"/>

<c:url var="toggleJsUrl" value="/resources/js/toggle.js"/>
<c:url var="coreJsUrl" value="/resources/js/ui.core.js"/>
<c:url var="tabsJsUrl" value="/resources/js/ui.tabs.js"/>


<html lang="en">
<head>
    <title> ::: mTutor :::</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<meta http-equiv="content-language" content="en" />
	<meta name="robots" content="noindex,nofollow" />
	<link rel="stylesheet" media="screen,projection" type="text/css" href="${resetCssUrl}" /> <!-- RESET -->
	<link rel="stylesheet" media="screen,projection" type="text/css" href="${mainCssUrl}" /> <!-- MAIN STYLE SHEET -->
	<link rel="stylesheet" media="screen,projection" type="text/css" href="${twoColCssUrl}" title="2col"/> <!-- DEFAULT: 2 COLUMNS -->
	<link rel="alternate stylesheet" media="screen,projection" type="text/css" href="${oneColCssUrl}" title="1col" /> <!-- ALTERNATE: 1 COLUMN -->
	<!--[if lte IE 6]><link rel="stylesheet" media="screen,projection" type="text/css" href="css/main-ie6.css" /><![endif]--> <!-- MSIE6 -->
	<link rel="stylesheet" media="screen,projection" type="text/css" href="${styleCssUrl}" /> <!-- GRAPHIC THEME -->
	<link rel="stylesheet" media="screen,projection" type="text/css" href="${mystyleCssUrl}" /> <!-- WRITE YOUR CSS CODE HERE -->
	
	<script type="text/javascript" src="${jqueryJsUrl}"></script>
	<script type="text/javascript" src="${switcherJsUrl}"></script>
	<script type="text/javascript" src="${toggleJsUrl}"></script>
	<script type="text/javascript" src="${coreJsUrl}"></script>
	<script type="text/javascript" src="${tabsJsUrl}"></script>
	<script type="text/javascript">
	$(document).ready(function(){
		$(".tabs > ul").tabs();
	});
	</script>
</head>
<body>

<div id="main">
	<jsp:include page="header.jsp"/>
	
	<div id="cols" class="box">

		<!-- Aside (Left Column) -->
		<div id="aside" class="box">
	 	<jsp:include page="navigation.jsp"/>
	</div>
	<hr class="noscreen" />

	<!-- Content (Right Column) -->
	<div id="content" class="box">
		<tiles:insertAttribute name="content"/>
	</div>
	</div>
    <hr class="noscreen" />

	<!-- Footer -->
	<div id="footer" class="box">

		<p class="f-left">&copy; 2012 <a href="#">Mitech</a>, All Rights Reserved &reg;</p>

	</div> 
</div>
</body>
</html>
