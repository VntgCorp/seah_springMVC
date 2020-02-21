<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html5>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->

<title>Write</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">



<!-- IE8 에서 HTML5 요소와 미디어 쿼리를 위한 HTML5 shim 와 Respond.js -->
<!-- WARNING: Respond.js 는 당신이 file:// 을 통해 페이지를 볼 때는 동작하지 않습니다. -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<style type="text/css">
.custab {
	border: 1px solid #ccc;
	padding: 5px;
	margin: 1% 0;
	box-shadow: 3px 3px 2px #ccc;
	transition: 0.5s;
}

.custab:hover {
	box-shadow: 3px 3px 0px transparent;
	transition: 0.5s;
}
</style>
</head>
<body>
	<div class="container">
		<div align="right" style="margin-top: 20px;">
			<button type="button" class="btn btn-info"
				onclick="javascript:location.href='/board/write';">게시글 작성</button>
		</div>
		<div class="row" align="center">
			<table class="table table-striped custab">
				<colgroup>
					<col width="100px" />
					<col width="" />
					<col width="150px" />
					<col width="200px" />
				</colgroup>
				<thead align="center">
					<tr>
						<th>No.</th>
						<th>제목</th>
						<th>작성자</th>
						<th>Action</th>
					</tr>
				</thead>
				<c:if test="${list ne null and list.size() eq 0 }">
					<tr>
						<td align="center">게시글이 없습니다.</td>
					</tr>
				</c:if>
				<c:forEach items="${list}" var="board">
					<tr>
						<td align="center">${board.bno }</td>
						<td class="list-row" bno="${board.bno }">${board.title }</td>
						<td align="center">${board.writer }</td>
						<td class="text-center"><a class='btn btn-info btn-xs'
							href="/board/update/${board.bno }"> <span
								class="glyphicon glyphicon-edit"></span> Edit
						</a> <a class="btn btn-danger btn-xs delBtn"
							href="javascript:void(0);" bno="${board.bno }"> <span
								class="glyphicon glyphicon-remove"></span> Del
						</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center">
				${paginator.getPageHtml() }
			</ul>
		</nav>
	</div>
	<form id="delForm" name="delForm" method="POST" action="">
		<input type="hidden" name="_method" value="DELETE"> <input
			type="hidden" name="bno" value="">
	</form>

	<form name="nextForm" action="/board" method="GET">
		<input type="hidden" name="pages" value="${paginator.pagingTO.pages }">
	</form>

	<script type="text/javascript">
	function goList(page) {
		document.nextForm.pages.value = page;
		document.nextForm.submit();
	}
		window.onload = function() {
			$('.list-row').click(function() {
				console.log('click ::: ' + $(this).attr("bno"));
				location.href = '/board/post/' + $(this).attr("bno");
			});

			$('.delBtn').click(function() {
				var bno = $(this).attr('bno');
				document.delForm.bno.value = bno;
				document.delForm.action = '/board/delete/' + bno;
				$('#delForm').submit();

			});

			
			<c:if test="${message ne null}">
			alert('${message}');
			location.href = "/board";
			</c:if>
		};
	</script>

	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->

	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>

</body>
</html>