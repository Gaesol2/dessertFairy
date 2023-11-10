/**
 * 
 */

	$().ready(function(){
		alert(1);
	   $(".conSubmit").on("click",function(){
		   alert(2);
		   if(validate()){
	      $("form[name=conForm]").submit();
	      }
		alert(11111);
	   });
	
		 
	   });//ready 끝
	   
	   window.load(function(){
		   alert(1);
	   })

  
//chk에 대해서 점검
function validate(){
	  var flen = $("form[name=conForm] .chkc").length;
	  for(var i = 0; i < flen; i++){
		  if( $('.chkc').eq(i).val()=="" || 
		      $('.chkc').eq(i).val()==null ||
		      $('.chkc').eq(i).val().trim()==""){
		   alert($('.chkc').eq(i).attr('title') + '은/는 필수 입력');
		   $('.chkc').eq(i).focus();
		   return false;
		  }  
	  }
	  return true;
}