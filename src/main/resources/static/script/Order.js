/**
 * 
 */

   function orderDetail(obj){
	var ono = $(obj).closest('tr').find('input[name=o_no]').val();
	var dno = $(obj).closest('tr').find('input[name=d_no]').val();
	var mId = $(obj).closest('tr').find('input[name=m_id]').val();
	 $('form[name=orform] input[name=o_no]').val(ono);
	 $('form[name=orform] input[name=d_no]').val(dno);
	 $('form[name=orform] input[name=m_id]').val(memId);
	 $('form[name=orform]').submit();
   }
   
   $(function(){
	   //배송관련 상태
	   $("#state"+'${i.count}').val('${order.o_state}')
   })