<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dessertFairy</title>
</head>
<body>
<div id="wrap">

	<div id="top">
		<c:import url="./custom/Top.jsp" />
	</div>
	
	<div class="clear"></div>
	
	<div id="contents">
		<c:import url="./${contentsJsp}.jsp"></c:import>
	</div>
	
	<div class="clear"></div>
	
	<div id="bottom">
		<c:import url="./custom/Bottom.jsp" />
	</div>

</div>
</body>
</html>