<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- BootStrap Library 등록 CDN 방식 : SiteMesh에서 Decorator.jsp에서 한꺼번에 해결 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>게시판 글 보기</title>
</head>
<body>
 <div class="container">
  <h1>게시판 글 보기</h1>
  <ul class="list-group">
   <li class="list-group-item row">
    <div class="col-md-2">no</div>
    <div class="col-me-10">${vo.no }</div>
   </li>
   <li class="list-group-item row">
    <div class="col-md-2">제목</div>
    <div class="col-me-10">${vo.content }</div>
   </li>
   <li class="list-group-item row">
    <div class="col-md-2">내용</div>
    <div class="col-me-10"><pre>${vo.content }</pre></div>
   </li>
   <li class="list-group-item row">
    <div class="col-md-2">작성자</div>
    <div class="col-me-10">${vo.writer }</div>
   </li>
   <li class="list-group-item row">
    <div class="col-md-2">작성일</div>
    <div class="col-me-10"><fmt:formatDate value="${vo.writeDate }" pattern="yyyy.MM.dd hh:mm"/></div>
   </li>
   <li class="list-group-item row">
    <div class="col-md-2">조회수</div>
    <div class="col-me-10">${vo.hit }</div>
   </li>
  </ul>
 </div>
</body>
</html>