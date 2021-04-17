<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 헤더 -->
<%@ include file="../layout/header.jsp" %>
<!-- 헤더 -->


<!-- 메인 -->
<div class="container">
	<form>
	<input type="hidden" id="id" value="${principal.user.id}"/>
	  <div class="form-group">
	    <label for="username">아이디</label>
	    <input type="text" value="${principal.user.username}" class="form-control" placeholder="이름 입력하세요" id="username" readonly>
	  </div>
	
	
	<c:if test="${empty principal.user.oauth}">
	  <div class="form-group">
	    <label for="password">패스워드</label>
	    <input type="password" class="form-control" placeholder="비밀번호 입력하세요" id="password">
	  </div>
	</c:if>
	  
	  <div class="form-group">
	    <label for="email">이메일</label>
	    <input type="email" value="${principal.user.email}" class="form-control" placeholder="이메일 입력하세요" id="email" readonly>
	  </div>
	 
	</form>
	<button id="btn-update" class="btn btn-primary">회원수정</button>
	 
</div>
<!-- 메인 -->

<script src="/js/user.js"></script>

<!-- 푸터 -->
<%@ include file="../layout/footer.jsp" %>
<!-- 푸터 -->
