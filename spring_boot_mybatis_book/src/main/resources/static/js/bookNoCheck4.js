/**
 * bookNoCheck4.js
 * 자바스크립트 내장 함수 axios() get방식: 자바스크립트만 사용해서 예제 구성
 * Promises => 사용
 */
 //윈도우 객체의 onload 이벤트가 발생할때 처리할 함수 구성 후 연결
 //onload 이벤트 발생은 태그 객체가 준비되어 있음
 window.onload = function(){
	let bookNoCheckBtn = document.getElementById("bookNoCheckBtn");
 
 	bookNoCheckBtn.addEventListener("click", () => { 
 		event.preventDefault(); //이벤트 중단
 		
 		let bookNo = document.getElementById("bookNo").value; //사용자가 입력한 도서번호 추출해서 변수에 저장
 		
 		if(bookNo==""){
 			alert("도서번호를 입력하세요");
 		}else{ //도서번호가 입력된 경우
 		
 			axios.get("/book/book/bookNoCheck4/" + bookNo) //서버에게 요청
 				.then(function(response){
 					if(response.data == "available"){
 						alert("사용가능한 번호입니다4.");
 					}else{
 						alert("사용 불가능한 번호입니다4");
 					}
 				})
 				.catch((error)=>{console.log(error.response)});				
 	
 		}//else끝
 	}); //click 끝
 
 }; //onload 끝