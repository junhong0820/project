/**
 * bookNoCheck1.js 
 * ajax get 요청 방식 사용
 */
 
 $(document).ready(function() {
 	
 	//중복조회 버튼 클릭 이벤트 연결
 	$('#bookNoCheckBtn').on('click', function(){
 		event.preventDefault();
 		
 		let bookNo = $('#bookNo').val();
 		
 		if(bookNo == "") {
 			alert("도서번호를 입력하세요");
 			return false;
 		} else {
 			//get방식 ajax 요청 : data:는 사용하지 않음, data는 url에 포함시켜서 전송
 			$.ajax({
 				type:"get",
 				url:"/book/book/bookNoCheck1/"+bookNo, ///book/book/bookNoCheck1/1001
 				dataType:'text', //반환 데이터 타입
 				success:function(result){
 					if(result=="available"){
 						alert("사용가능한 번호입니다.");
 					}else {
 						alert("사용할 수 없는 번호입니다.");
 					}
 				
 				},
 				error:function(){
 					alert("실패");
 				} 			
 			}); //ajax 끝
 		
 		}//else 끝
 	
 	}); //on 끝
 
 });//ready 끝