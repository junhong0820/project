/**
 * bookNoCheck.js 
 * ajax post 방식 사용
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
 		
 			$.ajax({
 				type:"post",
 				url:"/book/book/bookNoCheck",
 				data:{"bookNo":bookNo}, //컨트롤러에서 bookNo 이름으로 파라미터 데이터 추출
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