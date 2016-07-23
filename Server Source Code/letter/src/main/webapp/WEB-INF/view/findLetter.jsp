<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>CMS 해당 편지 조회 </title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
</head>
<body>
<h2>해당 user 편지 목록</h2>
<table border=''>
	<thead>
		<tr>
			<th>편지 ID</th>
			<th>받는 이 ID</th>
			<th>받는 이 Name</th>
			<th>보내는 이 ID</th>
			<th>보내는 이 Name</th>
			<th>Latitude</th>
			<th>Longitude</th>
			<th>읽음 확인</th>
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
						<td>${row.latitude}</td>
						<td>${row.longitude}</td>
						<td>${row.read_state}</td>
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
	<form method="post" action="delete.do">
		번호 : <input type="text" name="id"/><br>
		<input type="submit" value="입력완료"/>
	</form>
</body>
</html>