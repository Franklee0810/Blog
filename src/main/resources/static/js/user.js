let index = {
	init:function() {
		$("#btn-save").on("click", ()=>{ 
			this.save();
		});
		$("#btn-update").on("click", ()=>{ 
			this.update();
		});
	},

	save:function() {
		//alert("user의 save함수 실행됨");
		let data = {
			username : $("#username").val(),
			password : $("#password").val(),
			email : $("#email").val()
		};
		
		//console.log(data);
		
		
		$.ajax({
			type:"POST",
			url:"/auth/joinProc",
			data:JSON.stringify(data), //http body 데이터 
			contentType:"application/json;charset=utf-8", //바디 데이터 타입
			dataType:"json" //응답 서버로 올때 기본적으로 모든것이 문자열로 오는데, 이렇게 작성하면 자바스크립트 오브젝트로 변경한다는 것
		}).done(function(resp){
			console.log(resp);
			alert("회원가입 완료");
			location.href="/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); //ajax통신으로 데이터 json 변경하고 insert요청 
		
	},
	
	update:function() {
		 
		let data = { 
			id : $("#id").val(),
			username : $("#username").val(),
			password : $("#password").val(),
			email : $("#email").val()
		};
		
		
		
		$.ajax({
			type:"PUT",
			url:"/user",
			data:JSON.stringify(data), //http body 데이터 
			contentType:"application/json;charset=utf-8", //바디 데이터 타입
			dataType:"json" //응답 서버로 올때 기본적으로 모든것이 문자열로 오는데, 이렇게 작성하면 자바스크립트 오브젝트로 변경한다는 것
		}).done(function(resp){
			console.log(resp);
			alert("회원수정 완료");
			location.href="/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); //ajax통신으로 데이터 json 변경하고 insert요청 
		
	},
	
}

index.init();