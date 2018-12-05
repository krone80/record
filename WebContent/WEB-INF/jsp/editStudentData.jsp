<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>生徒情報管理システム｜生徒情報編集</title>
</head>
<body>
<form action="/record/StudentDataServlet" method="post" >
	<table>
		<tr>
			<th>ID</th>
			<td>${student.id}</td>
		</tr>
		<tr>
			<th>生徒氏名</th>
			<td><input type="text" name="name" value="<c:out value="${student.name}" />"></td>
		</tr>
		<tr>
			<th>生徒氏名(かな)</th>
			<td><input type="text" name="kana" value="<c:out value="${student.kana}" />"></td>
		</tr>
		<tr>
			<th>生年月日</th>
			<td><input type="date" name="birthday" value="${student.birthday}"></td>
		</tr>
		<tr>
			<th>学校名</th>
			<td><input type="text" name="school" value="${student.school}"></td>
	</tr>
	</table>
	<input type="hidden" name="id" value="${student.id}">
	<input type="hidden" name="action" value="edit">
	<p><input type="submit" value="編集"></p>
</form>
<a href="/record">TOPへ</a>
</body>
</html>