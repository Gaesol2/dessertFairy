/**
 * 
 */
$().ready(function(){
   $(".writeSubmit").on("click",function(){
	   if(validate()){
      $("form[name=writeForm]").submit();
      }
   });

	   $('.reviewUp').on('click', function(){
		   $("form[name=reviewForm]").attr('action', "/myUpForm")
		   $("form[name=reviewForm]").submit();
	 });
	 
	   $('.reviewDel').on('click', function(){
		   $("form[name=reviewForm]").attr('action', "/delProc")
		   $("form[name=reviewForm]").submit();
	 });
	 
	 $('.reviewUpdate').on('click', function(){
		   $("form[name=reviewForm]").attr('action', "/upProc")
		   $("form[name=reviewForm]").submit();
	 });
	 
		 let ratingLength = Number($("input[name='ratingLength']").val());
		 if(ratingLength==5) $("#rate1").attr("checked","checked");
		 else if(ratingLength==4) $("#rate2").attr("checked","checked");
		 else if(ratingLength==3) $("#rate3").attr("checked","checked");
		 else if(ratingLength==2) $("#rate4").attr("checked","checked");
		 else $("#rate5").attr("checked","checked");		 
	 
	 
   });//ready 끝

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

//카테고리
function category(){
	let category = $(".category").val();
	if(category=="최신순"){
		location.href="/reviewList?orderby=new";
	}else if(category=="오래된 순"){
		location.href="/reviewList?orderby=old";
	}else if(category=="별점 높은순"){
		location.href="/reviewList?orderby=star";
	}else if(category=="조회수 순"){
		location.href="/reviewList?orderby=read";
	}
	
	
}
