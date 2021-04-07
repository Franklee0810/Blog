<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!-- 헤더 -->
<%@ include file="../layout/header.jsp" %>
<!-- 헤더 -->


<!-- 메인 -->
<div class="container"> 
	<button class="btn btn-dark" onclick="history.back()">목록</button>  
	<button id="btn-update" class="btn btn-dark">수정</button>
	
	<c:if test="${board.user.id == principal.user.id}">
		<button id="btn-delete" class="btn btn-dark">삭제</button>
	</c:if>
	<br/><br/>
	
	<div>
		<input type="hidden" id="id" value="${board.id}"/>
		작성자 : <span><i>${board.user.username}</i></span>
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
