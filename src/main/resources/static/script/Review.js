/**
 * 
 */
$().ready(function(){
   $(".writeSubmit").on("click",function(){
	   if(validate()){
      $("form[name=writeForm]").submit();
      }
   });

	   $('.noticeUp').on('click', function(){
		   $("form[name=topForm1]").attr('action', "/noticeUpForm")
		   $("form[name=topForm1]").submit();
	 });
	 
	   $('.noticeDel').on('click', function(){
		   $("form[name=topForm1]").attr('action', "/noticeProc?flag=delete")
		   $("form[name=topForm1]").submit();
	 });
   });

//chk에 대해서 점검
function validate(){
	  var flen = $("form[name=writeForm] .chkb").length;
	  for(var i = 0; i < flen; i++){
		  if( $('.chkb').eq(i).val()=="" || 
		      $('.chkb').eq(i).val()==null ||
		      $('.chkb').eq(i).val().trim()==""){
		   alert($('.chkb').eq(i).attr('title') + '은/는 필수 입력');
		   $('.chkb').eq(i).focus();
		   return false;
		  }  
	  }
	  return true;
}

