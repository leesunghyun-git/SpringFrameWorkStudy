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
	width:1200px;
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
				      <a href="detail.do?no=${vo.no }">
				        <img src="${vo.poster }" alt="Lights" style="width:250px;height:250px;">
				        <div class="caption">
				          <p>${vo.title }</p>
				          <p>${vo.chef }</p>
				        </div>
				      </a>
				    </div>
				  </div>
			</c:forEach>
		</div>
		<div class="row text-center">
			<ul class="pagination" style="margin-top:20px">
					<c:if test="${startPage>1 }">
						<li><a href="list.do?page=${startPage-1 }">&lt;</a></li>
					</c:if>
					<c:forEach var="i" begin="${startPage }" end="${endPage }">
						<li class="${i==curPage?'active':'' }"><a href="list.do?page=${i }">${i}</a></li>
					</c:forEach>
					<c:if test="${endPage<totalPage }">
						<li><a href="list.do?page=${endPage+1 }">&gt;</a></li>
					</c:if>
			</ul>
		</div>
	</div>
</body>
</html>