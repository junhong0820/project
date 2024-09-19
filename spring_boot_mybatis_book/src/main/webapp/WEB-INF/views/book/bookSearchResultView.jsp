<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>도서 검색 결과 출력</title>		 
	</head>
	<body>
		<h3>도서 검색 결과</h3>		
		<table border="1" width="600">
			<tr>
				<th>도서번호</th>
				<th>도서명</th>
				<th>작가</th>
				<th>가격</th>
				<th>출판일</th>
				<th>재고</th>
				<th>출판사번호</th>
				<th>사진</th>
			</tr>
			
			<!-- 반복문 사용해서 모든 데이터 출력 -->
			<!-- 상품번호에 링크 설정 : /book/detailViewBook -->
			<!-- 날짜 포맷 설정 : 2024-05-10 형식 -->
			
			<c:choose>
				<c:when test="${empty bookList}">
					<tr align="center">
						<td colspan="8">찾는 도서가 없습니다</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="book" items="${bookList}">
						<tr>
						<td><a href="<c:url value='/book/detailViewBook/${book.bookNo}'/>">${book.bookNo}</a></td>
						<td>${book.bookName}</td>
						<td>${book.bookAuthor}</td>
						<td>${book.bookPrice}</td>
						<td><fmt:formatDate pattern="yyyy-MM-dd" value="${book.bookDate}"/></td>
						<td>${book.bookStock}</td>
						<td>${book.pubNo}</td>
						<td><img src="<c:url value='/book_images/${book.bookNo}.jpg'/>" width="30" height="20"/></td>
						</tr>
					</c:forEach>				
				</c:otherwise>			
			</c:choose>
			</table>

</body>
</html>