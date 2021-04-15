<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
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
		
		${(empty msg)?"":"alert('" += msg += "')"}
		
		$(".dataRow").click(function() {
			
			var no = $(this).find(".no").text();
			
			location = "view?no=" + no
			
		});
		
	});

</script>
<title>Notice List</title>
</head>
<body class="container">
 <h1>공지사항 리스트</h1>
 <ul class="list-group">
  <c:if test="${empty list }">
   <li class="list-group-item">데이터가 존재하지 않습니다</li>
  </c:if>
  <c:if test="${!empty list }">
   <c:forEach items="${list }" var="vo">
    <li class="list-group-item dataRow">
     <div>
      <span class="no">${vo.no }</span>.${vo.title }
     </div>
     <fmt:formatDate value="${vo.startDate }" pattern="yyyy.MM.dd"/> - <fmt:formatDate value="${vo.endDate }" pattern="yyyy.MM.dd"/> 
     <span style="float: right;">&emsp;작성일 : <fmt:formatDate value="${vo.writeDate }" pattern="yyyy.MM.dd"/></span>
     <span style="float: right;">수정일 : <fmt:formatDate value="${vo.updateDate }" pattern="yyyy.MM.dd"/></span> 
    </li>
   </c:forEach>
  </c:if>
 </ul>
 <a href="write" class="btn btn-default">등록</a>
</body>
</html>