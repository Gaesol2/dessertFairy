/**
 * 
 */

  $('.productInsert').on('click',function(){					// 필수입력 알림창
			var flen = $("form[name=productInsert_Form] .chk1").length;
		 	for(var i=0; i<flen; i++){
			if($('.chk1').eq(i).val()=="" ||
		       $('.chk1').eq(i).val()==null ||
		       $('.chk1').eq(i).val().trim()==""){						// trim() 공백제거
			  alert($('.chk1').eq(i).attr('title')+'를 입력하시오.');
			  $('.chk1').eq(i).focus();
			  return false;
			}
		   }
		    $("form[name=productInsert_Form]").submit();
		});