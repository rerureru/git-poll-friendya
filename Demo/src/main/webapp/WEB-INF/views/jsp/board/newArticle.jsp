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
	function addGNBSelectOption(gnbId, menuName) {
		var gnbSelectOption = createSelectOption(gnbId, menuName);
		console.log("gnb select option : " + gnbSelectOption );
		$("#gnbSelector").append(gnbSelectOption);
	}
	
	function addLNBSelectOption(lnbId, menuName) {
		var lnbSelectOption = createSelectOption(lnbId, menuName);
		console.log("lnb select option : " + lnbSelectOption );
		$("#lnbSelector").append(lnbSelectOption);
	}	
	
	function createSelectOption( id, menuName ) {
		var selectOptionTemplate = "<option value=#[menuId]>#[menuName]</option>";
		var selectOption = $(selectOptionTemplate.replace(/#\[menuId\]/g,
				id).replace(/#\[menuName\]/g, menuName));
		
		return selectOption;
	}
	
	function deleteLNBSelectOption() {
		$("#lnbSelector").children().each( 
			function() {
				$(this).remove();
			}		
		); 		
	}
	
	function getLnbList( gnbId ) {
		deleteLNBSelectOption();
		<c:url var="lnbRestURI" value="/board/menu/gnb/" />
		var lnbResourceURI = "${lnbRestURI}" + gnbId + "/lnb";
		console.log( "lnbResourceURI : " + lnbResourceURI );
		$.getJSON( lnbResourceURI ,'',
			function( lnbList ) {
				console.log("iamcalled");
				$.each( lnbList, 
					function( lnbIdx, lnbInfo) {
						addLNBSelectOption( lnbInfo.cDVal, lnbInfo.cDName );						
					}
				);
			}
		);
	}
	

	$(function() {
		
		<c:forEach var="gnbMenu" items="${boardGNB}">
			addGNBSelectOption("${gnbMenu.cDVal}", "${gnbMenu.cDName}");
		</c:forEach>

		<c:url var="loginUrl" value="/boardList.action" />
		$("#goToList").button().click(
			function(){ 
				window.location = "${loginUrl}";
				console.log('goToList Button clicked');
			}
		);
		
		$("#gnbSelector").change(
			function(){
				getLnbList( $("#gnbSelector option:selected").val() )
			}
		);	
		
		$("#lnbSelector").change( 
			function() {
				var selectedLnb = $(this).val();
				$('#selectedLnb').val(selectedLnb);
			}	
		);
		
	});
</script>
</head>
<body>
	<sec:authorize access="isAuthenticated()">
		<sec:authentication property="principal.username"/>
		<c:url value="/logout" var="logoutURL" />
		<a href="${logoutURL}">Log Out</a>
	</sec:authorize>
	
	<div id="menu">
		<div id="gnb">
			<label>gnb</label>
			<select id="gnbSelector">
			
			</select>
		</div>
		<div id="lnb">
			<label>lnb</label>
			<select id="lnbSelector">
			</select>
		</div>
	</div>
	<div id="article">
		<form action="<c:url value='/submitArticle.action' />" method="post">
			<input type="hidden" id="selectedLnb" name="catetoryID" />
			<label>제목</label>
			<input id="title" name="subject" type="text" />
		
			<textarea id="content" name="content" style="width:300px; height:150px;"></textarea>
			<br />
			<button id="goToList">목록으로</button>
			<input type="submit" value="작성완료" />	
			
		</form>
	</div>
	
	
	<!-- 
	<div id="log">
		boardGNB :
		<c:forEach var="gnbMenu" items="${boardGNB}">
			[${gnbMenu.cDKindID}/${gnbMenu.cDVal} &nbsp; : &nbsp; ${gnbMenu.cDName}] 
		</c:forEach>
		<br /> boardLNB :
		<c:forEach var="lnbMenu" items="${boardLNB}">
			[${lnbMenu.cDKindID}/${lnbMenu.cDVal} &nbsp; : &nbsp; ${lnbMenu.cDName}]
		</c:forEach>
		<br /> 
		
		
		boardContent : ${boardContent.articleList} <br /> 
		selectedMenu : ${selectedMenu} <br />
	</div>
 -->
</body>
</html>





