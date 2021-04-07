<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 헤더 -->
<%@ include file="layout/header.jsp" %>
<!-- 헤더 -->


<!-- 메인 -->
<div class="container">

<c:forEach var="board" items="${boards}">
	<div class="card m-2">
	  <div class="card-body">
	    <h4 class="card-title">${board.title}</h4>
	    <a href="#" class="btn btn-primary">상세</a>
	  </div>
	</div>
</c:forEach>	 
</div>
<!-- 메인 -->



<!-- 푸터 -->
<%@ include file="layout/footer.jsp" %>
<!-- 푸터 -->
