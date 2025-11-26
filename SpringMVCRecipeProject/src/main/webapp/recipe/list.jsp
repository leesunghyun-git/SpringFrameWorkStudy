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
	width:1400px;
	margin:0px auto;
}
p {
overflow: hideen;
white-space: nowrap;
text-overflow: ellipsis;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<c:forEach var="vo" items="${list }">
				<div class="col-md-3">
				    <div class="thumbnail">
				      <a href="#">
				        <img src="${vo.poster }" alt="Lights" style="width:250px;height:250px;" title="${vo.chef }">
				        <div class="caption">
				          <p>${vo.title }</p>
				        </div>
				      </a>
				    </div>
				  </div>
			</c:forEach>
		</div>
		<div class="row">
			<table class="table">
				<tr>
					<td class="text-center">
					<c:if test="${startPage>1 }">
						<a href="list.do?page=${startPage-1 }" class="btn btn-sm btn-info">&lt;</a>
					</c:if>
					<c:forEach var="i" begin="${startPage }" end="${endPage }">
						<a href="list.do?page=${i }" class="btn btn-sm btn-${i==curPage?'primary':'info' }">${i}</a>
					</c:forEach>
					<c:if test="${endPage<totalPage }">
						<a href="list.do?page=${endPage+1 }" class="btn btn-sm btn-info">&gt;</a>
					</c:if>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>