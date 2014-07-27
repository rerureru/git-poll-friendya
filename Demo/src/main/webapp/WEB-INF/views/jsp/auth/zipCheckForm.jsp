<%@ page contentType="text/html;charset=euc-kr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head><title>우편번호검색</title><link href="style/style.css" rel="stylesheet" type="text/css">

</head>
<body style="background-color:#FFFFCC">
<div style="text-align:center">
	<b>우편번호 찾기</b>
	<table>
	<tr>
		<td>
			<br>
			동이름 입력 : <input name="dong" id="dong" type="text">
			<input type="button" value="검색" onclick="" >
		</td>
	</tr>
	
	<tr><td align="center"><br>검색된 결과가 없습니다.</td></tr>
		
	<tr><td align="center"><br>※검색 후, 아래 우편번호를 클릭하면 자동으로 입력됩니다.</td></tr>
	<tr>
		<td>
		</td>
	</tr>
	</table>
</div>
</body>
</html>