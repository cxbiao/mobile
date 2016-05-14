<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<title>item</title>
<meta charset="utf-8" />

</head>

<body>
	<br>


	<table>
		<thead>
			<tr>
				<th>id</th>
				<th>姓名</th>
				<th>性别</th>
				<th>出生年月</th>
				<th>地址</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listUsers}" var="user">
				<tr>
					<td>${user.id}</td>
					<td>${user.username}</td>
					<td>${user.sex}</td>
					<td>  <fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd"/> </td>
					<td>${user.address}</td>
				</tr>

			</c:forEach>
		</tbody>
	</table>
</body>
</html>
