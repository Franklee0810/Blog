<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!-- 헤더 -->
<%@ include file="../layout/header.jsp" %>
<!-- 헤더 -->


<!-- 메인 -->
<div class="container">
	<form>
	  <input type="hidden" id="id" value="${board.id}"/>
	  <div class="form-group">
	    <input value="${board.title}" type="text" class="form-control" placeholder="제목 입력하세요" id="title">
	  </div>
  
	  <div class="form-group">
 	 	<textarea class="form-control summernote" rows="5" id="content">${board.content}</textarea>
	  </div>
	  
	</form>
	<button id="btn-update" class="btn btn-primary">수정</button>
</div>
<!-- 메인 -->

<!-- 섬머노트 js -->
<script>
$('.summernote').summernote({
  placeholder: '작성하세요~',
  tabsize: 2,
  height: 300
});
</script>
<!-- 섬머노트 js -->

<!-- board.js -->
<script src="/js/board.js"></script>
<!-- board.js -->

<!-- 푸터 -->
<%@ include file="../layout/footer.jsp" %>
<!-- 푸터 -->
