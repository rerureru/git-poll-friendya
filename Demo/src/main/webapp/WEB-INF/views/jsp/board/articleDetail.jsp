<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>jQuery UI Tabs - Simple manipulation</title>
<script src="resources/scripts/jquery-1.11.1.js"></script>
<script src="resources/scripts/jquery-ui-1.11.0.js"></script>
<link rel="stylesheet" href="resources/stylesheets/jquery-ui.css" />
<link rel="stylesheet" href="resources/stylesheets/style.css" />
<link rel="stylesheet" href="resources/stylesheets/base.css" />
<link rel="stylesheet" href="resources/stylesheets/bootstrap.css" />
<link rel="stylesheet" href="resources/stylesheets/custom.css" />
<script>
	$(function() {
		<c:url var="loginUrl" value="/boardList.action" />
		$("#goToList").button().click(
			function(){ 
				window.location = "${loginUrl}";
				console.log('goToList Button clicked');
			}
		);
	});
</script>
</head>
<body>
	<c:url var="gnbURL" value="boardList.action?gnb=${article.gnb.cDVal}" /> 
	<a href="${gnbURL}">${article.gnb.cDName}</a> > 
	<c:url var="lnbURL" value="boardList.action?gnb=${article.gnb.cDVal}&lnb=${article.lnb.cDVal}" />
	<a href="${lnbURL}"> ${article.lnb.cDName}</a>
	
	<sec:authorize access="isAuthenticated()">
		<sec:authentication property="principal.username"/>
		<c:url value="/logout" var="logoutURL" />
		<a href="${logoutURL}">Log Out</a>
	</sec:authorize>
	<sec:authorize access="!isAuthenticated()">
		<c:url var="loginPage" value="/login.action" />
		<a href="${loginPage}">login</a>
	</sec:authorize>
	
	<div id="articleHeader">
		<label>Writer</label>
		<label>${article.userinf.nickName}</label>
		<label>Date</label>
		<label>${article.createDate}</label>
		<label>Hits</label>
		<label>${article.hitCNT}</label>
		<label>Recommend</label>
		<label>${article.recommendCNT}</label>		
	</div>
	<div id="article">
		<input id="title" name="subject" readonly="readonly" value="${article.subject}"/>
		<textarea id="content" name="content" style="width:300px; height:150px;" readonly="readonly">
			${article.content} 
		</textarea>
	</div>
	<button id="goToList">목록으로</button>
</body>
</html>