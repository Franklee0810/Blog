<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!-- 헤더 -->
<%@ include file="../layout/header.jsp" %>
<!-- 헤더 -->


<!-- 메인 -->
<div class="container"> 
	
	<button class="btn btn-dark" onclick="history.back()">목록</button>  
	
	
	<c:if test="${board.user.id == principal.user.id}">
		<a href="/board/${board.id}/updateForm" class="btn btn-dark">수정</a>
		<button id="btn-delete" class="btn btn-dark">삭제</button>
	</c:if>
	<br/><br/>
	
	<div>
		<input type="hidden" id="id" value="${board.id}"/>
		<div>Username : <i>${board.user.username}</i></div>
		<div>Date : <i>${board.user.createDate}</i></div>
	</div>
	
	<br/>
	  <div>
	    <h3>${board.title}</h3>
	  </div>
  		<hr/>
  		<hr/>
	  <div>
 	 	<div>${board.content}</div>
	  </div>
	  	<hr/>
  		<hr/>  
</div>
<!-- 메인 -->
 

<!-- board.js -->
<script src="/js/board.js"></script>
<!-- board.js -->

<!-- 푸터 -->
<%@ include file="../layout/footer.jsp" %>
<!-- 푸터 -->
