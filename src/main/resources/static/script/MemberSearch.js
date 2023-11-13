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
		
//		$(".btn").click(function(e){
//			//스크롤 변경 방지
//			e.preventDefault();
//		});
		
		$('.submit1').on('click', function(){
		var flen = $("form[name=topForm1] .chk1").length;
		for(var i=0; i<flen; i++){
			if($('.chk1').eq(i).val()=="" ||
		       $('.chk1').eq(i).val()==null ||
		       $('.chk1').eq(i).val().trim()==""){
			  alert($('.chk1').eq(i).attr('title')+'를 입력하세요.');
			  $('.chk1').eq(i).focus();
			  return false;
			}
		}
		$("form[name=topForm1]").submit();
	});
		// 
	$('.submit2').on('click', function(){
		var flen = $("form[name=topForm2] .chk2").length;
		for(var i=0; i<flen; i++){
			if($('.chk2').eq(i).val()=="" ||
		       $('.chk2').eq(i).val()==null ||
		       $('.chk2').eq(i).val().trim()==""){
			  alert($('.chk2').eq(i).attr('title')+'를 입력하세요.');
			  $('.chk2').eq(i).focus();
			  return false;
			}
		}
		if(pcheck){
			alert("비밀번호가 일치하지 않습니다.")
		} else {
			$("form[name=topForm2]").submit();
		}
	}); 
		  
	});	/*READY END*/
	
