/**
 * 
 */
$().ready(function(){

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

  $('.productUpBtn').on('click',function(){					// 필수입력 알림창
		var flen = $("form[name=productUpForm] .chk1").length;
	 	for(var i=0; i<flen; i++){
			if($('.chk1').eq(i).val()=="" ||
		       $('.chk1').eq(i).val()==null ||
		       $('.chk1').eq(i).val().trim()==""){						// trim() 공백제거
			  	alert($('.chk1').eq(i).attr('title')+'를 입력하시오.');
			  	$('.chk1').eq(i).focus();
			  	
			  	return false;
			}
	   	}
	    	$("form[name=productUpForm]").submit();
	});
		
	$('.productUp').on('click',function(){
		$('form[name=productDetailForm]').attr('action','productUpForm');
		$('form[name=productDetailForm]').submit();
	});
	
	$('.productDel').on('click',function(){			//상품 삭제
	  dno = $('input[name=d_no]').val();
	 $.ajax({
		   async:true,
		   type:'post',
		   data:{"d_no":dno
		         },
		   url: 'orderCntOfProduct',
		   dataType:"json",
		   success : function(cnt) {
			 if(cnt>0){
				 alert('주문내역이 존재합니다.\n 삭제 불가');
				 return false;
			  }else{
				  r = confirm('삭제하시겠습니까?');
				 if(r){
					  $('form[name=productDetailForm]').attr('action','/productMgtProc?flag=delete');
     				  $('form[name=productDetailForm]').submit();
				 }else{
					 return false
				 }
			  }
				 
		     }
	   });
  });
	
});		//ready end