<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 헤더 -->
<%@ include file="../layout/header.jsp" %>
<!-- 헤더 -->


<!-- 메인 -->
<div class="container">
	<form action="/auth/loginProc" method="post">
	  <div class="form-group">
	    <label for="username">아이디</label>
	    <input type="text" name="username" class="form-control" placeholder="이름 입력하세요" id="username">
	  </div>
  
	  <div class="form-group">
	    <label for="password">패스워드</label>
	    <input type="password" name="password" class="form-control" placeholder="비밀번호 입력하세요" id="password"> 
	  </div>
	 
	  <button id="btn-login" class="btn btn-primary">로그인</button>
	  <a href="https://kauth.kakao.com/oauth/authorize?client_id=b90e84953a8733902015e04084c684b5&redirect_uri=http://localhost:8000/auth/kakao/callback&response_type=code"><img height="38px" src="/image/kakao_login_button.png"/></a> 
	</form>
	
</div>
<!-- 메인 -->


 <!-- 푸터 -->
<%@ include file="../layout/footer.jsp" %>
<!-- 푸터 -->
