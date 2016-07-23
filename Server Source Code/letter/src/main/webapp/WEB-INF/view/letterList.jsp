<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
.button				{ background: black; border: 1px solid #999;
					  -moz-border-radius: 5px; padding: 5px; color: white; font-weight: bold;
					  -webkit-border-radius: 5px; font-size: 13px;  width: 70px; }
.button:hover		{ background: white; color: black; }
</style>
<title>CMS 편지 조회 </title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
</head>
<body>
<h2>편지 목록</h2>
<table border=''>
	
	<thead>
		<tr>
			<th>편지 ID</th>
			<th>받는 이 ID</th>
			<th>받는 이 Name</th>
			<th>보내는 이 ID</th>
			<th>보내는 이 Name</th>
			<th>주소</th>
			<th>내용</th>
			<th>Latitude</th>
			<th>Longitude</th>
			<th>읽음 확인</th>
			<th>날짜</th>
		</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${fn:length(List) > 0}">
				<c:forEach items="${List}" var="row">
					<tr>
						<td>${row.letter_id}</td>
						<td>${row.to_id}</td>
						<td>${row.to_name}</td>
						<td>${row.from_id}</td>
						<td>${row.from_name}</td>
						<td>${row.address}</td>
						<td>${row.content}</td>
						<td>${row.latitude}</td>
						<td>${row.longitude}</td>
						<td>${row.read_state}</td>
						<td>${row.date}</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="4">조회된 결과가 없습니다.</td>
				</tr>
			</c:otherwise>
		</c:choose>
		
	</tbody>
</table>
	<h2>삭제할 편지 id 입력</h2>
	<form method="post" action="deleteLetter.do">
		번호 : <input type="text" name="letter_id"/><br>
		<input type="submit" value="입력완료"/>
	</form>
	<br><br><br>
	<a class='button' href='main.do'>홈으로</a>
</body>
</html>