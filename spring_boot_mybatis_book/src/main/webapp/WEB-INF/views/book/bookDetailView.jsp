<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<style>
	td{
		padding:0 5px;
	}
</style>
<html>
	<head>
		<meta charset="UTF-8">
		<title>도서 상세 정보 조회</title>
	</head>
	<body>
		<h3>도서 상세 정보 조회</h3>
		<table border=1>
		<tr>
			<th>도서 번호</th>
			<td>${vo.bookNo }</td>
		</tr>
		<tr>
			<th>도서명</th>
			<td>${vo.bookName }</td>
		</tr>
		<tr>
			<th>저자</th>
			<td>${vo.bookAuthor }</td>
		</tr>
		<tr>
			<th>가격</th>
			<td>${vo.bookPrice }</td>
		</tr>
		<tr>
			<th>출판일</th>
			<td><fmt:formatDate value="${vo.bookDate }" pattern="yyyy-MM-dd"/></td>
		</tr>
		<tr>
			<th>재고</th>
			<td>${vo.bookStock }</td>
		</tr>
		<tr>
			<th>출판사 번호</th>
			<td>${vo.pubNo }</td>
		</tr>
		</table>
		<br>
		<a href="<c:url value='/book/listAllBook'/>">[전체 도서 조회]</a><br>
		<a href="<c:url value='/book/updateBookForm/${vo.bookNo}'/>">[도서 정보 수정]</a><br>
		<a href="javascript:deleteCheck();">[도서 정보 삭제]</a><br>
		
		<script>
		  function deleteCheck(){
			  let answer = confirm("삭제하시겠습니까?");
			  
			  if(answer){
				  location.href = "/book/deleteBook/${vo.bookNo}";
			  }
		  }
		</script>
		<a href="<c:url value='/' />">[홈으로 이동]</a>
	</body>
</html>