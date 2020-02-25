<%@page import="com.digitus.board.vo.Member"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->

<title>Write</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">


<!-- IE8 에서 HTML5 요소와 미디어 쿼리를 위한 HTML5 shim 와 Respond.js -->
<!-- WARNING: Respond.js 는 당신이 file:// 을 통해 페이지를 볼 때는 동작하지 않습니다. -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
</head>
<%
Member member = (Member)request.getSession().getAttribute("member"); 
%>
<c:set value="<%=member %>" var="member" />
							
<body>

	<div class="container">

		<div class="starter-template">
			<h2>게시글 작성</h2>
			<form method="POST" id="writeForm" name="writeForm" action="/board/add-board">
				<!-- Table -->
				<table class="table">
					<colgroup>
						<col width="150px">
						<col width="*">
					</colgroup>
					<tr>
						<th scope="col">제목</th>
						<td>
							<input type="text" class="form-control" name="title" value="" required />
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<textarea name="content" style="width:100%; height:300px;" class="form-control" required></textarea>
						</td>
					</tr>
					<tr>
						<th scope="col">작성자</th>
						<td>
							${member.name }							
							<input type="hidden" name="userId" value="${member.userId }">
							<input type="hidden" name="writer" value="${member.name}">
							
						</td>
					</tr>
				</table>
				<div align="right">
					<button type="button" class="btn btn-light" onclick="javascript:location.href='/board';">뒤로가기</button>
					<button type="button" class="btn btn-light" onclick="writeBoard()">작성</button>
				</div>
			</form>
		</div>

	</div>
	<!-- /.container -->

	<script type="text/javascript">
		$(function() { 
			$("#writeForm").validate(); 
		});

		function writeBoard() {
			$('#writeForm').submit();
		}
	</script>

</body>
</html>