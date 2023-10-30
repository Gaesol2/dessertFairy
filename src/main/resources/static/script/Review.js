/**
 * 
 */
$().ready(function(){
	$(".writeSubmit").on("click",function(){
		$("form[name=writeForm]").submit();
	})
})