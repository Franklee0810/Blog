let index = {
	init:function() {
		$("#btn-save").on("click", ()=>{
			this.save();
		});
	},

	save:function() {
		//alert("user의 save함수 실행됨");
		let data = {
			username : $("#username").val(),
			password : $("#password").val(),
			email : $("#email").val()
		}
		
		//console.log(data);
		
		$.ajax().done().fail(); //ajax통신으로 데이터 json 변경하고 insert요청 
		
	}
}

index.init();