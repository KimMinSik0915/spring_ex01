<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="pageObject" tagdir="/WEB-INF/tags" %>
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
			
			var query = ${(empty pageObject)?"''":"'&page=" += pageObject.page +="&perPageNum=" += pageObject.perPageNum += "'"}
			
			// 검색정보 붙이기
			query +=  ${(empty pageObject.word)?"''":"'&key=" += pageObject.key +="&word=" += pageObject.word += "'"}
			
			location = "view?no=" + no + "&inc=1" + query;
			
		});
		
	});

</script>
<title>Notice List</title>
</head>
<body class="container">
 <h1 class="row">공지사항 리스트</h1>
  <form >
   <input name="page" value="${pageObject.page }" type="hidden">
   <input name="perPageNum" value="${pageObject.perPageNum }" type="hidden">
   <div class="input-group">
    <span class="input-group-addon">
     <select name="key">
      <option value="t" ${(pageObject.key == "t")?"selected":"" }>제목</option>
      <option value="t" ${(pageObject.key == "c")?"selected":"" }>내용</option>
      <option value="t" ${(pageObject.key == "s")?"selected":"" }>시작일</option>
      <option value="t" ${(pageObject.key == "e")?"selected":"" }>종료일</option>
      <option value="t" ${(pageObject.key == "tc")?"selected":"" }>제목/내용</option>
     </select>
    </span>
    <input type="text" class="form-control" placeholder="search" name="word" value="${pageObject.word }">
    <div class="input-group-btn">
     <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
    </div>
   </div>
  </form>
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
 <a href="write?perPageNum=${pageObject.perPageNum }" class="btn btn-default">등록</a>
 <div>
  <pageObject:pageNav listURI="list" pageObject="${pageObjcet }" />
 </div>
</body>
</html>