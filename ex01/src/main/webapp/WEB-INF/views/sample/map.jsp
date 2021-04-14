<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"/>
	<title>Kakao 지도 시작하기</title>
</head>
<body>
	<h1>원석깅이의 카카오 지도링~</h1>
	<div id="map" style="width:1000px;height:800px;"></div>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=d6e016ddb84caddc8c080816b4d9e06d"></script>
	<script>
		var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
		var options = { //지도를 생성할 때 필요한 기본 옵션
			center: new kakao.maps.LatLng(37.739297, 127.044853),  // 지도의 중심좌표
			level: 4 // 기본 확대 레벨
		};
	
		var map = new kakao.maps.Map(container, options); // 지도 생성
		
		// 마커를 표시할 위치입니다 
		var position =  new kakao.maps.LatLng(37.739297, 127.044853);
		
		// 마커를 생성합니다
		var marker = new kakao.maps.Marker({
		  position: position,
		  clickable: true // 마커를 클릭했을 때 지도의 클릭 이벤트가 발생하지 않도록 설정합니다
		});
		
		// 아래 코드는 위의 마커를 생성하는 코드에서 clickable: true 와 같이
		// 마커를 클릭했을 때 지도의 클릭 이벤트가 발생하지 않도록 설정합니다
		// marker.setClickable(true);

		// 마커를 지도에 표시합니다.
		marker.setMap(map);

		// 마커를 클릭했을 때 마커 위에 표시할 인포윈도우를 생성합니다
		var iwContent = '<div style="padding:10px;">이젠 컴퓨또로링 학원 <br><a href="/sample/EZEN.do" style="color:blue" target="_blank">QR코드 찍기</a> <a href="https://map.kakao.com/link/to/Hello World!,33.450701,126.570667" style="color:blue" target="_blank">길찾기</a></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
		    iwPosition = new kakao.maps.LatLng(37.739297, 127.044853); //인포윈도우 표시 위치입니다


		    var infowindow = new kakao.maps.InfoWindow({
		        position : iwPosition, 
		        content : iwContent 
		    });

		// 마커에 클릭이벤트를 등록합니다
		kakao.maps.event.addListener(marker, 'click', function() {
		      // 마커 위에 인포윈도우를 표시합니다
		      infowindow.open(map, marker);  
		});
		
		
	</script>
</body>
</html>