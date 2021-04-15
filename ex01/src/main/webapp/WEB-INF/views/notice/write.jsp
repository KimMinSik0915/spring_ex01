<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">

	$(function() {
		
		$(".backBtn").click(function() {
			
			history.back();
			
		});
		
	}); 

</script>
<title>공지사항 등록</title>
</head>
<body class="container">
 <h1>공지사항 등록</h1>
 <form action="write" method="post">
  <div class="form-group">
   <label for="title">제목</label>
   <input class="form-control" name="title" id="title" placeholder="제목은 4자 이상 입력하셔야 합니다." pattern=".{4,100}" maxlength="100" required="required" title="제목은 4자 이상 100자 이하로 입력하셔야 합니다.">
  </div>
  <div class="form-group">
   <label for="content">내용</label>
   <textarea rows="5" class="form-control" name="content" id="content" placeholder="내용은 4자 이상 입력하셔야 합니다." maxlength="700" required="required"></textarea>
  </div>
  <div class="form-group">
   <label for="startDate">공지 시작일</label>
   <input class="form-control" type="date" required="required" name="startDate" id="startDate" >
  </div>
  <div class="form-group">
   <label for="endDate">제목</label>
   <input class="form-control" type="date" required="required" name="endDate" id="endDate" >
  </div>
  <button class="btn btn-default">등록</button>
  <button class="btn btn-default" type="reset">새로입력</button>
  <button class="btn btn-default backBtn" type="button">취소</button>
 </form>
</body>
</html>