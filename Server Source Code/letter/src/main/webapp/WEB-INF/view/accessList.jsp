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
<title>CMS 접속자 리스트</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
</head>
<body>
<h2>접속자 목록</h2>
<table border=''>
	
	<thead>
		<tr>
			<th>번호</th>
			<th>접속자 ID</th>
			<th>접속자 Name</th>
			<th>접속 시간</th>
			<th>접속 종료 시간</th>
		</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${fn:length(List) > 0}">
				<c:forEach items="${List}" var="row">
					<tr>
						<td>${row.number}</td>
						<td>${row.access_id}</td>
						<td>${row.access_name}</td>
						<td>${row.access_date}</td>
						<td>${row.close_date}</td>
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
	<h2>삭제할 번호 입력</h2>
	<form method="post" action="deleteAccess.do">
		번호 : <input type="text" name="number"/><br>
		<input type="submit" value="입력완료"/>
	</form>
	<br><br><br>
	<a class='button' href='main.do'>홈으로</a>
</body>
</html>