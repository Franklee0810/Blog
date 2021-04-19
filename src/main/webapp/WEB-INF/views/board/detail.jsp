<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!-- 헤더 -->
<%@ include file="../layout/header.jsp" %>
<!-- 헤더 -->


<!-- 메인 -->
<div class="container"> 
	
	<button class="btn btn-dark" onclick="history.back()">list</button>  
	
	
	<c:if test="${board.user.id == principal.user.id}">
		<a href="/board/${board.id}/updateForm" class="btn btn-dark">modify</a>
		<button id="btn-delete" class="btn btn-dark">delete</button>
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
  		
  	<!-- 댓글 구현 -->
	<div class="card">
		<form>
			<input type="hidden" id="boardId" value="${board.id}"/>
			<div class="card-body"><textarea id="reply-content" class="form-control" rows="1"></textarea></div>
			<div class="card-footer"><button type="button" id="btn-reply-save" class="btn btn-dark">submit</button></div>
		</form>
	</div>
  	<br>
  	<div class="card">
  		<div class="card-header">review</div>
	  	<ul id="reply--box" class="list-group">
		  	<c:forEach var="reply" items="${board.replys}">
		  		 <li id="reply--1" class="list-group-item d-flex justify-content-between">
			 	<div>${reply.content}</div>
			 	<div class="d-flex">
			 		<div class="font-italic"> username : ${reply.user.username} &nbsp;</div>
			 		<button class="btn btn-dark">delete</button>
			 	</div>
			 </li>
		  	</c:forEach> 
		</ul>
  	</div>
  	
</div>
<!-- 메인 -->
 

<!-- board.js -->
<script src="/js/board.js"></script>
<!-- board.js -->

<!-- 푸터 -->
<%@ include file="../layout/footer.jsp" %>
<!-- 푸터 -->
