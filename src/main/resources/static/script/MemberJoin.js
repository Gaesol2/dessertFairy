$().ready(function(){
	var idchk=1;	
 	var pcheck = true;
 	var pCombiCheck = true;
 	
 	$('.m_join').on("click", function(){		//회원가입
		if(validate()){
			 if(idchk==1){
				alert('아이디 중복\n다시 해주세요')
				$('.idchk').focus();
				 return false;
		    }
		    	if(pCombiCheck){
				 alert('패스워드 형식이 잘못되었습니다.');
				 $('#password').focus();
				 $('font[id=pcombiCheck]').text('');
				 return false;
			  }

			  if(pcheck){
				 alert('패스워드가 다릅니다.');
				 $('#cpassword').focus();
				 return false;
			  }  
				$('form').submit();
			}
		});
		
	$('.idchk').on('propertychange change input paste',function(){
       $.ajax({
		   async:true,
		   type:'post',
		   url:'idCheck',
		   data:{'m_id':$('.idchk').val()},
		   dataType:"json",
		   success:function(data){
			   if(data>0){ //이미 존재하는 id
				  $('font[id=idcheck]').text('');
				  $('font[id=idcheck]').attr('color','red');
				  $('font[id=idcheck]').text('이미 존재하는 아이디 입니다.');
				  $('.idchk').focus();
				 idchk =1; //submit 불가  
			   }else{ //사용가능한 id
				  $('font[id=idcheck]').text('');
				  $('font[id=idcheck]').attr('color','blue');
				  $('font[id=idcheck]').text('사용가능한 아이디 입니다.');
				  $('.idchk').focus();
				 idchk=0; //전송가능 
			   }
		   }
	   });	 
      });	

	 $('#password, #cpassword').keyup(function(){				// 회원가입 비밀번호 확인
	    $('font[id=pcheck]').text('');
	    if($('#password').val()!=$('#cpassword').val()){
			 $('font[id=pcheck]').text('');
			 $('font[id=pcheck]').attr('color','red');
			 $('font[id=pcheck]').text('패스워드 다름');
			 pcheck=true;
		}else{
			 $('font[id=pcheck]').text('');
			  $('font[id=pcheck]').attr('color','#008000');
			 $('font[id=pcheck]').text('패스워드 같음');
			 pcheck=false;
		}
	  });
   
 	  $('#password').keyup(function(){
		 var passwordCombination = /^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*?_]).{8,16}$/;
		 
		 if(!passwordCombination.test($('#password').val())){
			 $('font[id=pcombiCheck]').text('비밀번호는 최소 8자에서 16자까지, 영문자, 숫자 및 특수 문자를 포함해야 합니다.');
			 pCombiCheck = true;
			}else{
				$('font[id=pcombiCheck]').text('');
				pCombiCheck = false;
			} 
		});
	  
});		// ready END

//chk에 대해서 점검
	function validate(){
		var flen = $("form[name=joinForm] .chk").length;
		for(var i=0; i<flen; i++){
			if($('.chk').eq(i).val()=="" ||
		       $('.chk').eq(i).val()==null ||
		       $('.chk').eq(i).val().trim()==""){
			  alert($('.chk').eq(i).attr('title')+'은/는 필수입력');
			  $('.chk').eq(i).focus();
			  return false;
			}
		 }
		var str = document.joinForm.m_email.value;
		var atPos = str.indexOf('@');
		var atLastPos = str.lastIndexOf('@');
		var dotPos = str.indexOf('.');
		var spacePos=str.indexOf(' ')
		var commaPos=str.indexOf(',')
		var eMailSize = str.length;
		if(!(atPos > 1 && atPos==atLastPos && 
		    dotPos> 3 && spacePos==-1 && commaPos ==-1 &&
		    atPos+1<dotPos && dotPos+1 <eMailSize)){
			alert('Email 주소 형식이 잘못되었습니다.\n다시 입력해 주시오.') 
			document.joinForm.m_email.focus();
			return false;
		   }
		return true;
	}