<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>生徒情報管理システム｜生徒一覧</title>
<link rel="stylesheet" type="text/css" href="/record/css/style.css">
</head>
<body>
<div class="container">
	<h2>生徒一覧</h2>
	<a href="/record/StudentDataServlet?action=register">新規生徒登録</a>
</div><!-- container -->
<div class="search">
	<div class="container">
		<h3>検索</h3>
		<form action="/record/StudentDataServlet" method="post" >
			<table>
				<tr>
					<th>ID</th>
					<th>生徒氏名</th>
					<th>生徒氏名(かな)</th>
					<th>学校名</th>
				</tr>
				<tr>
					<td><input type="text" name="id"></td>
					<td><input type="text" name="name"></td>
					<td><input type="text" name="kana"></td>
					<td><input type="text" name="school"></td>
				</tr>
			</table>
			<input type="hidden" name="action" value="search">
			<p><input type="submit" value="検索"></p>
		</form>
	</div><!-- /.container -->
</div><!-- /.search -->

<div class="studentdata">
	<div class="container">
		<h3>データ</h3>
		<table>
			<tr>
				<th>ID</th>
				<th>名前</th>
				<th>かな</th>
				<th>生年月日</th>
				<th>学校名</th>
				<th></th>
			</tr>
			<c:forEach var="student" items="${studentList}" varStatus="status">
				<tr>
					<td><c:out value="${student.id}" /></td>
					<td><c:out value="${student.name}" /></td>
					<td><c:out value="${student.kana}" /></td>
					<td><c:out value="${student.birthday}" /></td>
					<td><c:out value="${student.school}" /></td>
					<td>
						<a href="/record/StudentDataServlet?action=edit&index=${status.index}">編集</a>
						<a href="/record/StudentDataServlet?action=delete&id=${student.id}">削除</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div><!-- /.container -->
</div><!-- /.studentdata -->
<hr>
<a href="/record">TOPへ</a>

</body>
</html>