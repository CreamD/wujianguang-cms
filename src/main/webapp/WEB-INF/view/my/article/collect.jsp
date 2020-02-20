<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link href="/resource/css/bootstrap.css" rel="stylesheet">
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript">
	function del(id){
		location.href="my/article/delCollect?id="+id;
		
	}
</script>
<body>

 <div>
 	<table class="table table-bordered table-hover">
 		<tr align="center">
 			<td>主键ID</td>
 			<td>收藏内容</td>
 			<td>URL路径</td>
 			<td>收藏时间</td>
 			<td>用户ID</td>
 			<td>操作</td>
 		</tr>
 		<c:forEach items="${info.list}" var="collect">
 		<tr align="center">
 			<td>${collect.id}</td>
 			<td>${collect.text}</td>
 			<td>${collect.url}</td>
 			<td><fmt:formatDate value="${collect.created }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
 			<td>${collect.user_id}</td>
 			<td><button onclick="del(${collect.id})">删除</button></td>
 		</tr>
 		</c:forEach>
 		
 		<tr>
 			<td colspan="6">
 				<a href="pageNum=1">首页</a>
 				<a href="/my/article/collect.pageNum=${info.pageNum-1 }">上一页</a>
 				<a href="/my/article/collect.pageNum=${info.pageNum+1 }">下一页</a>
 				<a href="/my/article/collect.pageNum=${info.pages }">尾页</a>
 			</td>
 		</tr>
 	</table>
	  </div>
</body>
</html>