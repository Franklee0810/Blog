<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 헤더 -->
<%@ include file="../layout/header.jsp" %>
<!-- 헤더 -->


<!-- 메인 -->
<div class="container">
	<form action="/action_page.php">
	  <div class="form-group">
	    <label for="username">아이디</label>
	    <input type="text" class="form-control" placeholder="이름 입력하세요" id="username">
	  </div>
  
	  <div class="form-group">
	    <label for="password">패스워드</label>
	    <input type="password" class="form-control" placeholder="비밀번호 입력하세요" id="password">
	  </div>
	
	  <div class="form-group form-check">
	    <label class="form-check-label">
	      <input class="form-check-input" type="checkbox"> Remember me
	    </label>
	  </div>
	  <button type="submit" class="btn btn-primary">로그인 완료</button>
	</form>
	 
</div>
<!-- 메인 -->



<!-- 푸터 -->
<%@ include file="../layout/footer.jsp" %>
<!-- 푸터 -->
