<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>生徒情報管理システム｜新規生徒登録</title>
</head>
<body>
<form action="/record/StudentDataServlet" method="post" >
	<table>
		<tr>
			<th>生徒氏名</th>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<th>生徒氏名(かな)</th>
			<td><input type="text" name="kana"></td>
		</tr>
		<tr>
			<th>生年月日</th>
			<td><input type="date" name="birthday"></td>
		</tr>
		<tr>
			<th>学校名</th>
			<td><input type="text" name="school"></td>
		</tr>
	</table>
	<input type="hidden" name="action" value="register">
	<p><input type="submit" value="登録"></p>
</form>
<a href="/record">TOPへ</a>
</body>
</html>