/**
 * 
 */

	// 웹 페이지가 로드되면 buildCalendar 실행
$().ready(function(){
	// 캘린더 띄우기
	buildCalendar();
	
	//파일 업로드 옆에 글씨 띄우기
	$("#file").on("change",function(){
		let arr_fileName = $("input[name='image']").val().split("\\");
		let length_fileName = arr_fileName.length;
		let fileName = arr_fileName[length_fileName-1];
		$("font[class='file_name']").text(fileName);
	})
	
	//케이크 상세 요구사항 입력 창 띄우기
	$("#detail").on("click", function(){
		openWin = window.open("/cakeRequest","CakeRequest",
		"width=600, height=300, toolbar=no, location=no, menubar=no, resizable=no, scrollbars=no")
	})
	
	//빈칸 체크
	 $('.orderBtn').on('click',function(){
			var flen = $("form[name=cakeOrder] .chk").length;
		 	for(var i=0; i<flen; i++){
			if($('.chk').eq(i).val()=="none"){
			  alert($('.chk').eq(i).attr('title')+'를 선택하시오.');
			  return false;
			}
		   }
		    $("form[name='cakeOrder']").submit();
		});
	
	
		//total_price 초기값
		let total_price=21000;
	 
	 //케이크 사이즈 옵션 가격
	 $("select[name='c_size']").on("change",function(){
		 $("select").blur();
		let size = $("select[name='c_size'] > option:selected").val();

		// c_size 이전 select 가격 복구
		if(previous=="도시락") total_price+=5000;	
		else if(previous=="미니") total_price+=3000;
		else if(previous=="1호") total_price=total_price;
		else if(previous=="2호") total_price-=6000;
		else if(previous=="3호") total_price-=11000;
		
		// c_size 새로운 가격 반영
		if(size=="도시락") total_price-=5000;
		else if(size=="미니") total_price-=3000;
		else if(size=="1호") total_price=total_price;
		else if(size=="2호") total_price+=6000;
		else if(size=="3호") total_price+=11000;

		$(".price").text(total_price.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g,","));
		$("input[name='c_price']").val(total_price);
	})
	
	//빵시트 옵션 가격
	 $("select[name='c_sheet']").on("change",function(){
		 $("select").blur();
		let sheet = $("select[name='c_sheet'] > option:selected").val();

		// c_size 이전 select 가격 복구
		if(previous=="초코") total_price-=1000;
		else if(previous=="쿠앤크") total_price-=1500;
		
		// c_sheet 새로운 가격 반영		
		if(sheet=="초코") total_price+=1000;
		else if(sheet=="쿠앤크") total_price+=1500;
		
		$(".price").text(total_price.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g,","));
		$("input[name='c_price']").val(total_price);
	})
	
	 //안크림 옵션 가격
	 $("select[name='c_incream']").on("change",function(){
		 $("select").blur();
		let incream = $("select[name='c_incream'] > option:selected").val();

		// c_size 이전 select 가격 복구
		if(previous=="초코") total_price-=1000;	
		else if(previous=="크림치즈") total_price-=1000;
		else if(previous=="쿠앤크") total_price-=1500;
		
		// c_incream 새로운 가격 반영
		if(incream=="초코") total_price+=1000;
		else if(incream=="크림치즈") total_price+=1000;
		else if(incream=="쿠앤크") total_price+=1500;
		
		$(".price").text(total_price.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g,","));
		$("input[name='c_price']").val(total_price);
	})
	
	 //밖크림 옵션 가격
	 $("select[name='c_outcream']").on("change",function(){
		 $("select").blur();
		let outcream = $("select[name='c_outcream'] > option:selected").val();

		// c_size 이전 select 가격 복구
		if(previous=="초코") total_price-=1000;	
		else if(previous=="크림치즈") total_price-=1000;
		else if(previous=="쿠앤크") total_price-=1500;
		
		if(outcream=="초코") total_price+=1000;
		
		$(".price").text(total_price.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g,","));
		$("input[name='c_price']").val(total_price);
	})
	
	
	//네이버 지도
	var mapOptions = {
    center: new naver.maps.LatLng(37.4310405, 127.1286330),
    zoom: 16
}

	//네이버 지도 객체 생성
	var map = new naver.maps.Map('map', {
	    center: new naver.maps.LatLng(37.4310405, 127.1286330),
	    zoom: 16
	});
	
	//네이버 지도 마커 설정
	var marker = new naver.maps.Marker({
	    position: new naver.maps.LatLng(37.4310405, 127.1286330),
    	map: map
	});

	//마커에 설명 추가
	var HOME_PATH = window.HOME_PATH || '.';

	var dessertFairy = new naver.maps.LatLng(37.4310405, 127.1286330),
	    map = new naver.maps.Map('map', {
	        center: new naver.maps.LatLng(37.4310405, 127.1286330),
	        zoom: 16
	    }),
	    marker = new naver.maps.Marker({
	        map: map,
	        position: dessertFairy
	    });
	
	var contentString = [
	        '<div class="iw_inner">',
	        '   <p><strong>dessertFairy</strong></p>',
	        '   <p>경기도 성남시 성남대로 1133 <br/>',
	        '   </p>',
	        '</div>'
	    ].join('');
	
	var infowindow = new naver.maps.InfoWindow({
	    content: contentString
	});
	
	naver.maps.Event.addListener(marker, "click", function(e) {
	    if (infowindow.getMap()) {
	        infowindow.close();
	    } else {
	        infowindow.open(map, marker);
	    }
	});
	
	infowindow.open(map, marker);

})   // ready end

        let nowMonth = new Date();  // 현재 달을 페이지를 로드한 날의 달로 초기화
        let today = new Date();     // 페이지를 로드한 날짜를 저장
        today.setHours(0, 0, 0, 0);    // 비교 편의를 위해 today의 시간을 초기화

        // 달력 생성 : 해당 달에 맞춰 테이블을 만들고, 날짜를 채워 넣는다.
        function buildCalendar() {

            let firstDate = new Date(nowMonth.getFullYear(), nowMonth.getMonth(), 1);     // 이번달 1일
            let lastDate = new Date(nowMonth.getFullYear(), nowMonth.getMonth() + 1, 0);  // 이번달 마지막날

            let tbody_Calendar = document.querySelector(".Calendar > tbody");
            document.getElementById("calYear").innerText = nowMonth.getFullYear();             // 연도 숫자 갱신
            document.getElementById("calMonth").innerText = leftPad(nowMonth.getMonth() + 1);  // 월 숫자 갱신

            while (tbody_Calendar.rows.length > 0) {                        // 이전 출력결과가 남아있는 경우 초기화
                tbody_Calendar.deleteRow(tbody_Calendar.rows.length - 1);
            }

            let nowRow = tbody_Calendar.insertRow();        // 첫번째 행 추가           

            for (let j = 0; j < firstDate.getDay(); j++) {  // 이번달 1일의 요일만큼
                let nowColumn = nowRow.insertCell();        // 열 추가
            }

            for (let nowDay = firstDate; nowDay <= lastDate; nowDay.setDate(nowDay.getDate() + 1)) {   // day는 날짜를 저장하는 변수, 이번달 마지막날까지 증가시키며 반복  

                let nowColumn = nowRow.insertCell();        // 새 열을 추가하고


                let newDIV = document.createElement("p");
                newDIV.innerHTML = leftPad(nowDay.getDate());        // 추가한 열에 날짜 입력
                nowColumn.appendChild(newDIV);

                if (nowDay.getDay() == 6) {                 // 토요일인 경우
                    nowRow = tbody_Calendar.insertRow();    // 새로운 행 추가
                }

                if (nowDay < today) {                       // 지난날인 경우
                    newDIV.className = "pastDay";
                }
                else if (nowDay.getFullYear() == today.getFullYear() && nowDay.getMonth() == today.getMonth() && nowDay.getDate() == today.getDate()) { // 오늘인 경우           
                    newDIV.className = "today";
                    newDIV.onclick = function () { choiceDate(this); }
                }
                else {                                      // 미래인 경우
                    newDIV.className = "futureDay";
                    newDIV.onclick = function () { choiceDate(this); }
                }
            }
            $("input[name='c_month']").val(nowMonth.getMonth()+1);   // 월 자동 표시
            $("input[name='c_day']").val($(".today").text());   // 일 자동 표시
        }

        // 날짜 선택
        function choiceDate(newDIV) {
            if (document.getElementsByClassName("choiceDay")[0]) {                              // 기존에 선택한 날짜가 있으면
                document.getElementsByClassName("choiceDay")[0].classList.remove("choiceDay");  // 해당 날짜의 "choiceDay" class 제거
            }
            
            newDIV.classList.add("choiceDay");           // 선택된 날짜에 "choiceDay" class 추가
 			$("input[name='c_day']").val($(".choiceDay").text());
        }

        // 이전달 버튼 클릭
        function prevCalendar() {
            nowMonth = new Date(nowMonth.getFullYear(), nowMonth.getMonth() - 1, nowMonth.getDate());   // 현재 달을 1 감소
            let lastDate = new Date(nowMonth.getFullYear(), nowMonth.getMonth() + 1, 0).getDate();  // 이번달 마지막날
            buildCalendar();    // 달력 다시 생성
            $(".day").val(lastDate);
        }
        // 다음달 버튼 클릭
        function nextCalendar() {
            nowMonth = new Date(nowMonth.getFullYear(), nowMonth.getMonth() + 1, nowMonth.getDate());   // 현재 달을 1 증가
            let firstDate = new Date(nowMonth.getFullYear(), nowMonth.getMonth(), 1).getDate();     // 이번달 1일
            buildCalendar();    // 달력 다시 생성
            $(".day").val(firstDate);   // 일 자동 표시
        }

        // input값이 한자리 숫자인 경우 앞에 '0' 붙혀주는 함수
        function leftPad(value) {
            if (value < 10) {
                value = "0" + value;
                return value;
            }
            return value;
        }
        
        function inputMonth(){
			$(".month").val(nowMonth.getMonth()+1);
		}
		
		//케이크 요구사항
		function setCakeText(){
		 let text = $('#cakeRequest textarea').val(); //popup에서 받은 textarea
		 if(text==null || text.length==0){
			 alert('내용을 입력하세요');
			$('#cakeRequest textarea').focus();
			 return false;
		 } else{
			$("input[name='c_request']", opener.document).val(text);
			$(".detail_name", opener.document).text(text);
			this.window.close();
		 }
		
	}
	
	//select 선택 이전 값 불러오기
	 let previous = "";
 	 function size_focus(){previous = $("select[name='c_size']").val();} 
 	 function sheet_focus(){previous = $("select[name='c_sheet']").val();} 
 	 function incream_focus(){previous = $("select[name='c_incream']").val();} 
 	 function outcream_focus(){previous = $("select[name='c_outcream']").val();} 
	