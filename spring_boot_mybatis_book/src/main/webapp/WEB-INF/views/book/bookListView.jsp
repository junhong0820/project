<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h3>전체 도서 조회</h3>
		<table border="1" width ="600">
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
			<c:forEach items="${bookList }" var="book">
			<tr>
				<td><a href="<c:url value='/book/detailViewBook/${book.bookNo}' />">${book.bookNo}</a></td>
				<td>${book.bookName}</td>
				<td>${book.bookAuthor}</td>
				<td>${book.bookPrice}</td>
				<td><fmt:formatDate value="${book.bookDate}" pattern="YYYY-MM-dd" /></td>
				<td>${book.bookStock}</td>
				<td>${book.pubNo}</td>
				<td>
				  <img src="<c:url value='/book_img/${book.bookNo}.jpg' />" width="30" height="20">				  
				</td>
			</tr>
			</c:forEach>	 		
		</table><br><br>
		
		<a href="<c:url value='/' />">홈으로 이동</a>
	</body>
</html>