/**
 * 
 */
$().ready(function(){
    var plen = $('.price').length;
 	for(var i=0; i<plen; i++){
	 var p=$('.price').eq(i).text();
	 var to_p = 
	     p.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g,",");
	 $('.price').eq(i).text(to_p);
    }
    
   //select 수정시 자동으로 채크
   $("select[name='o_state']").change(function(){
	   	var tr =$(this).parent().parent();
	   	var td = tr.children();
	   	tr.find(td).find("input[name=check]").prop("checked", true); 
    });
	
  	$(".stateUpBtn").click(function(){ 
			var tdArr = new Array();
			// 체크된 체크박스 값을 가져온다
			var checkbox = $("input[name=check]:checked");
			
			checkbox.each(function(i){
			var tr = checkbox.parent().parent().eq(i);
			var td = tr.children();
			var dno = tr.find(td).find("input[name=d_no]").val();
			var ono = tr.find(td).find("input[name=o_no]").val();
			var mid = tr.find(td).find('input[name=m_id]').val();
			var state = tr.find(td).find("select[name=o_state]").val(); //
				// 가져온 값을 배열에 담는다.
				tdArr.push("o_no:"+ono);
				tdArr.push("d_no:"+dno);
				tdArr.push("m_id:"+mid);
				tdArr.push("o_state:"+state);
			});
			
			  $.ajax({ async:false,
			    type:'post',
			    data:{tdArr
				  },
		       url:"/orderMgtProc",
			   dataType:"json",
			   success:setInterval() /*콜백함수*/
		      }) 
		      
		     function setInterval(){//콜백함수
				//1 . check 박스 지우기
			 	var tr =$("select[name='o_state']").parent().parent();
	   			var td = tr.children();
	   			tr.find(td).find("input[name=check]").prop("checked", false);	
			  } 
			});
			
	$(".orl2").each(function(){
		var rows = $(".orl2:contains('"+$(this).text()+"')");
		
		if(rows.length > 1){
			rows.eq(0).attr("rowspan", rows.length);
			rows.not(":eq(0)").remove();
		}
	});
			
		 
})//ready 끝

   function orderDetail(obj){
	var ono = $(obj).closest('tr').find('input[name=o_no]').val();
	var dno = $(obj).closest('tr').find('input[name=d_no]').val();
	var mid = $(obj).closest('tr').find('input[name=m_id]').val();
	 $('form[name=orDetailForm] input[name=o_no]').val(ono);
	 $('form[name=orDetailForm] input[name=d_no]').val(dno);
	 $('form[name=orDetailForm] input[name=m_id]').val(mid);
	 $('form[name=orDetailForm]').submit();
   }
   