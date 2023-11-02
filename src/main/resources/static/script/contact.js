$().ready(function(){
	
	$('.noticeUp').on('click',function(){
		  $("form[name=topForm1]").attr('action', "/noticeUpForm")
          $("form[name=topForm1]").submit();
	  });
	
	$('.noticeDel').on('click',function(){
		  $("form[name=topForm1]").attr('action', "/noticeProc?flag=delete")
          $("form[name=topForm1]").submit();
	  });
	  
});

