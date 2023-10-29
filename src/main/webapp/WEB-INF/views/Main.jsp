<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dessertFairy</title>
<link rel="stylesheet" type="text/css" href="/css/main.css">
</head>
<body>
<div id="wrap">

	<div id="top">
		<c:import url="./customcake/Top.jsp" />
	</div>
	
	<div class="clear"></div>
	
	<div id="contents">
		<c:import url="./${contentsJsp}.jsp"></c:import>
	</div>
	
	<div class="clear"></div>
	
	<div id="bottom">
		<c:import url="./customcake/Bottom.jsp" />
	</div>

</div>
</body>
</html>