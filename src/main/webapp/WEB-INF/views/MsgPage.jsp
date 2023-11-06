<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dessert Fairy</title>
</head>
<body>
	
	<c:if test="${msg!=null}">
		<script type="text/javascript">
			let msg = "${msg}";
			alert(msg);
		</script>
	</c:if>
	<c:if test="${conf!=null}">
		<script type="text/javascript">
			let conf = "${conf}";
			if(!confirm(conf)) {
				history.back();
			} else {
				document.location.href="${url}";
			}
		</script>
	</c:if>
	<c:if test="${conf==null}">
		<script type="text/javascript">
			let url = "${url}";
			if(url.length==0 || url == null || url == "")
				url="/";
			document.location.href="${url}";
		</script>
	</c:if>
	
</body>
</html>