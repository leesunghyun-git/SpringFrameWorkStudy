<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
	margin-top:50px;
	
}
.row{
	margin:0px auto;
	width:600px;
}




</style>
</head>
<body>
	<div class="containter">
		<div class="row">
			<h3 class="text-center">개인 정보</h3>
			<table class="table">
				<tr>
					<td width=15%>이름</td>
					<td width=85%>${vo.name }</td>
				</tr>
				<tr>
					<td width=15%>성별</td>
					<td width=85%>${vo.sex }</td>
				</tr>
				<tr>
					<td width=15%>주소</td>
					<td width=85%>${vo.address }</td>
				</tr>
				<tr>
					<td width=15%>소개</td>
					<td width=85%><textarea rows="5" cols="50" name="content" readonly="readonly">${vo.content }</textarea></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>