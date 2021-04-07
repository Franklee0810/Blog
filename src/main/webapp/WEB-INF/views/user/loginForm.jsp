<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 헤더 -->
<%@ include file="../layout/header.jsp" %>
<!-- 헤더 -->


<!-- 메인 -->
<div class="container">
	<form action="#" method="post">
	  <div class="form-group">
	    <label for="username">아이디</label>
	    <input type="text" name="username" class="form-control" placeholder="이름 입력하세요" id="username">
	  </div>
  
	  <div class="form-group">
	    <label for="password">패스워드</label>
	    <input type="password" name="password" class="form-control" placeholder="비밀번호 입력하세요" id="password">
	  </div>
	
	  <div class="form-group form-check">
	    <label class="form-check-label">
	      <input name="remember" class="form-check-input" type="checkbox"> Remember me 
	    </label>
	  </div> 
	  <button id="btn-login" class="btn btn-primary">로그인</button>
	</form>
	
</div>
<!-- 메인 -->


 <!-- 푸터 -->
<%@ include file="../layout/footer.jsp" %>
<!-- 푸터 -->
