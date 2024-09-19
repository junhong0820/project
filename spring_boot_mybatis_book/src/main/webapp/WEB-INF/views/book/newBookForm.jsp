<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>bookForm</title>
		<script src="<c:url value='/js/jquery-3.7.1.min.js'/>"></script>
		<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
		<%-- <script src="<c:url value='/js/bookNoCheck.js'/>"></script> --%>
		<%-- <script src="<c:url value='/js/bookNoCheck1.js'/>"></script> --%>
		<%-- <script src="<c:url value='/js/bookNoCheck2.js'/>"></script> --%>
		<%-- <script src="<c:url value='/js/bookNoCheck3.js'/>"></script> --%>
		<%-- <script src="<c:url value='/js/bookNoCheck4.js'/>"></script> --%>
		<script src="<c:url value='/js/bookNoCheck5.js'/>"></script>
	</head>
	<body>
		<h3>도서 정보 등록</h3>
		<form method="post" action="<c:url value='/book/insertBook'/>">
		  <table>
		    <tr><td>도서번호</td><td><input type="text" name="bookNo" id="bookNo">
		    					  <button id="bookNoCheckBtn" name="bookNoCheckBtn">중복확인</button>
		    </td></tr>
		    <tr><td>도서명</td><td><input type="text" name="bookName"></td></tr>
		    <tr><td>저자</td><td><input type="text" name="bookAuthor"></td></tr>
		    <tr><td>가격</td><td><input type="text" name="bookPrice"></td></tr>
		    <tr><td>출판일</td><td><input type="text" name="bookDate"></td></tr>
		    <tr><td>재고</td><td><input type="text" name="bookStock"></td></tr>
		    <tr><td>출판사번호</td><td><input type="text" name="pubNo"></td></tr>
		    <tr><td colspan="2"><input type="submit" value="등록">
				<input type="reset" value="취소"></td></tr>
		  </table>			
		</form><br><br>
		
		<a href="<c:url value='/book/listAllBook' />">[전체 도서 조회]</a><br>
		<a href="<c:url value='/' />">[홈으로 이동]</a>
	</body>
</html>