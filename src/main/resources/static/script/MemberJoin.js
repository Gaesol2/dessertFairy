$().ready(function(){
	
		$('.m_join').on("click", function(){
			alert(11);
			if(validate()){
			 if(idchk==1){
				alert('아이디 중복\n다시 해주세요')
				$('#idchk').focus();
				 return false;
			    }
			    
			  if(pcheck){
				 alert('패스워드가 다릅니다.');
				 return false;
			  }  
				$('form').submit();
			}
		});
   // 		
 
});