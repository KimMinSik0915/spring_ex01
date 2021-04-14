<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- BootStrap Library 등록 CDN 방식 : SiteMesh에서 Decorator.jsp에서 한꺼번에 해결 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">

	.dataRow:hover {
	
		background: #eee;
		cursor: pointer;
	
	}

</style>
<script type="text/javascript">

	$(function () {
		
		$(".dataRow").click(function() {
			
			var no = $(this).find(".no").text();
			
			location = "view?no=" + no + "&inc=1";
			
		});
		
	});

</script>
<title>List</title>
</head>
<body class="container">
 <h1>게시판 리스트</h1>
 <ul class="list-group">
  <!-- Data가 존재하지 않는 경우 -->
  <c:if test="${empty list }">
   <li class="list-group-item">데이터가 존재하지 않습니다.</li>
  </c:if>
  <c:if test="${!empty list }">
   <c:forEach items="${list }" var="vo">
    <li class="list-group-item dataRow">
     <div>
     <span class="no">${vo.no }</span>. ${vo.title }
     </div>
     ${vo.writer } (<fmt:formatDate value="${vo.writeDate }" pattern="yyyy.MM.dd hh:mm"/>) <span class="badge">${vo.hit }</span>
     </li>
   </c:forEach>
  </c:if>
 </ul>
 <!-- a tag, js : loaction, 주소입력 : get 방식으로 넘어간다 || post방식은 꼭 지정을 해야 한다 -->
 <a href="write">글 쓰기</a>
</body>
</html>