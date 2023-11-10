/**
 * 
 */
$().ready(function(){
	var idchk=1;	
 	var pcheck = true;	//두개가 다르면 true,같으면 false
	
		$('#idSearch').on('click', function(){		/*아이디 찾기*/
			var flen = $("form[name=idSearchForm] .idSearchChk").length;
		 	for(var i=0; i<flen; i++){
			if($('.idSearchChk').eq(i).val()=="" ||
		       $('.idSearchChk').eq(i).val()==null ||
		       $('.idSearchChk').eq(i).val().trim()==""){						// trim() 공백제거
			  alert($('.idSearchChk').eq(i).attr('title')+'를 입력하시오.');
			  $('.idSearchChk').eq(i).focus();
			  return false;
			}
		   }
		    $("form[name=idSearchForm]").submit();
		});
		
		$('#password, #cpassword').keyup(function(){				// 비밀번호 확인
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
	  
		$('#pwChange').on('click', function(){		/*비밀번호 재설정*/
			var flen = $("form[name=pwSearchForm] .pwSearchChk").length;
		 	for(var i=0; i<flen; i++){									
			if($('.pwSearchChk').eq(i).val()=="" ||
		       $('.pwSearchChk').eq(i).val()==null ||
		       $('.pwSearchChk').eq(i).val().trim()==""){
			  alert($('.pwSearchChk').eq(i).attr('title')+'를 입력하시오.');
			  $('.pwSearchChk').eq(i).focus();
			  return false;
			}
		   }
		    if(pcheck){										// 비밀번호 비교
				alert("비밀번호가 다릅니다.");
			}else{
			  $("form[name=pwSearchForm]").submit();			// 비밀번호 수정 완료 버튼
			}
		});		
	});	/*READY END*/
	
		