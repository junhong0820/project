/**
 * 도서 검색 js
 * ajax post 방식으로 서버에 비동기 요청
 * view 페이지를 응답 데이터로 받아서 현재 페이지에 html로 삽입
 */
 
 $(document).ready(function(){//body내 태그 객체가 모두 준비되어 있는지 확인
 
 	//검색 폼에 submit 이벤트가 발생하면 처리 함수
 	$('#bookSearchFrm2').on('submit', function(){
 
 		event.preventDefault(); //태그 객체의 이벤트 연결 시 반드시 추가
 		
 		//폼에 입력된 모든 데이터 쿼리스트링변환
 		//이 시점 this는 prdSearchFrm1이고 form태그 내 모든 태그객체의 value를 쿼리스트링으로 변환, 태그내 name 속성 필수
 		//연결된 productSearchForm1.jsp를 예시로
 		//한개의 form태그 내 name 속성이 있는 2개의 태그에 대해서 쿼리 스트링 방식으로 데이터 집합을 생성해 줌
 		//type=prdName&keyword=모니터 과 같이 구성해주는 함수
 		let formData = $(this).serialize(); //서버측으로 전송할 예정
 		console.log(formData);
 		//필수 입력값 입력 확인
 		let keyword = $("#keyword").val();
 		let type = $("#type").val();
 		
 		if(keyword == "" || type == ""){
 			alert("검색조건과 검색어 입력하세요");
 		} else {
 		
 			$.ajax({//1.서버와 비동기통신을 이용 서버에 요청하고 2.서버로부터 전달된 데이터 이용해서 현재 페이지의 내용을 변경하는 작업까지 해결함
 				type:"post",
 				url:"/book/book/bookSearch2",
 				data:formData, //formData는 key=value 형식으로 2개 data가 저장됨, 컨트롤러는 HashMap으로 받는게 효율적인
 				success:function(result){ 
 					//view 페이지가 응답데이터로 서버에서 전달되면 html코드로 전달되므로 
 					//현재 html페이지에 전달받은 html 페이지를 삽입
 					$("#searchResultBox").html(result);											
 				},//success 끝
 				error:function(){
 					alert("실패");
 				}
 			});//ajax 끝
 		
 		}//else 끝
 	});//on끝
 	
 });//ready끝