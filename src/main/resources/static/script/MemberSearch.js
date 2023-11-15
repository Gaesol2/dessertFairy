/**
 * 
 */
$().ready(function(){
	let idchk=1;
 	let pcheck = true;	//두개가 다르면 true,같으면 false
	
		$('#idSearch').on('click', function(){
		var flen = $("form[name=idSearchForm] .idChk").length;
		for(var i=0; i<flen; i++){
			if($('.idChk').eq(i).val()=="" ||
		       $('.idChk').eq(i).val()==null ||
		       $('.idChk').eq(i).val().trim()==""){
			  alert($('.idChk').eq(i).attr('title')+'를 입력하세요.');
			  $('.idChk').eq(i).focus();
			  return false;
			}
		}
		$("form[name=idSearchForm]").submit();
	});
		// 
	$('#pwChange').on('click', function(){
		var flen = $("form[name=pwChangeForm] .pwChk").length;
		for(var i=0; i<flen; i++){
			if($('.pwChk').eq(i).val()=="" ||
		       $('.pwChk').eq(i).val()==null ||
		       $('.pwChk').eq(i).val().trim()==""){
			  alert($('.pwChk').eq(i).attr('title')+'를 입력하세요.');
			  $('.pwChk').eq(i).focus();
			  return false;
			}
		}
		if(pcheck){
			alert("비밀번호가 일치하지 않습니다.")
		} else {
			$("form[name=pwChangeForm]").submit();
		}
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
   
 	  $('#password').keyup(function(){		// 비밀번호 문자+숫자+특수문자 조합
		 var passwordCombination = /^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*?_]).{8,16}$/;
		 
		 if(!passwordCombination.test($('#password').val())){
			 $('font[id=pcombiCheck]').text(`영문자, 숫자 및 특수문자를 포함하여 8~16글자만 가능합니다.`);
			 pCombiCheck = true;
			}else{
				$('font[id=pcombiCheck]').text('');
				pCombiCheck = false;
			} 
		});
	  
//		$(".btn").click(function(e){
//			//스크롤 변경 방지
//			e.preventDefault();
//		});

		$('.searchBtn').on('click',function(){	
			var flen = $("form[name=pwSearchForm] .searchChk").length;
		 	for(var i=0; i<flen; i++){
			if($('.searchChk').eq(i).val()=="" ||
		       $('.searchChk').eq(i).val()==null ||
		       $('.searchChk').eq(i).val().trim()==""){
			  alert($('.searchChk').eq(i).attr('title')+'를 입력하시오.');
			  $('.searchChk').eq(i).focus();
			  return false;
			}
		   }
		    $("form[name=pwSearchForm]").submit();
		});
		
		
	
		
		
		
		
		
		
		  
	});	/*READY END*/