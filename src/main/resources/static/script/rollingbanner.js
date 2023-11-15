/**
 * 
 */

 $(document).ready(function() {
		let $banner = $(".banner").find("ul");

		let $bannerWidth = $banner.children().outerWidth();//이미지의 폭
		let $bannerHeight = $banner.children().outerHeight(); // 높이
		let $length = $banner.children().length;//이미지의 갯수
		let rollingId;

		//정해진 초마다 함수 실행
		rollingId = setInterval(function() { rollingStart(); }, 6000);//다음 이미지로 롤링 애니메이션 할 시간차
    
		function rollingStart() {
			$banner.css("width", $bannerWidth * $length + "px");
			$banner.css("height", $bannerHeight + "px");
			//alert(bannerHeight);
			//배너의 좌측 위치를 옮겨 준다.
			$banner.animate({left: - $bannerWidth + "px"}, 1500, function() { //숫자는 롤링 진행되는 시간이다.
				//첫번째 이미지를 마지막 끝에 복사(이동이 아니라 복사)해서 추가한다.
				$(this).append("<li>" + $(this).find("li:first").html() + "</li>");
				//뒤로 복사된 첫번재 이미지는 필요 없으니 삭제한다.
				$(this).find("li:first").remove();
				//다음 움직임을 위해서 배너 좌측의 위치값을 초기화 한다.
				$(this).css("left", 0);
				//이 과정을 반복하면서 계속 롤링하는 배너를 만들 수 있다.
			});
		}
		
		window.addEventListener("wheel", function(e){
		    e.preventDefault();
		},{passive : false});
		
		let mHtml = $("html");
		let page = 1;
		
		
		mHtml.animate({scrollTop : 0},10);
		
		$(window).on("wheel", function(e) {
		    if(mHtml.is(":animated")) return;
		    if(e.originalEvent.deltaY > 0) {
		        if(page == 12) return;
		        page++;
		    } else if(e.originalEvent.deltaY < 0) {
		        if(page == 1) return;
		        page--;
		    }
		    var posTop =(page-1) * 800;
		    mHtml.animate({scrollTop : posTop});
		})
	
	}); 