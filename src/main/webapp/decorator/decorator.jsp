<%@page import="com.digitus.board.vo.Member"%>
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
<!-- 합쳐지고 최소화된 최신 CSS 
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
-->
<link href="http://bootstrapk.com/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="http://bootstrapk.com/examples/navbar/navbar.css" rel="stylesheet">
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
<%
Member member = (Member)request.getSession().getAttribute("member"); 
%>
<c:set value="<%=member %>" var="member" />
	<div class="wraper">
		<header>
			<div class="container">
				<nav class="navbar navbar-default">
			    	<div class="container-fluid">
				 		<div class="navbar-header">
				            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
				            </button>
				            <a class="navbar-brand" href="#">Project name</a>
				          </div>
				          <div id="navbar" class="navbar-collapse collapse">
				            <ul class="nav navbar-nav">
				              <li class="active"><a href="/board">Home</a></li>
				            </ul>
				            <ul class="nav navbar-nav navbar-right">
				              <li><a href="javascript:void(0);">${member.name }님 로그인</a></li>
				              <li><a href="/logout" style="font-size: 12px">로그아웃</a></li>
				        	</ul>
				    	</div><!--/.nav-collapse -->
		        	</div><!--/.container-fluid -->
		      	</nav>
			</div>
		
		</header>
	
		<sitemesh:write property='body'>내부 구조만 body 태그 사이에 넣을 것</sitemesh:write>
	</div>

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