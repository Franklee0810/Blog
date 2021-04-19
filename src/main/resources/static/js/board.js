let index = {
	init:function() {
		$("#btn-save").on("click", ()=>{ 
			this.save();
		});
		
		$("#btn-delete").on("click", ()=>{ 
			this.deleteById();
		});
		
		$("#btn-update").on("click", ()=>{ 
			this.update();
		});
		$("#btn-reply-save").on("click", ()=>{ 
			this.replySave();
		});
		 
	},

	save:function() {
		let data = {
			title : $("#title").val(),
			content : $("#content").val(),
		};
		
		//console.log(data);
		
		
		$.ajax({
			type:"POST",
			url:"/api/board",
			data:JSON.stringify(data), //http body 데이터 
			contentType:"application/json;charset=utf-8", //바디 데이터 타입
			dataType:"json" //응답 서버로 올때 기본적으로 모든것이 문자열로 오는데, 이렇게 작성하면 자바스크립트 오브젝트로 변경한다는 것
		}).done(function(resp){
			console.log(resp);
			alert("글 작성 완료");
			location.href="/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); //ajax통신으로 데이터 json 변경하고 insert요청 
		
	},
	
	deleteById:function() {
		let id = $("#id").val();
		
		$.ajax({
			type:"DELETE",
			url:"/api/board/"+id, 
			dataType:"json" //응답 서버로 올때 기본적으로 모든것이 문자열로 오는데, 이렇게 작성하면 자바스크립트 오브젝트로 변경한다는 것
		}).done(function(resp){ 
			alert("글 삭제 완료");
			location.href="/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		});  
		
	},
	
	update:function() {
		
		let id = $("#id").val();
	
		let data = {
			title : $("#title").val(),
			content : $("#content").val(),
		};
	
		
		$.ajax({
			type:"PUT",
			url:"/api/board/"+id,
			data:JSON.stringify(data),  
			contentType:"application/json;charset=utf-8", 
			dataType:"json" 
		}).done(function(resp){
			console.log(resp);
			alert("글 수정 완료");
			location.href="/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		});  
		
	},
	
	replySave:function() {
		let data = {  
			content : $("#reply-content").val()
		};
		let boardId = $("#boardId").val();
		
		$.ajax({
			type:"POST",
			url:`/api/board/${boardId}/reply`,
			data:JSON.stringify(data), //http body 데이터 
			contentType:"application/json;charset=utf-8", //바디 데이터 타입
			dataType:"json" //응답 서버로 올때 기본적으로 모든것이 문자열로 오는데, 이렇게 작성하면 자바스크립트 오브젝트로 변경한다는 것
		}).done(function(resp){
			console.log(resp);
			alert("댓글 작성 완료");
			location.href=`/board/${boardId}`;
		}).fail(function(error){
			alert(JSON.stringify(error));
		});  
		
	},
	
	replyDelete:function(boardId, replyId) {
		 
		$.ajax({
			type:"DELETE",
			url:`/api/board/${boardId}/reply/${replyId}`,  
			dataType:"json"  
		}).done(function(resp){
			console.log(resp);
			alert("댓글 삭제 완료");
			location.href=`/board/${boardId}`;
		}).fail(function(error){
			alert(JSON.stringify(error));
		});  
		
	},
	
}

index.init();