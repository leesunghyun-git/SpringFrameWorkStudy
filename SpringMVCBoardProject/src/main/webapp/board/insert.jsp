<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
	margin-top: 50px;
}
.row{
	width:800px;
	margin:0px auto;
}
</style>
</head>
<body>
	<div class="container">
		<h3 class="text-center">글 쓰기</h3>
		<div class="row">
			<form action="insert_ok.do" method="post">
			<table class="table">
				<tr>
					<th class="text-cetner" width=20%>이름</th>
					<td width=80%><input type="text" name="name" size=20 class="input-sm" required="required"></td>
				</tr>
				<tr>
					<th class="text-cetner" width=20%>제목</th>
					<td width=80%><input type="text" name="subject" size=50 class="input-sm" required></td>
				</tr>
				<tr>
					<th class="text-cetner" width=20%>내용</th>
					<td width=80%><textarea name="content" rows="10" cols="50" style="resize: none;" required></textarea></td>
				</tr>
				<tr>
					<th class="text-cetner" width=20%>비밀번호</th>
					<td width=80%><input type="password" name="pwd" size=10 class="input-sm" required></td>
				</tr>
				<tr>
					<td colspan="2" class="text-center">
					<button type="submit" class="btn btn-sm btn-warning">글쓰기</button>
					<button type="button" class="btn btn-sm btn-danger" onclick="javascript:history.back()">취소</button>
					</td> 
				</tr>
			</table>
			</form>
		</div>
	</div>
</body>
</html>