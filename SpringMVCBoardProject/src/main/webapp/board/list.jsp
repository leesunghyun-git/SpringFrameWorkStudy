<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<h1 class="text-center">게시판</h1>
	<div class="row">
		<table class="table">
			<tr>
				<td><a href="insert.do" class="btn btn-sm btn-warning">새글</a></td>
			</tr>
		</table>
		<table class="table">
			<tr>
				<th width=10% class="text-center">번호</th>
				<th width=45% class="text-center">제목</th>
				<th width=15% class="text-center">이름</th>
				<th width=20% class="text-center">작성일</th>
				<th width=10% class="text-center">조회수</th>
			</tr>
			<c:forEach var="vo" items="${list }">
				<tr style="cursor:pointer;" onclick="javascript:location.href='detail.do?no=${vo.no}'">
				<td width=10% class="text-center">${vo.no }</td>
				<td width=45%>${vo.subject }</td>
				<td width=15% class="text-center">${vo.name }</td>
				<td width=20% class="text-center">${vo.dbday }</td>
				<td width=10% class="text-center">${vo.hit }</td>
				</tr>			
			</c:forEach>
			<tr>
				<td colspan="5" class="text-center">
				<c:if test="${startPage>1 }">
				<a href="list.do?page=${startPage-1}" class="btn btn-sm btn-info">&lt;</a>
				</c:if>
				<c:forEach var="i" begin="${startPage}" end="${endPage }">
				<a href="list.do?page=${i }" class="btn btn-sm btn-${i==curPage?'primary':'info'}">${i}</a>
				</c:forEach>
				<c:if test="${endPage<totalPage }">
				<a href="list.do?page=${endPage+1}" class="btn btn-sm btn-info">&gt;</a>
				</c:if>
				</td>
			</tr>
		</table>
	</div>
</div>
</body>
</html>