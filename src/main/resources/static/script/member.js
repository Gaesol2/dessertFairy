/**
 * 
 */

 $().ready(function(){
		
	})
	
	function update(flag){
		//패스워드 확인하기
		openWin = window.open("/pwCheck","pwCheak",
		"width=400, height=150, toolbar=no, location=no, menubar=no, resizable=no, scrollbars=no")
		if(flag=='u'){
		 $("#upForm").attr("action", "/memUpForm");
		}else{
		 $("#upForm").attr("action", "/memDelete");	
		var yn = confirm("정말 탈퇴하시겠습니까?\n 구매이력과 포인트가 소멸됩니다.")
		if(yn==false){
			return false;
		}
		 
	}
}
		
		
	function setParentText(){
		 var pw1 = $('#pwck').val() //popup에서 받은 pass
		 if(pw1==null || pw1.length==0){
			 alert('패스워드를 입력하세요')
			$('#pwck').focus();
			 return false;
		 }
		 var pw2 = $("#pw", opener.document).val(); //opener의 pw
		 if(pw1==pw2){
			$("#upForm", opener.document).submit();
			this.window.close();
		}else{
			alert('비밀번호 오류')
			this.window.close();
		}
		
	}
	 