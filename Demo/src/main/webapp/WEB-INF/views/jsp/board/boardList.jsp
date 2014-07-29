<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>jQuery UI Tabs - Simple manipulation</title>
<script src="scripts/jquery-1.11.1.js"></script>
<script src="scripts/jquery-ui-1.11.0.js"></script>
<link rel="stylesheet" href="stylesheets/jquery-ui.css" />
<link rel="stylesheet" href="stylesheets/style.css" />
<link rel="stylesheet" href="stylesheets/base.css" />
<link rel="stylesheet" href="stylesheets/bootstrap.css" />
<link rel="stylesheet" href="stylesheets/custom.css" />
<script>
	$(function() {
		var menuGNBTemplate = "<li id=#[menuId]><a href='boardList.action?gnb=#[selectedGNB]'>#[menuName]</a></li>";
		var menuLNBTemplate = "<li id=#[menuId]><a href='boardList.action?gnb=#[selectedGNB]&lnb=#[selectedLNB]'>#[menuName]</a></li>";

		function addGNBMenu(gnbId, menuName) {
			var menuLi = $(menuGNBTemplate.replace(/#\[menuId\]/g,
					"GNB-" + gnbId).replace(/#\[selectedGNB\]/g, gnbId)
					.replace(/#\[menuName\]/g, menuName));
			$("#menu-global ul").append(menuLi);
		}

		function addLNBMenu(gnbId, lnbId, menuName) {
			var menuLi = $(menuLNBTemplate.replace(/#\[menuId\]/g,
					"LNB-" + lnbId).replace(/#\[selectedGNB\]/g, gnbId)
					.replace(/#\[selectedLNB\]/g, lnbId).replace(
							/#\[menuName\]/g, menuName));
			$("#menu-local ul").append(menuLi);
		}

		function checkSelectedMenu(gnbId, lnbId) {
			var gnbNick = "GNB-" + gnbId;
			var lnbNick = "LNB-" + lnbId;
			$("#" + gnbNick).addClass("current");
			$("#" + lnbNick).addClass("active");

		}

		

		<c:forEach var="gnbMenu" items="${boardGNB}">
		addGNBMenu("${gnbMenu.cDVal}", "${gnbMenu.cDName}");
		</c:forEach>

		<c:forEach var="lnbMenu" items="${boardLNB}">
		addLNBMenu("${selectedMenu.selectedGNBMenuID}", "${lnbMenu.cDVal}",
				"${lnbMenu.cDName}");
		</c:forEach>

		checkSelectedMenu("${selectedMenu.selectedGNBMenuID}",
				"${selectedMenu.selectedLNBMenuID}");

		$("#queryIdealType")
				.button()
				.click(
						
					function() {
						var jsonServerAddrTemplate = "http://localhost:8090/demo/friend/users/#[userId]/idealtype";
						console.log(jsonServerAddrTemplate);
					
						var jsonServerAddr = "http://localhost:8090/demo/friend/users/" + $('#userid').val() + "/idealtype";
						console.log(jsonServerAddr);
						$.getJSON(jsonServerAddr, '',function(idealTypeList) {
							var idealTypeHTML = '';
							console.log("iamcalled");
							idealTypeHTML += 'userID || compliance score<br/>'
							$.each(idealTypeList, function(idealType, idealTypeInfo) {
								idealTypeHTML += idealTypeInfo.userID;
								idealTypeHTML += ' || ' + idealTypeInfo.score + "<br/>";
							});

							$('#idealTypeListBox').html(idealTypeHTML);
						});
						
					}
				);
	});
</script>
</head>
<body>
	<nav id="main" class="constrain clearfix">
	<div id="menu-global" class="menu-top-container">
		<ul id="menu-top" class="menu">
			<!-- content - javascript code -->
		</ul>
	</div>
	</nav>

	<nav class="navbar">
	<div id="menu-local" class="navbar-inner">
		<ul id="menu-top" class="nav">
			<!-- content - javascript code -->
		</ul>
	</div>
	</nav>

	<div id="contents">
		<table class="table table-striped">
			<thread>
			<tr>
				<th>no
					</td>
					<th>subject
						</td>
						<th>creator
							</td>
							<th>date
								</td>
								<th>hits
									</td>
									<th>recommended
										</td>
										<th>category
											</td>
			</tr>
			</thread>
			<tbody>
				<c:forEach var="article" items="${boardContent.articleList}">
					<tr>
						<td>${article.boardID}</td>
						<td><c:url var="articleDetailURL"
								value="/articleDetail.action?boardId=${article.boardID}" /> <a
							href="${articleDetailURL}"> ${article.subject}</a></td>
						<td>${article.creator}</td>
						<td>${article.createDate}</td>
						<td>${article.hitCNT}</td>
						<td>${article.recommendCNT}</td>
						<td><a href="boardList.action?gnb=${article.gnb.cDVal}">${article.gnb.cDName}</a>
							> <a
							href="boardList.action?gnb=${article.gnb.cDVal}&lnb=${article.lnb.cDVal}">${article.lnb.cDName}</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<div id="createArticle">
		<button>new</button>
	</div>

	<div id="idealType">
		<input id="userid" name="userid" type="text" />
		<button id="queryIdealType">이상형</button>
		<div id="idealTypeListBox"></div>
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





